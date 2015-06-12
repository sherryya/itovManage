<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"	+ request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<div class="pageContent">
	<form method="post" action="<c:url value='/terminalmanagement/terminal/updateTerminal?navTabId=terminal&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<c:forEach var="terminalList" items="${terminalList}" varStatus="s">
		
			<p>
				<input type="hidden" name="user_id" value="${terminalList.user_id}" />
			
				<label>设备名称：</label>
				<input name="terminal_name" class="required" type="text" size="30"  value="${terminalList.terminal_name}"/>
			</p>
			
			
			<p>
				<label>设备imei号：</label>
				<input name="terminal_imei" class="required" type="text" size="30" value="${terminalList.terminal_imei}"/>
			</p>
											
			<p>
				<label>设备类型：</label>
				<select name="terminal_device_type" class="required combox">
					<option value="1" <c:if test="${terminalList.terminal_device_type=='1'}">selected</c:if>>类型1</option>
					<option value="2" <c:if test="${terminalList.terminal_device_type=='2'}">selected</c:if>>类型2</option>
				</select>
			</p>
			
			<p>
				<label>设备生产商：</label>
				<input name="terminal_producer" class="" type="text" size="30" value="${terminalList.terminal_producer}"/>
			</p>

		</c:forEach>
		
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

