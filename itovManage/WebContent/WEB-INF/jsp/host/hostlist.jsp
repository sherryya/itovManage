<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<head>
<meta http-equiv="pragma" content="no-cache"  />
<meta http-equiv="content-type" content="no-cache, must-revalidate" />
</head>
<c:import url="../management/_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/host/hostlist'/>" onsubmit="return navTabSearch(this)">
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
			<li>
			<label>主播类型：</label>
				<select name=hostType>
				    <option selected="selected" value="">全部</option> 
				    <option value="0"  ${ '0' eq param.hostType ? 'selected="selected"' : ''}>主播</option> 
					<option value="1"  ${ '1' eq param.hostType ? 'selected="selected"' : ''}>导播</option> 
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
			<li><a class="add" target="navTab" href="<c:url value='/personalmanagement/host/addHost'/>" title="添加主播"><span>添加主播</span></a></li>
			<li><a class="edit" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/host/editHost/{slt_objId}'/>" title="主播修改"><span>修改</span></a></li>
<%-- 			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/test/delete/{slt_testId}'/>" title="您确定要删除吗?"><span>删除</span></a></li> --%>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">姓名</th>
				<th width="5%">性别</th>
			    <th width="20%">学校</th>
			    <th width="20%">专业</th>
				<th width="10%">电话</th>
				<th width="20%">住址</th>
				<th width="5%">主播类型</th>
				<th width="10%" >状态</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${hostList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }"  height="25px">
				<td>${s.index + 1}</td>
				<td>${item.name}</td>
				<td>${item.sex}</td>
				<td>${item.school}</td>
			    <td>${item.specialty}</td>
				<td>${item.telphone}</td>
 				<td>
				${item.address}
				</td>
				<td>
				<c:if test="${item.hostType!=null}">
				${ '0' eq item.hostType ? '主播' : ''}
				${ '1' eq item.hostType ? '导播' : ''}
				</c:if>
				</td>
				<td>
				<c:if test="${item.voip_status==null}">
				    <a class="button" id="setAccount" href="<c:url value='/personalmanagement/host/addHostAccount/${item.id }'/>" target="dialog" rel="dlg_page8"><span>设置账户</span></a>
				</c:if>
				${ '0' eq item.voip_status ? '在线' : ''}
				${ '-1' eq item.voip_status ? '不在线' : ''}
				${ '1' eq item.voip_status ? '占线' : ''}
				${ '2' eq item.voip_status ? '暂停' : ''}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../management/_frag/pager/panelBar.jsp"></c:import>
</div>