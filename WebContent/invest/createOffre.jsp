<%@ page import="java.text.*,java.util.*" %>
<%@ page import="com.ejb.ServiceSociete" %>
<%@ page import="com.beans.Societe" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin - Bootstrap Admin Template</title>
	<link rel="stylesheet" type="text/css"
		href="../DataTables-1.10.5/media/css/jquery.dataTables.css">
	<!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    <!-- DataTables -->
   <script type="text/javascript" charset="utf8"src="../DataTables-1.10.5/media/js/jquery.dataTables.js"></script>
    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../css/plugins/morris.css" rel="stylesheet">
    
	
	<!-- jQuery -->
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
<script>
$(document).ready(function(){
	$("select[name=idSociete]").change(function(){
		
		if($(this).val()==0){
			$("#etape2").hide()
			$("#etape3").hide();
			$("#etape4").hide()
			$("#etapeOption").hide();
			$("#etapeAction").hide()
		}
		else $("#etape2").slideDown("fast");
	});
	$("select[name=typeActif]").on("change",function(){		
		if($(this).val()==0){
			$("#etape3").hide();
			$("#etape4").hide()
			$("#etapeOption").hide();
			$("#etapeAction").hide()
		}
		else if($("#etape4").is(":visible")){
			if($("select[name=typeActif]").val()=="Action"){
				$("#etapeOption").slideUp("fast",function(){
					 $("#etapeAction").slideDown("fast");
				});			
			}
			else {
				$("#etapeAction").slideUp("fast",function(){
					 $("#etapeOption").slideDown("fast");
				});	
			}
		}
		else $("#etape3").slideDown("fast");
	});
	$("select[name=nego]").on("change",function(){
		
		if($(this).val()==0){
			$("#etape4").hide()
			$("#etapeOption").hide();
			$("#etapeAction").hide()
		}
		else $("#etape4").slideDown("fast");
	});
	$("select[name=typeContrat]").on("change",function(){
		$("#dateEnchere").hide();
		if($(this).val()=="enchere") $("#dateEnchere").slideDown("fast");
		
		if($(this).val()==0){
			$("#etapeOption").hide();
			$("#etapeAction").hide()
		}
		else if($("select[name=typeActif]").val()=="Action") $("#etapeAction").slideDown("fast");
		else $("#etapeOption").slideDown("fast");
	});
});
</script>
    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index.html">Trading Platform</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-envelope"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu message-dropdown">
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-preview">
                            <a href="#">
                                <div class="media">
                                    <span class="pull-left">
                                        <img class="media-object" src="http://placehold.it/50x50" alt="">
                                    </span>
                                    <div class="media-body">
                                        <h5 class="media-heading"><strong>John Smith</strong>
                                        </h5>
                                        <p class="small text-muted"><i class="fa fa-clock-o"></i> Yesterday at 4:32 PM</p>
                                        <p>Lorem ipsum dolor sit amet, consectetur...</p>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="message-footer">
                            <a href="#">Read All New Messages</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-bell"></i> <b class="caret"></b></a>
                    <ul class="dropdown-menu alert-dropdown">
                        <li>
                            <a href="#">Alert Name <span class="label label-default">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-primary">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-success">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-info">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-warning">Alert Badge</span></a>
                        </li>
                        <li>
                            <a href="#">Alert Name <span class="label label-danger">Alert Badge</span></a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">View All</a>
                        </li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> John Smith <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-envelope"></i> Inbox</a>
                        </li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-gear"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Log Out</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                	<li class="active">
                    	<a href="index.html"> Accueil</a>
                    </li>
                    <li>
                        <a href="index.html"><i class="fa fa-fw fa-building"></i> Sociétés</a>
                    </li>                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo" class="collapsed" aria-expanded="false"><i class="fa fa-fw fa-money"></i> Marché OTC<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse" aria-expanded="false" style="height: 0px;">
                            <li>
                                <a href="#">Voir les offres</a>
                            </li>
                            <li>
                                <a href="#">Créer une offre</a>
                            </li>
                        </ul>
                    </li>                 
                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo2" class="collapsed" aria-expanded="false"><i class="fa fa-fw fa-money"></i> En cours<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse" aria-expanded="false" style="height: 0px;">
                            <li>
                                <a href="#">Mes Enchères</a>
                            </li>
                            <li>
                                <a href="#">Mes Offres</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="index.html"><i class="fa fa-fw fa-list"></i> Historique</a>
                    </li>   
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            Offres en cours
                        </h1>
                        
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                	<div class="col-lg-6">
                		<form action="OffreAdd" method="post">
                			<div class="form-group" id="etape1">
                				<label>Entreprise</label>
                				<select name="idSociete" class="form-control">
                					<option value="0">Choisir la société</option>
                					<% ServiceSociete ss=new ServiceSociete();
                					List socList=ss.getSocieteSelonEtat(1);
                					for(Object s : socList){
                						Societe soc=(Societe) s;
                					%>
                					<option value="<%= soc.getIdSociete() %>"><%= soc.getNom()%> (<%= soc.getMnemo() %>)</option>
                					<%
                					}
                					%>
                				</select>
                			</div>
                			<div class="form-group" id="etape2" style="display:none">
                				<label>Type d'actif</label>
                				<select name="typeActif" class="form-control">
                					<option value="0">Choisir le type d'actif</option>
                					<option value="Action">Action</option>
                					<option value="stockOption">StockOption</option>
                				</select>
                			</div>
                			<div class="form-group" id="etape3" style="display:none">
                				<label>Je veux ?</label>
                				<select name="nego" class="form-control">
                					<option value="0">Choisir Acheter/Vendre ?</option>
                					<option value="Achat">Acheter</option>
                					<option value="Vente">Vendre</option>
                				</select>
                			</div>
                			
                			<div class="form-group" id="etape4" style="display:none">
                				<label>Négociation</label>
                				<select name="typeContrat" class="form-control">
                					<option value="0">Choisir Direct/Enchère ?</option>
                					<option value="direct">Direct</option>
                					<option value="enchere">Enchère</option>
                				</select>
                			</div>
                			<%!
							   DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
							   String now = fmt.format(Calendar.getInstance().getTime());
							   DateFormat fmt2 = new SimpleDateFormat("HH:mm");
							   String now2 = fmt2.format(Calendar.getInstance().getTime());
							%>
                			<div class="form-group" id="dateEnchere" style="display:none">
                				<label>Date fin enchère</label>                				
                				<input type="date" name="date" value="<%= now%>" min="<%= now%>" class="form-control" style="width:30%"/><input style="width:30%" class="form-control" type="time" value="<%= now2 %>" name="time"/>
                			</div>
                			<div id="etapeOption" style="display:none" class="well">
                				<div class="form-group" >
	                				<label>Quantite</label>
	                				<input type="text" name="quantite" class="form-control"/>
	                			</div>
	                			<div class="form-group" >
	                				<label>Prix</label>
	                				<input type="text" name="prix" class="form-control"/>
	                			</div>
	                			<div class="form-group"  >
	                				<label>Maturité</label>
	                				<input type="date" name="maturite" class="form-control"/>
	                			</div>
	                			<div class="form-group" >
	                				<label>Strike</label>
	                				<input type="text" name="strike" class="form-control"/>
	                			</div>
                			</div>
                			
                			<div id="etapeAction" style="display:none" class="well">
                				<div class="form-group" >
	                				<label>Quantite</label>
	                				<input type="text" name="quantite" class="form-control"/>
	                			</div>
	                			<div class="form-group">
	                				<label>Prix</label>
	                				<input type="text" name="prix" class="form-control"/>
	                			</div>
                			</div>
                			
                			<button type="submit" class="btn btn-success">Ajouter l'offre</button>
                		</form>
                	</div>
                </div>

               

                

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    

</body>

</html>
