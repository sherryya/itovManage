<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include	file="/include.inc.jsp"%>
<style>
img{max-width:900px;width:expression(this.width > 900 ? 900: true);height:auto;}
</style>
<input type="hidden" name="lonlatID" id="lonlatID" value="${lonlatID }" />
<script>
function delPicture(name,path_name)
{

 	var send_json = "Json={\"name\":\""+name+"\",\"path_name\":\""+path_name+"\"}";
 	
	$.ajax({
		type : "POST",
		url :  "/itovManage/zdjsmanagement/zdjs/viewSpotPictureDel",
		data : send_json,
		dataType : "json",
		success : function(data, textStatus) {
			initPic();
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alertMsg.error("数据连接异常！");
		}
	}); 
}
function initPic()
{
    var lonlatID=$("#lonlatID").val()
    var lon=lonlatID.split("_")[0];
    var lat=lonlatID.split("_")[1];
    var send_json = "Json={\"lon\":"+lon+",\"lat\":"+lat+"}";
	$.ajax({
		type : "POST",
		url :  "/itovManage/zdjsmanagement/zdjs/viewSpotPicture1",
		data : send_json,
		dataType : "text",
		success : function(data, textStatus) {
			$("#display_div").html(data);
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alertMsg.error("数据连接异常！");
		}
	}); 
}
</script>
 <div class="pageFormContent" layoutH="60"> 
	<fieldset>
		<legend></legend>
<div id="display_div"></div>
	</fieldset>
</div>
<script type="text/javascript">
initPic();
</script>
