<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" dir="ltr">

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
	<div id="loading">
		<div class="loader simple-loader">
			<div class="loader-body"></div>
		</div>
	</div>
	<!-- loader END -->
	
	<!-- Slider start -->
	
	<jsp:include page="AdminSlidebar.jsp"></jsp:include>
	
	<!-- Slider end -->
	
	<main class="main-content">
	<!-- header start -->
	
		<jsp:include page="AdminHeader.jsp"></jsp:include>
		
	<!-- header end -->
	
		<!-- Nav Header Component Start -->
			<div class="iq-navbar-header" style="height: 215px;">

				<div class="iq-header-img">
					<img src="../assets/images/dashboard/top-header.png" alt="header"
						class="theme-color-default-img img-fluid w-100 h-100 animated-scaleX">
					<img src="../assets/images/dashboard/top-header1.png" alt="header"
						class="theme-color-purple-img img-fluid w-100 h-100 animated-scaleX">
					<img src="../assets/images/dashboard/top-header2.png" alt="header"
						class="theme-color-blue-img img-fluid w-100 h-100 animated-scaleX">
					<img src="../assets/images/dashboard/top-header3.png" alt="header"
						class="theme-color-green-img img-fluid w-100 h-100 animated-scaleX">
					<img src="../assets/images/dashboard/top-header4.png" alt="header"
						class="theme-color-yellow-img img-fluid w-100 h-100 animated-scaleX">
					<img src="../assets/images/dashboard/top-header5.png" alt="header"
						class="theme-color-pink-img img-fluid w-100 h-100 animated-scaleX">
				</div>
			</div>
			<!-- Nav Header Component End -->
	
		<div class="conatiner-fluid content-inner mt-n5 py-0">
			<div class="row">
				<div class="col-md-12 col-lg-12">
					<div class="row row-cols-1">
						<div class="overflow-hidden d-slider1 ">
							<ul class="p-0 m-0 mb-2 swiper-wrapper list-inline">
								<li class="swiper-slide card card-slide" data-aos="fade-up"
									data-aos-delay="700">
									<div class="card-body">
										<div class="progress-widget">
											<div id="circle-progress-01"
												class="text-center circle-progress-01 circle-progress circle-progress-primary"
												data-min-value="0" data-max-value="100" data-value="90"
												data-type="percent">
												<svg class="card-slie-arrow icon-24" width="24"
													viewBox="0 0 24 24">
                                                    <path
														fill="currentColor"
														d="M5,17.59L15.59,7H9V5H19V15H17V8.41L6.41,19L5,17.59Z" />
                                                </svg>
											</div>
											<div class="progress-detail">
												<p class="mb-2">Total Sales</p>
												<h4 class="counter">$560K</h4>
											</div>
										</div>
									</div>
								</li>
								<li class="swiper-slide card card-slide" data-aos="fade-up"
									data-aos-delay="800">
									<div class="card-body">
										<div class="progress-widget">
											<div id="circle-progress-02"
												class="text-center circle-progress-01 circle-progress circle-progress-info"
												data-min-value="0" data-max-value="100" data-value="80"
												data-type="percent">
												<svg class="card-slie-arrow icon-24" width="24"
													viewBox="0 0 24 24">
                                                    <path
														fill="currentColor"
														d="M19,6.41L17.59,5L7,15.59V9H5V19H15V17H8.41L19,6.41Z" />
                                                </svg>
											</div>
											<div class="progress-detail">
												<p class="mb-2">Total Profit</p>
												<h4 class="counter">$185K</h4>
											</div>
										</div>
									</div>
								</li>
								<li class="swiper-slide card card-slide" data-aos="fade-up"
									data-aos-delay="900">
									<div class="card-body">
										<div class="progress-widget">
											<div id="circle-progress-03"
												class="text-center circle-progress-01 circle-progress circle-progress-primary"
												data-min-value="0" data-max-value="100" data-value="70"
												data-type="percent">
												<svg class="card-slie-arrow icon-24" width="24"
													viewBox="0 0 24 24">
                                                    <path
														fill="currentColor"
														d="M19,6.41L17.59,5L7,15.59V9H5V19H15V17H8.41L19,6.41Z" />
                                                </svg>
											</div>
											<div class="progress-detail">
												<p class="mb-2">Total Cost</p>
												<h4 class="counter">$375K</h4>
											</div>
										</div>
									</div>
								</li>
								<li class="swiper-slide card card-slide" data-aos="fade-up"
									data-aos-delay="1000">
									<div class="card-body">
										<div class="progress-widget">
											<div id="circle-progress-04"
												class="text-center circle-progress-01 circle-progress circle-progress-info"
												data-min-value="0" data-max-value="100" data-value="60"
												data-type="percent">
												<svg class="card-slie-arrow icon-24" width="24px"
													viewBox="0 0 24 24">
                                                    <path
														fill="currentColor"
														d="M5,17.59L15.59,7H9V5H19V15H17V8.41L6.41,19L5,17.59Z" />
                                                </svg>
											</div>
											<div class="progress-detail">
												<p class="mb-2">Revenue</p>
												<h4 class="counter">$742K</h4>
											</div>
										</div>
									</div>
								</li>
								<li class="swiper-slide card card-slide" data-aos="fade-up"
									data-aos-delay="1100">
									<div class="card-body">
										<div class="progress-widget">
											<div id="circle-progress-05"
												class="text-center circle-progress-01 circle-progress circle-progress-primary"
												data-min-value="0" data-max-value="100" data-value="50"
												data-type="percent">
												<svg class="card-slie-arrow icon-24" width="24px"
													viewBox="0 0 24 24">
                                                    <path
														fill="currentColor"
														d="M5,17.59L15.59,7H9V5H19V15H17V8.41L6.41,19L5,17.59Z" />
                                                </svg>
											</div>
											<div class="progress-detail">
												<p class="mb-2">Net Income</p>
												<h4 class="counter">$150K</h4>
											</div>
										</div>
									</div>
								</li>
								<li class="swiper-slide card card-slide" data-aos="fade-up"
									data-aos-delay="1200">
									<div class="card-body">
										<div class="progress-widget">
											<div id="circle-progress-06"
												class="text-center circle-progress-01 circle-progress circle-progress-info"
												data-min-value="0" data-max-value="100" data-value="40"
												data-type="percent">
												<svg class="card-slie-arrow icon-24" width="24"
													viewBox="0 0 24 24">
                                                    <path
														fill="currentColor"
														d="M19,6.41L17.59,5L7,15.59V9H5V19H15V17H8.41L19,6.41Z" />
                                                </svg>
											</div>
											<div class="progress-detail">
												<p class="mb-2">Today</p>
												<h4 class="counter">$4600</h4>
											</div>
										</div>
									</div>
								</li>
								<li class="swiper-slide card card-slide" data-aos="fade-up"
									data-aos-delay="1300">
									<div class="card-body">
										<div class="progress-widget">
											<div id="circle-progress-07"
												class="text-center circle-progress-01 circle-progress circle-progress-primary"
												data-min-value="0" data-max-value="100" data-value="30"
												data-type="percent">
												<svg class="card-slie-arrow icon-24 " width="24"
													viewBox="0 0 24 24">
                                                    <path
														fill="currentColor"
														d="M19,6.41L17.59,5L7,15.59V9H5V19H15V17H8.41L19,6.41Z" />
                                                </svg>
											</div>
											<div class="progress-detail">
												<p class="mb-2">Members</p>
												<h4 class="counter">11.2M</h4>
											</div>
										</div>
									</div>
								</li>
							</ul>
							<div class="swiper-button swiper-button-next"></div>
							<div class="swiper-button swiper-button-prev"></div>
						</div>
						Data
					</div>
				</div>
			</div>
		</div>


		<!-- Footer Section Start -->
		
		<jsp:include page="AdminFooter.jsp"></jsp:include>
		
		<!-- Footer Section End -->
	</main>
	
	
	<!-- Wrapper End--><!-- offcanvas start -->
	
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