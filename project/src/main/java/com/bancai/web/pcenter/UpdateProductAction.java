package com.bancai.web.pcenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.bancai.constants.BancaiConstants;
import com.bancai.dao.Product;
import com.bancai.dao.ProductPicture;
import com.bancai.service.ProductPictureService;
import com.bancai.service.ProductService;
import com.bancai.utils.xss.HTMLInputFilter;
import com.bancai.web.base.BaseAction;

public class UpdateProductAction extends BaseAction
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1976514987076291500L;
	private Integer productId;
	private String name;
	private String introduction;
	private String category;
	private String detail;
	Logger logger = Logger.getLogger(UpdateProductAction.class);

	/*
	 * 目录结构 /picture/用户id/product/图片文件
	 */
	public String execute()
	{
		ProductService service = new ProductService();
		Product product = null;
		if (productId == null || productId.equals(BancaiConstants.DEFAULT_ID))
		{
			product = new Product();
		}
		else
		{
			product = service.getProduct(productId);
		}
		product.setName(name);
		product.setIntroduction(introduction);
		if(BancaiConstants.CATEGORY_CASCADE_DEFAULT.equals(category)){
			category = null;
		}
		if(BancaiConstants.CATEGORY_CASCADE_DEFAULT.equals(detail)){
			detail = null;
		}
		product.setCategory(category);
		product.setDetail(detail);
		product.setEnterprise(getEnterpriseId());

		if (productId == null || productId.equals(BancaiConstants.DEFAULT_ID))
		{
			service.saveProduct(product);
		}

		// 存储用户上传的图片
		Collection<ProductPicture> pictures = getsProductPictureMap().values();
		List<Integer> pictureIdList = new ArrayList<Integer>();
		for (ProductPicture picture : pictures)
		{
			pictureIdList.add(picture.getId());
		}
		new ProductPictureService().deleteProductPictures(pictureIdList);
		for (ProductPicture picture : pictures)
		{
			picture.setProductId(product.getId());
			// 将新上传的临时目录里面的图片转存到永久目录
			if (picture.getId() == null)
			{
				String targetPath = PictureOperation
						.getUniqueProductPictureRelativePath(picture.getPath(),getUserId());
				PictureOperation.copressFileToDest(picture.getPath(), targetPath,
						BancaiConstants.COMPRESS_TARGET_WIDTH,
						BancaiConstants.COMPRESS_TARGET_HEIGHT);
				picture.setPath(targetPath);
				//如果图片存在则存储，否则将其从缓存中删除
				if(PictureOperation.existPicture(targetPath)){
					new ProductPictureService().save(picture);
				}
			}
		}

		// 将封面图片进行更新
		ProductPicture pubProductPicture = getPubProductPicture();
		if (pubProductPicture != null)
		{
			product.setIcon(pubProductPicture.getPath());
		}

		try
		{
			service.updateProduct(product);
		}
		catch (RuntimeException re)
		{
			logger.log(Level.FATAL, "update error", re);
		}

		return SUCCESS;
	}

	public void setProductId(Integer productId)
	{
		this.productId = productId;
	}

	public void setName(String name)
	{
		this.name = new HTMLInputFilter().filter(name);
	}

	public void setIntroduction(String introduction)
	{
		this.introduction = new HTMLInputFilter().filter(introduction);
	}

	public void setCategory(String category)
	{
		this.category = new HTMLInputFilter().filter(category);
	}

	public void setDetail(String detail)
	{
		this.detail = new HTMLInputFilter().filter(detail);
	}
	
	public Integer getProductId()
	{
		return productId;
	}

	public String getName()
	{
		return new HTMLInputFilter().filter(name);
	}

	public String getIntroduction()
	{
		return new HTMLInputFilter().filter(introduction);
	}

	public String getDetail()
	{
		return new HTMLInputFilter().filter(detail);
	}
	
	public String getCategory()
	{
		return new HTMLInputFilter().filter(category);
	}

}
