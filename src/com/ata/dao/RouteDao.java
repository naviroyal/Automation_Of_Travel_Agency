package com.ata.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ata.bean.RouteBean;
import com.ata.util.Config;

public class RouteDao {
	Connection con = Config.getConnection();
	String createRoute(RouteBean routeBean) {
		String routeId = routeBean.getRouteId();
		String Source= routeBean.getSource();
		String destination = routeBean.getDestination();
		int distance = routeBean.getDistance();
		int travelDuration = routeBean.getTravelDuration();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("insert into route values(?, ?, ?, ?, ?)");
			ps.setString(1, routeId);
			ps.setString(2, Source);
			ps.setString(3, destination);
			ps.setInt(4, distance);
			ps.setInt(5, travelDuration);
			int a = ps.executeUpdate();
			if(a>0) return "Successful";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
		return "unsuccessful";	

	}
	int deleteRoute(ArrayList<String> routeId) {
		PreparedStatement ps;
		int a = 0;
		for(int i=0; i<routeId.size(); i++) {
			try {
				ps = con.prepareStatement("delete from route where routeid = ?");
				ps.setString(1, routeId.get(i));
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
	boolean updateRoute(RouteBean routeBean) {
		String routeId = routeBean.getRouteId();
		String Source= routeBean.getSource();
		String destination = routeBean.getDestination();
		int distance = routeBean.getDistance();
		int travelDuration = routeBean.getTravelDuration();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("update route set source = ?, destination = ?, 	distance =?, travel_duration = ? where routeid = ?");
			ps.setString(5, routeId);
			ps.setString(1, Source);
			ps.setString(2, destination);
			ps.setInt(3, distance);
			ps.setInt(4, travelDuration);
			final int a = ps.executeUpdate();
			if(a>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		return false;
		
	}
	RouteBean findByID(String routeId) {
		RouteBean db = new RouteBean();
		try {
			PreparedStatement ps = con.prepareStatement("select * from route where routeid = ?");
			ps.setString(1, routeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				db.setRouteId(rs.getString(1));
				db.setSource(rs.getString(2));
				db.setDestination(rs.getString(3));
				db.setDistance(rs.getInt(4));
				db.setTravelDuration(5);
				
			}
			return db;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
	}
	ArrayList<RouteBean> findAll(){
		ArrayList<RouteBean> cb = new ArrayList<RouteBean>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from route");
			ResultSet rs = ps.executeQuery();
			RouteBean db = new RouteBean();
			while(rs.next()) {
				db.setRouteId(rs.getString(1));
				db.setSource(rs.getString(2));
				db.setDestination(rs.getString(3));
				db.setDistance(rs.getInt(4));
				db.setTravelDuration(5);
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
