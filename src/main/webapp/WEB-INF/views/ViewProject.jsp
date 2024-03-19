<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BT| View Project Details</title>

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
						<div class="mt-4">
							<div class="card card-body d-flex justify-content-between">
								<div class="header-title">
									<h3 class="card-title">View Project</h3>
								</div>
							</div>

						</div>
						<div class="card">
							<div class="card-body">
								<div class="d-flex justify-content-between mb-4">
									<div class="row">
										<div class="">
											<h3>${project.projecttitle}</h3>

										</div>
									</div>

								</div>
								<div
									class="d-flex  justify-content-start align-items-center mb-3">

									<div>
										<h5>
											Status :
											<c:if test="${project.projectStatusId == 1 }">
												OnHold
											</c:if><c:if test="${project.projectStatusId == 2 }">
												NotStarted
											</c:if>
											<c:if test="${project.projectStatusId == 3 }">
												OnGoing
											</c:if>
											<c:if test="${project.projectStatusId == 4 }">
												Complete
											</c:if>
										</h5>
										<br>
										<h5>Start Date : ${project.projectStartDate}</h5>
										<h6>End Date : ${project.projectCompletionDate}</h6>
										<br>
										<h5 class="">Estimated Hours : ${project.estimatedHours}</h5>
										<h6 class="mb-0">Utillized Hours :
											${project.totalUtilizedHours}</h6>
									</div>
								</div>
								<div>
									<h5>Document URL</h5>
									<small><a href="${project.docURL}">${project.docURL}</a></small>

								</div>
								<br>

								<div>
									<h5>Description</h5>
									<small>${project.description}</small>

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