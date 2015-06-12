<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/empAgent/getLog'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
		 	<li>
			<label>坐席id：</label>
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
			<li><a class="add" target="navTab" rel="newsNav" href="<c:url value='/management/test/add'/>" title="添加测试信息"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="newsNav" href="<c:url value='/management/test/edit/{slt_testId}'/>" title="修改测试信息"><span>修改</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/test/delete/{slt_testId}'/>" title="您确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div> 
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">用户ID</th>
				<th width="10%">坐席id</th>
				<th width="10%">url</th>
				<th width="10%">callTime</th>
				<th width="10%">callfrom</th>
				<th width="10%">callTo</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${logList}" varStatus="s">
			<tr target="slt_objId" rel="${item.agentid }">
				<td>${s.index + 1}</td>
				<td>${item.id}</td>
				<td>${item.agentid}</td>
				<td>${item.recordurl}</td>
				<td>${item.calldatetime}</td>
				<td>	
				   ${item.callfrom}		
				</td>
				<td>
				   ${item.callto}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>