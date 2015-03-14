<%@page import="com.ejb.ServiceInvestisseur"%>
<%@ page import="com.beans.User" %>
<%@ page import="com.beans.Investisseur" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% User u=(User)session.getAttribute("sessionUser");
	ServiceInvestisseur si=new ServiceInvestisseur();
	Investisseur i=si.getByIdUser(u.getId());
%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>SB Admin - Bootstrap Admin Template</title>

<!-- jQuery -->
<script src="../js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="../js/bootstrap.min.js"></script>

<!-- Bootstrap Core CSS -->
<link href="../css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="../css/sb-admin.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-ex1-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="index.html">Trading Platform</a>
			</div>
			<!-- Top Menu Items -->
			<ul class="nav navbar-right top-nav">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-envelope"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu message-dropdown">
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-preview"><a href="#">
								<div class="media">
									<span class="pull-left"> <img class="media-object"
										src="http://placehold.it/50x50" alt="">
									</span>
									<div class="media-body">
										<h5 class="media-heading">
											<strong>John Smith</strong>
										</h5>
										<p class="small text-muted">
											<i class="fa fa-clock-o"></i> Yesterday at 4:32 PM
										</p>
										<p>Lorem ipsum dolor sit amet, consectetur...</p>
									</div>
								</div>
						</a></li>
						<li class="message-footer"><a href="#">Read All New
								Messages</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-bell"></i> <b
						class="caret"></b></a>
					<ul class="dropdown-menu alert-dropdown">
						<li><a href="#">Alert Name <span
								class="label label-default">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-primary">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-success">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span class="label label-info">Alert
									Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-warning">Alert Badge</span></a></li>
						<li><a href="#">Alert Name <span
								class="label label-danger">Alert Badge</span></a></li>
						<li class="divider"></li>
						<li><a href="#">View All</a></li>
					</ul></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b
						class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
						</li>
						<li><a href="#"><i class="fa fa-fw fa-envelope"></i>
								Inbox</a></li>
						<li><a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
						</li>
						<li class="divider"></li>
						<li><a href="#"><i class="fa fa-fw fa-power-off"></i> Log
								Out</a></li>
					</ul></li>
			</ul>
			<!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="index.html"><i
							class="fa fa-fw fa-building"></i> Accueil</a></li>
					<li><a href="index.html"><i class="fa fa-fw fa-building"></i>
							Sociétés</a></li>
					<li><a href="charts.html"><i class="fa fa-fw fa-dashboard"></i>
							En cours de négociation</a></li>
					<li><a href="tables.html"><i class="fa fa-fw fa-money"></i>
							Voir/Vendre mes titres</a></li>

				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</nav>

		<div id="page-wrapper">

			<div class="container-fluid">

				<!-- Page Heading -->
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Bienvenue sur votre espace
							Investisseur</h1>

					</div>
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-lg-12">
						<div class="alert alert-info alert-dismissable">
							<button type="button" class="close" data-dismiss="alert"
								aria-hidden="true">&times;</button>
							<i class="fa fa-info-circle"></i> Version béta 1.0 en cours de
							développement
						</div>
					</div>
				</div>
				<!-- /.row -->
				<h1>Complétez votre profil avant d'accéder au plus grand marché
					OTC !</h1>
				<div class="row">
					<div class="col-lg-6">
						<form>
							<div class="form-group">
								<label for="exampleInputEmail1">Nom</label> <input
									type="text" class="form-control"  placeholder="Nom" value="<%= i.getNom()%>" required="required">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Prénom</label> <input type="text" class="form-control" value="<%= i.getPrenom() %>"
									placeholder="Prénom" required="required">
							</div>		
							<div class="form-group">
								<label for="exampleInputFile">Téléphone</label> <input required="required" type="text" class="form-control" value="<%= i.getTelephone() %>" placeholder="Code Postal">
							</div>					
							<div class="form-group">
								<label for="exampleInputFile">Adresse complète</label> <input required="required" type="text" class="form-control" value="<%= i.getAdresse() %>" placeholder="Adresse">
							</div>
							<div class="form-group">
								<label for="exampleInputFile">Code postal</label> <input required="required" type="text" class="form-control" value="<%= i.getCodePostal() %>" placeholder="Code Postal">
							</div>
							
							<div class="form-group">
								<label for="exampleInputFile">Ville</label> <input required="required" type="text" class="form-control" value="<%= i.getVille() %>" placeholder="Ville">
							</div>
							<div class="form-group">
								<label for="exampleInputFile">Pays</label> 
								<select class="form-control" >
									<option>France</option>
									<option>Belgique</option>
									<option>Luxembourg</option>
								</select>
							</div>
							<div class="checkbox">
								<label> <input type="checkbox" required="required"> J'accepte les conditions générales de TradingPlatform
								</label>
							</div>
							<button type="submit" class="btn btn-success">Valider mon profil</button>
						</form>
					</div>
				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- /#page-wrapper -->

		</div>
		<!-- /#wrapper -->
</body>

</html>
