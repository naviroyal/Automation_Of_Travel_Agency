package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ata.bean.CredentialsBean;
import com.ata.util.Config;


public class CredentialsDao {
	Connection con = Config.getConnection(); 
	public String createCredential(CredentialsBean credentialsBean) {
		PreparedStatement ps;
		
		String id = credentialsBean.getUserId();
		String psw = credentialsBean.getPassword();
		String type = credentialsBean.getUserType();
		int loginStatus = credentialsBean.getLoginStatus();
		try {
			ps = con.prepareStatement("insert into user_credentials values(?, ?, ?, ?)");
			ps.setString(1, id);
			ps.setString(2, psw);
			ps.setString(3, type);
			ps.setInt(4, loginStatus);
			int a = ps.executeUpdate();
			if(a>0) return "Success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
		return "unsuccessful";
		
	}
	public int deleteCredential(ArrayList<String> userId) {
		PreparedStatement ps;
		int a = 0;
		for(int i=0; i<userId.size(); i++) {
			try {
				ps = con.prepareStatement("delete from user_credentials where userid = ?");
				ps.setString(1, userId.get(i));
				int p = ps.executeUpdate();
				if(p>0) a++;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}	
		}
		return a;
		
	}
	public boolean updateCredential(CredentialsBean credentialsBean) {
		String id = credentialsBean.getUserId();
		int loginStatus = credentialsBean.getLoginStatus();
		try {
			PreparedStatement ps = con.prepareStatement("update user_credentials set loginstatus = ? where userid = ?");
			ps.setInt(1, loginStatus);
			ps.setString(2, id);
			int a = ps.executeUpdate();
			if(a>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	public boolean updatePassword(CredentialsBean credentialsBean) {
		String id = credentialsBean.getUserId();
		String password = credentialsBean.getPassword();
		try {
			PreparedStatement ps = con.prepareStatement("update user_credentials set password = ? where userid = ?");
			ps.setString(1, password);
			ps.setString(2, id);
			int a = ps.executeUpdate();
			if(a>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}

	public CredentialsBean findByID(String userId) {
		CredentialsBean cb = new CredentialsBean();
		
		System.out.println(userId);
		System.out.println("bsd");
		try {
			PreparedStatement ps = con.prepareStatement("select * from user_credentials where userid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cb.setUserId(rs.getString(1));
				cb.setPassword(rs.getString(2));
				cb.setUserType(rs.getString(3));
				cb.setLoginStatus(rs.getInt(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return cb;
	}
	ArrayList<CredentialsBean> findAll(){
		ArrayList<CredentialsBean> cb = new ArrayList<CredentialsBean>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from user_credentials");
			ResultSet rs = ps.executeQuery();
			CredentialsBean c = new CredentialsBean();
			while(rs.next()) {
				c.setUserId(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setUserType(rs.getString(3));
				c.setLoginStatus(rs.getInt(4));
				cb.add(c);
			}
			return cb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}
