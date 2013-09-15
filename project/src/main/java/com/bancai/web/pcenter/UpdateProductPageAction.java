package com.bancai.web.pcenter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bancai.dao.Product;
import com.bancai.dao.ProductPicture;
import com.bancai.dao.ProductPictureDAO;
import com.bancai.service.EnterprisePictureService;
import com.bancai.service.EnterpriseService;
import com.bancai.service.ProductPictureService;
import com.bancai.service.ProductService;
import com.bancai.web.base.BaseAction;

public class UpdateProductPageAction extends BaseAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4508774070535102459L;
	private int productId;
	private Product	product;
	private Map<Integer, ProductPicture> productPictureMap = new HashMap<Integer, ProductPicture>(); 
	final int PICTURE_START_INDEX = -1;
	public String execute(){
		clearUnpersistentProductPicture();
		getsProductPictureMap().clear();
		
		ProductService service = new ProductService();
		product = service.getProduct(productId);
		List<ProductPicture> productPictures = new ProductPictureService().findAllByProductId(productId);
		int key = PICTURE_START_INDEX;
		for(ProductPicture picture : productPictures){
			
			//对于不存在的图片，将记录从数据库中删除
			if(!PictureOperation.existPicture(picture.getPath())){
				new EnterprisePictureService().deleteByPrimaryKey(picture.getId());
			}
			productPictureMap.put(key, picture);
			if(picture.getStatus()!=null && picture.getStatus() == ProductPictureDAO.PUB_STATUS){
				putPubProductPicture(picture);
			}
			getsProductPictureMap().put(key, picture);
			key--;
			if(-key > new EnterpriseService().getMaxPictureNumber(getEnterpriseId())){
				break;
			}
		}
		return SUCCESS;
	}
	public Product getProduct(){
		return product;
	}
	public  void setProductId(int productId){
		this.productId =productId;
	}
	
	public int getProductId(){
		return productId;
	}
	public Map<Integer, ProductPicture> getProductPictureMap() {
		return productPictureMap;
	}
	
}
