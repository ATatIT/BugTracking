<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>




<!doctype html>
<html lang="en" dir="ltr">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BT|Forgot Password</title>

<!-- Favicon -->
<link rel="shortcut icon" href="../../assets/images/favicon.ico">

<!-- Library / Plugin Css Build -->
<link rel="stylesheet" href="../../assets/css/core/libs.min.css">


<!-- Hope Ui Design System Css -->
<link rel="stylesheet" href="../../assets/css/hope-ui.min.css?v=4.0.0">

<!-- Custom Css -->
<link rel="stylesheet" href="../../assets/css/custom.min.css?v=4.0.0">

<!-- Dark Css -->
<link rel="stylesheet" href="../../assets/css/dark.min.css">

<!-- Customizer Css -->
<link rel="stylesheet" href="../../assets/css/customizer.min.css">

<!-- RTL Css -->
<link rel="stylesheet" href="../../assets/css/rtl.min.css">


</head>
<body class=" " data-bs-spy="scroll" data-bs-target="#elements-section"
	data-bs-offset="0" tabindex="0">
	<!-- loader Start -->
	<div id="loading">
		<div class="loader simple-loader">
			<div class="loader-body"></div>
		</div>
	</div>
	<!-- loader END -->

	<div class="wrapper">
		<section class="login-content">
			<div class="row m-0 align-items-center bg-white vh-100">
				<div class="">
					<div class="row justify-content-center">
						<div class="col-md-6">
							<div
								class="card card-transparent shadow-none d-flex justify-content-center mb-0 auth-card">
								<div class="card-body">
									<a href="../../dashboard/index.html"
										class="navbar-brand d-flex align-items-center mb-3"> <!--Logo start-->
										<div class="logo-main">
											<div class="logo-normal">
												<svg class="text-primary icon-30" viewBox="0 0 30 30"
													fill="none" xmlns="http://www.w3.org/2000/svg">
                                          <rect x="-0.757324"
														y="19.2427" width="28" height="4" rx="2"
														transform="rotate(-45 -0.757324 19.2427)"
														fill="currentColor" />
                                          <rect x="7.72803" y="27.728"
														width="28" height="4" rx="2"
														transform="rotate(-45 7.72803 27.728)" fill="currentColor" />
                                          <rect x="10.5366" y="16.3945"
														width="16" height="4" rx="2"
														transform="rotate(45 10.5366 16.3945)" fill="currentColor" />
                                          <rect x="10.5562"
														y="-0.556152" width="28" height="4" rx="2"
														transform="rotate(45 10.5562 -0.556152)"
														fill="currentColor" />
                                      </svg>
											</div>
											<div class="logo-mini">
												<svg class="text-primary icon-30" viewBox="0 0 30 30"
													fill="none" xmlns="http://www.w3.org/2000/svg">
                                          <rect x="-0.757324"
														y="19.2427" width="28" height="4" rx="2"
														transform="rotate(-45 -0.757324 19.2427)"
														fill="currentColor" />
                                          <rect x="7.72803" y="27.728"
														width="28" height="4" rx="2"
														transform="rotate(-45 7.72803 27.728)" fill="currentColor" />
                                          <rect x="10.5366" y="16.3945"
														width="16" height="4" rx="2"
														transform="rotate(45 10.5366 16.3945)" fill="currentColor" />
                                          <rect x="10.5562"
														y="-0.556152" width="28" height="4" rx="2"
														transform="rotate(45 10.5562 -0.556152)"
														fill="currentColor" />
                                      </svg>
											</div>
										</div> <!--logo End-->




										<h4 class="logo-title ms-3">Bug Tracking</h4>
									</a>
									<h2 class="mb-2 text-center">Confirm Mail</h2>
									<form action="otpforpassword" method="post">
										<div class="row">
											<div class="col-lg-12">
												<div class="form-group">

													<label for="email" class="form-label">Email</label> <input
														type="email" class="form-control" id="email" name="email"
														aria-describedby="email" placeholder=" "> <span
														style="color: red;"> ${erroremail}</span>
												</div>
											</div>





										</div>
										<div class="d-flex justify-content-center">
											<button type="submit" class="btn btn-primary">Continue</button>
										&nbsp;<a href="login" class="btn btn-primary">Back</a>
										</div>



									</form>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</section>
	</div>

	<!-- Library Bundle Script -->
	<script src="../../assets/js/core/libs.min.js"></script>

	<!-- External Library Bundle Script -->
	<script src="../../assets/js/core/external.min.js"></script>

	<!-- Widgetchart Script -->
	<script src="../../assets/js/charts/widgetcharts.js"></script>

	<!-- mapchart Script -->
	<script src="../../assets/js/charts/vectore-chart.js"></script>
	<script src="../../assets/js/charts/dashboard.js"></script>

	<!-- fslightbox Script -->
	<script src="../../assets/js/plugins/fslightbox.js"></script>

	<!-- Settings Script -->
	<script src="../../assets/js/plugins/setting.js"></script>

	<!-- Slider-tab Script -->
	<script src="../../assets/js/plugins/slider-tabs.js"></script>

	<!-- Form Wizard Script -->
	<script src="../../assets/js/plugins/form-wizard.js"></script>

	<!-- AOS Animation Plugin-->

	<!-- App Script -->
	<script src="../../assets/js/hope-ui.js" defer></script>


</body>
</html>