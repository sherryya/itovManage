<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<script type="text/javascript">
	function callback(flag, msg) {
		if (flag == 'true') {
			alertMsg.correct(msg)
			//$.pdialog.closeCurrent();
		} else {
			alertMsg.error(msg)
		}
	}
	

	function checkPdtpSubmit() {
		var spotName = $("#pdtpNewForm #spotName");
		if (spotName.val().trim() == "") {
			alertMsg.error("景点名称不能为空！");
			spotName.focus();
			return false;
		}
		var spotAddress = $("#pdtpNewForm #spotAddress");
		if (spotAddress.val().trim() == "") {
		    spotAddress.focus();
			alertMsg.error("详细地址不能为空！");
			return false;
		}
		var spotIntroduction = $("#pdtpNewForm #spotIntroduction");
		if (spotIntroduction.val().trim() == "") {
			alertMsg.error("景点介绍不能为空！");
			spotIntroduction.focus();
			return false;
		}
		
	   var myfiles1 = $("#pdtpNewForm #myfiles1");
/* 		if (myfiles1.val().trim() == "") {
			alertMsg.error("照片不能为空！");
			myfiles1.focus();
			return false;
		} */
		if(myfiles1.val().trim()!="")
		{
			var extStart=myfiles1.val().lastIndexOf(".");  
	        var ext=myfiles1.val().substring(extStart,myfiles1.val().length).toLowerCase();  
	        if(ext!=".bmp"&&ext!=".png"&&ext!=".gif"&&ext!=".jpg"&&ext!=".jpeg"){  
	            alert("图片限于bmp,png,gif,jpeg,jpg格式"); 
	            myfiles1.focus();  
	            return false;  
	        }
        }
        
        return true;  
	}
	function rxw(lonlat)
	{
	  var arr=lonlat.split("_");
	  var json= "{\"lon\":"+arr[0]+",\"lat\":"+arr[1]+"}";
	  $.pdialog.open("/itovManage/zdjsmanagement/zdjs/displaypicture/"+json+"/"+arr[0], "renxiwei", "照片浏览",{width:400,height:400,max:true,mask:true,mixable:true,minable:true,resizable:true});
	}
	
	function show(par)
	{
	 if(par==1)
	 {
	
	 $("#div_loading").show();
	 }
	 else
	 {

	  $("#div_loading").hide();
	 }
	}
</script>
<!--  -->
<form method="post"   target="hidden_frame"
	action="<c:url value='/zdjsmanagement/zdjs/save?navTabId=zdjsSave&callbackType=closeCurrent'/>"
	class="pageForm required-validate" id="pdtpNewForm"
	enctype="multipart/form-data">

	<div class="pageFormContent" layoutH="60">
		<fieldset>
			<legend></legend>
			<dl>
				<dt>景点名称：</dt>
				<dd>
					<input class="input" type="text" style="width:200px;"
						name="spotName" id="spotName" value="${vo.spotName }"  maxlength="30" /><font color="red">*</font>
						<div id="div_loading"  style="display: none;">loading</div>	
				</dd>
			</dl>
			<dl>
				<dt>联系电话：</dt>
				<dd>
					<input type="text" name="spotTel" value="${vo.spotTel }"  id="spotTel"  style="width:200px;"
						maxlength="30" />
				</dd>
			</dl>
			<dl>
				<dt>联系人：</dt>
				<dd>
					<input type="text" maxlength="30" name="spotManager" id="spotManager" value="${vo.spotManager }"  style="width:200px;" />
				</dd>
			</dl>
			<dl>
				<dt>详细地址：</dt>
				<dd>
					<input type="text" name="spotAddress" value="${vo.spotAddress }" id="spotAddress"  style="width:200px;" /><font color="red">*</font>
					<input type="text" value="${lonlatId}"   style="display: none;" name="lonlatId"/>
					<input type="text" value="${lonlat}"  style="display: none;" name="lonlat" />
					
				</dd>
			</dl>


		</fieldset>
		<fieldset>
			<legend></legend>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles" id="myfiles1" /><font color="red">*</font>
				</dd>
			</dl>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles"  id="myfiles2" />
				</dd>
			</dl>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles"  id="myfiles3"/>
				</dd>
			</dl>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles"   id="myfiles4"/>
				</dd>
			</dl>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles"  id="myfiles5"/>
				</dd>
			</dl>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles"  id="myfiles6"/>
				</dd>
			</dl>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles"  id="myfiles7"/>
				</dd>
			</dl>
			<dl>
				<dt>照片：</dt>
				<dd>
					<input type="file" name="myfiles"  id="myfiles8"/>
				</dd>
			</dl>
			<dl style="width:100%; text-align: right; ">
			 <a class="button"  href="javaScript:rxw('${lonlatId}')"><span>照片浏览</span></a>
			
			</dl>
		
		</fieldset>
		<fieldset>
			<legend></legend>
			<dl class="nowrap">
				<dt>景点介绍：</dt>
				<dd>
					
					<textarea name="spotIntroduction"   id="spotIntroduction"  cols="80" rows="9">${vo.spotIntroduction }</textarea><font color="red">*</font>
				</dd>
			</dl>
			<dl class="nowrap">
				<dt>景点备注：</dt>
				<dd>
					<textarea name="spotNote" id="spotNote"   cols="80" rows="3">${vo.spotNote }</textarea>
				</dd>
			</dl>
		</fieldset>
	</div>
	<iframe name="hidden_frame" id="hidden_frame"
		style="display:none"></iframe> 
	<div class="formBar">
		<ul>
			<li>
				<div class="buttonActive">
					<div class="buttonContent">
						<button type="submit" onclick="return checkPdtpSubmit();">保存</button>
					</div>
				</div>
			</li>
			<li>
				<div class="button">
					<div class="buttonContent">
						<button type="button" class="close">关闭</button>
					</div>
				</div>
			</li>
		</ul>
	</div>
</form>
