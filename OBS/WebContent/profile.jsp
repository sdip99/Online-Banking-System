<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description"
	content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
<meta name="author" content="Coderthemes">

<link rel="shortcut icon" href="assets/images/favicon_1.ico">

<title>Online Banking</title>

<!--Form Wizard-->
<link rel="stylesheet" type="text/css"
	href="assets/plugins/jquery.steps/demo/css/jquery.steps.css" />

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
	<c:import url="header_user.jsp"></c:import>
	<c:import url="sidebar_user.jsp"></c:import>
	<!-- ============================================================== -->
	<!-- Start right Content here -->
	<!-- ============================================================== -->
	<div class="content-page">
		<!-- Start content -->
		<div class="content">
			<div class="container">

				<!-- Page-Title -->
				<div class="row">
					<div class="col-md-4">

						<div class="card-box m-t-20">
							<h4 class="m-t-0 header-title">
								<b>Personal Information</b>
							</h4>
							<div class="p-20">
								<div class="about-info-p">
									<strong>Full Name</strong> <br>
									<p class="text-muted">${account_info.cust_name}</p>
								</div>
								<div class="about-info-p">
									<strong>Mobile</strong> <br>
									<p class="text-muted">${account_info.phone_no }</p>
								</div>
								<div class="about-info-p">
									<strong>Email</strong> <br>
									<p class="text-muted">${account_info.email}</p>
								</div>
								<div class="about-info-p m-b-0">
									<strong>Address</strong> <br>
									<p class="text-muted">${account_info.address }</p>
								</div>
							</div>
							<diV align="center">
								<a href="user_home.jsp"><button type="submit"
										class="btn btn-default btn-rounded waves-effect waves-light">Go
										Back</button></a><br>
								<br>
							</diV>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>

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

	<!--Form Validation-->
	<script
		src="assets/plugins/bootstrapvalidator/dist/js/bootstrapValidator.js"
		type="text/javascript"></script>

	<!--Form Wizard-->
	<script src="assets/plugins/jquery.steps/build/jquery.steps.min.js"
		type="text/javascript"></script>
	<script type="text/javascript"
		src="assets/plugins/jquery-validation/dist/jquery.validate.min.js"></script>

	<!--wizard initialization-->
	<script src="assets/pages/jquery.wizard-init.js" type="text/javascript"></script>

</body>
</html>