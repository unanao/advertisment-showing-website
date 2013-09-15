/*
 * Copyright (C) 1998-2012 58BanCai Team.All Rights Reserved.		
 * 														
 * FileName: SaveProductPictureAction.java					
 *			
 * Description:										
 */

package com.bancai.web.pcenter;

import java.io.File;
import java.util.Map;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.EnterprisePicture;
import com.bancai.service.EnterpriseService;
import com.bancai.web.base.BaseAction;

public class SaveEnterprisePictureAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4309474600020834915L;
	private Integer enterpriseId;
	private Integer id;
	private File file;
    private String fileFileName;
    private String fileFileContentType;
    private String filePath;
    private String message = "你已成功上传文件";
    
  
	@Override
    public String execute()  {
		if(enterpriseId == null ){
			return ERROR;
		}
		long maxPicNumber = new EnterpriseService().getMaxPictureNumber(enterpriseId);
		if(enterpriseId.equals(BancaiConstants.DEFAULT_ID)){
			maxPicNumber = BancaiConstants.DEFAULT_PICTURE_MAX_NUMBER;
		}
		Map<Integer, EnterprisePicture> map = getsEnterprisePictureMap();
		if(map.size() >= maxPicNumber){
			return SUCCESS;
		}
		filePath = PictureOperation.getUniqueJpgPictureTempRelativePath(fileFileName);
		PictureOperation.saveEnterprisePicture(file, filePath);
		EnterprisePicture enterprisePicture = new EnterprisePicture();
		enterprisePicture.setEnterpriseId(enterpriseId);
		enterprisePicture.setPath(filePath);
		map.put(id, enterprisePicture);

        return SUCCESS;
    }
	  
	public void setId(Integer id) {
		this.id = id;
	}

	public void setEnterpriseId(Integer enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileFileContentType() {
		return fileFileContentType;
	}

	public void setFileFileContentType(String fileFileContentType) {
		this.fileFileContentType = fileFileContentType;
	}

	public String getFilePath() {
		return filePath;
	}
	 
}
