<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/empAgent/empAgentlist'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
		 	
		</ul>
		<div class="subBar">
			
		</div>
	</div>
</div>
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/personal/add'/>" title="坐席添加"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/personal/edit/{slt_objId}'/>" title="坐席修改"><span>修改</span></a></li>
<%-- 			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/test/delete/{slt_testId}'/>" title="您确定要删除吗?"><span>删除</span></a></li> --%>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">坐席ID</th>
				<th width="10%">账号ID</th>
			    <th width="10%">子账号ID</th>
			    <th width="10%">VOIP账号</th>
				<th width="10%">子账号令牌</th>
				<th width="15%">创建时间</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${empList}" varStatus="s">
			<tr target="slt_objId" rel="${item.accountId }">
				<td>${s.index + 1}</td>
				<td>${item.agentId}</td>
				<td>${item.accountId}</td>
				<td>${item.subaccountsid}</td>
			    <td>${item.voipaccount}</td>
				<td>${item.subtoken}</td>
				<td>
				   ${item.datecreated}
				</td>
			    
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>