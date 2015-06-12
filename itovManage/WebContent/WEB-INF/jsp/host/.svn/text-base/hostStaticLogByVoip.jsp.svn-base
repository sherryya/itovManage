<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../management/_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/hostStatic/hostStaticLoglist/${voipAccount}'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
			<label>开始日期：</label>
				<input type="text" name="starttime"  class="date" size="20" value="${starttime}"/><a class="inputDateButton" href="javascript:;">选择</a>
			</li>
			<li>
			<label>结束日期：</label>
				<input type="text" name="endtime"  class="date" size="20" value="${endtime}"/><a class="inputDateButton" href="javascript:;">选择</a>
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
			<li class="line">line</li>
		</ul>
	</div> 
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="10%">主播账号ID</th>
				<th width="10%">被呼叫voip</th>
			    <th width="10%">挂机类型</th>
				<th width="10%">voip账号</th>
				<th width="10%">在线时间</th>
				<th width="10%">录音地址</th>
				<th width="10%">呼叫类型</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${hostStaticLogList}" varStatus="s">
			<tr target="slt_objId" rel="${item.voipaccount }">
				<td>${s.index + 1}</td>
				<td>${item.accountId}</td>
				<td>${item.caller}</td>
				<td>
				${'1' eq item.byetype ? '正常结束电话':''}
				${'-1' eq item.byetype ? '被叫没有振铃就收到了挂断消息':''}
				${'-2' eq item.byetype ? '呼叫超时没有接通被挂断':''}
				${'-8' eq item.byetype ? '直拨被叫振铃了挂断':''}
				${'-5' eq item.byetype ? '被叫通道建立了被挂断':''}
				${'2' eq item.byetype ? '账户欠费或者设置的通话时间到':''}
				${'-7' eq item.byetype ? '系统鉴权失败':''}
				${'-3' eq item.byetype ? '回拨主叫接通了主叫挂断':''}
				</td>
				<td>${item.voipaccount }</td>
				<td>
				${item.onlinetime}
				</td>
				<td>${item.recordurl}</td>
				<td>
				${ '1' eq item.type ? '回拨' : ''}
				${ '0' eq item.type ? '普通呼叫' : ''}
				${ '2' eq item.type ? 'VoIP网络通话' : ''}
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../management/_frag/pager/panelBar.jsp"></c:import>
</div>