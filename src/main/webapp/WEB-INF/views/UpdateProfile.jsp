<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BT|Update Profile</title>

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
	<c:if test="${role.roleId == 1 }">
		<jsp:include page="AdminSlidebar.jsp"></jsp:include>
	</c:if>

	<c:if test="${role.roleId == 3 }">
		<jsp:include page="DeveloperSlidebar.jsp"></jsp:include>
	</c:if>

	<!-- Slider end -->

	<main class="main-content">
		<!-- header start -->
		<c:if test="${role.roleId == 1 }">
			<jsp:include page="AdminHeader.jsp"></jsp:include>
		</c:if>
		
		<c:if test="${role.roleId == 3 }">
			<jsp:include page="DeveloperHeader.jsp"></jsp:include>
		</c:if>

		<!-- header end -->
		<div class="mt-5">

			<div class="conatiner-fluid content-inner mt-n5 py-0">
				<div class="row mt-3 p-3">
					<div class="col-sm-12">
						<div class="card mt-4">
							<div class="card-header d-flex justify-content-between">
								<div class="header-title">
									<h4 class="card-title">Update Information</h4>
								</div>
							</div>
							<div class="card-body">


								<form action="saveupdateduserprofile" method="post">

									<div class="row">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="full-name" class="form-label">First Name</label>
												<input type="text" class="form-control" id="full-name"
													name="firstName" value="${user.firstName }">
											</div>
										</div>

										<div class="col-lg-6">
											<div class="form-group">
												<label for="last-name" class="form-label">Last Name</label>
												<input type="text" class="form-control" id="last-name"
													name="lastName" value="${user.lastName }">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="col-lg-6">
											<div class="form-group ">
												<label for="last-name" class="form-label">Gender</label>
												<div class="form-control">
													<input type="radio" class="form-check-input " name="gender"
														value="Male"
														${user.gender.equalsIgnoreCase("Male") ? "checked" : ""} />&nbsp;Male
													&nbsp; <input type="radio" class="form-check-input"
														name="gender" value="Female"
														${user.gender.equalsIgnoreCase("Female") ? "checked" : ""} />&nbsp;Female
												</div>
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group ">
												<label for="email" class="form-label">Email</label> <input
													type="email" class="form-control" id="email" name="email"
													value="${user.email } ">
											</div>
										</div>
									</div>

									<div class="row">

										<div class="col-lg-6">
											<div class="form-group">
												<label for="phone" class="form-label">Phone No.</label> <input
													type="tel" class="form-control" id="phone" name="contact"
													value="${user.contact } ">
											</div>
										</div>
										<div class="col-lg-6">
											<div class="form-group">
												<label for="date-of-birth" class="form-label">Date
													of Birth</label> <input type="date" class="form-control"
													id="date-of-birth" name="dob" value="${user.dob}">
											</div>
										</div>
									</div>

									<%-- <div class="row">
										<div class="col-lg-6">
											<div class="form-group">
												<label for="password" class="form-label">Password </label> <input
													type="password" class="form-control" id="password"
													name="pass" placeholder=" ">
											</div>
										</div>

										<div class="col-lg-6">
											<div class="form-group">
												<label for="password" class="form-label"> Confirm
													Password </label> <input type="password" class="form-control"
													id="confirmpassword" name="confirmPassword" placeholder=""><span
													style="color: red">${confirmpassword}</span>
											</div>
										</div>



									</div>
 --%>
									<div class="row">

										<div class="col-lg-6">
											<div class="form-group">
												<label for="address" class="form-label">Address</label> <input
													type="text" class="form-control" id="address"
													name="address" value="${user.address } ">
											</div>
										</div>

										<div class="col-lg-6">
											<div class="form-group">
												<label for="city" class="form-label">City </label> <input
													type="text" class="form-control" id="city" name="city"
													value="${user.city } ">
											</div>
										</div>


									</div>

									<div class="row">


										<div class="col-lg-6">
											<div class="form-group">
												<label for="state" class="form-label">State</label> <input
													type="text" class="form-control" id="state" name="state"
													value="${user.state } ">
											</div>
										</div>

										<div class="col-lg-6">
											<div class="form-group">
												<label for="state" class="form-label">Select Role</label> <select
													class="form-select" name="roleId">
													<option value="-1">----Select Role----</option>
													<c:forEach items="${roleList}" var="role">
														<option value="${role.roleId}"
															${role.roleId == user.roleId ? "selected" : ""}>${role.roleName}</option>
													</c:forEach>
												</select>
											</div>
										</div>
										<input type="hidden" name="userId" value="${user.userId }">
										<input type="hidden" name="pass" value="${user.pass}">

									</div>
									<div class="d-flex justify-content-center">
										<button type="submit" formmethod="post"
											class="btn btn-primary">Update User</button>
										&nbsp; <a href=""><button type="button"
												class="btn btn-primary">Clear</button></a>
										<!-- <a href=""><button type="button" class="btn btn-primary">Cancle</button></a> -->
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