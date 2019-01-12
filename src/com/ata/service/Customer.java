package com.ata.service;

import java.util.ArrayList;
import com.ata.bean.*;
public interface Customer {
	ArrayList<VehicleBean> viewVehiclesByType(String vehicleType);
	ArrayList<VehicleBean> viewVehicleBySeats(int noOfSeats);
	ArrayList<RouteBean> viewAllRoutes();
	String bookVehicle(ReservationBean reservationBean);
	boolean cancelBooking(String userId, String reservationId);
	ReservationBean viewBookingDetails(String reservationId);
	ReservationBean printBookingDetails(String reservationId);
	
}
