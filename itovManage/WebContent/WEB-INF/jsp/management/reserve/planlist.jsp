<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<c:url value='/querymanagement/reserveplan/list'/>" onsubmit="return navTabSearch(this)">
<script type="text/javascript">
 $(function() {
    $( "#start" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 3,
      onClose: function( selectedDate ) {
        $( "#end" ).datepicker( "option", "minDate", selectedDate );
      }
    });
    $( "#end" ).datepicker({
      defaultDate: "+1w",
      changeMonth: true,
      numberOfMonths: 3,
      onClose: function( selectedDate ) {
        $( "#start" ).datepicker( "option", "maxDate", selectedDate );
      }
    });
  });

</script>


<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">			
			<li>
				<label>开始时间：</label>
				<input id="start" type="text" name="begin_time" value="${param.begin_time}" class="date" dateFmt="yyyy-MM-dd" readonly="true" style="float:left"  
			
 				/>
				<a class="inputDateButton" href="javascript:;">选择</a>
			</li> 
			
			
			<li>
				<label>结束时间：</label>
				<input id="end" type="text" name="end_time" value="${param.end_time}" class="date" dateFmt="yyyy-MM-dd" readonly="true" style="float:left"      
 				/>
				<a class="inputDateButton" href="javascript:;">选择</a>
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
			<li><a class="add" target="navTab" rel="personalNav" href="<c:url value='/querymanagement/reserveplan/add'/>" title="预约计划信息添加"><span>添加</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>

	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="8%">预约内容</th>
				<th width="8%">发放数量</th>
				<th width="8%">开始时间</th>
				<th width="8%">结束时间</th>
		</thead>
	<tbody>
		<c:forEach var="item" items="${reservePlanList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.content}</td>
				<td>${item.num}</td>
				<td>${item.begin_time}</td>
				<td>${item.end_time}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>