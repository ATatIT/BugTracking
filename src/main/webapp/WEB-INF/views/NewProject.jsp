<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BT|NewProject</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../assets/images/favicon.ico">

<!-- Library / Plugin Css Build -->
<link rel="stylesheet" href="../assets/css/core/libs.min.css">

<!-- Aos Animation Css -->
<link rel="stylesheet" href="../assets/vendor/aos/dist/aos.css">

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
						<div class="card mt-4">
							<div class="card-header d-flex justify-content-between">
								<div class="header-title">
									<h4 class="card-title">New Project</h4>
								</div>
							</div>
							<div class="card-body">

								<form class="row g-3" action="saveproject" method="post">
									<div class="col-md-6">
										<label class="form-label">ProjectTitle</label> <input
											type="text" class="form-control" id="validationCustom01"
											name="projecttitle">
									</div>
									<div class="col-md-6">
										<label class="form-label">DocumentURL</label> <input
											type="text" class="form-control" id="validationCustom02"
											name="docURL">
									</div>
									
									<div class="col-md-6">
										<label class="form-label">EstimatedHours</label> <input
											type="text" class="form-control" id="validationCustom02"
											name="estimatedHours">
									</div>
									<div class="col-md-6">
										<label class="form-label">TotalUtilizedHours</label> <input
											type="text" class="form-control" id="validationCustom02"
											name="totalUtilizedHours">
									</div>
									<div class="col-md-6">
										<label class="form-label">ProjectStartDate</label> <input
											type="date" class="form-control" id="validationCustom02"
											name="projectStartDate">
									</div>
									<div class="col-md-6">
										<label class="form-label">ProjectCompletionDate</label> <input
											type="date" class="form-control" id="validationCustom02"
											name="projectCompletionDate">
									</div>
									
									<div class="col-md-6">
										<label class="form-label">Description</label>
										<textarea rows="4" class="form-control" name="description"></textarea>
									</div>
									<div class="col-md-6">
										<label class="form-label">Status</label> <select class="form-select" name="projectStatusId">
											<option value="-1">----Status----</option>
											<c:forEach items="${projectStatuList}" var="projectstatus">
												<option value="${projectstatus.statusId}">${projectstatus.status}</option>
											</c:forEach>
										</select>
									</div>
									<div class="col-12">
										<button class="btn btn-primary" type="submit">Add Project
											</button>
									</div>
								</form>
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

	<!-- App Script -->
	<script src="../assets/js/hope-ui.js" defer></script>


</body>

</html>