<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<head>
<meta http-equiv="pragma" content="no-cache"  />
<meta http-equiv="content-type" content="no-cache, must-revalidate" />
</head>
<div class="pageContent">
<form method="post" action="<c:url value='/personalmanagement/host/insertAccount?callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="57">

		<p>
			<label>用户名: </label>
			<input type="text" name="account_name" class="required alphanumeric" minlength="3" maxlength="20"/>
		</p>
		<p>
			<label>密码: </label>
			<input type="password" name="account_password" class="required alphanumeric" minlength="6" maxlength="20"/>
		</p>
		<p>
				<label>主播类型：</label>
				<select name="hostType" class="required combox" id="hostType">
					<option value="0" selected>主播</option>
					<option value="1">导播</option>
				</select>
		</p>
		<p id="channelClass">
				<label>频道类型：</label>
				<select name="channelType">
					<option value="1"  selected>生活频道</option>
					<option value="2">娱乐频道</option>
					<option value="3">新闻频道</option>
					<option value="4">体育频道</option>
					<option value="5">财经频道</option>
				</select>
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
<script>
$(function(){
	
	$("#channelClass").hide();
	//如果是主播则可以选择频道
	if($("#hostType").val()==0)
	{
		$("#channelClass").show();
	}else
	{
		$("#channelClass").hide();
	}
	$("#hostType").change(function(){
		if($("#hostType").val()==0)
		{
			$("#channelClass").show();
		}else
		{
			$("#channelClass").hide();
		}
	});
})
</script>
