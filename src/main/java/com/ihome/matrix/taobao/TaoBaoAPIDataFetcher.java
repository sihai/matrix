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
import com.taobao.api.request.TopatsResultGetRequest;
import com.taobao.api.response.TopatsResultGetResponse;

/**
 * 
 * @author sihai
 *
 */
public class TaoBaoAPIDataFetcher {
	
	private static final String GATEWAY = "http://gw.api.taobao.com/router/rest";
	private static final String APP_KEY = "12553639";
	private static final String SECRET = "7d7e073108bf8e6195a7012c3492457c";
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			TaobaoClient client = new DefaultTaobaoClient(GATEWAY, APP_KEY, SECRET);
			//TopatsItemcatsGetRequest request = new TopatsItemcatsGetRequest();
			//request.setSellerType("B");
			//request.setCids("0");
			//request.setOutputFormat("json");
			//TopatsItemcatsGetResponse response = client.execute(request);
			//System.out.println(response.getBody());
			//Thread.sleep(120 * 1000);
			TopatsResultGetRequest resultRequest = new TopatsResultGetRequest();
			resultRequest.setTaskId(36554236L);
			TopatsResultGetResponse resultResponse = client.execute(resultRequest);
			System.out.println(resultResponse.getTask().getDownloadUrl());
			String zipFile = downloadFile(resultResponse.getTask().getDownloadUrl());
			List<Category> catList = readZipFile(zipFile);
			dump(catList);
		} catch (ApiException e) {
			e.printStackTrace();
		/*} catch (InterruptedException e) {
			e.printStackTrace();*/
		}  catch (IOException e) {
			e.printStackTrace();
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
	 * @param json
	 * @return
	 */
	private static Category resolve(Category parent, JSONObject json) {
		Category cat = new Category();
		cat.id = json.getLong("cid");
		cat.name = json.getString("name");
		cat.parent = parent;
		JSONArray children = json.getJSONArray("childCategoryList");
		for(int i = 0; i < children.size(); i++) {
			cat.children.add(resolve(cat, children.getJSONObject(i)));
		}
		return cat;
	}
	
	/**
	 * 
	 * @param zip
	 * @param entry
	 * @return
	 * @throws IOException
	 */
	public static JSONObject toJSON(ZipFile zip, ZipEntry entry) throws IOException {
		
		byte[] buffer = new byte[(int)entry.getSize()];
		
		int offset = 0;
		int length = 0;
		BufferedInputStream in = null;
		try {
			in = new BufferedInputStream(zip.getInputStream(entry));
			while((length = in.read(buffer, offset, 8192)) > 0) {
				offset += length;
			}
			return JSONObject.fromObject(String.valueOf(buffer));
		} finally {
			if(null != in) {
				in.close();
			}
		}
	}
	
	public static void dump(List<Category> catList) {
		
	}
}
