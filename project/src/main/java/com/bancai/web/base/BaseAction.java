/*
 * $Id: ExampleSupport.java 739661 2009-02-01 00:06:00Z davenewton $
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.bancai.web.base;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.EnterprisePicture;
import com.bancai.dao.Product;
import com.bancai.dao.ProductPicture;
import com.bancai.web.pcenter.PictureOperation;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 自定义的Struts2基类
 * @author hubaiyu
 *
 */
public class BaseAction extends ActionSupport implements AccountsContants{
	public static final String PRODUCT_MAP_KEY = "_";
	public static final String ENTERPRISE_MAP_KEY = "__";
	public static final String PUB_PRODUCT_KEY = "___";
	public static final String PUB_ENTERPRISE_KEY = "____";
    /**
     * 测试是否包含中文
     * @param str
     * @author yicou
     * @return
     */
    boolean containsChn(String str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= '\u4e00' && ch <= '\u9fa5') {
                return true;
            }
        }
        return false;
    }
    /**
     * 对于中文解码
     * @param str
     * @author yicou
     * @return
     */
    public String getDecodeString(String str) {
        String word = null;
        // 测试原文
        if (containsChn(str)) {
            return str;
        }
        // 测试ISO8859
        try {
            word = new String(str.getBytes("ISO8859_1"), "UTF8");
            if (containsChn(word)) {
                return word;
            }
        } catch(Exception ex) {
        }

        // 测试GBKID_INVALID_KEY
        try {
            word = new String(str.getBytes("GBK"), "UTF8");
            if (containsChn(word)) {
                return word;
            }
        } catch(Exception ex) {
        }
        return str;
    }
	private static final long serialVersionUID = -8486920562321594582L;

	public boolean hasFieldError(String fieldName) {
		return this.getFieldErrors().get(fieldName) != null
			&& this.getFieldErrors().get(fieldName).size() > 0;
	}
	
	public String getFieldError(String fieldName) {
		return hasFieldError(fieldName) ? this.getFieldErrors().get(fieldName).get(0) : "";
	}
	
	public Integer getUserId(){
		Object object = getSession().get(SESSION_USER_ID);
		return object == null?-1:(Integer)object;
	}
	public Integer getEnterpriseId(){
		Object object = getSession().get(SESSION_ENTERPRISE_ID);
		return object == null?-1:(Integer)object;
	}
	public Map<String,Object> getSession(){
		return ActionContext.getContext().getSession();
	}
	/**
	 * 存储编号和产品图片封面对应关系
	 * @param enterprisePictureId
	 */
	public void putPubProductPicture(ProductPicture productPicture){
		getSession().put(PUB_PRODUCT_KEY, productPicture);
	}
	
	/**
	 * 根据编号获得产品图片封面
	 */
	public ProductPicture getPubProductPicture(){
		return (ProductPicture)getSession().get(PUB_PRODUCT_KEY);
	}
	
	public Map<Integer, ProductPicture> getsProductPictureMap(){
		@SuppressWarnings("unchecked")
		Map<Integer, ProductPicture> object = (Map<Integer, ProductPicture>)getSession().get(PRODUCT_MAP_KEY);
		if (object == null) {
			object = new HashMap<Integer, ProductPicture>();
			getSession().put(PRODUCT_MAP_KEY, object);
		}
		return object;
	}
	/**
	 * 删除用户未点击保存的图片
	 */
	public void clearUnpersistentProductPicture(){
		for(EnterprisePicture picture : getsEnterprisePictureMap().values()){
			if(picture.getId() == null){
				PictureOperation.deletePicture(picture.getPath());
			}
		}
	}
	/**
	 * 存储编号和企业图片封面对应关系
	 * @param enterprisePictureId
	 */
	public void putPubEnterprisePicture(EnterprisePicture enterprisePicture){
		getSession().put(PUB_ENTERPRISE_KEY, enterprisePicture);
	}
	
	/**
	 * 根据编号获得企业图片封面
	 */
	public EnterprisePicture getPubEnterprisePicture(){
		return (EnterprisePicture)getSession().get(PUB_ENTERPRISE_KEY);
	}
	
	/**
	 * 获得非封面的企业图面列表
	 * @return
	 */
	public Map<Integer, EnterprisePicture> getsEnterprisePictureMap(){
		@SuppressWarnings("unchecked")
		Map<Integer, EnterprisePicture> object = (Map<Integer, EnterprisePicture>)getSession().get(ENTERPRISE_MAP_KEY);
		if (object == null) {
			object = new HashMap<Integer, EnterprisePicture>();
			getSession().put(ENTERPRISE_MAP_KEY, object);
		}
		return object;
	}
	/**
	 * 删除用户未点击保存的图片
	 */
	public void clearUnpersistentEnterprisePicture(){
		for(EnterprisePicture picture : getsEnterprisePictureMap().values()){
			if(picture.getId() == null){
				PictureOperation.deletePicture(picture.getPath());
			}
		}
	}
	
	public void changeProductPicture(List<Product> products){
		
		for(Product p : products){
			if(p.getIcon() == null){
				p.setIcon(BancaiConstants.PRODUCT_DEFAULT_PATH);
			}else{
				if(!PictureOperation.existPicture(p.getIcon())){
					p.setIcon(BancaiConstants.PRODUCT_DEFAULT_PATH);
				}
			}
		}
	}
	public void changeEnterprisePicture(List<Enterprise> enterprises){
		for(Enterprise e : enterprises){
			if(e.getLogo() == null){
				e.setLogo(BancaiConstants.ENTERPRISE_DEFAULT_PATH);
			}else{
				if(!PictureOperation.existPicture(e.getLogo())){
					e.setLogo(BancaiConstants.ENTERPRISE_DEFAULT_PATH);
				}
			}
		}
	}
}
	
