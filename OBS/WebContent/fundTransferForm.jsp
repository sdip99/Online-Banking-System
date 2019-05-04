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

<script>
	(function(i, s, o, g, r, a, m) {
		i['GoogleAnalyticsObject'] = r;
		i[r] = i[r] || function() {
			(i[r].q = i[r].q || []).push(arguments)
		}, i[r].l = 1 * new Date();
		a = s.createElement(o), m = s.getElementsByTagName(o)[0];
		a.async = 1;
		a.src = g;
		m.parentNode.insertBefore(a, m)
	})(window, document, 'script', 'assets/analytics.js', 'ga');

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
							<!-- <li>
										<a href="#">Ubold</a>
									</li> -->
							<li class="active">Home</li>
						</ol>
					</div>
				</div>


				<div class="row">

					<div class="col-md-12">
						<form action="transferFund.html">
							<div class="panel panel-default">
								<!-- <div class="panel-heading">
                                        <h4>Invoice</h4>
                                    </div> -->
								<div class="panel-body">
									<div class="clearfix">
										<div class="pull-left">
											<h4 class="text-right">Transfer Fund</h4>

										</div>
										<div class="pull-right">
											<h4>
												Available Balance<br> <strong><i
													class="fa fa-inr">&nbsp; ${account_info.balance}</i></strong>
											</h4>
										</div>
									</div>
								</div>
								<hr>

								<div class="col-lg-12">

									<div class="pull-left m-t-30" style="margin-right: 2px;">
										<p>
											<strong>Payee Name : </strong> ${payee.payee_name }
										</p>
										<p class="m-t-10">
											<strong>Payee Accout_id : </strong> ${payee.payee_acc_no }
										</p>
										<p class="m-t-10">
											<strong>Payee Ifsc Code: </strong> ${payee.payee_ifsc}
										</p>
									</div>

									<br> <input type="text" name="amount"
										parsley-trigger="change" required placeholder="Enter amount"
										class="form-control" id="userName">

								</div>
								<input type="hidden" name="pid" value="${payee.payee_acc_no}" />

								<br> <br>
								<div class="col-lg-12">
									<input type="checkbox" required> <label>I agree
										with the Terms and Conditions.</label>
								</div>
								<br>
								<br>
								<diV align="center">
									<button type="submit"
										class="btn btn-default btn-rounded waves-effect waves-light">Transfer
										Fund</button>
									<br>
									<br>
								</diV>
							</div>

						</form>


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