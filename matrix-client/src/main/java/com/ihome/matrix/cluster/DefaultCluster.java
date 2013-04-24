/**
 * 
 */
package com.ihome.matrix.cluster;

import com.ihome.matrix.cluster.impl.SimpleCategoryCluster;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.CategoryQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class DefaultCluster implements Cluster {
	
	private CategoryManager categoryManager;
	private ProductManager	productManager;

	private CategoryCluster categoryCluster;
	private ProductCluster	productCluster;
	
	public void initialize() {
		
		// 
		CategoryDO root = new CategoryDO();
		root.setName(CategoryManager.ROOT_NAME);
		ResultModel<CategoryDO> resultModel = categoryManager.query(CategoryQueryModel.newInstance().withParent(CategoryManager.ROOT_ID).withCurrentPage(1L).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		root.setChildren(resultModel.getItemList());
		for(CategoryDO child : resultModel.getItemList()) {
			child.setParent(root);
			_init_(child);
		}
		categoryCluster = new SimpleCategoryCluster();
		((SimpleCategoryCluster)categoryCluster).initialize(root);
	}
	
	@Override
	public CategoryDO clusterCategory(ItemDO item) {
		return categoryCluster.clusterCategory(item);
	}
	
	@Override
	public ProductDO clusterProduct(ItemDO item) {
		// TODO
		return null;
	}
	
	private void _init_(CategoryDO category) {
		ResultModel<CategoryDO> resultModel = categoryManager.query(CategoryQueryModel.newInstance().withParent(category.getId()).withCurrentPage(1L).withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		category.setChildren(resultModel.getItemList());
		for(CategoryDO child : resultModel.getItemList()) {
			child.setParent(category);
			_init_(child);
		}
	}
	
	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
