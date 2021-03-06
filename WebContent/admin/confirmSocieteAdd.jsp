<!DOCTYPE html>
<%@ page import="com.beans.User"%>
<%@ page import="com.beans.Societe"%>
<%@ page import="java.util.*"%>
<% User u=(User)session.getAttribute("sessionUser");%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Bootstrap Admin Template</title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
						data-toggle="dropdown"><i class="fa fa-user"></i> Connect� en
							tant que <%= u.getUsername() %> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="../deconnexion"><i
									class="fa fa-fw fa-power-off"></i> Log Out</a></li>
						</ul></li>
				</ul>
				<ul class="nav navbar-nav side-nav">
					<li class="active"><a href="indexAdmin.jsp"><i
							class="fa fa-fw fa-building"></i> Soci�t�s</a></li>
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
               <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
					
                        <h1 class="page-header">
                            Administration des soci�t�s
                        </h1>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-6">
                    		<% HttpSession s=request.getSession(); %>
						  <div class="well">
						  <p>La soci�t� <%=((Societe)s.getAttribute("societe")).getNom() %> a �t� valid�e.</p>
						  <p>Les identifiants g�n�r�s sont : </p>
						  <ul>
						  	<li>Login : <%= ((Societe)s.getAttribute("societe")).getUserSociety().getUsername() %></li>
						  	<li>Password : <%= s.getAttribute("pass") %></li>
						  	
						  </ul>
						  </div>    
						  
						  <a class="btn btn-primary" href="indexAdmin.jsp">Retour � la liste des soci�t�s</a>                 
                    </div>
                    
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>

</body>

</html>
