package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ata.bean.VehicleBean;
import com.ata.util.Config;

public class VehicleDao {
	Connection con = Config.getConnection();
	String createVehicle(VehicleBean vehicleBean) {
		String vehicleId = vehicleBean.getVehicleId();
		String name = vehicleBean.getName();
		String type = vehicleBean.getType();
		String registrationNumber = vehicleBean.getRegistrationNumber();
		int seatingCapacity = vehicleBean.getSeatingCapacity();
		double farePerKM = vehicleBean.getFarePerKM();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into vehicle values(?, ?, ?, ?, ?, ?)");
			ps.setString(1, vehicleId);
			ps.setString(2, name);
			ps.setString(3, type);
			ps.setString(4, registrationNumber);
			ps.setInt(5, seatingCapacity);
			ps.setDouble(6, farePerKM);
			int a = ps.executeUpdate();
			if(a>0) return "Successful";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
		return "unsuccessful";	
	}
	int deleteVehicle(ArrayList<String> vehicleId) {
		PreparedStatement ps;
		int a = 0;
		for(int i=0; i<vehicleId.size(); i++) {
			try {
				ps = con.prepareStatement("delete from vehicle where vehicleid = ?");
				ps.setString(1, vehicleId.get(i));
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
	boolean updateVehicle(VehicleBean vehicleBean) {
		String vehicleId = vehicleBean.getVehicleId();
		String name = vehicleBean.getName();
		String type = vehicleBean.getType();
		String registrationNumber = vehicleBean.getRegistrationNumber();
		int seatingCapacity = vehicleBean.getSeatingCapacity();
		double farePerKM = vehicleBean.getFarePerKM();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update vehicle set name = ?, type = ?, registration_number =?, seating_capacity = ?, fare_per_km = ? where vehicleid = ?");
			ps.setString(6, vehicleId);
			ps.setString(1, name);
			ps.setString(2, type);
			ps.setString(3, registrationNumber);
			ps.setInt(4, seatingCapacity);
			ps.setDouble(5, farePerKM);
			final int a = ps.executeUpdate();
			if(a>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return false;
		
	}
	VehicleBean findByID(String vehicleId) {
		VehicleBean vb = new VehicleBean();
		try {
			PreparedStatement ps = con.prepareStatement("select * from vehicle where vehicleid = ?");
			ps.setString(1, vehicleId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				vb.setVehicleId(rs.getString(1));
				vb.setName(rs.getString(2));
				vb.setRegistrationNumber(rs.getString(3));
				vb.setSeatingCapacity(rs.getInt(4));
				vb.setFarePerKM(rs.getDouble(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return vb;
		
	}
	ArrayList<VehicleBean> findAll(){
		ArrayList<VehicleBean> pb = new ArrayList<VehicleBean>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from vehicle");
			ResultSet rs = ps.executeQuery();
			VehicleBean vb = new VehicleBean();
			while(rs.next()) {
				vb.setVehicleId(rs.getString(1));
				vb.setName(rs.getString(2));
				vb.setRegistrationNumber(rs.getString(3));
				vb.setSeatingCapacity(rs.getInt(4));
				vb.setFarePerKM(rs.getDouble(5));
				pb.add(vb);
			}
			return pb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
	}

}
