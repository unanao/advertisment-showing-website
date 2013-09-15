package com.bancai.service;

import java.util.ArrayList;
import java.util.List;

import com.bancai.dao.DisplayEnterpriseDAO;
import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterpriseDAO;

public class DisplayEnterpriseService {
	
	private static final String ENTERPRISE_ID = "enterpriseId";

	public List<Enterprise> getEnterprises(String[] areas, int size) {
		List<Enterprise> enterpriseList = new ArrayList<Enterprise>();
		for(String area:areas){
			enterpriseList.addAll(getEnterprises(area, size));
		}
		return enterpriseList;
	}

	public List<Enterprise> getEnterprises(String area, int size) {
		// 购买套餐的企业
		List<Enterprise> displayList = new DisplayEnterpriseDAO()
				.findAllByArea(area);
		// size个企业
		List<Enterprise> allEnterprises = new EnterpriseDAO().findByProperty(
				EnterpriseDAO.COUNTY, area, 0, size);
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
	 * 根据企业id删除展示的内容
	 * @param corpId
	 */
	public void deleteShowCorpByCorpIdNoTranscation(int corpId) {
		DisplayEnterpriseDAO showCorpDao = new DisplayEnterpriseDAO();
		
		showCorpDao.deleteByColumnNoTranscation(ENTERPRISE_ID, corpId);
	}
	
}
