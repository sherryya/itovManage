<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include	file="/include.inc.jsp"%>
<%@ page import="dwz.manageRest.dto.TZdcHostUser"%>
<%@ page import="java.util.List"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"	+ request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<script>
  $(function(){
	 var t =  $("#accountIdTemp").val();
	 if(!Math.abs(t) <= 1e-15)
	 {
		 $("#setAccount").addClass("buttonDisabled");
		 $("#setAccount").attr("disabled",true);
		 
		 $("#hideSetAccount").hide();
	 }
	  
  });
</script>
<div class="pageContent">
	<form method="post"
		action="<c:url value='/personalmanagement/host/editHostInfo'/>"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<c:forEach var="hostList" items="${hostList}" varStatus="s">
		<p>
		<input type="hidden" id ="accountIdTemp" value="${accountIdTemp}">
		<input type="hidden" name="id" value="${hostList.id}" />
		    <label>姓  名：</label>
				<input name="name" class="required"  type="text" size="30"  value="${hostList.name}"/>
			</p>
			<p>
				<label>昵  称：</label>
				<input name="nickname" class="required" type="text" size="30" value="${hostList.nickname}"/>
			</p>
			<p>
				<label>性  别：</label>
				<select name="sex" class="required combox" readonly="readonly" >
				    <c:if test="${hostList.sex!=null&&hostList.sex!=''}">
				       <option value="${hostList.sex}" selected>${hostList.sex}</option>
				       <c:if test="${hostList.sex=='男'}">
				          <option value="女">女</option>
				       </c:if>
				       <c:if test="${hostList.sex=='女'}">
				          <option value="男">男</option>
				       </c:if>
				    </c:if>
				    <c:if test="${hostList.sex==null || hostList.sex==''}">
				       <option value="男">男</option>
					   <option value="女" selected>女</option>
				    </c:if>
				   
				</select>
			</p>
			<p>
				<label>等   级：</label>
				<input name="grade" value="${hostList.grade}" type="text" size="30"/>
			</p>
			<p>
				<label>出生年月：</label>
				<input type="text" name="birthday"  class="date" size="30" value="${hostList.birthday}"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>民族：</label>
				<input type="text" value=""  name="nation" class="textInput" value="${hostList.nation}"> 
			</p>
			<p>
				<label>联系电话：</label>
				<input name="telphone" class="phone" type="text" size="30" value="${hostList.telphone}"/>
			</p>
			<p>
				<label>身高：</label>
				<input type="text" name="height" size="30" value="${hostList.height}" />
			</p>
			<p>
				<label>体重：</label>
				<input type="text" name="weight" size="30" value="${hostList.weight}"/>
			</p>
			<p>
				<label>邮箱：</label>
				<input type="text" name="email" class="email" size="30" value="${hostList.email}"/>
			</p>
			<p>
				<label>毕业学校：</label>
				<input type="text" name="school" size="30" value="${hostList.school}" />
			</p>
			<p>
				<label>专业：</label>
				<input type="text" name="specialty"  size="30" value="${hostList.specialty}" />
			</p>
			<p>
				<label>毕业时间：</label>
				<input type="text" name="specdate" class="date" size="30" value="${hostList.specdate}"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>籍贯：</label>
				<input type="text" name="nativePlace" size="30" value="${hostList.nativePlace}"/>
			</p>
			<p>
				<label>住址：</label>
				<input type="text" name="address"　size="30" value="${hostList.address}"/>
			</p>
			<br>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>个人简介：</dt>
				<dd><textarea cols="45" rows="5" name="introduce" value="${hostList.introduce}">${hostList.introduce}</textarea></dd>
			</dl>
			<table>
				<tr>
				  <td>照片：</td>
				  <td>
				      <a class="button" href="<c:url value='/personalmanagement/host/picture'/>" target="dialog" rel="dlg_page8"><span>上传照片</span></a>
				  </td>
				  <td>
				       <div style="float:left; display:block; margin:10px; overflow:auto; width:150px; height:200px; border:solid 1px #CCC; line-height:21px; background:#FFF;">
				       <img src="<%=path%>/styles/upload/host/${hostList.pic}"/>
				       </div>
				  </td>
				</tr>
			</table>
			<p>
				<label>建档日期：</label>
				<input class="date" readonly="readonly" type="text" size="30" name="createdate" value="${hostList.createdate}"/><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
		    <div class="divider"></div>
		    </br>
		    <div>
		    <table>
		     <tr><td>账户信息：</br></td></tr>
		     <tr><td>用户名：${hostList.account_name}</br></td></tr>
		     <tr><td>主播类型：<c:if test="${hostList.hostType==0}">主播</c:if><c:if test="${hostList.hostType==1}">导播</c:if></td></tr>
		     <tr><td>房间号:${hostList.roomId}</br></td></tr></br>
		   </table>
		    </div>
		
		<div class="divider"></div>
		<div id="hideSetAccount"><a class="button" id="setAccount" href="<c:url value='/personalmanagement/host/addHostAccount/${hostList.id}'/>" target="dialog" rel="dlg_page8"><span>设置账户</span></a><br /><br /></div>
		</c:forEach>
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
