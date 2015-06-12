<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageHeader">
	<H2>角色管理</H2>
		<div class="searchBar">
		<div class="subBar">
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
			<li><a class="add" rel="pageNav" target="navTab" href="<c:url value='/personalmanagement/role/add'/>" title="角色管理"><span>添加</span></a></li>
		</ul>
	</div>
	<table class="list" width="100%" layoutH="58">
		<thead>
			<tr>
				<th width="5%">&nbsp;序号</th>
				<th width="10%">&nbsp;角色名称</th>
				<th width="10%">&nbsp;角色描述</th>
				<th width="4%">&nbsp;排序</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${roleList}" varStatus="s">
			<tr target="slt_pageId" rel="${item.roleId}">
				<td>&nbsp;&nbsp;${s.index + 1}</td>
				<td>&nbsp;&nbsp;${item.roleName}</td>
				<td>&nbsp;&nbsp;${item.roleDescription}</td>
				<td>&nbsp;&nbsp;${item.roleTaxis}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>

