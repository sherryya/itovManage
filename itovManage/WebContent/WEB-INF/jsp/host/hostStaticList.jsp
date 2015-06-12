<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../management/_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/hostStatic/hostStaticlist'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>用户状态：</label>
				<select name="voipStatus">
				    <option selected="selected" value="">全部状态</option> 
				    <option value="0"  ${ '0' eq param.voipStatus ? 'selected="selected"' : ''}>在线</option> 
					<option value="-1"  ${ '-1' eq param.voipStatus ? 'selected="selected"' : ''}>离线</option> 
					<option value="1"  ${ '1' eq param.voipStatus ? 'selected="selected"' : ''}>占线</option> 
					<option value="2"  ${ '2' eq param.voipStatus ? 'selected="selected"' : ''}>暂停</option> 
				<!-- 	<option value="4"  ${ '4' eq param.account_type ? 'selected="selected"' : ''}>系统坐席</option> -->
			
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
			<li><a class="edit" target="navTab" rel="newsNav" href="<c:url value='/personalmanagement/hostStatic/hostStaticLoglist/{slt_objId}'/>" title="查看详情"><span>查看详情</span></a></li>
			<li><a class="edit" target="navTab" rel="newsNav" href="<c:url value='/personalmanagement/hostStatic/hostStaticInfo/{slt_objId}'/>" title="查看班次"><span>查看班次</span></a></li>
			<li class="line">line</li>
		</ul>
	</div> 
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">主播账号ID</th>
				<th width="10%">用户名</th>
			    <th width="10%">主播姓名</th>
				<th width="10%">voip账号</th>
				<th width="10%">在线时长</th>
				<th width="10%">状态</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${hostStaticList}" varStatus="s">
			<tr target="slt_objId" rel="${item.voipaccount }">
				<td>${s.index + 1}</td>
				<td>${item.accountId}</td>
				<td>${item.account_name}</td>
				<td>${item.hostName}</td>
				<td>${item.voipaccount }</td>
				<td>
				${item.onlinetime}
				</td>
				<td>
				${ '-1' eq item.voip_status ? '离线' : ''}
				${ '0' eq item.voip_status ? '在线' : ''}
				${ '1' eq item.voip_status ? '占线' : ''}
				${ '2' eq item.voip_status ? '暂停' : ''}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../management/_frag/pager/panelBar.jsp"></c:import>
</div>