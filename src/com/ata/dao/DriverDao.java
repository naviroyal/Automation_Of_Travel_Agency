package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ata.bean.DriverBean;
import com.ata.util.Config;

public class DriverDao {
	Connection con = Config.getConnection(); 
	
	String createDriver(DriverBean driverBean) {
		PreparedStatement ps;
		final String driverId = driverBean.getDriverId();
		final String name = driverBean.getName();
		final String city = driverBean.getCity();
		final String location = driverBean.getLocation();
		final String mobileNo = driverBean.getDriverId();
		final String licenceNo = driverBean.getLicenseNumber();
		final String pincode = driverBean.getPincode();
		final String street = driverBean.getStreet();
		final String state = driverBean.getState();
		
			try {
				ps = con.prepareStatement("insert into driver values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
				ps.setString(1, driverId);
				ps.setString(2, name);
				ps.setString(3, street);
				ps.setString(4, location);
				ps.setString(5, city);
				ps.setString(6, state);
				ps.setString(7, pincode);
				ps.setString(8, mobileNo);
				ps.setString(9, licenceNo);
				int a = ps.executeUpdate();
				if(a>0) return "Successful";
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "unsuccessful";
			}
			return "unsuccessful";
		
	}

	int deleteDriver(ArrayList<String> driverId) {
		PreparedStatement ps;
		int a = 0;
		for(int i=0; i<driverId.size(); i++) {
			try {
				ps = con.prepareStatement("delete from driver where driverid = ?");
				ps.setString(1, driverId.get(i));
				
				final int p = ps.executeUpdate();
				if(p>0) a++;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return 0;
			}
			
		}
		return a;
		
	}
	boolean updateDriver(DriverBean driverBean) {
		final PreparedStatement ps;
		final String driverId = driverBean.getDriverId();
		final String name = driverBean.getName();
		final String city = driverBean.getCity();
		final String location = driverBean.getLocation();
		final String mobileNo = driverBean.getDriverId();
		final String licenceNo = driverBean.getLicenseNumber();
		final String pincode = driverBean.getPincode();
		final String street = driverBean.getStreet();
		final String state = driverBean.getState();
		try {
			ps = con.prepareStatement("update driver set name = ?, street = ?, location = ?, city = ?, state = ?, pincode = ?, mobile_no = ?, licence_number = ? where driverid = ?");
			ps.setString(9, driverId);
			ps.setString(1, name);
			ps.setString(2, street);
			ps.setString(3, location);
			ps.setString(4, city);
			ps.setString(5, state);
			ps.setString(6, pincode);
			ps.setString(7, mobileNo);
			ps.setString(8, licenceNo);
			
			final int a = ps.executeUpdate();
			if(a>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return false;
		
	}
	DriverBean findByID(String driverId) {
		DriverBean db = new DriverBean();
		try {
			PreparedStatement ps = con.prepareStatement("select * from driver where driverid = ?");
			ps.setString(1, driverId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				db.setDriverId(rs.getString(1));
				db.setName(rs.getString(2));
				db.setStreet(rs.getString(3));
				db.setLocation(rs.getString(4));
				db.setCity(rs.getString(5));
				db.setState(rs.getString(6));
				db.setPincode(rs.getString(7));
				db.setMobileNo(rs.getString(8));
				db.setLicenseNumber(rs.getString(9));
			}
			return db;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	ArrayList<DriverBean> findAll(){
		ArrayList<DriverBean> cb = new ArrayList<DriverBean>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from driver");
			ResultSet rs = ps.executeQuery();
			DriverBean db = new DriverBean();
			while(rs.next()) {
				
				db.setDriverId(rs.getString(1));
				db.setName(rs.getString(2));
				db.setStreet(rs.getString(3));
				db.setLocation(rs.getString(4));
				db.setCity(rs.getString(5));
				db.setState(rs.getString(6));
				db.setPincode(rs.getString(7));
				db.setMobileNo(rs.getString(8));
				db.setLicenseNumber(rs.getString(9));
				cb.add(db);
				
			}
			return cb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}

}
