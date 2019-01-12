package com.ata.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.ata.bean.ReservationBean;
import com.ata.util.Config;


public class Reservation {
	Connection con = Config.getConnection(); 
	
	String createReservation(ReservationBean reservationBean) {
		PreparedStatement ps;
		String userId = reservationBean.getUserId();
		String reservationId = reservationBean.getReservationId();
		String routeId = reservationBean.getRouteId();
		Date bookingDate = reservationBean.getBookingDate();
		Date journeyDate = reservationBean.getJourneyDate();
		String vehicleId = reservationBean.getVehicleId();
		String driverId = reservationBean.getDriverId();
		String bookingStatus = reservationBean.getBookingStatus();
		double totalFare = reservationBean.getTotalFare();
		String boardingPoint = reservationBean.getBoardingPoint();
		String dropPoint = reservationBean.getDropPoint();
		try {
			ps = con.prepareStatement("insert into reservation values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1, reservationId);
			ps.setString(2, userId);
			ps.setString(3, vehicleId);
			ps.setString(4, routeId);
			ps.setDate(5, bookingDate);
			ps.setDate(6, journeyDate);
			ps.setString(7, driverId);
			ps.setString(8, bookingStatus);
			ps.setDouble(9, totalFare);
			ps.setString(10, boardingPoint);
			ps.setString(11, dropPoint);
			int a = ps.executeUpdate();
			if(a>0) return "Successful";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "unsuccessful";
		}
		return "unsuccessful";
	}
	int deleteReservation(ArrayList<String> reservationId) {
		
		PreparedStatement ps;
		int a = 0;
		for(int i=0; i<reservationId.size(); i++) {
			try {
				ps = con.prepareStatement("delete from reservation where reservationid = ?");
				ps.setString(1, reservationId.get(i));
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
	boolean updateReservation(ReservationBean reservationBean) {
		PreparedStatement ps;
		String userId = reservationBean.getUserId();
		String reservationId = reservationBean.getReservationId();
		String routeId = reservationBean.getRouteId();
		Date bookingDate = reservationBean.getBookingDate();
		Date journeyDate = reservationBean.getJourneyDate();
		String vehicleId = reservationBean.getVehicleId();
		String driverId = reservationBean.getDriverId();
		String bookingStatus = reservationBean.getBookingStatus();
		double totalFare = reservationBean.getTotalFare();
		String boardingPoint = reservationBean.getBoardingPoint();
		String dropPoint = reservationBean.getDropPoint();
		try {
			ps = con.prepareStatement("update reservation set userid = ?, vehicleid = ?, routeid = ?, booking_date = ?, journey_date =?, driverid = ?, booking_status = ?, total_fare = ?, boarding_point = ?, drop_point = ? where reservationid = ?");
			ps.setString(1, userId);
			ps.setString(2, vehicleId);
			ps.setString(3, routeId);
			ps.setDate(4, bookingDate);
			ps.setDate(5, journeyDate);
			ps.setString(6, driverId);
			ps.setString(7, bookingStatus);
			ps.setDouble(8, totalFare);
			ps.setString(9, boardingPoint);
			ps.setString(10, dropPoint);
			ps.setString(11, reservationId);
			final int a = ps.executeUpdate();
			if(a>0) return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}

		return false;
		
	}
	ReservationBean findByID(String userId) {
		ReservationBean rB = new ReservationBean();
		try {
			PreparedStatement ps = con.prepareStatement("select * from reservation where reservationid = ?");
			ps.setString(1, userId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				rB.setReservationId(rs.getString(1));
				rB.setUserId(rs.getString(2));
				rB.setVehicleId(rs.getString(3));
				rB.setRouteId(rs.getString(4));
				rB.setBookingDate(rs.getDate(5));
				rB.setJourneyDate(rs.getDate(6));
				rB.setDriverId(rs.getString(7));
				rB.setBookingStatus(rs.getString(8));
				rB.setTotalFare(rs.getDouble(9));
				rB.setBoardingPoint(rs.getString(10));
				rB.setDropPoint(rs.getString(11));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return rB;
		
	}
	ArrayList<ReservationBean> findAll(){
		ArrayList<ReservationBean> cb = new ArrayList<ReservationBean>();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement("select * from reservation");
			ResultSet rs = ps.executeQuery();
			ReservationBean rB = new ReservationBean();
			while(rs.next()) {
				rB.setReservationId(rs.getString(1));
				rB.setUserId(rs.getString(2));
				rB.setVehicleId(rs.getString(3));
				rB.setRouteId(rs.getString(4));
				rB.setBookingDate(rs.getDate(5));
				rB.setJourneyDate(rs.getDate(6));
				rB.setDriverId(rs.getString(7));
				rB.setBookingStatus(rs.getString(8));
				rB.setTotalFare(rs.getDouble(9));
				rB.setBoardingPoint(rs.getString(10));
				rB.setDropPoint(rs.getString(11));
		
				cb.add(rB);
				
			}
			return cb;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}

}
