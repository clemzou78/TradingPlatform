<!DOCTYPE html>
<%@ page import="com.beans.Societe"%>
<%@ page import="com.beans.User"%>
<%@ page import="java.util.*"%>
<%
	User u = (User) session.getAttribute("sessionUser");
%>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Bootstrap Admin Template</title>



<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="../css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css"
	href="../DataTables-1.10.5/media/css/jquery.dataTables.css">
<!-- jQuery -->
<script type="text/javascript" charset="utf8"
	src="../DataTables-1.10.5/media/js/jquery.js"></script>
<!-- DataTables -->
<script type="text/javascript" charset="utf8"
	src="../DataTables-1.10.5/media/js/jquery.dataTables.js"></script>
</head>

<body>
	<script>
		$(document).ready(function() {
			$("#table").DataTable();
		});
		/*
		 function fade()
		 {
		 $("#formRegisterSociety").fadeIn("fast");
		 };
		 */
	</script>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target=".navbar-ex1-collapse">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="index.html">TradingPlatform -
						Admin</a>
				</div>
				<!-- Top Menu Items -->
				<ul class="nav navbar-right top-nav">
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-user"></i> Connecté en
							tant que <%=u.getUsername()%> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="../deconnexion"><i
									class="fa fa-fw fa-power-off"></i> Log Out</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="indexAdmin.jsp"><i
							class="fa fa-fw fa-building"></i> Sociétés</a></li>
					<li><a href="listeUsers.jsp"> <i class="fa fa-fw fa-user"></i>
							Utilisateurs
					</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">

						<h1 class="page-header">Administration des sociétés</h1>
						<a class="btn btn-success" href="societeAdd.jsp">Créer une
							société</a>

						<form role="form" id="formRegisterSociety" style="display: none"
							method="post" action="#">
							<br>
							<div class="form-group input-group"
								style="width: 100%; margin: auto">
								<input type="text" class="form-control" placeholder="Societe"
									name="societe">
							</div>
							<br>
							<div class="form-group input-group"
								style="width: 100%; margin: auto">
								<input type="text" class="form-control" placeholder="Mnemo"
									name="Mnemo">
							</div>
							<br>
							<div class="form-group input-group"
								style="width: 100%; margin: auto">
								<input type="text" class="form-control"
									placeholder="Description" name="description">
							</div>
							<button type="submit" class="btn btn-default"
								style="margin-top: 20px">Submit</button>
							<br />
						</form>
					</div>
				</div>
				<!-- /.row -->

				<div class="row" style="margin-top: 10px">
					<%
						List listSociete = Societe.getAllSociete();
					%>
					<div class="col-lg-12">
						<div class="table-responsive">
							<table id="table"
								class="table table-bordered table-hover table-striped">
								<thead>
									<tr>
										<th>Mnémo</th>
										<th>Société</th>
										<th>Description</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (int i = 0; i < listSociete.size(); i++) {
											String chaine=((Societe) listSociete.get(i)).getDescription();
											String description=chaine.substring(0,(chaine.length()<250?chaine.length():250))+"...";%>
									<tr>
										<td><%=((Societe) listSociete.get(i)).getMnemo()%></td>
										<td><%=((Societe) listSociete.get(i)).getNom()%></td>
										<td><%=description %></td>
									</tr>
									<%
										}
									%>

								</tbody>
							</table>
						</div>
					</div>
				</div>
				<!-- /.row -->


			</div>
			<!-- /.row -->

		</div>
		<!-- /.container-fluid -->

	</div>
	<!-- /#page-wrapper -->


	</div>
	<!-- /#wrapper -->

</body>

</html>
