<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm"
	action="<c:url value='pushmanagement/traffic/list'/>"
	onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<!-- 			<ul class="searchContent">
			</ul> -->
			<div class="subBar">
				<span style="margin-left: 5px; line-height: 25px; float: left">总记录数:
					<strong>${vo.totalCount}</strong>
				</span>
			</div>
		</div>
	</div>
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">

			<li><a class="add" target="dialog" rel="personalNavAdd"
				mask="true" maxable="true" minable="true" resizable="true"
				drawable="true" fresh="true"
				href="<c:url value='/personalmanagement/personal/add'/>"
				title="坐席添加"><span>新增路况信息</span></a></li>

			<li><a class="edit" target="dialog" rel="personalNavModify"
				href="<c:url value='/personalmanagement/personal/edit/{slt_objId}'/>"
				title="坐席修改"><span>修改路况信息</span></a></li>
			<li class="line">line</li>
		</ul>

	</div>

	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">地区</th>
				<th width="10%">类型</th>
				<th width="10%">描述</th>
				<th width="10%">VOIP账号</th>
				<th width="10%">用户电话</th>
				<th width="5%">性别</th>
				<!-- 	<th width="10%">用户类型</th> -->
				<th width="10%">当前状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${userList}" varStatus="s">
				<tr target="slt_objId" rel="${item.account_id }">
					<td>${s.index + 1}</td>
					<td>${item.account_id}</td>
					<td>${item.account_name}</td>
					<td>${item.personal_real_name}</td>
					<td>${item.voipAccount}</td>
					<td>${item.personal_tel}</td>
					<td>${ '1' eq item.personal_sex ? '男' : '女'}</td>
					<td>${ '0' eq item.agentstate ? '准备中' : ''}${ '1' eq item.agentstate ? '准备就绪' : ''}
						${ '2' eq item.agentstate ? '用户锁定' : ''} ${ '3' eq item.agentstate ? '咨询通话中' : ''}
						${ '4' eq item.agentstate ? '座席线路忙' : ''} ${ '-1' eq item.agentstate ? '离线' : ''}
						${ '-2' eq item.agentstate ? '新账号' : ''}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>