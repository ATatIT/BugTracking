<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BT|Tasks</title>

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

<body>

	<!-- loader Start -->
	<%@include file="Loder.jsp"%>
	<!-- loader END -->

	<!-- Slider start -->

	<jsp:include page="TesterSlidebar.jsp"></jsp:include>

	<!-- Slider end -->

	<main class="main-content">
		<!-- header start -->

		<jsp:include page="TesterHeader.jsp"></jsp:include>

		<!-- header end -->
		<div class="mt-5">

			<div class="conatiner-fluid content-inner mt-n5 py-0">

				<div class="row mt-3 p-3">
					<div class="col-sm-12">
						<div class="card mt-4">
							<div class="card-header d-flex justify-content-between">
								<div class="header-title">
									<h4 class="card-title">${project.projecttitle}:
										${module.moduleName}'s Task</h4>
								</div>
								<div class="header-title"><a href="listmoduleoftester?projectId=${project.projectId}">Back</a></div>
							</div>
							<div class="card-body">
								<div id="button-div-id"></div>
								<div class="table-responsive">
									<div id="datatable_wrapper"
										class="dataTables_wrapper dt-bootstrap5">
										<div class="table-responsive border-bottom my-3">
											<table id="my-table" class="table table-striped"
												data-toggle="data-table">
												<thead>

													<tr class="odd">
														<!-- <th>TaskId</th> -->
														<th>Title</th>
														<!-- <th>ModuleId</th> -->
														<!-- <th>ProjectId</th> -->
														<th>Status</th>
														<!-- <th>Description</th> -->
														<!-- <th>DocUrl</th> -->
														<th>Estimated Hours</th>
														<th>TotalUtilized Hours</th>
														<th>Action</th>

													</tr>


												</thead>
												<tbody>
													<c:forEach items="${task}" var="task" varStatus="status">

														<tr class="${status.index % 2 == 0 ? 'even' : 'odd'}">
															<%-- <td>${task.taskId}</td> --%>
															<td><a href="bugreport?taskId=${task.taskId}&moduleId=${module.moduleId}&projectId=${project.projectId}">${task.title}</a> </td>
															<%-- <td>${task.moduleId}</td> --%>
															<%-- <td>${task.projectId}</td> --%>
															<td><c:if test="${task.status == 1 }">
												OnHold
											</c:if> <c:if test="${task.status == 2 }">
												NotStarted
											</c:if> <c:if test="${task.status == 3 }">
												OnGoing
											</c:if> <c:if test="${task.status == 4 }">
												Complete
											</c:if> <c:if test="${task.status == 5 }">
												<span class="text-success">Approved</span> 
											</c:if> <c:if test="${task.status == 6 }">
												Defected
											</c:if></td>

															<%-- <td>${task.description}</td> --%>
															<%-- <td>${task.docURL}</td> --%>
															<td>${task.estimatedHours}</td>
															<td>${task.totalUtilizedHours}</td>
															<td><a href="viewtask?taskId=${task.taskId}">View</a></td>
														</tr>
													</c:forEach>


												</tbody>

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
	<!-- <script src="../assets/js/dataTables.buttons.min.js"></script>
	<script src="../assets/js/buttons.bootstrap4.min.js"></script> -->
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