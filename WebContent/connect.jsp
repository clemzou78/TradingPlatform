<!DOCTYPE html>
<html lang="en" style="width: 100%; height: 100%">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Accueil - Trading Platform</title>

<!-- Bootstrap Core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/sb-admin.css" rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="css/plugins/morris.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<script src="js/jquery.js"></script>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.text-vertical-center {
	display: table-cell;
	text-align: center;
	vertical-align: middle;
}

.header {
	display: table;
	position: relative;
	width: 100%;
	height: 100%;
	background: url(img/bg.jpg) no-repeat center center scroll;
	background-size: cover;
}
</style>
</head>
<script>
function init_form1(){
	$("#forminvest").submit(function(){
		$("#wrongPassword").fadeOut("fast");
		if( $("#password").val()!=$("#confirmPassword").val() ){
			 $("#wrongPassword").fadeIn("fast");
			return false;
		}	
	});
}
$(document).ready(function(){
	$("#formConnect").submit(function(){
		$.post("connexion",{name:$("input[name='username']").val(),password:$("input[name='password']").val()},function(data){
			if(data==0){
				$("#errorMatch").fadeIn("fast");
				$("#errorMissing").fadeOut("fast");
			}
			else if(data==2){
				$("#errorMissing").fadeIn("fast");
				$("#errorMatch").fadeOut("fast");
			}
			else window.location.href="index.jsp";
		});
		return false;
	});
	$("#notLoggedId").click(function(){
		$("#divButton").fadeIn("slow");
	});

	$("#investButton").click(function(){
		$("#welcomemsg").fadeOut("fast");
		$("#formButton").fadeOut("fast");
		$("#divButton").fadeOut("fast",function(){
			$("#formConnect").fadeOut("fast");
			$("#divButton").height("500px");
			$("#divButton").slideDown("slow");
			$("#divButton").html($("#form1").html()).promise().done(function(){
				init_form1();
			});
		});		
		return false;
	});

	$("#societeButton").click(function(){
		$("#welcomemsg").fadeOut("fast");
		$("#formButton").fadeOut("fast");
		$("#divButton").fadeOut("fast",function(){
			$("#formConnect").fadeOut("fast");
			$("#divButton").height("500px");
			$("#divButton").slideDown("slow");
			$("#divButton").html($("#form2").html()).promise().done(function(){
			});
		});		
		return false;
	});
	
	
	
	
	
});
</script>
<body style="width: 100%; height: 100%; display: block; margin: 0;">
	<!-- Header -->
	<header id="top" class="header">
		<div class="text-vertical-center">
			<h1 id="welcomemsg">Welcome on The Trading Platform</h1>
			<form role="form" id="formConnect" method="post" action="#">
				<div id="formButton">
					<div class="form-group input-group"
						style="width: 10%; margin: auto">
						<input type="text" class="form-control" placeholder="Username"
							name="username">
					</div>

					<div class="form-group input-group"
						style="width: 10%; margin: auto">
						<input type="password" class="form-control" placeholder="Password"
							name="password">
					</div>
					<button type="submit" class="btn btn-default"
						style="margin-top: 20px">Login</button>
					<br />
					<p class="bg-danger" id="errorMatch"
						style="color: red; display: none; margin-top: 10px"">Couple
						login/pass inconnu</p>
					<p class="bg-danger" id="errorMissing"
						style="color: red; display: none; margin-top: 10px"">Veuillez
						renseigner les champs</p>
					<a href="#" id="notLoggedId" style="margin-top: 20px">Pas
						encore inscrit ?</a>
				</div>
			</form>

			<div class="well" id="divButton"
				style="margin-top: 10px; display: none;">
				<b style="font-size: 1.2em">Je souhaite m'inscrire en tant que :
				</b><br />
				<br />
				<button id="investButton" class="btn btn-success"
					style="width: 150px">Investisseur</button>
				<button style="width: 150px" class="btn btn-success" id="societeButton">Société</button>
			</div>
			<div id="form1" style="display: none">
				<form role="form" id="forminvest" method="post" action="InvestissorAdd">
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Nom *</label> <input type="text" class="form-control"
							placeholder="Nom" name="nom" required="required">
					</div>
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Prenom *</label> <input type="text" class="form-control"
							placeholder="Prénom" name="prenom" required="required">
					</div>
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Email *</label> <input type="email" class="form-control"
							placeholder="Email" name="email" required="required">
					</div>
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Mot de passe *</label> <input type="password" id="password"
							class="form-control" placeholder="Mot de passe" name="password"
							required="required">
					</div>
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Confirmez mot de passe *</label> <input type="password"
							id="confirmPassword" class="form-control"
							placeholder="Mot de passe" name="confirmPassword"
							required="required">
					</div>
					<p style="color: red; display: none" id="wrongPassword">Les
						mots de passe ne correspondent pas</p>
					<button type="submit" class="btn btn-success" style="margin-top: 20px">S'inscrire</button>
				</form>
			</div>
			
			<div id="form2" style="display: none">
				<form role="form" id="forminvest" method="post" action="SocieteAddAccueil">
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Société *</label> <input type="text" class="form-control"
							placeholder="Société" name="societe" required="required">
					</div>
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Email *</label> <input type="email" class="form-control"
							placeholder="Email" name="email" required="required">
					</div>
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Mnemo (Raccourci)*</label> <input type="text" class="form-control"
							placeholder="Mnemo" name="mnemo" required="required">
					</div>
					<div class="form-group input-group"
						style="width: 10%; margin: auto; margin-top: 20px">
						<label>Description *</label> <textarea name="description" class="form-control" required="required" rows="8"></textarea>
					</div>
					<button type="submit" class="btn btn-success" style="margin-top: 20px">S'inscrire</button>
				</form>
			</div>

		</div>
	</header>
</body>

</html>
