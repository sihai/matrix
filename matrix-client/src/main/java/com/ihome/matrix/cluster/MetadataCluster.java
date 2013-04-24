/**
 * 
 */
package com.ihome.matrix.cluster;

import com.ihome.matrix.cluster.impl.MetadataCategoryCluster;
import com.ihome.matrix.cluster.impl.MetadataProductCluster;
import com.ihome.matrix.domain.CategoryAssDO;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.ItemDO;
import com.ihome.matrix.domain.ProductAssDO;
import com.ihome.matrix.domain.ProductDO;
import com.ihome.matrix.manager.CategoryManager;
import com.ihome.matrix.manager.ProductManager;
import com.ihome.matrix.model.BaseQueryModel;
import com.ihome.matrix.model.CategoryAssQueryModel;
import com.ihome.matrix.model.ProductAssQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class MetadataCluster implements Cluster {

	private CategoryManager categoryManager;
	private ProductManager	productManager;

	private CategoryCluster categoryCluster;
	private ProductCluster	productCluster;
	
	public void initialize() {
		// category cluster
		ResultModel<CategoryAssDO> result = categoryManager.query(CategoryAssQueryModel.newInstance().withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		categoryCluster = new MetadataCategoryCluster();
		((MetadataCategoryCluster)categoryCluster).initialize(result.getItemList());
		// product cluster
		ResultModel<ProductAssDO> r = productManager.query(ProductAssQueryModel.newInstance().withPageSize(BaseQueryModel.MAX_PAGE_SIZE));
		productCluster = new MetadataProductCluster();
		((MetadataProductCluster)productCluster).initialize(r.getItemList());
	}
	
	@Override
	public ProductDO clusterProduct(ItemDO item) {
		return productCluster.clusterProduct(item);
	}

	@Override
	public CategoryDO clusterCategory(ItemDO item) {
		return categoryCluster.clusterCategory(item);
	}

	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}

	public void setProductManager(ProductManager productManager) {
		this.productManager = productManager;
	}
}
