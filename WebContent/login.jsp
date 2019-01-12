<%@page import="com.ata.util.UserUtil"%>
<%@page import="com.ata.bean.CredentialsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String uname = request.getParameter("uname");
	String password = request.getParameter("password");
	CredentialsBean cb = new CredentialsBean();
	cb.setUserId(uname);
	cb.setPassword(password);
	UserUtil uu = new UserUtil();
	String s = uu.login(cb);
	
%>
</body>
</html>