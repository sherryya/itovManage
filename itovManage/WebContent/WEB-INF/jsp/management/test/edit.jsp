<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>

<div class="pageContent">
	<h2 class="contentTitle">测试内容修改</h2>

	<form
		action="<c:url value='/management/test/update?navTabId=testLiNav&callbackType=closeCurrent'/>"
		method="post" class='required-validate pageForm'
		onsubmit="return iframeCallback(this, navTabAjaxDone);"   enctype="multipart/form-data" >
		<input type="hidden" name="id" value="${Tests.id}" />

		<div class="pageFormContent" layoutH="97">
			<div class="unit">
				<label>姓名</label> <input type="text" name="name"
					value="${Tests.name}" class="textInput required" maxlength="200"
					size="100" />
			</div>


			<div class="unit">
				<label>昵称</label> <input type="text" name="nick_name"
					value="${Tests.nick_name}" class="textInput required"
					maxlength="200" size="100" />
			</div>
			<div class="unit">
				<label>年龄</label> <input type="text" name="age" value="${Tests.age}"
					class="textInput required" maxlength="200" size="100" />
			</div>
			<div class="unit">
				<label>性别</label> <input type="text" name="sex" value="${Tests.sex}"
					class="textInput required" maxlength="200" size="100" />
			</div>
			
			<div class="unit">
				<label>照片</label> <input type="file" name="file" value="${Tests.sex}"
					class="textInput required" maxlength="200" size="100" />
			</div>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<button type="submit">保存</button>
						</div>
					</div>
				</li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">关闭</button>
						</div>
					</div>
				</li>
			</ul>
		</div>
	</form>
</div>

