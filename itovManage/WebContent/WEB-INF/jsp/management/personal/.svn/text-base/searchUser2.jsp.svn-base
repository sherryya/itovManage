<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/user4s/lookup'/>" onsubmit="return dwzSearch(this, 'dialog');">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>4s店名称:</label>
				<input class="textInput" name="accountName" value="${param.accountName}" type="text">
			</li>	 
		</ul>
		<div class="subBar">
			<span style="margin-left: 5px; line-height: 25px; float: left"></span>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查                  询</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>
<div class="pageContent">
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="">序号</th>
				<th width="">名称</th>
				<th width="">请选择</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${shop4sList}" varStatus="status">
			<tr target="slt_objId" rel="${item.shop4s_id }">
				<td>${status.index + 1}</td>
				<td>${item.shop4s_name}</td>
				<td>  
                      <a class="btnSelect" href="javascript:$.bringBack({company_id:'${item.shop4s_id}', company_name:'${item.shop4s_name}'})" title="查找带回">选择</a>  
                </td>  
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>