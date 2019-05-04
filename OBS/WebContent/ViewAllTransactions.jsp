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
	<c:import url="header_admin.jsp"></c:import>
	<c:import url="admin_sidebar.jsp"></c:import>
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
						<h4 class="page-title">Welcome Admin</h4>
						<ol class="breadcrumb">

							<li><a href="admin_home.jsp">Home</a></li>
							<li class="active">View All Transactions</li>
						</ol>

					</div>
				</div>

				<div class="row">
					<div class="col-sm-12">
						<div class="card-box">
							<div class="row">
								<div class="col-lg-12">
									<h4 class="m-t-0 header-title">
										<b>Today's All Transactions</b>
									</h4>
									<div class="p-20">
										<table class="table m-0">

											<thead>
												<tr>
													<th>Transaction ID</th>
													<th>Transaction Description</th>
													<th>Transaction Date</th>
													<th>Transaction Type</th>
													<th>Transaction Amount</th>
													<th>Account ID</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="transactions" items="${trList}">

													<tr>
														<td>${transactions.transactionId}</td>
														<td>${transactions.transactionDescription}</td>
														<td>${transactions.transactionDate}</td>
														<td>${transactions.transactionType}</td>
														<td>${transactions.transactionAmount}</td>
														<td>${transactions.accountId}</td>

													</tr>

												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

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