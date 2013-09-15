package com.bancai.web.pcenter;

import java.util.List;
import java.util.Map;

import com.bancai.constants.AccountsContants;
import com.bancai.dao.Enterprise;
import com.bancai.dao.Product;
import com.bancai.service.EnterpriseService;
import com.bancai.service.PackageService;
import com.bancai.service.ProductService;
import com.bancai.service.UserService;
import com.bancai.utils.xss.HTMLInputFilter;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.bancai.dao.Package;

public class PersonalSummaryAction extends ActionSupport implements AccountsContants {
	private static final long serialVersionUID = 9028920398230478396L;
	private String name;
	private List<Package> packages;
	private Enterprise enterprise;
	private List<Product> products;
	
	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		PackageService packageService = new PackageService();
		EnterpriseService enterpriseService = new EnterpriseService();
		ProductService productService = new ProductService();
		Map<String, Object> session = ActionContext.getContext().getSession();
		Integer userId = (Integer) session.get(SESSION_USER_ID);
		Integer enterpriseId = (Integer) session.get(SESSION_ENTERPRISE_ID);
		
		
		try {
			name = userService.getNameByUserId(userId);
			packages = packageService.getPackagesByEnterpriseId(enterpriseId);
			enterprise = enterpriseService.getEnterprise(enterpriseId);
			products = productService.getAllProductsByEnterpriseId(enterpriseId);
			
			return SUCCESS;
		} catch (Exception e) {
			addActionError("我们遇到了技术问题， 如果您有时间，通知我们");
			return ERROR;
		}
	}

	public String getName() {
		return new HTMLInputFilter().filter(name);
	}

	public List<Package> getPackages() {
		return packages;
	}

	public Enterprise getEnterprise() {
		return enterprise;
	}

	public List<Product> getProducts() {
		return products;
	}
}
