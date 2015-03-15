<%@ page import="com.beans.contrat.Contrat" %>
<%@ page import="com.beans.contrat.NegoType" %>
<%@ page import="com.beans.contrat.ContratEnchere" %>
<%@ page import="com.beans.contrat.ContratDirect" %>
<%@ page import="com.beans.contrat.StockOption" %>
<%@ page import="java.text.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<% Contrat c= (Contrat) request.getAttribute("contrat");%>
<%= c.getIdContrat()%>

<%@ page import="java.util.*" %>
<%@ page contentType="text/html; charset=UTF-8" %>
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
<script>
$(document).ready(function(){
	$("#offres").DataTable({
		"order": [],
	    "columnDefs": [ {
	      "targets"  : 'no-sort',
	      "orderable": false,
	    }],
	    initComplete: function () {
		    var api=this.api();
		    var column=api.column(6);
		    $("select[name=typeContrat]").change(function(){
				var val=$(this).val();
				column
				.search( val ? '^'+val+'$' : '', true, false )
                .draw();
			});
		    var api=this.api();
			var column2=api.column(5);
			$("select[name=venteAchat]").change(function(){
				var val2=$(this).val();
				column2
				.search( val2 ? '^'+val2+'$' : '', true, false )
                .draw();
			});
		}
	})
});
</script>
<body>

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
                            Offre - Référence : <%= c.getIdContrat() %>
                        </h1>
                        
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                	<div class="col-lg-12">
                		<% 
                				DecimalFormat formatter = new DecimalFormat("###,###,###.00");
                				String moneyString = formatter.format(c.getPrix());
								ContratEnchere c2=null;
                				String type;
                				if(c instanceof ContratEnchere) type="Enchère";
                				else type="Direct";                			
                			%>
                			<%
                				String txt="";
                				if(c.getTypeN()==NegoType.Achat && type.equals("Enchère"))
                					txt="L'investisseur souhaite acheter l'actif au meilleur prix. Proposez un prix plus bas que les concurrents !";
                				else if(c.getTypeN()==NegoType.Achat && type.equals("Direct"))
                					txt="L'investisseur souhaiter acheter l'actif au prix indiqué. Cela vous intéresse-t-il ?";
                				else if(c.getTypeN()==NegoType.Vente && type.equals("Direct"))
                					txt="L'investisseur souhaiter vendre l'actif au prix indiqué. Preneur ?";
                				else if(c.getTypeN()==NegoType.Vente && type.equals("Enchère"))
                					txt="L'investisseur souhaiter vendre l'actif au meilleur prix. Que le meilleur gagne !";
                			%>
                			
                			<p><span class="badge" style="font-size:1.4em"><%= txt %></span></p>
                		<div class="well">
                			
                			<p style="font-size:1.2em"><%
                				if(type.equals("Enchère")){
                				c2=(ContratEnchere) c;
                				SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd à hh:mm");
                				String formate=formatter2.format(c2.getDateFin());                				
                			%>
                				<u>Enchère se terminant le <b><%= formate %></b></u>
                			<%
                			}else{%>
                				Contrat Direct                			
                			<%} %></p>
                			<p>Entreprise : <%=c.getActif().getSoc().getNom() %> (<%= c.getActif().getSoc().getMnemo() %>) - <a href="#">Voir l'historique</a></p>
                			<p>Type de contrat : <%= c.getTypeN().toString() %></p>
                			<p>Proposé par : <%= c.getProposeUser().getPrenom()+" "+c.getProposeUser().getNom() %>
                			<% if(c.getActif() instanceof StockOption){
                				SimpleDateFormat formatter3= new SimpleDateFormat("yyyy-MM-dd");
                				String dateMat=formatter3.format(((StockOption)(c.getActif())).getMaturite());
                				String moneyStrike=formatter.format(((StockOption)(c.getActif())).getStrike());
                			
                			%>  <p>Maturité : <%= dateMat %>
                				<p>Strike : <%= moneyStrike %>
                			<%}
                			else{%>
       							        				
                			<%} %>
                			<%if(type=="Enchère"){
                				String moneyString2 = formatter.format(c2.getPrixDepart());
                			%>
                				<p>Prix de départ : <%=moneyString2 %>
                			<%} %>
                			<p>Prix Actuel : <%=moneyString %> €</p>
                			<% if(type.equals("Enchère")){%>
                				<p>Proposition : <input type="number" style="width:100px"/></p>
                				<button class="btn btn-success" type="submit">Enchérir</button>
                			<%}
                			else{%>
                				<button class="btn btn-success" type="submit">Accepter</button>
                			<%} %>
                			<p>
                		</div>
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
