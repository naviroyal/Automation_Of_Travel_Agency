package com.ata.service;

import java.sql.Date;
import java.util.ArrayList;
import com.ata.bean.*;
public interface Adminstrator {
	String addVehicle(VehicleBean vehicleBean);
	int deleteVehicle(ArrayList<String> vehicleId);
	VehicleBean viewVehicle(String vehicleId);
	boolean modifyVehicle(VehicleBean vehicleBean);
	String addDriver(DriverBean driverBean);
	int deleteDriver(ArrayList<String> driverId);
	boolean allotDriver(String reservationID, String driverId);
	boolean modifyDriver(DriverBean driverBean);
	String addRoute(RouteBean routeBean);
	int deleteRoute(ArrayList<String> routeId);
	RouteBean viewRoute(String routeId);
	boolean modifyRoute(RouteBean routeBean);
	ArrayList<ReservationBean> viewBookingDetails(Date journeyDate,String source, String destination);
}
