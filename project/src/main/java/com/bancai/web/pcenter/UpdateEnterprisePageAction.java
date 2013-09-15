package com.bancai.web.pcenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterprisePicture;
import com.bancai.dao.EnterprisePictureDAO;
import com.bancai.dao.Phone;
import com.bancai.service.EnterprisePictureService;
import com.bancai.service.EnterpriseService;
import com.bancai.service.PhoneService;
import com.bancai.web.base.BaseAction;

public class UpdateEnterprisePageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4508774070535102459L;
	private int enterpriseId;
	private Enterprise enterprise;
	private Phone phone;
	private String message;
	private Map<Integer, EnterprisePicture> enterprisePictureMap = new HashMap<Integer, EnterprisePicture>(); 
	final int PICTURE_START_INDEX = -1;
	public String execute(){
		EnterpriseService service = new EnterpriseService();
		enterpriseId = getEnterpriseId();
		
		//如果是新建企业
		if(enterpriseId==-1){
			enterprise = new Enterprise();
			phone = new Phone();
			return SUCCESS;
		}

		clearUnpersistentEnterprisePicture();
		getsEnterprisePictureMap().clear();

		enterprise = service.getEnterprise(getEnterpriseId());
		List<Phone> phones = new PhoneService()
				.getPhonesByEnterpriseId(enterpriseId);
		List<EnterprisePicture> enterprisePictures = new EnterprisePictureService()
				.findAllByEnterpriseId(enterpriseId);
		
		//返回已存在图片以及对应编号
		int key = PICTURE_START_INDEX;
		for (EnterprisePicture picture : enterprisePictures) {
			
			//对于不存在的图片，将记录从数据库中删除
			if(!PictureOperation.existPicture(picture.getPath())){
				new EnterprisePictureService().deleteByPrimaryKey(picture.getId());
			}
			enterprisePictureMap.put(key, picture);
			if (picture.getStatus() != null
					&& picture.getStatus() == EnterprisePictureDAO.PUB_STATUS) {
				putPubEnterprisePicture(picture);
			}
			getsEnterprisePictureMap().put(key, picture);
			key--;
			if (-key > new EnterpriseService()
					.getMaxPictureNumber(enterpriseId)) {
				break;
			}
		}
		if (phones != null && phones.size() > 0) {
			phone = phones.get(0);
		}
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<Integer, EnterprisePicture> getEnterprisePictureMap() {
		return enterprisePictureMap;
	}
}
