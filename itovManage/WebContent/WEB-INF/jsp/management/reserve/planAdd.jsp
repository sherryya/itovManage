<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
	
</script>

<div class="pageContent">
	<form method="post" action="<c:url value='/querymanagement/reserveplan/insertReservePlan?navTabId=reserveplan&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">			
		<p>
				<label>开始时间：</label>
				<input type="text" name="begin_time" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
				<input type="hidden" name="orgLookup.id" value="${orgLookup.id}"/>
			
		</p>
				
		<p>
				<label>结束时间：</label>
				<input type="text" name="end_time" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
				<input type="hidden" name="orgLookup.id" value="${orgLookup.id}"/>
			
		</p>
			
			
		<p>
			<label>数量：</label>
			<input name="num" class="required" type="text" size="30"  alt="请输入数量"/>
		</p>


		
		<dl class="nowrap">
			<dt>预约信息内容：</dt>
			<dd><textarea cols="45" rows="5" name="content"></textarea></dd>
		</dl>

			
		</div>
		<div class="formBar">
			<ul>
				<!--<li><a class="buttonActive" href="javascript:;"><span>保存</span></a></li>-->
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>

