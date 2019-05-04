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

<link href="assets/plugins/timepicker/bootstrap-timepicker.min.css"
	rel="stylesheet">
<link
	href="assets/plugins/mjolnic-bootstrap-colorpicker/dist/css/bootstrap-colorpicker.min.css"
	rel="stylesheet">
<link
	href="assets/plugins/bootstrap-datepicker/dist/css/bootstrap-datepicker.min.css"
	rel="stylesheet">
<link href="assets/plugins/clockpicker/dist/jquery-clockpicker.min.css"
	rel="stylesheet">
<link
	href="assets/plugins/bootstrap-daterangepicker/daterangepicker.css"
	rel="stylesheet">

<link href="assets/css/bootstrap.min.css" rel="stylesheet"
	type="text/css" />
<link href="assets/css/core.css" rel="stylesheet" type="text/css" />
<link href="assets/css/components.css" rel="stylesheet" type="text/css" />
<link href="assets/css/icons.css" rel="stylesheet" type="text/css" />
<link href="assets/css/pages.css" rel="stylesheet" type="text/css" />
<link href="assets/css/responsive.css" rel="stylesheet" type="text/css" />

<!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

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
						<h4 class="page-title">Update details</h4>
						<ol class="breadcrumb">
							<li><a href="admin_home.jsp">Home</a></li>
							<li class="active">Update details</li>
						</ol>
					</div>
				</div>

				<c:if test="${details!=null}">
					<form action="saveDetails.html" method="post">
						<table align="center" cellpadding="1" cellspacing="1">
							<tr>

								<td>Name:</td>
								<td><input type="text" name="cname"
									value="${details.cust_name}" readonly /></td>
							</tr>
							<tr>
								<td>Account Number :</td>
								<td><input type="text" name="cid"
									value="${details.accountId}" readonly /></td>
							</tr>

							<tr>
								<td>Phone Number :</td>
								<td><input type="text" name="phoneno"
									value="${details.phone_no}" required="required"
									pattern="^[1-9][0-9]{9}" /></td>
							</tr>
							<tr>
								<td>Email Address :</td>
								<td><input type="email" name="emailid"
									value="${details.email}" required="required" /></td>
							</tr>
							<tr>
								<td>Permanent Address:</td>
								<td><input type="text" rows="5" cols="21" name="add1"
									value="${details.address}" required="required" /></td>


							</tr>

							<tr>
								<td></td>
								<td colspan="1" align="left"><input type="submit"
									value="Save" /> <input type="reset" value="reset" /></td>
							</tr>

						</table>

					</form>
				</c:if>
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


	<script src="assets/plugins/moment/moment.js"></script>
	<script src="assets/plugins/timepicker/bootstrap-timepicker.min.js"></script>
	<script
		src="assets/plugins/mjolnic-bootstrap-colorpicker/dist/js/bootstrap-colorpicker.min.js"></script>
	<script
		src="assets/plugins/bootstrap-datepicker/dist/js/bootstrap-datepicker.min.js"></script>
	<script src="assets/plugins/clockpicker/dist/jquery-clockpicker.min.js"></script>
	<script
		src="assets/plugins/bootstrap-daterangepicker/daterangepicker.js"></script>

	<script>
		jQuery(document)
				.ready(
						function() {

							// Time Picker
							jQuery('#timepicker').timepicker({
								defaultTIme : false
							});
							jQuery('#timepicker2').timepicker({
								showMeridian : false
							});
							jQuery('#timepicker3').timepicker({
								minuteStep : 15
							});

							//colorpicker start

							$('.colorpicker-default').colorpicker({
								format : 'hex'
							});
							$('.colorpicker-rgba').colorpicker();

							// Date Picker
							jQuery('#datepicker').datepicker();
							jQuery('#datepicker-autoclose').datepicker({
								autoclose : true,
								todayHighlight : true
							});
							jQuery('#datepicker-inline').datepicker();
							jQuery('#datepicker-multiple-date').datepicker({
								format : "mm/dd/yyyy",
								clearBtn : true,
								multidate : true,
								multidateSeparator : ","
							});
							jQuery('#date-range').datepicker({
								toggleActive : true
							});

							//Clock Picker
							$('.clockpicker').clockpicker({
								donetext : 'Done'
							});

							$('#single-input').clockpicker({
								placement : 'bottom',
								align : 'left',
								autoclose : true,
								'default' : 'now'
							});
							$('#check-minutes').click(
									function(e) {
										// Have to stop propagation here
										e.stopPropagation();
										$("#single-input").clockpicker('show')
												.clockpicker('toggleView',
														'minutes');
									});

							//Date range picker
							$('.input-daterange-datepicker').daterangepicker({
								buttonClasses : [ 'btn', 'btn-sm' ],
								applyClass : 'btn-default',
								cancelClass : 'btn-white'
							});
							$('.input-daterange-timepicker').daterangepicker({
								timePicker : true,
								format : 'MM/DD/YYYY h:mm A',
								timePickerIncrement : 30,
								timePicker12Hour : true,
								timePickerSeconds : false,
								buttonClasses : [ 'btn', 'btn-sm' ],
								applyClass : 'btn-default',
								cancelClass : 'btn-white'
							});
							$('.input-limit-datepicker').daterangepicker({
								format : 'MM/DD/YYYY',
								minDate : '06/01/2015',
								maxDate : '06/30/2015',
								buttonClasses : [ 'btn', 'btn-sm' ],
								applyClass : 'btn-default',
								cancelClass : 'btn-white',
								dateLimit : {
									days : 6
								}
							});

							$('#reportrange span').html(
									moment().subtract(29, 'days').format(
											'MMMM D, YYYY')
											+ ' - '
											+ moment().format('MMMM D, YYYY'));

							$('#reportrange')
									.daterangepicker(
											{
												format : 'MM/DD/YYYY',
												startDate : moment().subtract(
														29, 'days'),
												endDate : moment(),
												minDate : '01/01/2012',
												maxDate : '12/31/2015',
												dateLimit : {
													days : 60
												},
												showDropdowns : true,
												showWeekNumbers : true,
												timePicker : false,
												timePickerIncrement : 1,
												timePicker12Hour : true,
												ranges : {
													'Today' : [ moment(),
															moment() ],
													'Yesterday' : [
															moment().subtract(
																	1, 'days'),
															moment().subtract(
																	1, 'days') ],
													'Last 7 Days' : [
															moment().subtract(
																	6, 'days'),
															moment() ],
													'Last 30 Days' : [
															moment().subtract(
																	29, 'days'),
															moment() ],
													'This Month' : [
															moment().startOf(
																	'month'),
															moment().endOf(
																	'month') ],
													'Last Month' : [
															moment()
																	.subtract(
																			1,
																			'month')
																	.startOf(
																			'month'),
															moment()
																	.subtract(
																			1,
																			'month')
																	.endOf(
																			'month') ]
												},
												opens : 'left',
												drops : 'down',
												buttonClasses : [ 'btn',
														'btn-sm' ],
												applyClass : 'btn-default',
												cancelClass : 'btn-white',
												separator : ' to ',
												locale : {
													applyLabel : 'Submit',
													cancelLabel : 'Cancel',
													fromLabel : 'From',
													toLabel : 'To',
													customRangeLabel : 'Custom',
													daysOfWeek : [ 'Su', 'Mo',
															'Tu', 'We', 'Th',
															'Fr', 'Sa' ],
													monthNames : [ 'January',
															'February',
															'March', 'April',
															'May', 'June',
															'July', 'August',
															'September',
															'October',
															'November',
															'December' ],
													firstDay : 1
												}
											},
											function(start, end, label) {
												console.log(
														start.toISOString(),
														end.toISOString(),
														label);
												$('#reportrange span')
														.html(
																start
																		.format('MMMM D, YYYY')
																		+ ' - '
																		+ end
																				.format('MMMM D, YYYY'));
											});

						});
	</script>
</body>
</html>