/**
 * ihome .inc
 * igo
 */
package com.ihome.matrix.web.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartHttpServletRequest;


/**
 * 将Form中的参数转换成java bean
 * @author sihai
 *
 */
public class FormUtil {

	/**
	 * 
	 * @param clazz
	 * @param request
	 * @return
	 */
	public static <T> T toBean(Class<T> clazz, HttpServletRequest request) {
		if(request instanceof MultipartHttpServletRequest) {
			return com.iacrqq.util.FormUtil.toBean(clazz, (Map<String, Object>)((MultipartHttpServletRequest)request).getParameterMap());
		} else {
			return com.iacrqq.util.FormUtil.toBean(clazz, (Map<String, Object>)request.getParameterMap());
		}
	}
}
