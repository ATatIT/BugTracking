<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BT|Profile</title>

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
				<div class="row">
					<div class="col-lg-12" style="margin-top: 75px;">
						<div class="card">
							<div class="card-body">
								<div
									class="d-flex flex-wrap align-items-center justify-content-between">
									<div class="d-flex flex-wrap align-items-center">
										<div
											class="profile-img position-relative me-3 mb-3 mb-lg-0 profile-logo profile-logo1">
											<img src="../../assets/images/avatars/01.png"
												alt="User-Profile"
												class="theme-color-default-img img-fluid rounded-pill avatar-100">
											<img src="../../assets/images/avatars/avtar_1.png"
												alt="User-Profile"
												class="theme-color-purple-img img-fluid rounded-pill avatar-100">
											<img src="../../assets/images/avatars/avtar_2.png"
												alt="User-Profile"
												class="theme-color-blue-img img-fluid rounded-pill avatar-100">
											<img src="../../assets/images/avatars/avtar_4.png"
												alt="User-Profile"
												class="theme-color-green-img img-fluid rounded-pill avatar-100">
											<img src="../../assets/images/avatars/avtar_5.png"
												alt="User-Profile"
												class="theme-color-yellow-img img-fluid rounded-pill avatar-100">
											<img src="../../assets/images/avatars/avtar_3.png"
												alt="User-Profile"
												class="theme-color-pink-img img-fluid rounded-pill avatar-100">
										</div>
										<div class="d-flex flex-wrap align-items-center mb-3 mb-sm-0">
											<h4 class="me-2 h4">${user.firstName} ${user.lastName}</h4>
											
										</div>
									</div>

								</div>
							</div>
						</div>
					</div>

					<div>
						<div class="profile-content tab-content">



							<div id="profile-profile" class="tab-pane fade active show"
								role="tabpanel">

								<div class="card">
									<div class="card-header">
										<div class="header-title">
											<h4 class="card-title">About User</h4>
										</div>
									</div>
									<div class="card-body">
										<div class="mt-2">
											<h6 class="mb-1">Role:</h6>
											<p>${role.roleName }</p>
										</div>
										<div class="mt-2">
											<h6 class="mb-1">Gender:</h6>
											<p>${user.gender }</p>
										</div>
										<div class="mt-2">
											<h6 class="mb-1">DOB:</h6>
											<p>${user.dob }</p>
										</div>
										<div class="mt-2">
											<h6 class="mb-1">Email:</h6>
											<p>
												${user.email }
											</p>
										</div>
										<div class="mt-2">
											<h6 class="mb-1">Contact:</h6>
											<p>
												${user.contact }
											</p>
										</div>
										<div class="mt-2">
											<h6 class="mb-1">Address:</h6>
											<p>
												${user.address }
											</p>
										</div>
										<div class="mt-2">
											<h6 class="mb-1">City:</h6>
											<p>
												${user.city }
											</p>
										</div>
										<div class="mt-2">
											<h6 class="mb-1">State:</h6>
											<p>
												${user.state }
											</p>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>

				</div>
				<div class="offcanvas offcanvas-bottom share-offcanvas"
					tabindex="-1" id="share-btn" aria-labelledby="shareBottomLabel">
					<div class="offcanvas-header">
						<h5 class="offcanvas-title" id="shareBottomLabel">Share</h5>
						<button type="button" class="btn-close text-reset"
							data-bs-dismiss="offcanvas" aria-label="Close"></button>
					</div>
					<div class="offcanvas-body small">
						<div class="d-flex flex-wrap align-items-center">
							<div class="text-center me-3 mb-3">
								<img src="../../assets/images/brands/08.png"
									class="img-fluid rounded mb-2" alt="">
								<h6>Facebook</h6>
							</div>
							<div class="text-center me-3 mb-3">
								<img src="../../assets/images/brands/09.png"
									class="img-fluid rounded mb-2" alt="">
								<h6>Twitter</h6>
							</div>
							<div class="text-center me-3 mb-3">
								<img src="../../assets/images/brands/10.png"
									class="img-fluid rounded mb-2" alt="">
								<h6>Instagram</h6>
							</div>
							<div class="text-center me-3 mb-3">
								<img src="../../assets/images/brands/11.png"
									class="img-fluid rounded mb-2" alt="">
								<h6>Google Plus</h6>
							</div>
							<div class="text-center me-3 mb-3">
								<img src="../../assets/images/brands/13.png"
									class="img-fluid rounded mb-2" alt="">
								<h6>In</h6>
							</div>
							<div class="text-center me-3 mb-3">
								<img src="../../assets/images/brands/12.png"
									class="img-fluid rounded mb-2" alt="">
								<h6>YouTube</h6>
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