<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../management/_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/hostStatic/hostStaticlist'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>用户状态：</label>
				<select name="voipStatus">
				</select>
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
			<li><a class="edit" target="navTab" rel="newsNav" href="<c:url value='/personalmanagement/hostStatic/hostStaticLogById/{slt_objId}'/>" title="查看详情"><span>查看详情</span></a></li>
			<li class="line">line</li>
		</ul>
	</div> 
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">主播账号ID</th>
				<th width="10%">上班时间</th>
			    <th width="10%">下班时间</th>
			     <th width="10%">查看详情</th>
			</tr>
	</thead>
	<tbody>
		<c:forEach var="item" items="${hostStaticInfoList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id}">
				<td>${s.index + 1}</td>
				<td>${item.voipaccount }</td>
				<td>${item.linetime}</td>
				<td>${item.oftime}</td>
				<td><a class="edit" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/host/editHost/{slt_objId}'/>" title="查看/修改"><span>查看在线时长</span></a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../management/_frag/pager/panelBar.jsp"></c:import>
</div>