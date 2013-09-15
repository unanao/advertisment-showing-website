package com.bancai.web.pcenter;

import com.bancai.constants.BancaiConstants;
import com.bancai.web.base.BaseAction;

public class SaveProductPageAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2230055768896064290L;
	private Integer productId = BancaiConstants.DEFAULT_ID;//默认产品的id
	public String execute() {
		clearUnpersistentProductPicture();
		getsProductPictureMap().clear();
		return SUCCESS;
	}

	public Integer getProductId(){
		return productId;
	}

}
