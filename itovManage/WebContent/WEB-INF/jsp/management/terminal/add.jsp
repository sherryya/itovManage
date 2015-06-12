<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>


<div class="pageContent">
	<form method="post" action="<c:url value='/terminalmanagement/terminal/insertTerminal?navTabId=terminal&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>设备名称：</label>
				<input name="terminal_name" class="required" type="text" size="30"  alt=""   />
			</p>
			<p>
				<label>设备imei号：</label>
				<input name="terminal_imei" type="" class="required" size="30" />
			</p>
			<p>
				<label>设备类型：</label>
				<select name="terminal_device_type" class="required combox">
					<option value="1" selected>类型1</option>
					<option value="2">类型2</option>
				</select>
			</p>
			<p>
				<label>设备生产商：</label>
				<input name="terminal_producer" type="" class="required" size="30" />
			</p>
			<p>
				<label>出库时间: </label>
				<input type="text" name="terminal_binding_date" class="date" readonly="readonly"/>
				<a href="javascript:;" class="inputDateButton">选择</a>
			</p>
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

