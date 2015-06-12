<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<c:url value='/management/test'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>Keywords：</label>
				<input type="text" name="sex" value="${param.sex}"/>
			</li>
			<li>
			
			</li>
			
		</ul>
		<div class="subBar">
			<span style="margin-left: 5px; line-height: 25px; float: left">Matching Records Found: <strong>${vo.totalCount}</strong></span>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">Search</button></div></div></li>
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
				<th width="50px"></th>
				<th>姓名</th>
				<th width="140px">昵称</th>
				<th width="140px">年龄</th>
				<th width="100px">性别</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${testList}" varStatus="s">
			<tr target="slt_testId" rel="${item.id }">
			<td>${s.index + 1}</td>
			<td>${item.name}</td>
			<td>${item.nick_name}</td>
			<td>${item.age}</td>
			<td>${item.sex}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>