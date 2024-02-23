<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty user}">
	<c:redirect url="login"/>
</c:if>

<!-- loader Start -->

<div id="loading">
	<div class="loader simple-loader">
		<div class="loader-body"></div>
	</div>
</div>
<!-- loader END -->