<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.beans.User" %>
    <%@ page import="com.beans.UserType" %>
<% if (session.getAttribute("sessionUser") == null) { %>
<jsp:include page="connect.jsp"></jsp:include>
<%} else{ User u=(User)session.getAttribute("sessionUser");
	if(u.getType()==UserType.Administrateur){
		String site = "admin/indexAdmin.jsp" ;
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site); 
}
	else if(u.getType()==UserType.Investisseur){
		String site = "invest/completeProfil.jsp" ;
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site); 
	}
	}%>