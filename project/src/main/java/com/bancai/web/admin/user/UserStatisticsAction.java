package com.bancai.web.admin.user;

import com.bancai.constants.AccountsContants;
import com.bancai.service.UserService;
import com.opensymphony.xwork2.ActionSupport;

public class UserStatisticsAction extends ActionSupport implements AccountsContants {
	private static final long serialVersionUID = -2659352469955178662L;
	public Long registerNr;
	public Long activateNr;
	public Long unactivateNr;
	public Long frozenNr;
	
	@Override
	public String execute() throws Exception {
		UserService userService = new UserService();
		
		try {
			registerNr = userService.registerUserNr();
			activateNr = userService.statusUserNr(ACTIVATED);
			unactivateNr = userService.statusUserNr(UNACTIVATED);
			frozenNr = userService.statusUserNr(FREEZED);
			
			return SUCCESS;
		} catch (Exception ex) {
			addActionError("获取注册用户个数");
			
			return ERROR;
		}
	}
	
	public Long getRegisterNr() {
		return registerNr;
	}

	public Long getActivateNr()
	{
		return activateNr;
	}

	public void setActivateNr(Long activateNr)
	{
		this.activateNr = activateNr;
	}

	public Long getUnactivateNr()
	{
		return unactivateNr;
	}

	public void setUnactivateNr(Long unactivateNr)
	{
		this.unactivateNr = unactivateNr;
	}

	public Long getFrozenNr()
	{
		return frozenNr;
	}

	public void setFrozenNr(Long frozenNr)
	{
		this.frozenNr = frozenNr;
	}

	public void setRegisterNr(Long registerNr)
	{
		this.registerNr = registerNr;
	}
}
