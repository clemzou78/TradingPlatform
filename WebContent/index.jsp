<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.beans.User" %>
<% if (session.getAttribute("sessionUser") == null) { %>
<jsp:include page="connect.jsp"></jsp:include>
<%} else{ User u=(User)session.getAttribute("sessionUser");
	if(u.getType()==1){
		String site = "admin/indexAdmin.jsp" ;
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site); 
}
	}%>