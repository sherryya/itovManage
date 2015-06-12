<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
	<form method="post" action="<c:url value='/personalmanagement/host/insertHost?navTabId=personal&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>姓  名：</label>
				<input name="name" class="required" type="text" size="30"  alt="请输入姓名"/>
			</p>
			<p>
				<label>昵  称：</label>
				<input name="nickname" class="required" type="text" size="30"  alt="请输入昵称"/>
			</p>
			<p>
				<label>性  别：</label>
				<select name="sex" class="required combox">
					<option value="男">男</option>
					<option value="女" selected>女</option>
				</select>
			</p>
			<p>
				<label>联系电话：</label>
				<input name="telphone" class="phone" type="text" size="30"/>
			</p>
			<p>
				<label>出生年月：</label>
				<input type="text" name="birthday" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
				<input type="hidden" name="orgLookup.id" value="${orgLookup.id}"/>
				<!--<input type="text" class="required" name="orgLookup.orgName" value="" suggestFields="orgNum,orgName" suggestUrl="demo/database/db_lookupSuggest.html" lookupGroup="orgLookup" />
				<a class="btnLook" href="demo/database/dwzOrgLookup.html" lookupGroup="orgLookup">查找带回</a>		  -->
			</p>
			<p>
				<label>民族：</label>
				<input type="text" value="" name="nation" class="textInput">
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" name="email" class="email" size="30" />
			</p>
			<p>
				<label>身高：</label>
				<input type="text" name="height" size="30" />
			</p>
			<p>
				<label>体重：</label>
				<input type="text" name="weight" size="30" />
			</p>
			<p>
				<label>毕业学校：</label>
				<input type="text" name="school" size="30" />
			</p>
			<p>
				<label>专业：</label>
				<input type="text" name="specialty"  size="30" />
			</p>
			<p>
				<label>毕业时间：</label>
				<input type="text" name="specdate" class="date" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>籍贯：</label>
				<input type="text" name="nativePlace" size="30" />
			</p>
			<p>
				<label>住址：</label>
				<input type="text" name="address"　size="30" />
			</p>
			
			<p>
				<label>照片：</label>
				<a class="button" href="<c:url value='/personalmanagement/host/picture'/>" target="dialog" rel="dlg_page8"><span>上传照片</span></a>
			</p>
			<dl class="nowrap">
				<dt>个人简介：</dt>
				<dd><textarea cols="45" rows="5" name="introduce"></textarea></dd>
			</dl>
			<div class="divider"></div>
			<p>
				<label>建档日期：</label>
				<input class="date" type="text" size="30" name="createdate" /><a class="inputDateButton" href="javascript:;">选择</a>
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

