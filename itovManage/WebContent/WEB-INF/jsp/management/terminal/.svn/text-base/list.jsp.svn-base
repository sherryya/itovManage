<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/terminalmanagement/terminal/list'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>设备类型：</label>
				<select name="terminal_device_type">
					<option value=""  ${ '' eq terminal_device_type ? 'selected="selected"' : ''}>全部</option>
					<option value="1"  ${ '1' eq param.terminal_device_type ? 'selected="selected"' : ''}>类型1</option>
					<option value="2"  ${ '2' eq param.terminal_device_type ? 'selected="selected"' : ''}>类型2</option>
				</select>
			</li>
			<li>
				<label>绑定状态：</label>
				<select name="terminal_status">
					<option value=""  ${ '' eq param.terminal_status? 'selected="selected"' : ''}>全部</option>
					<option value="1"  ${ '1' eq param.terminal_status? 'selected="selected"' : ''}>已绑定</option>
					<option value="0"  ${ '0' eq param.terminal_status? 'selected="selected"' : ''}>未绑定</option>
				</select>
			</li>
		 	<li>
			<label>设备名称：</label>
			<input type="text" name="terminal_name" value="${param.terminal_name}"/>
			</li> 
			<li>
			<label>imei号：</label>
			<input type="text" name="terminal_imei" value="${param.terminal_imei}"/>
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
			<li><a class="add" target="navTab" href="<c:url value='/terminalmanagement/terminal/addlist'/>" title="添加设备信息"><span>添加设备信息</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<c:url value='/terminalmanagement/terminal/deleteTerminal/{slt_objId}'/>" title="您确定要删除吗?"><span>删除设备信息</span></a></li>
			<li><a class="edit" target="navTab"  href="<c:url value='/terminalmanagement/terminal/editlist/{slt_objId}'/>" title="设备信息修改"><span>设备信息修改</span></a></li>
			<li><a class="icon" target="dialog" rel="dlg_page8" href="<c:url value='/terminalmanagement/terminal/excelList/'/>" title="导入excel"><span>导入excel</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="8%">设备名称</th>
				<th width="8%">imei号</th>
				<th width="8%">设备类型</th>
				<th width="8%">设备绑定状态</th>
				<th width="8%">设备绑定日期</th>
				<th width="8%">设备生产商</th>
				
				
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${terminalList}" varStatus="s">
			<tr target="slt_objId" rel="${item.user_id}">
				<td>${s.index + 1}</td>
				<td>${item.terminal_name}</td>
				<td>${item.terminal_imei}</td>
				<td>
					${ null eq item.terminal_device_type ? '--' : ''}
					${ '1' eq item.terminal_device_type ? '类型1' : ''}
					${ '2' eq item.terminal_device_type ? '类型2' : ''}
				</td>
				<td>
				${ '1' eq item.terminal_status ? '已绑定' : ''}
				${ '0' eq item.terminal_status ? '未绑定' : ''}
				</td>
			    <td>
			    ${ null eq item.terminal_binding_date ? '--' : ''}			    
			   	<fmt:formatDate value="${item.terminal_binding_date}"  type="date" dateStyle="full"/>
			    </td>
			    <td>${item.terminal_producer}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>