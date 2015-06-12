<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
  <form method="post" rel="pagerForm" action="<c:url value='/zdjsmanagement/zdjs/list'/>" onsubmit="return navTabSearch(this)"> 
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
		<li>
			<label>里程时间：</label>
			<input type="text" name="date"   class="date" readonly="readonly" 
			value="${date eq '' ? param.date : date}" />
			</li>
		 	<li>
			<label>UID：</label>
			<input type="text" name="deviceuid" value="${deviceuid }"/>
			</li> 
		 
		</ul>
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
			<li><a class="add" target="dialog" rel="dlg_page1" max="true"  mask="true" href="<c:url value='/zdjsmanagement/zdjs/add/{slt_objId}'/>" title="添加景点"><span>添加景点</span></a></li>
			<li class="line">line</li>
		</ul>
	</div> 
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>

                        <th width="8%">里程时间</th>
						<th width="8%">开始时间</th>
						<th width="8%">结束时间</th>
						<th width="8%">里程数</th>
						<th width="8%">油耗</th>
						<th style="word-wrap:break-word;word- break:break-all;" width="10%">开始地点</th>
						<th style="word-wrap:break-word;word- break:break-all;" width="10%">结束地点</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${List}" varStatus="s">
			<tr target="slt_objId" rel="${item.startTime},${item.endTime}">
				<td>${s.index + 1}</td>
				<td>${item.totaltime}</td>
				<td>${item.startTime}</td>
				<td>${item.endTime}</td>
				<td>${item.totalkilo}</td>
				<td>${item.totaloil}</td>
				<td>${item.startLocation}</td>
				<td>${item.endLocation}</td>


			    
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>