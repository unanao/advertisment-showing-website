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

import com.bancai.dao.ProductPicture;
import com.bancai.service.EnterpriseService;
import com.bancai.web.base.BaseAction;

public class SaveProductPictureAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4309474600020834915L;
	private int productId;
	private int id;
	private File file;
    private String fileFileName;
    private String fileFileContentType;
    private String filePath;
    private String message = "你已成功上传文件";
    
 
	@Override
    public String execute()  {
		Map<Integer, ProductPicture> productMap = getsProductPictureMap();
		long maxPicNumber = new EnterpriseService().getMaxPictureNumber(getEnterpriseId());
		if(productMap.size() >= maxPicNumber){
				return SUCCESS;
		}
		
		filePath = PictureOperation.getUniqueJpgPictureTempRelativePath(fileFileName);
		PictureOperation.saveProductPicture(file, filePath);
		ProductPicture productPicture = new ProductPicture();
		productPicture.setProductId(productId);
		productPicture.setPath(filePath);

		productMap.put(id, productPicture);
        return SUCCESS;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
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
