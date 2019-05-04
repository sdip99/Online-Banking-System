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

<link rel="stylesheet" href="assets/plugins/morris/morris.css">
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
      })(window,document,'script','assets/analytics.js','ga');

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
					<div class="col-sm-12">
						<h4 class="page-title">Welcome ${account_info.cust_name}</h4>
						<ol class="breadcrumb">
							<li><a href="user_home.jsp">Home</a></li>
							<li class="active">Settings</li>
						</ol>
					</div>
				</div>


				<div class="row">

					<div class="col-md-12">


						<div class="col-lg-4">
							<div class="card-box">
								<a href="ChangePassword.jsp"><div class="bar-widget">
										<div class="table-box">
											<div class="table-detail">
												<div class="iconbox bg-custom">
													<i class="ion-edit"></i>
												</div>
											</div>

											<div class="table-detail">
												<h4 class="m-t-0 m-b-5">
													<b>Change Password</b>
												</h4>

											</div>
										</div>
									</div></a>
							</div>
						</div>

						<div class="col-lg-4">
							<div class="card-box">
								<a href="changeDetails.html"><div class="bar-widget">

										<div class="table-box">
											<div class="table-detail">
												<div class="iconbox bg-danger">
													<i class="ion-ipad"></i>
												</div>
											</div>

											<div class="table-detail">
												<h4 class="m-t-0 m-b-5">
													<b>Change Mobile No</b>
												</h4>
											</div>

										</div>
									</div></a>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

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