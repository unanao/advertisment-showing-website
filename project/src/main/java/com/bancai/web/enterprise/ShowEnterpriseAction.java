package com.bancai.web.enterprise;

import java.util.ArrayList;
import java.util.List;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterprisePicture;
import com.bancai.dao.Phone;
import com.bancai.dao.Product;
import com.bancai.service.EnterprisePictureService;
import com.bancai.service.EnterpriseService;
import com.bancai.service.PhoneService;
import com.bancai.service.ProductService;
import com.bancai.web.base.BaseAction;

public class ShowEnterpriseAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4508774070535102459L;
	private int enterpriseId;
	private Enterprise enterprise;
	private Phone phone;
	private List<Product> products;
	private List<EnterprisePicture> enterprisePictures;
	public String execute(){
		EnterpriseService service = new EnterpriseService();
		if(enterpriseId == Integer.valueOf(BancaiConstants.DEFAULT_ID)){
			return INPUT;
		}
		enterprise = service.getEnterprise(enterpriseId);
		List<Enterprise> enterprises = new ArrayList<Enterprise>();
		enterprises.add(enterprise);
		changeEnterprisePicture(enterprises);
		enterprisePictures = new EnterprisePictureService().findAllByEnterpriseId(enterpriseId);
		List<Phone> phones = new PhoneService().getPhonesByEnterpriseId(enterpriseId);
		if(phones!=null&&phones.size()>0) phone = phones.get(0);
		products = new ProductService().getAllProductsByEnterpriseId(enterpriseId);
		changeProductPicture(products);
		return SUCCESS;
	}
	public Enterprise getEnterprise(){
		return enterprise;
	}
	public void setEnterpriseId(int enterpriseId){
		this.enterpriseId = enterpriseId;
	}
	public Phone getPhone(){
		return phone;
	}
	public List<Product> getProducts() {
		return products;
	}
	
	public List<EnterprisePicture> getEnterprisePictures(){
		return enterprisePictures;
	}
	
}
