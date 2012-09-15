package com.ihome.matrix;

import org.springframework.test.AbstractDependencyInjectionSpringContextTests;

public class MatrixBaseTestCase extends AbstractDependencyInjectionSpringContextTests {

	@Override
	protected String[] getConfigLocations() {
		return new String[]{"classpath*:/spring-test/spring-matrix-test.xml"};
	}
}
