<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>


<div class="pageContent">
	<form method="post" action="<c:url value='/personalmanagement/user4s/insertUser4s?navTabId=user4s&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>账号名称：</label>
				<input name="account_name" class="required" type="text" size="30"  alt=""   />
			</p>
			<p>
				<label>密码：</label>
				<input name="account_password" type="" class="required" size="30" />
			</p>
			<!-- 
			<p>
				<label>4s店：</label>
				<select name="company_id" class="required combox" >
					<c:forEach var="item" items="${shop4sList}">
							<option value="${item.shop4s_id}">${item.shop4s_name}</option>
					</c:forEach>
				</select>
			</p>
		 -->
		
			<p>
				<label>4s店名称</label>
			    <input name="company_id" value="" type="hidden" />  
                <input class="required" name="company_name" type="text" />  
                <a class="btnLook" href="<c:url value='/personalmanagement/user4s/lookup'/>" warn="用户" lookupGroup="">查找带回</a>       
                <span class="info">(lookup)</span>  
			</p>
 			
			<p>
				<label>昵  称：</label>
				<input name="nickname" class="required" type="text" size="30"  alt="请输入昵称"/>
			</p>
			
			
			<p>
				<label>真实姓名：</label>
				<input name="real_name" class="required" type="text" size="30"  alt="请输入真实姓名"/>
			</p>
			
			
			<p>
				<label>性  别：</label>
				<select name="person_sex" class="required combox">
					<option value="1">男</option>
					<option value="0" selected>女</option>
				</select>
			</p>
			<p>
				<label>联系电话：</label>
				<input name="person_tel" class="phone" type="text" size="30"/>
			</p>


			<p>
				<label>邮箱：</label>
				<input type="text" name="person_email" class="email" size="30" />
			</p>
		
		<!-- 
			<p>
				<label>照片：</label>
				<a class="button" href="<c:url value='/personalmanagement/host/picture'/>" target="dialog" rel="dlg_page8"><span>上传照片</span></a>
			</p>
 		-->
		
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

