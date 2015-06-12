<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/user4s/user4slist'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
	<ul class="searchContent">
		 <li>
			<label>用户名：</label>
			<input type="text" name="accountName" value="${param.accountName}"/>
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
			<li><a class="add" target="navTab" href="<c:url value='/personalmanagement/user4s/addUser4s'/>" title="添加4s用户"><span>添加4s用户</span></a></li>
			<li><a class="edit" target="navTab" rel="user4s" href="<c:url value='/personalmanagement/user4s/editUser4s/{slt_objId}'/>" title="4s用户修改"><span>4s用户修改</span></a></li>
<%-- 			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/test/delete/{slt_testId}'/>" title="您确定要删除吗?"><span>删除</span></a></li> --%>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">账名名称</th>
				<th width="10%">昵称</th>
				<th width="10%">4s店信息</th>
				<th width="10%">真实姓名</th>
				<th width="10%">性别</th>
				<th width="10%">电话</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${user4slist}" varStatus="s">
			<tr target="slt_objId" rel="${item.account_id}"  height="25px">
				<td>${s.index + 1}</td>
				<td>${item.account_name}</td>
				<td>${item.nickname}</td>
				<td>${item.company_name}</td>
				<td>${item.real_name}</td>
				<td>
				${ '1' eq item.person_sex ? '男' : ''}
				${ '0' eq item.person_sex ? '女' : ''}
				</td>
				<td>${item.person_tel}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>