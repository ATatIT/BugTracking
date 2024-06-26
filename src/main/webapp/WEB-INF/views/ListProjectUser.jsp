<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BugTracking|Dashboard</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../assets/images/favicon.ico">

<!-- Library / Plugin Css Build -->
<link rel="stylesheet" href="../assets/css/core/libs.min.css">

<!-- Aos Animation Css -->
<link rel="stylesheet" href="../assets/vendor/aos/dist/aos.css">

<!-- DataTables button CSS -->
<link rel="stylesheet"
	href="../assets/css/core/datatables.button.min.css">

<!-- Hope Ui Design System Css -->
<link rel="stylesheet" href="../assets/css/hope-ui.min.css?v=4.0.0">

<!-- Custom Css -->
<link rel="stylesheet" href="../assets/css/custom.min.css?v=4.0.0">

<!-- Dark Css -->
<link rel="stylesheet" href="../assets/css/dark.min.css">

<!-- Customizer Css -->
<link rel="stylesheet" href="../assets/css/customizer.min.css">

<!-- RTL Css -->
<link rel="stylesheet" href="../assets/css/rtl.min.css">


</head>

<body class="  ">
	<!-- loader Start -->
	<%@include file="Loder.jsp"%>
	<!-- loader END -->

	<!-- Slider start -->

	<jsp:include page="AdminSlidebar.jsp"></jsp:include>

	<!-- Slider end -->

	<main class="main-content">
		<!-- header start -->

		<jsp:include page="AdminHeader.jsp"></jsp:include>

		<!-- header end -->
		<div class="mt-5">

			<div class="conatiner-fluid content-inner mt-n5 py-0">
				<div class="row mt-3 p-3">
					<div class="col-sm-12">
						<div class="card card-body d-flex justify-content-between">
							<div class="header-title">
								<h4 class="card-title">${pt.projecttitle}'sTeam</h4>
							</div>
							<div class="header-title">
								<h6 class="card-title">
									<a href="newprojectuser?projectId=${pt.projectId}">Assing
										Team Member</a>
								</h6>
							</div>
						</div>
						<div class="card mt-4">
							<div class="card-header d-flex justify-content-between">
								<div class="header-title">
									<h4 class="card-title">Active</h4>
								</div>
							</div>
							<div class="card-body">
								<div id="button-div-id"></div>
								<div class="table-responsive">
									<div id="datatable_wrapper"
										class="dataTables_wrapper dt-bootstrap5">
										<div class="table-responsive border-bottom my-3">
											<table id="my-table"
												class="table table-striped dataTable text-dark">
												<tr class="odd">
													<th>FirstName</th>
													<th>LastName</th>
													<th>Email</th>
													<th>Role</th>
													<th>Action</th>
												</tr>

												<c:forEach items="${pu}" var="puser" varStatus="status">

													<tr class="${status.index % 2 == 0 ? 'even' : 'odd'}">
														<td>${puser.firstName}</td>
														<td>${puser.lastName}</td>
														<td>${puser.email}</td>
														<td><c:if test="${puser.roleId == 1 }">
												Admin
											</c:if> <c:if test="${puser.roleId == 2 }">
												Project Manager
											</c:if> <c:if test="${puser.roleId == 3 }">
												Developer
											</c:if> <c:if test="${puser.roleId == 4 }">
												Tester
											</c:if></td>
														<td><a
															href="projectuserassignstatus?userId=${puser.userId}&projectId=${pt.projectId}&status=2">Revoke</a>
															| <a
															href="projectuserassignstatus?userId=${puser.userId}&projectId=${pt.projectId}&status=3">Hold</a></td>
													</tr>
												</c:forEach>


											</table>
										</div>
										<div class="clear"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="card mt-4">
							<div class="card-header d-flex justify-content-between">
								<div class="header-title">
									<h4 class="card-title">On Hold</h4>
								</div>
							</div>
							<div class="card-body">

								<div class="table-responsive">
									<div id="datatable_wrapper"
										class="dataTables_wrapper dt-bootstrap5">
										<div class="table-responsive border-bottom my-3">
											<table class="table table-striped dataTable text-dark">
												<tr class="odd">
													<th>FirstName</th>
													<th>LastName</th>
													<th>Email</th>
													<th>Role</th>
													<th>Action</th>
												</tr>

												<c:forEach items="${puhold}" var="puser" varStatus="status">

													<tr class="${status.index % 2 == 0 ? 'even' : 'odd'}">
														<td>${puser.firstName}</td>
														<td>${puser.lastName}</td>
														<td>${puser.email}</td>
														<td>${puser.roleId}</td>
														<td><a
															href="projectuserassignstatus?userId=${puser.userId}&projectId=${pt.projectId}&status=1">Re-Assign</a>
															| <a
															href="projectuserassignstatus?userId=${puser.userId}&projectId=${pt.projectId}&status=2">Revoke</a></td>
													</tr>
												</c:forEach>


											</table>
										</div>
										<div class="clear"></div>
									</div>
								</div>
							</div>
						</div>
						<div class="card mt-4">
							<div class="card-header d-flex justify-content-between">
								<div class="header-title">
									<h4 class="card-title">Revoked</h4>
								</div>
							</div>
							<div class="card-body">

								<div class="table-responsive">
									<div id="datatable_wrapper"
										class="dataTables_wrapper dt-bootstrap5">
										<div class="table-responsive border-bottom my-3">
											<table class="table table-striped dataTable text-dark">
												<tr class="odd">
													<th>FirstName</th>
													<th>LastName</th>
													<th>Email</th>
													<th>Role</th>
													<th>Action</th>
												</tr>

												<c:forEach items="${purevoke}" var="puser"
													varStatus="status">

													<tr class="${status.index % 2 == 0 ? 'even' : 'odd'}">
														<td>${puser.firstName}</td>
														<td>${puser.lastName}</td>
														<td>${puser.email}</td>
														<td>${puser.roleId}</td>
														<td><a
															href="projectuserassignstatus?userId=${puser.userId}&projectId=${pt.projectId}&status=1">Re-Assign</a>
															| <a
															href="projectuserassignstatus?userId=${puser.userId}&projectId=${pt.projectId}&status=3">Hold</a></td>
													</tr>
												</c:forEach>


											</table>
										</div>
										<div class="clear"></div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>



		<!-- Footer Section Start -->

		<jsp:include page="AdminFooter.jsp"></jsp:include>

		<!-- Footer Section End -->
	</main>


	<!-- Wrapper End-->
	<!-- offcanvas start -->

	<jsp:include page="AdminCanvas.jsp"></jsp:include>

	<!-- Library Bundle Script -->
	<script src="../assets/js/core/libs.min.js"></script>

	<!-- External Library Bundle Script -->
	<script src="../assets/js/core/external.min.js"></script>

	<!-- Widgetchart Script -->
	<script src="../assets/js/charts/widgetcharts.js"></script>

	<!-- mapchart Script -->
	<script src="../assets/js/charts/vectore-chart.js"></script>
	<script src="../assets/js/charts/dashboard.js"></script>

	<!-- fslightbox Script -->
	<script src="../assets/js/plugins/fslightbox.js"></script>

	<!-- Settings Script -->
	<script src="../assets/js/plugins/setting.js"></script>

	<!-- Slider-tab Script -->
	<script src="../assets/js/plugins/slider-tabs.js"></script>

	<!-- Form Wizard Script -->
	<script src="../assets/js/plugins/form-wizard.js"></script>

	<!-- AOS Animation Plugin-->
	<script src="../assets/vendor/aos/dist/aos.js"></script>


	<!-- DataTables Button JS -->
	<script src="../assets/js/dataTables.buttons.min.js"></script>
	<script src="../assets/js/buttons.bootstrap4.min.js"></script>
	<!-- Include the JSZip library (for Excel export) -->
	<script src="../assets/js/jszip.min.js"></script>

	<!-- Include the HTML5 export buttons (CSV, Excel, PDF, Print) -->
	<script src="../assets/js/buttons.html5.min.js"></script>

	<!-- Include the Button print functionality -->
	<script src="../assets/js/buttons.print.min.js"></script>

	<!-- Include the Column visibility button -->
	<script src="../assets/js/buttons.colVis.min.js"></script>

	<!-- App Script -->
	<script src="../assets/js/hope-ui.js" defer></script>


</body>


</html>