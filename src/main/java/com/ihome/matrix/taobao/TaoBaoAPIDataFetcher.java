/**
 * ihome.matrix
 */
package com.ihome.matrix.taobao;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.domain.Product;
import com.taobao.api.request.ProductsSearchRequest;
import com.taobao.api.response.ProductsSearchResponse;

/**
 * 
 * @author sihai
 *
 */
public class TaoBaoAPIDataFetcher {
	
	private static final String GATEWAY = "http://gw.api.taobao.com/router/rest";
	private static final String APP_KEY = "12553639";
	private static final String SECRET = "7d7e073108bf8e6195a7012c3492457c";
	
	private static final TaobaoClient client = new DefaultTaobaoClient(GATEWAY, APP_KEY, SECRET);
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedWriter writer = null;
		
		try {
			//TopatsItemcatsGetRequest request = new TopatsItemcatsGetRequest();
			//request.setSellerType("B");
			//request.setCids("0");
			//request.setOutputFormat("json");
			//TopatsItemcatsGetResponse response = client.execute(request);
			//System.out.println(response.getBody());
			//Thread.sleep(120 * 1000);
			//TopatsResultGetRequest resultRequest = new TopatsResultGetRequest();
			//resultRequest.setTaskId(36554236L);
			//TopatsResultGetResponse resultResponse = client.execute(resultRequest);
			//System.out.println(resultResponse.getTask().getDownloadUrl());
			//String zipFile = downloadFile(resultResponse.getTask().getDownloadUrl());
			String zipFile = "c:\\taobao-category.zip";
			List<Category> catList = readZipFile(zipFile);
			writer = new BufferedWriter(new FileWriter(new File("c:\\category.txt")));
			dump(1, catList, writer);
			writer.flush();
			fetchItem(catList);
		/*} catch (ApiException e) {
			e.printStackTrace();*/
		/*} catch (InterruptedException e) {
			e.printStackTrace();*/
		}  catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(null != writer) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static String downloadFile(String strURL) throws IOException {
		BufferedWriter writer = null;
		BufferedReader reader = null;
		HttpURLConnection connection = null;
		try {
			URL url = new URL(strURL);
			connection = (HttpURLConnection)url.openConnection();
			int length = 0;
			char[] buffer = new char[8192];
			reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			File zipFile = File.createTempFile("taobao-category", ".zip");
			writer = new BufferedWriter(new FileWriter(zipFile));
			while((length = reader.read(buffer)) > 0) {
				writer.write(buffer, 0, length);
			}
			writer.flush();
			return zipFile.getAbsolutePath();
		} catch (MalformedURLException e) {
			return null;
		} finally {
			if(null != reader) {
				reader.close();
			}
			if(null != connection) {
				connection.disconnect();
			}
			if(null != writer) {
				writer.close();
			}
		}
	}
	
