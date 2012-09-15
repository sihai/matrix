package com.ihome.matrix.manager.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.ihome.matrix.MatrixBaseTestCase;
import com.ihome.matrix.domain.CategoryDO;
import com.ihome.matrix.manager.CategoryManager;

public class CategoryManagerImplTest extends MatrixBaseTestCase {

	@Autowired
	private CategoryManager categoryManager;
	
	@Test
	public void testAdd() throws Exception {
		CategoryDO category = new CategoryDO();
		category.setName("test");
		category.setDescription("test");
		category.setIsDeleted(false);
		category.setRank(0);
		category.setStatus(0);
		categoryManager.add(category);
	}

	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testQuery() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	public void setCategoryManager(CategoryManager categoryManager) {
		this.categoryManager = categoryManager;
	}
}
