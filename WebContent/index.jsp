<%@page import="com.ejb.ServiceInvestisseur"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.beans.User" %>
    <%@ page import="com.beans.UserType" %>
    <%@ page import="com.ejb.ServiceInvestisseur" %>
     <%@ page import="com.beans.Investisseur" %>
<% if (session.getAttribute("sessionUser") == null) { %>
<jsp:include page="connect.jsp"></jsp:include>
<%} else{ User u=(User)session.getAttribute("sessionUser");
	if(u.getType()==UserType.Administrateur){
		String site = "/ApplicationTrading/admin/indexAdmin.jsp" ;
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
}
	else if(u.getType()==UserType.Investisseur){
		Investisseur i=(new ServiceInvestisseur()).getByIdUser(u.getId());
		if(!i.isValidate() && i.getAdresse().equals("")){
			String site = "/ApplicationTrading/invest/completeProfil.jsp" ;
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		}
		else if(!i.isValidate()){
			String site = "/ApplicationTrading/invest/attenteProfil.jsp" ;
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		}
		else{
			String site = "/ApplicationTrading/invest/indexInvestisseur.jsp" ;
			response.setStatus(response.SC_MOVED_TEMPORARILY);
			response.setHeader("Location", site); 
		}
	}
}%>