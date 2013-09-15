package com.bancai.service;

import java.util.List;

import com.bancai.dao.AdvertiseEnterpriseDAO;
import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterpriseDAO;

public class AdvertiseEnterpriseService {

	private static final String ENTERPRISE_ID = "enterpriseId";

	public List<Enterprise> getEnterprises(int size) {
		// 购买套餐的企业
		List<Enterprise> displayList = new AdvertiseEnterpriseDAO().findAllEnterprises();
		// size个企业
		List<Enterprise> allEnterprises = new EnterpriseDAO().findAll(0, size);
		for (Enterprise e : allEnterprises) {
			// 如果要返回的企业列表个数已到size个，则返回
			if (displayList.size() == size) {
				break;
			}
			boolean exists = false;
			// 如果e的id和displayList某个元素的id相同，表明列表已存在此元素
			for (Enterprise enterprise : displayList) {
				if (enterprise.getId().equals(e.getId())) {
					exists = true;
				}
			}
			if(!exists){
				displayList.add(e);
			}
		}
		//如果个数还没够size个则添加默认的企业
		displayList.addAll(CommonService.createEmptyEnterprises(size
				- displayList.size()));
		return displayList;
	}
	
	/**
	 * 根据企业id删除企业广告位的内容
	 * @param corpId
	 */
	public void deleteAdCorpByCorpIdNoTranscation(int corpId) {
		AdvertiseEnterpriseDAO adCorpDao = new AdvertiseEnterpriseDAO();

		adCorpDao.deleteByColumnNoTranscation(ENTERPRISE_ID, corpId);
	}

}
