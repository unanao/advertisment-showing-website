package com.bancai.web.pcenter;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterprisePicture;
import com.bancai.dao.Phone;
import com.bancai.service.EnterprisePictureService;
import com.bancai.service.EnterpriseService;
import com.bancai.service.PhoneService;
import com.bancai.utils.xss.HTMLInputFilter;
import com.bancai.web.base.BaseAction;

public class UpdateEnterpriseAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1976514987076291500L;
	private int enterpriseId;
	private String name;
	private String province;
	private String city;
	private String county;
	private String address;
	private Integer scale;
	private String introduction;
	private String contacter;
	private String number;
	private File logo;
	private String logoFileName;
	Logger logger = Logger.getLogger(UpdateEnterpriseAction.class);
	
	/*
	 *目录结构 /picture/用户id/enterprise/图片文件 
	 */
	public String execute(){
		EnterpriseService service = new EnterpriseService();
		Enterprise enterprise = null;
		Phone phone = null;
		enterpriseId = getEnterpriseId();
		if(enterpriseId == BancaiConstants.DEFAULT_ID){
			enterprise = new Enterprise();
			enterprise.setPicNum(BancaiConstants.DEFAULT_PICTURE_MAX_NUMBER);
			phone = new Phone();
		}else{
		    enterprise = service.getEnterprise(enterpriseId);
		    phone = new PhoneService().getPhonesByEnterpriseId(enterpriseId).get(0);
		}
		
		
		enterprise.setName(name);
		if(BancaiConstants.CITY_CASCADE_DEFAULT.equals(province)){
			province = null;
		}
		if(BancaiConstants.CITY_CASCADE_DEFAULT.equals(city)){
			city = null;
		}
		if(BancaiConstants.CITY_CASCADE_DEFAULT.equals(county)){
			county = null;
		}
		enterprise.setProvince(province);
		enterprise.setCity(city);
		enterprise.setCounty(county);
		enterprise.setAddress(address);
		enterprise.setScale(scale);
		enterprise.setIntroduction(introduction);
		phone.setContacter(contacter);
		phone.setNumber(number);
		
		if(enterpriseId == BancaiConstants.DEFAULT_ID)
		{
			service.saveEnterpriseAndPhone(enterprise, phone, getUserId());
			getSession().put(SESSION_ENTERPRISE_ID, enterprise.getId());
		}
		

		//存储用户上传的图片
		Collection<EnterprisePicture> pictures = getsEnterprisePictureMap()
								.values();
		List<Integer> pictureIdList = new ArrayList<Integer>();
		for (EnterprisePicture picture : pictures) {
			if(picture.getId() != null){
				pictureIdList.add(picture.getId());
			}
		}
		new EnterprisePictureService().deleteEnterprisePictures(pictureIdList);
		for (EnterprisePicture picture : pictures) {
			picture.setEnterpriseId(getEnterpriseId());
			//将最新上传的临时目录里面的图片转存到永久目录
			if(picture.getId() == null){
				String targetPath = PictureOperation.getUniqueEnterprisePictureRelativePath(picture.getPath(),getUserId());
				PictureOperation.copressFileToDest(picture.getPath(),targetPath,BancaiConstants.COMPRESS_TARGET_WIDTH,BancaiConstants.COMPRESS_TARGET_HEIGHT);
				picture.setPath(targetPath);
				if(PictureOperation.existPicture(targetPath)){
					new EnterprisePictureService().save(picture);
				}
			}
		}
		
		//更新封面信息
		EnterprisePicture pubEnterprisePicture = getPubEnterprisePicture();
		if (pubEnterprisePicture != null) {
			enterprise.setLogo(PictureOperation.getUniqueEnterprisePictureRelativePath(pubEnterprisePicture.getPath(),getUserId()));
		}
		
		try {
			service.updateEnterpriseAndPhone(enterprise, phone);
			return SUCCESS;
		} catch (RuntimeException re) {
			logger.log(Level.FATAL, "update error", re);
			return ERROR;
		}

	}
	public void setName(String name) {
		this.name = new HTMLInputFilter().filter(name);
	}
	public void setProvince(String province) {
		this.province = new HTMLInputFilter().filter(province);
	}
	
	public void setCity(String city) {
		this.city = new HTMLInputFilter().filter(city);
	}
	public void setCounty(String county) {
		this.county = new HTMLInputFilter().filter(county);
	}
	public void setAddress(String address) {
		this.address = new HTMLInputFilter().filter(address);
	}
	public void setScale(Integer scale) {
		this.scale = (scale);
	}
	public void setIntroduction(String introduction) {
		this.introduction = new HTMLInputFilter().filter(introduction);
	}
	public void setContacter(String contacter) {
		this.contacter = new HTMLInputFilter().filter(contacter);
	}
	public void setNumber(String number) {
		this.number = new HTMLInputFilter().filter(number);
	}
	public void setLogo(File logo) {
		this.logo = logo;
	}
	public void setEnterpriseId(int enterpriseId) {
		this.enterpriseId = enterpriseId;
	}
	public void setLogoFileName(String logoFileName) {
		this.logoFileName = new HTMLInputFilter().filter(logoFileName);
	}
	public String getName() {
		return new HTMLInputFilter().filter(name);
	}
	public String getProvince() {
		return new HTMLInputFilter().filter(province);
	}
	public String getCity() {
		return new HTMLInputFilter().filter(city);
	}
	public String getCounty() {
		return new HTMLInputFilter().filter(county);
	}
	public String getAddress() {
		return new HTMLInputFilter().filter(address);
	}
	public Integer getScale() {
		return scale;
	}
	public String getIntroduction() {
		return new HTMLInputFilter().filter(introduction);
	}
	public String getContacter() {
		return new HTMLInputFilter().filter(contacter);
	}
	public String getNumber() {
		return new HTMLInputFilter().filter(number);
	}
	public File getLogo() {
		return logo;
	}
	public String getLogoFileName() {
		return new HTMLInputFilter().filter(logoFileName);
	}
	
}
