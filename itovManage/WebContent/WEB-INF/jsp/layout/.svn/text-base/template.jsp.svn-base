<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><decorator:title />
	<fmt:message key="ui.title" />
</title>
<c:set var="website" value="${info:contextWebsite()}"></c:set>

<meta name="keywords"
	content='<c:out value="${website.metaKeywords}"></c:out>' />
<meta name="description"
	content='<c:out value="${website.metaDescription}"></c:out>' />
<meta name="author" content="z@j-ui" />
<meta name="ROBOTS" content="INDEX, FOLLOW" />

<link
	href="<c:url value='/styles/website/${website.template}/layout/${website.layout}.css'/>"
	rel="stylesheet" type="text/css" />
<link
	href="<c:url value='/styles/website/${website.template}/themes/${website.theme}/color.css'/>"
	rel="stylesheet" type="text/css" />

<!--[if IE]>
<script src="<c:out value='/styles/website/common/js/html5.js'/>"></script>
<![endif]-->
<script src="<c:url value='/styles/dwz/js/jquery-1.7.2.js'/>"
	type="text/javascript"></script>
<script src="<c:url value='/styles/website/common/js/ui.js'/>"
	type="text/javascript"></script>
<decorator:head />
</head>
<body>
	<c:import
		url="/WEB-INF/jsp/layout/${website.template}/header.jsp?template=${website.template}&layout=${website.layout}&theme=${website.theme}"
		charEncoding="UTF-8" />

	<article id="container">

		<decorator:body />
		<div class="clearBoth">&nbsp;</div>
	</article>

	<c:import
		url="/WEB-INF/jsp/layout/${website.template}/footer.jsp?template=${website.template}&layout=${website.layout}&theme=${website.theme}"
		charEncoding="UTF-8" />


</body>

</html>
