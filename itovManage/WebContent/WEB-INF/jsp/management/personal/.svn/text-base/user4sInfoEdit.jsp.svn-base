<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"	+ request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<div class="pageContent">
	<form method="post" action="<c:url value='/personalmanagement/user4s/editUser4sInfo?navTabId=user4s&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<c:forEach var="user4sList" items="${user4sList}" varStatus="s">
		
			<p>
				<input type="hidden" name="account_id" value="${user4sList.account_id}" />
			
				<label>账号名称：</label>
				<input name="account_name" class="required" type="text" size="30"  value="${user4sList.account_name}"/>
			</p>
			
			
			<p>
				<label>真实姓名：</label>
				<input name="real_name" class="required" type="text" size="30" value="${user4sList.real_name}"/>
			</p>
									
			<p>
				<label>昵  称：</label>
				<input name="nickname" class="required" type="text" size="30"  value="${user4sList.nickname}"/>
			</p>
					 
			<p>
				<label>4s店名称</label>
				 <input name="company_id" value="${user4sList.company_id}" type="hidden" />  
                <input class="required" name="company_name" value="${user4sList.company_name}" type="text" />  
                <a class="btnLook" href="<c:url value='/personalmanagement/user4s/lookup'/>" warn="用户" lookupGroup="">查找带回</a>       
                <span class="info">(lookup)</span>
			</p> 
			
			<p>
				<label>性  别：</label>
				<select name="person_sex" class="required combox">
					<option value="1" <c:if test="${user4sList.person_sex=='1'}">selected</c:if>>男</option>
					<option value="0" <c:if test="${user4sList.person_sex=='0'}">selected</c:if>>女</option>
				</select>
			</p>
			 
			
			<p>
				<label>联系电话：</label>
				<input name="person_tel" class="phone" type="text" size="30" value="${user4sList.person_tel}"/>
			</p>


			<p>
				<label>邮箱：</label>
				<input type="text" name="person_email" class="email" size="30" value="${user4sList.person_email}"/>
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

