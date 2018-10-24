<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<liferay-theme:defineObjects />
<portlet:defineObjects />

<portlet:resourceURL var="listURL"/>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@page import="java.util.List"%>
<script>
    define._amd = define.amd;
    define.amd = false;
</script>
<script src="<%=request.getContextPath()%>/js/jquery.plugin.js"></script>
<script src="<%=request.getContextPath()%>/js/jquery.datepick.js"></script>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/redmond.datepick.css">
<script src="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.js"></script>
<script src="<%=request.getContextPath()%>/js/dataTables.min.js"></script>
<script src="<%=request.getContextPath()%>/js/chosen.jquery.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/js/jquery-ui-1.12.1/jquery-ui.min.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/bootstrap-chosen.css" type="text/css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/dataTables.min.css?454" type="text/css">

<script>
    define._amd = define.amd;
</script>