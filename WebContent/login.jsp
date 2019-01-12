<%@page import="com.ata.util.UserUtil"%>
<%@page import="com.ata.bean.CredentialsBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>`
<% 
	String uname = request.getParameter("email");
	String password = request.getParameter("password");
	//System.out.print(uname);
	CredentialsBean cb = new CredentialsBean();
	cb.setUserId(uname);
	cb.setPassword(password);
	UserUtil uu = new UserUtil();
	String s = uu.login(cb);
	if(s.equals("A")){
		cb.setUserType(s);
		session.setAttribute("bean", cb);
		RequestDispatcher rd=request.getRequestDispatcher("admin.jsp");  
		rd.forward(request, response);//method may be include or forward  
	}
	else {
		cb.setUserType(s);
		session.setAttribute("bean", cb);
		RequestDispatcher rd=request.getRequestDispatcher("customer.jsp");  
		rd.forward(request, response);//method may be include or forward  
	}
		
	
%>