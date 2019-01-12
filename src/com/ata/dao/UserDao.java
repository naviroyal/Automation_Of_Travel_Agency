package com.ata.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ata.bean.ProfileBean;
import com.ata.util.Config;

public class UserDao {
	java.sql.Connection con = Config.getConnection();
	public String createUser(ProfileBean profileBean) {
		PreparedStatement ps;
		String userId = profileBean.getUserId();
		String firstName = profileBean.getFirstName();
		String lastName = profileBean.getLastName();
		Date dateOfBirth = profileBean.getDateOfBirth();
		String gender = profileBean.getGender(); 
		String street = profileBean.getStreet();
		String location = profileBean.getLocation();
		String city = profileBean.getCity();
		String state = profileBean.getState();
		String pincode = profileBean.getPincode();
		String mobileNo = profileBean.getMobileNo();
		String emailId = profileBean.getEmailId();
		try {
			
			ps = con.prepareStatement("insert into user_profile values(?,?,?,?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, userId);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setDate(4, dateOfBirth);
			ps.setString(5, gender);
			ps.setString(6, street);
			ps.setString(7, location);
			ps.setString(8, city);
			ps.setString(9, state);
			ps.setString(10, pincode);
			ps.setString(11, mobileNo);
			ps.setString(12, emailId);
			int a = ps.executeUpdate();
			if(a>0) return "Success";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
		return "unsuccessful";

	}
	int deleteUser(ArrayList<String> userId) {
		PreparedStatement ps;
		int a = 0;
		for(int i=0; i<userId.size(); i++) {
			try {
				ps = con.prepareStatement("delete from user_profile where userid = ?");
				ps.setString(1, userId.get(i));
				int p = ps.executeUpdate();
				if(p>0)a++;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			
		}
		return a;
	}
	boolean updateUser(ProfileBean profileBean) {
		PreparedStatement ps;
		String userId = profileBean.getUserId();
		String firstName = profileBean.getFirstName();
		String lastName = profileBean.getLastName();
		Date dateOfBirth = profileBean.getDateOfBirth();
		String gender = profileBean.getGender(); 
		String street = profileBean.getStreet();
		String location = profileBean.getLocation();
		String city = profileBean.getCity();
		String state = profileBean.getState();
		String pincode = profileBean.getPincode();
		String mobileNo = profileBean.getMobileNo();
		String emailId = profileBean.getEmailId();
		try {
			ps = con.prepareStatement("update user_profile set first_name = ?, last_name = ?, date_of_birth = ?, gender = ?, street = ?, location =?, city =?, state=?, pincode=?, mobile_no=?, email_id=? where userid = ?");
			ps.setString(1, firstName);
			ps.setString(2, lastName);
			ps.setDate(3, dateOfBirth);
			ps.setString(4, gender);
			ps.setString(5, street);
			ps.setString(6, location);
			ps.setString(7, city);
			ps.setString(8, state);
			ps.setString(9, pincode);
			ps.setString(10, mobileNo);
			ps.setString(11, emailId);
			ps.setString(12, userId);
			final int a = ps.executeUpdate();
			if(a>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
		
	}
	public ProfileBean findByID(String userId) {
		ProfileBean cb = new ProfileBean();
		System.out.println(userId);
		try {
			PreparedStatement ps = con.prepareStatement("select * from user_profile where userid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cb.setUserId(rs.getString(1));
				cb.setFirstName(rs.getString(2));
				cb.setLastName(rs.getString(3));
				cb.setDateOfBirth(rs.getDate(4));
				cb.setGender(rs.getString(5));
				cb.setStreet(rs.getString(6));
				cb.setLocation(rs.getString(7));
				cb.setCity(rs.getString(8));
				cb.setState(rs.getString(9));
				cb.setPincode(rs.getString(10));
				cb.setMobileNo(rs.getString(11));
				cb.setEmailId(rs.getString(12));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return cb;
	}
	ArrayList<ProfileBean> findAll(){
		ArrayList<ProfileBean> pb = new ArrayList<ProfileBean>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from user_profile");
			ResultSet rs = ps.executeQuery();
			ProfileBean cb = new ProfileBean();
			while(rs.next()) {
				cb.setUserId(rs.getString(1));
				cb.setFirstName(rs.getString(2));
				cb.setLastName(rs.getString(3));
				cb.setDateOfBirth(rs.getDate(4));
				cb.setGender(rs.getString(5));
				cb.setStreet(rs.getString(6));
				cb.setLocation(rs.getString(7));
				cb.setCity(rs.getString(8));
				cb.setState(rs.getString(9));
				cb.setPincode(rs.getString(10));
				cb.setMobileNo(rs.getString(11));
				cb.setEmailId(rs.getString(12));
				pb.add(cb);
			}
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}
}


