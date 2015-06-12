<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/personal/list'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			
		 	<li>
			<label>用户名：</label>
			<input type="text" name="keywords" value="${param.keywords}"/>
			</li> 
		</ul>
		<div class="subBar">
			<span style="margin-left: 5px; line-height: 25px; float: left">总记录数: <strong>${vo.totalCount}</strong></span>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查                  询</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab" rel="printNav" href="<c:url value='/personalmanagement/personal/printSkip/{slt_objId}'/>" title="打印跳转><span>打印跳转</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">用户ID</th>
				<th width="10%">车机imei</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${terminalList}" varStatus="s">
			<tr target="slt_objId" rel="${item.terminal_imei }">
				<td>${s.index + 1}</td>
				<td>${item.user_id}</td>
				<td>${item.terminal_imei}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>