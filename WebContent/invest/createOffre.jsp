<%@ page import="java.text.*,java.util.*" %>
<%@ page import="com.ejb.ServiceSociete" %>
<%@ page import="com.beans.Societe" %>
<%@ page import="com.beans.User" %>
<% User u=(User)session.getAttribute("sessionUser");%>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>TradingPlatform</title>
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
	$("#buttonSubmit").on("click",function(){
		$("#myModal").modal('show');
		return false;
	});
	$("#confirm").on("click",function(){
		$("#formAjoutOffre").submit();
	});
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
			$("#etape4").hide();
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
			$("#etapeAction").hide();
			$("#buttonSubmit").hide();
		}
		else{ 
			$("#buttonSubmit").show();
			if($("select[name=typeActif]").val()=="Action") $("#etapeAction").slideDown("fast");
			else $("#etapeOption").slideDown("fast");
		}
	});
});
</script>
    <div id="wrapper">

        <!-- Navigation -->
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
					<li class="dropdown"><a href="#" class="dropdown-toggle"
						data-toggle="dropdown"><i class="fa fa-user"></i> Connect� en
							tant que <%=u.getUsername()%> <b class="caret"></b></a>
						<ul class="dropdown-menu">
							<li><a href="../deconnexion"><i
									class="fa fa-fw fa-power-off"></i> Log Out</a></li>
						</ul></li>
				</ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                	<li class="active">
                    	<a href="indexInvestisseur.jsp"> Accueil</a>
                    </li>
                    <li>
                        <a href="societes.jsp"><i class="fa fa-fw fa-building"></i> Soci�t�s</a>
                    </li>                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo" class="collapsed" aria-expanded="false"><i class="fa fa-fw fa-money"></i> March� OTC<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse" aria-expanded="false" style="height: 0px;">
                            <li>
                                <a href="Offres">Voir les offres</a>
                            </li>
                            <li>
                                <a href="createOffre.jsp">Cr�er une offre</a>
                            </li>
                        </ul>
                    </li>                 
                    
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo2" class="collapsed" aria-expanded="false"><i class="fa fa-fw fa-money"></i> En cours<i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo2" class="collapse" aria-expanded="false" style="height: 0px;">
                            <li>
                                <a href="MesEncheres">Mes Ench�res</a>
                            </li>
                            <li>
                                <a href="MesOffres">Mes Offres</a>
                            </li>
                        </ul>
                    </li>
                    
                    <li>
                        <a href="historique.jsp"><i class="fa fa-fw fa-list"></i> Historique</a>
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
                            Cr�er une offre
                        </h1>
                        
                    </div>
                </div>
                <!-- /.row -->
                <div class="row">
                	<div class="col-lg-6">
                		<form action="OffreAdd" method="post" id="formAjoutOffre">
                			<div class="form-group" id="etape1">
                				<label>Entreprise</label>
                				<select name="idSociete" class="form-control">
                					<option value="0">Choisir la soci�t�</option>
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
                				<label>N�gociation</label>
                				<select name="typeContrat" class="form-control">
                					<option value="0">Choisir Direct/Ench�re ?</option>
                					<option value="direct">Direct</option>
                					<option value="enchere">Ench�re</option>
                				</select>
                			</div>
                			<%!
							   DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
							   String now = fmt.format(Calendar.getInstance().getTime());
							   DateFormat fmt2 = new SimpleDateFormat("HH:mm");
							   String now2 = fmt2.format(Calendar.getInstance().getTime());
							%>
                			<div class="form-group" id="dateEnchere" style="display:none">
                				<label>Date fin ench�re</label>                				
                				<input type="date" name="date" value="<%= now%>" min="<%= now%>" class="form-control" style="width:30%"/><input style="width:30%" class="form-control" type="time" value="<%= now2 %>" name="time"/>
                			</div>
                			<div id="etapeOption" style="display:none" class="well">
                				<div class="form-group" >
	                				<label>Quantite</label>
	                				<input type="text" name="quantite1" class="form-control"/>
	                			</div>
	                			<div class="form-group" >
	                				<label>Prix</label>
	                				<input type="text" name="prix1" class="form-control"/>
	                			</div>
	                			<div class="form-group"  >
	                				<label>Maturit�</label>
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
	                				<input type="text" name="quantite2" class="form-control" required="required"/>
	                			</div>
	                			<div class="form-group">
	                				<label>Prix</label>
	                				<input type="text" name="prix2" class="form-control" required="required"/>
	                			</div>
                			</div>
                			
                			<button data-toggle="modal" data-target="#myModal" style="display:none"  id="buttonSubmit" class="btn btn-success">Ajouter l'offre</button>
                		</form>
                	</div>
                </div>

               

                

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title">Confirmation</h4>
      </div>
      <div class="modal-body">
        <p>Confirmez-vous l'ajout de l'offre ? </p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Annuler</button>
        <button type="button" class="btn btn-primary" id="confirm">Confirmer</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
    

</body>

</html>
