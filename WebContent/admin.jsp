<%@ include file="header.jsp" %>
<%@page import="com.ata.bean.CredentialsBean"%>
<% CredentialsBean cb = (CredentialsBean)session.getAttribute("bean"); 
	String type = cb.getUserType();
%>	
 <%  
		UserDao ud = new UserDao();
		ProfileBean pb =ud.findByID(cb.getUserId());
		String fname = pb.getFirstName();
		String lname = pb.getLastName();
%>
 <% out.print(fname+" "+lname); %>
<% if(type.equals("A")) {%>
	<h1> sdkfjlsdn </h1>	
<% } %>	

</body>
</html>