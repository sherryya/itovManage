<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/querymanagement/feedback/feedbacklist'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>评价星值：</label>
				 
				<select name="feedbackType_query">
					<option value="%"  ${ '%' eq param.feedbackType_query ? 'selected="selected"' : ''}>全部</option>
					<option value="1"  ${ '1' eq param.feedbackType_query ? 'selected="selected"' : ''}>一颗星</option>
					<option value="2"  ${ '2' eq param.feedbackType_query ? 'selected="selected"' : ''}>两颗星</option>
					<option value="3"  ${ '3' eq param.feedbackType_query ? 'selected="selected"' : ''}>三颗星</option>
					<option value="4"  ${ '4' eq param.feedbackType_query ? 'selected="selected"' : ''}>四颗星</option>
					<option value="5"  ${ '5' eq param.feedbackType_query ? 'selected="selected"' : ''}>五颗星</option>
				</select>
				 
			</li>
			<li>
				<label>是否处理：</label>
				<select name="isdeal_query">
					<option value="%"  ${ '%' eq param.isdeal_query? 'selected="selected"' : ''}>全部</option>
					<option value="1"  ${ '1' eq param.isdeal_query? 'selected="selected"' : ''}>已处理</option>
					<option value="0"  ${ '0' eq param.isdeal_query? 'selected="selected"' : ''}>未处理</option>
				</select>
			</li>
		 	<li>
			<label>用户名：</label>
			<input type="text" name="accountName" value="${param.accountName}"/>
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
				<th width="8%">用户真实名</th>
				<th width="8%">用户昵称</th>
				<th width="8%">是否处理</th>
				<th width="8%">评价星值</th>
				<th width="30%">反馈内容</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${userList}" varStatus="s">
			<tr target="slt_objId" rel="${item.accountId }">
				<td>${s.index + 1}</td>
				<td>${item.accountName}</td>
				<td>${item.nickName}</td>
				<td>
					${ '1' eq item.isDeal ? '已处理' : '未处理'}
				</td>
				<td>
				${ '1' eq item.feedbackType ? '一颗星' : ''}
				${ '2' eq item.feedbackType ? '两颗星' : ''}
				${ '3' eq item.feedbackType ? '三颗星' : ''}
				${ '4' eq item.feedbackType ? '四颗星' : ''}
				${ '5' eq item.feedbackType ? '五颗星' : ''}
				</td>
			    <td>${item.feedbackInfo}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>