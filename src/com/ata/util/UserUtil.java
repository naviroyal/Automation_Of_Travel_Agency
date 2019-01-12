package com.ata.util;
import com.ata.bean.CredentialsBean;
import com.ata.bean.ProfileBean;
import com.ata.dao.CredentialsDao;
import com.ata.dao.UserDao;

public class UserUtil implements User {
	private Authentication auth = new Authentication();
	@Override
	public String login(CredentialsBean credentialsBean) {
//		ProfileBean pb = (new UserDao()).findByID(userId)
		if(auth.authenticate(credentialsBean)) {
			CredentialsDao cd = new CredentialsDao();
			System.out.println("A");
			CredentialsBean cb = cd.findByID(credentialsBean.getUserId());
			System.out.println("B");
			String type = cb.getUserType();
			return type;
		}
			// TODO Auto-generated method stub
		return "C";
	}

	@Override
	public boolean logout(String userId) {
		CredentialsBean cb = new CredentialsBean();
		cb.setUserId(userId);
		if(auth.changeLoginStatus(cb, 0)) return true;
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String changePassword(CredentialsBean credentialsBean, String newPassword) {
		if(auth.authenticate(credentialsBean)) {
			credentialsBean.setPassword(newPassword);
			CredentialsDao cd = new CredentialsDao();
			if(cd.updatePassword(credentialsBean)) 
				return "S";
		// TODO Auto-generated method stub
		}
		return "F";
	}

	@Override
	public String register(ProfileBean profileBean, CredentialsBean credentialsBean) {
		UserDao ud = new UserDao();
		CredentialsDao cd = new CredentialsDao();
		if(ud.createUser(profileBean).equals("Success") && cd.createCredential(credentialsBean).equals("Success")) {
			return "S";
		}
		return "F";
	}

}
