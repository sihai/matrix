/**
 * 
 */
package com.ihome.matrix.util;

import java.util.ArrayList;
import java.util.List;

import com.iacrqq.util.StringUtil;
import com.ihome.matrix.enums.DistributeWayEnum;
import com.ihome.matrix.enums.PaywayEnum;

/**
 * 
 * @author sihai
 *
 */
public class DistributeWayUtil {
	
	public static List<DistributeWayEnum> split(String distributeWays) {
		DistributeWayEnum distributeWay = null;
		List<DistributeWayEnum> distributeWayList = new ArrayList<DistributeWayEnum>();
		if(StringUtil.isNotBlank(distributeWays)) {
			String[] array = distributeWays.split(",");
			for(String v : array) {
				distributeWay = DistributeWayEnum.toEnum(Integer.valueOf(v));
				if(null != distributeWay) {
					distributeWayList.add(distributeWay);
				}
			}
		}
		return distributeWayList;
	}
	
	/**
	 * 
	 * @param payways
	 * @param payway
	 * @return
	 */
	public static boolean isSupported(String distributeWays, DistributeWayEnum distributeWay) {
		return null != distributeWays && distributeWays.contains(String.valueOf(distributeWay.getValue()));
	}
}
