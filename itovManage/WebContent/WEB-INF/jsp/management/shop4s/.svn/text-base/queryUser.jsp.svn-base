<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/shop4s/querylist/${companyId}'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
			<label>姓名：</label>
				<input type="text" name="accountName"   size="20" value="${accountName}"/>
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
			<li class="line">line</li>
		</ul>
	</div> 
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">用户姓名</th>
				<th width="10%">用户类型</th>
			    <th width="10%">用户昵称</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${shop4sUserList}" varStatus="s">
			<tr target="slt_objId" rel="${item.account_id}">
				<td>${s.index + 1}</td>
				<td>${item.account_name}</td>
				<td>
				${ '1' eq item.account_type ? '个人' : ''}
				${ '2' eq item.account_type ? '企业' : ''}
				${ '3' eq item.account_type ? '企业员工' : ''}
				</td>
				<td>${item.nickname}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>