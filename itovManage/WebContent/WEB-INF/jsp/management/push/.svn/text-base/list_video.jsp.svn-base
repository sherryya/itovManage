<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm"
	action="<c:url value='/pushmanagement/video/list'/>"
	onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<div class="subBar">
				<span
					style="margin-left: 5px; line-height: 45px; float: left;margin-top: 5px;margin-bottom: 5px">总记录数:
					<strong>${vo.totalCount}</strong> </span>
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
				href="<c:url value='/pushmanagement/video/add'/>" title="新增视频"><span>新增视频</span>
			</a></li>
			<li><a class="edit" target="dialog" rel="personalNavModify"
				href="<c:url value='/pushmanagement/video/edit/{slt_objId}'/>"
				title="修改视频信息"><span>修改视频信息</span> </a></li>
			<li class="line">line</li>
		</ul>
	</div>

	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="6%">序号</th>
				<th width="6%">热门-推荐</th>
				<th width="6%">大分类-小分类</th>
				<th width="10%">标题</th>
				<th width="10%">视频URL(http://)</th>
				<th width="9%">时长(时:分:秒)</th>
				<th width="5%">点击量(次)</th>
				<th width="10%">截图URL</th>
				<th width="8%">添加时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${userList}" varStatus="s">
				<tr target="slt_objId" rel="${item.id }">
					<td>${s.index + 1}</td>
					<td>${item.type_category_t}</td>
					<td>${item.type_classify_l}</td>
					<td>${item.title}</td>
					<td>${item.url_file}</td>
					<td>${item.duration}</td>
					<td>${item.point}</td>
					<td>${item.url_image}</td>
					<td>${item.time_add}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>