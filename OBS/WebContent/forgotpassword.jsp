<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">

<link rel="shortcut icon" href="assets/images/favicon_1.ico">

<title>Forgot Password</title>

<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/css/core.css" rel="stylesheet" type="text/css" />
<link href="assets/css/components.css" rel="stylesheet" type="text/css" />
<link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
<link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
<link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />



<script src="assets/js/modernizr.min.js"></script>

<script>(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
      (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
      m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
      })(window,document,'script','../../../www.google-analytics.com/analytics.js','ga');

      ga('create', 'UA-69506598-1', 'auto');
      ga('send', 'pageview');
</script>

</head>
<body>

	<div class="animationload">
		<div class="loader"></div>
	</div>

	<div class="account-pages"></div>
	<div class="clearfix"></div>
	<div class="wrapper-page">
		<div class=" card-box">
			<div class="panel-heading">
				<h3 class="text-center">
					Enter Details to <strong class="text-custom">authenticate</strong>
				</h3>
			</div>

			<div class="panel-body">
				<c:if test="${error!=null}">
					${error}</c:if>
				<form class="form-horizontal m-t-20" action="forgotPassword.html"
					method="post">
					<div class="form-group ">
						<div class="col-xs-12">
							<input class="form-control" type="text" required=""
								placeholder="Account Id" name="accountid">
						</div>
					</div>

					<div class="form-group ">
						<div class="col-xs-12">
							<input class="form-control" type="text" required=""
								placeholder="Debit Number" name="debitnumber">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-12">
							<input class="form-control" type="text" required=""
								placeholder="CVV" name="cvv">
						</div>
					</div>

					<div class="form-group">
						<div class="col-xs-12">
							<div class="checkbox checkbox-primary">
								<input id="checkbox-signup" type="checkbox" checked="checked">
								<label for="checkbox-signup">I accept <a href="#">Terms
										and Conditions</a></label>
							</div>
						</div>
					</div>

					<div class="form-group text-center m-t-40">
						<div class="col-xs-12">
							<button
								class="btn btn-pink btn-block text-uppercase waves-effect waves-light"
								type="submit">Submit</button>
						</div>
					</div>

				</form>

			</div>
		</div>

		<div class="row">
			<div class="col-sm-12 text-center">
				<p>
					Already have account?<a href="index.html"
						class="text-primary m-l-5"><b>Sign In</b></a>
				</p>
			</div>
		</div>

	</div>

	<script>
			var resizefunc = [];
		</script>

	<!-- jQuery  -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/detect.js"></script>
	<script src="assets/js/fastclick.js"></script>
	<script src="assets/js/jquery.slimscroll.js"></script>
	<script src="assets/js/jquery.blockUI.js"></script>
	<script src="assets/js/waves.js"></script>
	<script src="assets/js/wow.min.js"></script>
	<script src="assets/js/jquery.nicescroll.js"></script>
	<script src="assets/js/jquery.scrollTo.min.js"></script>


	<script src="assets/js/jquery.core.js"></script>
	<script src="assets/js/jquery.app.js"></script>

</body>

</html>
>
