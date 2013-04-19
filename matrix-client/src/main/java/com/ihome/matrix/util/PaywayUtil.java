/**
 * 
 */
package com.ihome.matrix.util;

import java.util.ArrayList;
import java.util.List;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.enums.PaywayEnum;

/**
 * 
 * @author sihai
 *
 */
public class PaywayUtil {
	
	public static List<PaywayEnum> split(String payways) {
		PaywayEnum payway = null;
		List<PaywayEnum> paywayList = new ArrayList<PaywayEnum>();
		if(StringUtil.isNotBlank(payways)) {
			String[] array = payways.split(",");
			for(String v : array) {
				payway = PaywayEnum.toEnum(Integer.valueOf(v));
				if(null != payway) {
					paywayList.add(payway);
				}
			}
		}
		return paywayList;
	}
	
	/**
	 * 
	 * @param payways
	 * @param payway
	 * @return
	 */
	public static boolean isSupported(String payways, PaywayEnum payway) {
		return null != payways && payways.contains(String.valueOf(payway.getValue()));
	}
}
