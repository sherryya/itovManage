<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/querymanagement/reserve/reservelist'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">			
			<li>
			<label>预约码：</label>
			<input type="text" name="reserve_code" value="${param.reserve_code}"/>
			</li> 
			
			<li>
			<label>预约电话：</label>
			<input type="text" name="phone_num" value="${param.phone_num}"/>
			</li> 
			
		 	<li>
			<label>预约姓名：</label>
			<input type="text" name="name" value="${param.name}"/>
			</li> 
			
			<li>
				<label>是否邮寄：</label>
				<select name="is_deal">
					<option value="%"  ${ '%' eq param.is_deal ? 'selected="selected"' : ''}>全部</option>
					<option value="1"  ${ '1' eq param.is_deal ? 'selected="selected"' : ''}>已邮寄</option>
					<option value="0"  ${ '2' eq param.is_deal ? 'selected="selected"' : ''}>未邮寄</option>
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
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="8%">预约姓名</th>
				<th width="8%">预约码</th>
				<th width="8%">预约电话</th>
				<th width="8%">预约地址</th>
				<th width="8%">预约时间</th>
				<th width="8%">品牌</th>
				<th width="8%">型号</th>
				<th width="8%">款式</th>
		</thead>
	<tbody>
		<c:forEach var="item" items="${reserveList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.realname}</td>
				<td>${item.reserveCode}</td>
				<td>${item.phoneNo}</td>
				<td>${item.address}</td>
				<td><fmt:formatDate value="${item.crtDate}"  type="date" dateStyle="full"/></td>
				<td>${item.brand}</td>
				<td>${item.model}</td>
				<td>${item.style}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>