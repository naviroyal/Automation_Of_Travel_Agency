package com.ata.util;

import com.ata.bean.CredentialsBean;
import com.ata.dao.CredentialsDao;


public class Authentication implements Authenticate{
	CredentialsDao cd = new CredentialsDao();
	@Override
	public boolean authenticate(CredentialsBean credentialsBean) {
		
		String userId = credentialsBean.getUserId();
		String password = credentialsBean.getPassword();
		CredentialsBean cb = cd.findByID(userId);
		String usr = cb.getUserId();
		String psw = cb.getPassword();
		System.out.println("authenticate");
		if(userId.equals(usr) && password.equals(psw)) {
			System.out.println("authenticate1");
			return true;
		}
		
		return false;
	}

	@Override
	public String authorize(String userId) {
		CredentialsBean cb = cd.findByID(userId);
		String s = cb.getUserType();
		System.out.println("authenticate2  "+s);
		return s;
	}

	@Override
	public boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus) {
		credentialsBean.setLoginStatus(loginStatus);
		System.out.println(credentialsBean.getLoginStatus()+" "+credentialsBean.getUserId());
		if(cd.updateCredential(credentialsBean)) {
			return true;
		}
			return false;
		}

}
