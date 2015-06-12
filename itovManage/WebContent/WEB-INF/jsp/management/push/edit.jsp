<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<form id="pagerForm" method="post"
	action="/management/book/edit/${book.id}">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
	<form method="post"
		action="<c:url value='/personalmanagement/personal/update?navTabId=personal&callbackType=closeCurrent'/>"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone);">
		<input type="hidden" name="account_id" value="${vo.account_id}" />
		<div class="pageFormContent" layoutH="57">
			<p>
				<label>用户名: </label> <input type="text" name="account_name"
					value="${vo.account_name}" readonly="readonly" />
			</p>
			<p>
				<label>电话: </label> <input type="text" name="personal_tel"
					value="${vo.personal_tel}" maxlength="30" readonly="readonly" />
			</p>
			<p>
				<label>性别: </label> <select name="personal_sex">

					<option value="1" ${"1" eq vo.personal_sex ? 'selected="selected"' : ''}>男</option>
					<option value="1" ${"0" eq vo.personal_sex ? 'selected="selected"' : ''}>女</option>
				</select>
			</p>
			<p>
				<label>真实姓名: </label> <input type="text" name="personal_real_name"
					value="${vo.personal_real_name}"  class="required"
					maxlength="100"   />
			</p>


			<p>
				<label>Email: </label> <input type="text" name="personal_email"  class="email"
					value="${vo.personal_email}" maxlength="30" />
			</p>
			<p>
				<label>QQ: </label> <input type="text" name="personal_qq"
					value="${vo.personal_qq}"  class="digits" maxlength="13"/>
			</p>
			<p>
				<label>年龄: </label> <input type="text" name="personal_age"   class="required digits" maxlength="3"
					value="${vo.personal_age}" />
			</p>
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