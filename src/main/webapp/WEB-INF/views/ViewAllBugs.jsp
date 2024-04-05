<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html lang="en" dir="ltr">

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>BT|View Bug</title>

<!-- Bug Table -->
<style type="text/css">
@media print {
	#print-link {
		display: none;
	}
}

/* Table */
#bug-table {
  width: 100%;
  border-collapse: collapse;
  border-spacing: 0;
  font-family: Arial, sans-serif;
}

/* Table Header */
#bug-table thead th {
  padding: 8px;
  text-align: left;
  background-color: #f1f1f1;
  border: 1px solid #ddd;
}

/* Table Body */
#bug-table tbody td {
  padding: 8px;
  text-align: left;
  border: 1px solid #ddd;
}

/* First column width */
#bug-table tbody td:first-child {
  width: 50px;
}

/* Last column width */
#bug-table tbody td:last-child {
  width: 200px;
}

/* Highlighted row color */
#bug-table tbody tr.highlighted {
  background-color: #f2dede;
}

</style>
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

	<c:if test="${role.roleId == 1 }">
		<jsp:include page="AdminSlidebar.jsp"></jsp:include>
	</c:if>

	<c:if test="${role.roleId == 2 }">
		<jsp:include page="PmSlidebar.jsp"></jsp:include>
	</c:if>

	<c:if test="${role.roleId == 3 }">
		<jsp:include page="DeveloperSlidebar.jsp"></jsp:include>
	</c:if>

	<c:if test="${role.roleId == 4 }">
		<jsp:include page="TesterSlidebar.jsp"></jsp:include>
	</c:if>

	<!-- Slider end -->

	<main class="main-content">


		<!-- header start -->

		<c:if test="${role.roleId == 1 }">
			<jsp:include page="AdminHeader.jsp"></jsp:include>
		</c:if>

		<c:if test="${role.roleId == 2 }">
			<jsp:include page="PmHeader.jsp"></jsp:include>
		</c:if>

		<c:if test="${role.roleId == 3 }">
			<jsp:include page="DeveloperHeader.jsp"></jsp:include>
		</c:if>

		<c:if test="${role.roleId == 4 }">
			<jsp:include page="TesterHeader.jsp"></jsp:include>
		</c:if>

		<!-- header end -->
		<div class="mt-5">

			<div class="conatiner-fluid content-inner mt-n5 py-0">

				<div class="row mt-3 p-3">
					<div class="col-sm-12">
						<div class="mt-4">
							<div class="card card-body d-flex justify-content-between">
								<div class="header-title d-flex align-items-center">
									<h3 class="card-title" style="margin-right: 10px;">Bug
										Details</h3>
									<c:if test="${role.roleId == 1 }">
										<a class="card-title" href="listproject"
											style="margin-left: auto;">Back</a>
									</c:if>
									
									<c:if test="${role.roleId == 2 }">
										<a class="card-title" href="listprojectofpm"
											style="margin-left: auto;">Back</a>
									</c:if>

								</div>
							</div>


						</div>
						<div id="bug" class="row mt-3">
							<div class="col-sm-12">
								<div class="card mt-4">
									<div class="card-header d-flex justify-content-between">
										<div class="header-title">
											<h4 class="card-title">Bugs</h4>
										</div>
										<div class="header-title">
											<a href="#" id="print-link">Print</a>
										</div>
									</div>
									<div class="card-body">
										<div id="button-div-id"></div>
										<div class="table-responsive">
											<div id="datatable_wrapper"
												class="dataTables_wrapper dt-bootstrap5">
												<div class="table-responsive border-bottom my-3">
													<table id="bug-table" class="table "
														data-toggle="data-table">
														<thead>
															<tr class="odd">
																<th class="text-center">Sr No.</th>
																<th class="text-center">Category</th>
																<th class="text-center">Label</th>
																<th class="text-center">Value</th>
															</tr>


														</thead>
														<tbody>
															<c:forEach items="${bugs}" var="b" varStatus="sr">
																<c:if test="${b.status == 6 }">
																	<tr class="even">
																		<td class="text-center " rowspan="15">${sr.index+1}</td>
																	</tr>
																	<tr>
																		<td class="text-center" rowspan="7">Bug ID</td>
																	</tr>
																	<tr>
																		<td>BugId No.</td>
																		<td>#${b.bugId}</td>
																	</tr>

																	<tr>
																		<td>Bug Name</td>
																		<td>${b.bugName }</td>
																	</tr>

																	<tr>
																		<td>Reporter</td>
																		<td>${b.firstName}</td>
																	</tr>

																	<tr>
																		<td>Assigned Developer</td>
																		<td>${dev[b.bugId]}</td>
																	</tr>

																	<tr>
																		<td>Reporting Date</td>
																		<td>${b.date }</td>
																	</tr>
																	<tr>
																		<td>Approve Date</td>
																		<td><c:if test="${b.approveDate != null }">${b.approveDate }</c:if>
																			<c:if test="${b.approveDate == null }">Not Approved</c:if></td>
																	</tr>

																	<tr>
																		<td class="text-center" rowspan="3">Bug Overview</td>
																	</tr>

																	<tr>
																		<td>Description</td>
																		<td>${b.description }</td>
																	</tr>

																	<tr>
																		<td>Comment</td>
																		<td>${b.comment }</td>
																	</tr>

																	<tr>
																		<td class="text-center" rowspan="4">Project
																			Detail</td>
																	</tr>

																	<tr>
																		<td>Project</td>
																		<td>${b.projectTitle}</td>
																	</tr>

																	<tr>
																		<td>Module</td>
																		<td>${b.moduleName }</td>
																	</tr>

																	<tr>
																		<td>Task</td>
																		<td>${b.title }</td>
																	</tr>
																	<tr>
																		<td colspan="4"></td>
																	</tr>
															</c:if>
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
							<div class="col-sm-12">
								<div class="card mt-4">
									<div class="card-header d-flex justify-content-between">
										<div class="header-title">
											<h4 class="card-title">Approve Bugs</h4>
										</div>
										<div class="header-title">
											<a href="#" id="print-link">Print</a>
										</div>
									</div>
									<div class="card-body">
										<div id="button-div-id"></div>
										<div class="table-responsive">
											<div id="datatable_wrapper"
												class="dataTables_wrapper dt-bootstrap5">
												<div class="table-responsive border-bottom my-3">
													<table id="bug-table" class="table"
														data-toggle="data-table">
														<thead>
															<tr class="odd">
																<th class="text-center">Sr No.</th>
																<th class="text-center">Category</th>
																<th class="text-center">Label</th>
																<th class="text-center">Value</th>
															</tr>


														</thead>
														<tbody>
															<c:forEach items="${bugs}" var="b" varStatus="sr">
																<c:if test="${b.status == 5 }">
																	<tr class="even">
																		<td class="text-center " rowspan="15">${sr.index+1}</td>
																	</tr>
																	<tr>
																		<td class="text-center" rowspan="7">Bug ID</td>
																	</tr>
																	<tr>
																		<td>BugId No.</td>
																		<td>#${b.bugId}</td>
																	</tr>

																	<tr>
																		<td>Bug Name</td>
																		<td>${b.bugName }</td>
																	</tr>

																	<tr>
																		<td>Reporter</td>
																		<td>${b.firstName}</td>
																	</tr>

																	<tr>
																		<td>Assigned Developer</td>
																		<td>${dev[b.bugId]}</td>
																	</tr>

																	<tr>
																		<td>Reporting Date</td>
																		<td>${b.date }</td>
																	</tr>
																	
																	<tr>
																		<td>Approve Date</td>
																		<td><c:if test="${b.approveDate != null }">${b.approveDate }</c:if>
																			<c:if test="${b.approveDate == null }">Not Approved</c:if></td>
																	</tr>

																	<tr>
																		<td class="text-center" rowspan="3">Bug Overview</td>
																	</tr>

																	<tr>
																		<td>Description</td>
																		<td>${b.description }</td>
																	</tr>

																	<tr>
																		<td>Comment</td>
																		<td>${b.comment }</td>
																	</tr>

																	<tr>
																		<td class="text-center" rowspan="4">Project
																			Detail</td>
																	</tr>

																	<tr>
																		<td>Project</td>
																		<td>${b.projectTitle}</td>
																	</tr>

																	<tr>
																		<td>Module</td>
																		<td>${b.moduleName }</td>
																	</tr>

																	<tr>
																		<td>Task</td>
																		<td>${b.title }</td>
																	</tr>
																	<tr>
																		<td colspan="4"></td>
																	</tr>
																</c:if>
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

	<!-- For Bugtable -->
	<script type="text/javascript">
		function printBugDetails() {
			var printContents = document.getElementById('bug').innerHTML;
			var originalContents = document.body.innerHTML;

			document.body.innerHTML = printContents;

			window.print();

			document.body.innerHTML = originalContents;

			// Rebind the click event after printing
			document.getElementById('print-link').addEventListener('click',
					printBugDetails);
		}

		document.getElementById('print-link').addEventListener('click',
				printBugDetails);
	</script>

	<!-- App Script -->
	<script src="../assets/js/hope-ui.js" defer></script>


</body>

</html>
