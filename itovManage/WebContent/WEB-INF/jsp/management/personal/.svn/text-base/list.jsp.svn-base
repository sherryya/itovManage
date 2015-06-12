<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/personal/list'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>用户类型：</label>
				<select name="account_type">
					<option value="4"  ${ '4' eq param.account_type ? 'selected="selected"' : ''}>系统坐席</option>
				</select>
			</li>
			<li>
				<label>当前状态：</label>
				<select name="agentstate">
				    <option value="%"  ${ '%' eq param.agentstate ? 'selected="selected"' : ''}>【全部】</option>
					<option value="0"  ${ '0' eq param.agentstate ? 'selected="selected"' : ''}>准备中</option>
					<option value="1"  ${ '1' eq param.agentstate ? 'selected="selected"' : ''}>准备就绪</option>
					<option value="2"  ${ '2' eq param.agentstate ? 'selected="selected"' : ''}>用户锁定</option>
					<option value="3"  ${ '3' eq param.agentstate ? 'selected="selected"' : ''}>咨询通话中</option>
					<option value="4"  ${ '4' eq param.agentstate ? 'selected="selected"' : ''}>座席线路忙</option>
					<option value="-1"  ${ '-1' eq param.agentstate ? 'selected="selected"' : ''}>离线</option>
					<option value="-2"  ${ '' eq param.agentstate ? 'selected="selected"' : ''}>新账号</option>
				</select>
			</li>
		 	<li>
			<label>用户名：</label>
			<input type="text" name="keywords" value="${param.keywords}"/>
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
			<li><a class="add" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/personal/add'/>" title="坐席添加"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/personal/edit/{slt_objId}'/>" title="坐席修改"><span>修改</span></a></li>
<%-- 			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/test/delete/{slt_testId}'/>" title="您确定要删除吗?"><span>删除</span></a></li> --%>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">用户ID</th>
				<th width="10%">用户名</th>
			    <th width="10%">用户真实名</th>
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
				<td>
				${ '1' eq item.personal_sex ? '男' : '女'}
				</td>
 				<td>
				${ '0' eq item.agentstate ? '准备中' : ''}
				${ '1' eq item.agentstate ? '准备就绪' : ''}
				${ '2' eq item.agentstate ? '用户锁定' : ''}
				${ '3' eq item.agentstate ? '咨询通话中' : ''}
				${ '4' eq item.agentstate ? '座席线路忙' : ''}
				${ '-1' eq item.agentstate ? '离线' : ''}
				${ '-2' eq item.agentstate ? '新账号' : ''}
				</td>
			    
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>