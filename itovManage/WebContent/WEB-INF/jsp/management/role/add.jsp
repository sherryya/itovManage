<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<c:url value='/personalmanagement/role/insert?navTabId=roleNav&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>角色名称: </label>
			<input type="text" name="roleName" class="required " minlength="2" maxlength="20"/>
		</p>
		<p>
			<label>角色描述: </label>
			<input type="text" name="roleDescription"   minlength="6" maxlength="200"/>
		</p>
          <p>
			<label>排序: </label>
			<input type="text" name="roleTaxis" class="required alphanumeric" minlength="1" maxlength="100"/>
		</p>		
			
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
