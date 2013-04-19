/**
 * 
 */
package com.ihome.matrix.manager.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.iacrqq.util.DateUtil;
import com.ihome.matrix.dao.PromotionActivityDAO;
import com.ihome.matrix.dao.exception.ValidateException;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.domain.PromotionActivityDO;
import com.ihome.matrix.domain.ShopDO;
import com.ihome.matrix.manager.PromotionActivityManager;
import com.ihome.matrix.model.PromotionActivityQueryModel;
import com.ihome.matrix.model.ResultModel;

/**
 * 
 * @author sihai
 *
 */
public class PromotionActivityManagerImpl implements PromotionActivityManager {
	
	@Autowired
	private PromotionActivityDAO promotionActivityDAO;
	
	@Override
	public void add(PromotionActivityDO promotionActivity) throws ValidateException {
		validate(promotionActivity);
		promotionActivityDAO.insert(promotionActivity);
	}

	@Override
	public PromotionActivityDO get(Long id) {
		return promotionActivityDAO.get(id);
	}

	@Override
	public ResultModel<PromotionActivityDO> query(PromotionActivityQueryModel queryModel) {
		// XXX mock
		return ResultModel.buildResultModel(queryModel, /*promotionActivityDAO.query(queryModel)*/mock(9), 20L/*promotionActivityDAO.count(queryModel)*/);
	}

	@Override
	public void update(PromotionActivityDO promotionActivity) throws ValidateException {
		validate(promotionActivity);
		promotionActivityDAO.update(promotionActivity);

	}

	@Override
	public void delete(Long id) {
		promotionActivityDAO.delete(id);
	}
	
	/**
	 * 
	 * @param promotionActivity
	 * @throws ValidateException
	 */
	private void validate(PromotionActivityDO promotionActivity) throws ValidateException {
		// TODO
	}
	
	private List<PromotionActivityDO> mock(int size) {
		PromotionActivityDO promotionActivity = null;
		CategoryDO category = null;
		ShopDO shop = null;
		List<PromotionActivityDO> promotionActivityList = new ArrayList<PromotionActivityDO>(20);
		for(int i = 0; i < size; i++) {
			promotionActivity = new PromotionActivityDO();
			promotionActivity.setId(Long.valueOf(i));
			promotionActivity.setName(String.format("促销活动_%d", i));
			promotionActivity.setLogoURL("/assets/img/test.jpg");
			
			category = new CategoryDO();
			category.setId(1L);
			category.setName("测试分类");
			promotionActivity.setCategory(category);
			
			shop = new ShopDO();
			shop.setId(1L);
			shop.setName("测试店铺");
			promotionActivity.setShop(shop);
			
			promotionActivity.setStartTime(DateUtil.getToday());
			promotionActivity.setEndTime(DateUtil.getTomorrow());
			promotionActivityList.add(promotionActivity);
		}
		return promotionActivityList;
	}
	
	public void setPromotionActivityDAO(PromotionActivityDAO promotionActivityDAO) {
		this.promotionActivityDAO = promotionActivityDAO;
	}
}