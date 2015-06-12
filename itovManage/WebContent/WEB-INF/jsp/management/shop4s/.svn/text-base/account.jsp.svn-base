<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/shop4s/adduser?navTabId=shop4s&callbackType=closeCurrent'/>" onsubmit="return validateCallback(this, navTabAjaxDone);">


<div class="pageHeader">
	<div class="searchBar">
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
			<li><a class="add" target="navTab" rel="newsNav" href="<c:url value='/personalmanagement/shop4s/adduserinfo/{slt_objId}/${companyId}?navTabId=shop4s&callbackType=closeCurrent'/>" title="导入用户" onclick="return validateCallback(this, navTabAjaxDone);"><span>导入</span></a></li>
		</ul> 
	</div> 
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">用户名</th>
			    <th width="10%">用户真实名</th>
				<th width="10%">用户电话</th>
				<th width="10%">性别</th>
				<th width="10%">用户类型</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${userList}" varStatus="s">
			<tr target="slt_objId" rel="${item.account_id }">
				<td>${s.index + 1}</td>
				<td>${item.account_name}</td>
				<td>${item.personal_real_name}</td>
				<td>${item.personal_tel}</td>
				<td>
				${ '1' eq item.personal_sex ? '男' : '女'}
				</td>
				<td>
				${ '1' eq item.account_type ? '个人' : ''}
				${ '2' eq item.account_type ? '企业' : ''}
				${ '3' eq item.account_type ? '企业员工' : ''}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>