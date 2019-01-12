package com.ata.util;

import com.ata.bean.CredentialsBean;

public interface Authenticate {
	boolean authenticate(CredentialsBean credentialsBean);
	String authorize(String userId);
	boolean changeLoginStatus(CredentialsBean credentialsBean, int loginStatus);
}