	public static List<Category> readZipFile(String url) throws IOException {
		List<Category> catList = new ArrayList<Category>();
		ZipFile zip = new ZipFile(url);
		JSONObject json = null;
		for (Enumeration<ZipEntry> entries = (Enumeration<ZipEntry>)zip.entries(); entries.hasMoreElements();) {
			ZipEntry entry = entries.nextElement();
			if("/".equals(entry.getName())) {
				continue;
			}
			Category cat = new Category();
			cat.id = Long.valueOf(entry.getName());
			try {
				json = toJSON(zip, entry);
				catList.add(resolve(null, json));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return catList;
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	private static Category resolve(Category parent, JSONObject json) {
		if(json.containsKey("cid") && json.containsKey("name")) {
			Category cat = new Category();
			cat.id = json.getLong("cid");
			cat.name = json.getString("name");
			cat.parent = parent;
			
			if(json.containsKey("childCategoryList")) {
				String strChildren = json.getString("childCategoryList");
				if(!"null".equals(strChildren)) {
					JSONArray children = json.getJSONArray("childCategoryList");
					for(int i = 0; i < children.size(); i++) {
						Category c = resolve(cat, children.getJSONObject(i));
						if(null != c) {
							cat.children.add(c);
						}
					}
				}
			}
			return cat;
		} else {
			//System.out.println(json.toString());
			return null;
		}
	}
	
	/**
	 * 
	 * @param zip
	 * @param entry
	 * @return
	 * @throws IOException
	 */
	public static JSONObject toJSON(ZipFile zip, ZipEntry entry) throws IOException {
		
		int size = (int)entry.getSize();
		byte[] buffer = new byte[size];
		
		int offset = 0;
		int length = 0;
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(zip.getInputStream(entry));
			while((length = in.read(buffer, offset, (size - offset) > 8192 ? 8192 : (size - offset))) > 0) {
				offset += length;
			}
			return JSONObject.fromObject(new String(buffer));
		} finally {
			if(null != in) {
				in.close();
			}
		}
	}
	
	public static void fetchItem(List<Category> catList) {
		for(Category cat : catList) {
			try {
				fetch(cat);
			} catch (ApiException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void fetch(Category category) throws ApiException {
		Long pageSize = 40L;
		Long currentPage = 1L;
		Long totalPage = 0L;
		
		ProductsSearchRequest request =new ProductsSearchRequest();
		request.setFields("product_id,name,pic_url,cid,props,price,tsc,status");
		request.setCid(50011999L);
		request.setStatus("3");
		request.setPageNo(currentPage);
		request.setPageSize(pageSize);
		request.setVerticalMarket(4L);
		ProductsSearchResponse response = client.execute(request);
		totalPage = (response.getTotalResults() + 1) / pageSize;
		
		process(response.getProducts());
		
		while(currentPage < totalPage) {
			request.setPageNo(currentPage++);
			response = client.execute(request);
			process(category, response.getProducts());
		}
	}
	
	public static void process(Category category, List<Product> pList) {
		if(null != pList) {
			for(Product p : pList) {
				fetchItem(catgory, p);
			}
		}
	}
	
	public static void fetchItem(Category catgory, Product product) {
		// taobao.items.search 这个API不让调
		ItemsSearchRequest req = new ItemsSearchRequest();
		req.setFields("num_iid,title,nick,pic_url,cid,price,type,delist_time,post_fee");
		req.setQ("title");
		req.setCid(34341L);
		req.setNicks("nick1,nick2,nick3");
		req.setProps("pid1:vid1;pid2:vid2");
		req.setProductId(345342L);
		req.setOrderBy("popularity:desc");
		req.setWwStatus(true);
		req.setPostFree(true);
		req.setLocationState("浙江");
		req.setLocationCity("杭州");
		req.setIs3D(true);
		req.setStartScore(1L);
		req.setEndScore(2L);
		req.setStartVolume(100L);
		req.setEndVolume(200L);
		req.setOneStation(true);
		req.setIsCod(true);
		req.setIsMall(true);
		req.setIsPrepay(true);
		req.setGenuineSecurity(true);
		req.setPromotedService("2");
		req.setStuffStatus("new");
		req.setStartPrice(10L);
		req.setEndPrice(120L);
		req.setPageNo(1L);
		req.setPageSize(40L);
		req.setAuctionFlag(true);
		req.setAutoPost(true);
		req.setHasDiscount(true);
		req.setIsXinpin(true);
		ItemsSearchResponse response = client.execute(req);
	}
	
	public static void dump(int level, List<Category> catList, BufferedWriter writer) throws IOException {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < level; i++) {
			sb.append("--");
		}
		String prefix = sb.toString();
		for(Category cat : catList) {
			writer.write(prefix + cat.name);
			writer.newLine();
			dump(level + 1, cat.children, writer);
		}
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	public static class Category {
		Long id;
		String name;
		Category parent;
		List<Category> children = new ArrayList<Category>();
	}
	
	/**
	 * 
	 * @author sihai
	 *
	 */
	public static class Item {
		Long 	id;
		String 	name;
		String 	tsc;
		Long 	catId;
		String 	pvs;
		Double  price;
		String  picURL;
		Long    status;
		
		Category category;
	}
}
