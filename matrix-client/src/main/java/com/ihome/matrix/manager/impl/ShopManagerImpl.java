/**
 * ihome.igo
 */
package com.ihome.matrix.manager.impl;

import java.util.List;

import com.ihome.matrix.dao.ShopCategoryDAO;
import com.ihome.matrix.dao.ShopDAO;
import com.ihome.matrix.dao.ShopProductDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.ShopCategoryDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.domain.ShopProductDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.manager.ShopManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.ResultModel;
import com.ihome.matrix.model.ShopCategoryQueryModel;
import com.ihome.matrix.model.ShopProductQueryModel;
import com.ihome.matrix.model.ShopQueryModel;

/**
 * 
 * @author sihai
 *
 */
public class ShopManagerImpl implements ShopManager {

	private ShopDAO shopDAO;
	private ShopProductDAO shopProductDAO;
	private ShopCategoryDAO shopCategoryDAO;
	private CategoryManager categoryManager;
	private ProductManager productManager;

	@Override
	public void add(ShopDO shop) throws ValidateException {
		validate(shop);
		shopDAO.insert(shop);
	}

	@Override
	public ShopDO get(Long id) {
		ShopDO shop = shopDAO.get(id);
		if(null != shop) {
			setShopCategoryList(shop);
			setShopProductList(shop);
		}
		return shop;
	}
	
	@Override
	public ShopDO getByShopIdAndPlatform(String shopId, int platform) {
		return shopDAO.getByShopIdAndPlatform(shopId, platform);
	}

	@Override
	public ResultModel<ShopDO> query(ShopQueryModel queryModel) {
		List<ShopDO> shopList = shopDAO.query(queryModel);
		for(ShopDO s : shopList) {
			setShopCategoryList(s);
			setShopProductList(s);
		}
		return ResultModel.buildResultModel(queryModel, shopList, shopDAO.count(queryModel));
	}

	@Override
	public void update(ShopDO shop) throws ValidateException {
		validate(shop);
		shopDAO.update(shop);
	}

	@Override
	public void delete(Long id) {
		shopDAO.delete(id);
	}
	
	
	@Override
	public void addShopProduct(ShopProductDO shopProduct) throws ValidateException {
		validateShopProduct(shopProduct);
		shopProductDAO.insert(shopProduct);
	}

	@Override
	public ShopProductDO getShopProduct(Long id) {
		return shopProductDAO.get(id);
	}

	@Override
	public ResultModel<ShopProductDO> query(ShopProductQueryModel queryModel) {
		return ResultModel.buildResultModel(queryModel, shopProductDAO.query(queryModel), shopProductDAO.count(queryModel));
	}

	@Override
	public void updateShopProduct(ShopProductDO shopProduct) throws ValidateException {
		validateShopProduct(shopProduct);
		shopProductDAO.update(shopProduct);
	}

	@Override
	public void deleteShopProduct(Long id) {
		shopProductDAO.delete(id);
	}
	
	@Override
	public void deleteShopProductByShopId(Long shopId) {
		shopProductDAO.deleteByShopId(shopId);
	}
	
	@Override
	public void addShopCategory(ShopCategoryDO shopCategory) throws ValidateException {
		validateShopCategory(shopCategory);
		shopCategoryDAO.insert(shopCategory);
	}

	@Override
	public ShopCategoryDO getShopCategory(Long id) {
		return shopCategoryDAO.get(id);
	}

	@Override
	public ResultModel<ShopCategoryDO> query(ShopCategoryQueryModel queryModel) {
		List<ShopCategoryDO> shopCategoryList = shopCategoryDAO.query(queryModel);
		for(ShopCategoryDO shopCategory : shopCategoryList) {
			shopCategory.setShop(get(shopCategory.getShop().getId()));
		}
		return ResultModel.buildResultModel(queryModel, shopCategoryList, shopCategoryDAO.count(queryModel));
	}

	@Override
	public void updateShopCategory(ShopCategoryDO shopCategory) throws ValidateException {
		validateShopCategory(shopCategory);
		shopCategoryDAO.update(shopCategory);
	}

	@Override
	public void deleteShopCategory(Long id) {
		shopCategoryDAO.delete(id);
	}	
	
	@Override
	public void deleteShopCategoryByShopId(Long shopId) {
		shopCategoryDAO.deleteByShopId(shopId);
	}

	@Override
	public void deleteShopCategory(Long shop, Long category) {
		shopCategoryDAO.delete(shop, category);
	}

	/**
	 * 
	 * @param shop
	 * @throws ValidateException
	 */
	private void validate(ShopDO shop) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param shopProduct
	 * @throws ValidateException
	 */
	private void validateShopProduct(ShopProductDO shopProduct) throws ValidateException {
		// TODO
	}
	
	/**
	 * 
	 * @param shopProduct
	 * @throws ValidateException
	 */
	private void validateShopCategory(ShopCategoryDO shopCategory) throws ValidateException {
		// TODO
	}
	
	private void setShopCategoryList(ShopDO shop) {
		// XXX 如果一个shop主营类目超过<code>BaseQueryModel.MAX_PAGE_SIZE</code>, 那就恐怖了哇
		List<ShopCategoryDO> shopCategoryList = shopCategoryDAO.query(ShopCategoryQueryModel.newInstance().withShop(shop.getId()).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		for(ShopCategoryDO shopCategory : shopCategoryList) {
			shopCategory.setCategory(categoryManager.get(shopCategory.getCategory().getId()));
		}
		shop.setShopCategoryList(shopCategoryList);
	}
	/**
	 * 
	 * @param shop
	 */
	private void setShopProductList(ShopDO shop) {
		// XXX 如果一个shop主营产品超过<code>BaseQueryModel.MAX_PAGE_SIZE</code>, 那就恐怖了哇
		List<ShopProductDO> shopProductList = shopProductDAO.query(ShopProductQueryModel.newInstance().withShop(shop.getId()).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		for(ShopProductDO shopProduct : shopProductList) {
			shopProduct.setProduct(productManager.get(shopProduct.getProduct().getId()));
		}
		shop.setShopProductList(shopProductList);
	}

	public void setShopDAO(ShopDAO shopDAO) {
		this.shopDAO = shopDAO;
	}
	
	public void setShopProductDAO(ShopProductDAO shopProductDAO) {
		this.shopProductDAO = shopProductDAO;
	}
	
	public void setShopCategoryDAO(ShopCategoryDAO shopCategoryDAO) {
		this.shopCategoryDAO = shopCategoryDAO;
	}
	
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}