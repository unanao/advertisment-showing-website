package com.bancai.web.enterprise;

import java.util.List;

import com.bancai.dao.Enterprise;
import com.bancai.service.EnterpriseService;
import com.bancai.utils.Pager;
import com.bancai.web.base.BaseAction;

public class ListMoreEnterprisesAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4749786136088574102L;
	private List<Enterprise> enterprises;
	private String county;
	private Pager p = new Pager();
	public String execute(){
		enterprises = new EnterpriseService().listEnterprises(county,p);
		changeEnterprisePicture(enterprises);
		return SUCCESS;
	}
	public List<Enterprise> getEnterprises() {
		return enterprises;
	}
	
	public void setCounty(String county){
		this.county = county;
	}
	public String getCounty(){
		return county;
	}
	public Pager getP() {
		return p;
	}
	public void setP(Pager p) {
		this.p = p;
	}
	
}
