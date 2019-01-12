package com.ata.util;
import com.ata.bean.*;
public interface User {
	String login(CredentialsBean credentialsBean);
	boolean logout(String userId);
	String changePassword(CredentialsBean credentialsBean, String newPassword);
	String register(ProfileBean profileBean, CredentialsBean credentialsBean);
	
}
