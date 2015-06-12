<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include	file="/include.inc.jsp"%>

<!-- <script type="text/javascript"	src="http://api.mapbar.com/api/mapbard31.3.js"></script> -->
<input type="hidden" name="deviceuid" id="deviceuid" value="${deviceuid }" />
<script src="<c:url value='/styles/js_handle/map.js'/>" type="text/javascript"></script>

<div class="pageContent" style="padding: 0px;">
		<a id="a_id" style="display:none;" ref="dlg_page2" href="/itovManage/zdjsmanagement/zdjs/infoedit/" target="dialog" mask="true" width="800"  height="600" title="上传景点信息" ></a>
		
	
		<div id="mapbar"  style="position:relative; top:0;left:0;width:1330px;height:535px;border:1px solid #ccc;"></div>
		
		<div id="div_controls" style="position:absolute;  right:5px;top:5px; ">
		<img src="/itovManage/styles/images/map/a1.png"  id="Image1"   
			onMouseOver="MM_swapImage('Image1','','/itovManage/styles/images/map/b1.png',1)"
			onMouseOut="MM_swapImgRestore()"
			onClick="javascript:maplet.setMode(1)"> 
	    <img
			src="/itovManage/styles/images/map/a2.png" id="Image2"
			onMouseOver="MM_swapImage('Image2','','/itovManage/styles/images/map/b2.png',1)"
			onMouseOut="MM_swapImgRestore()"
			onClick="javascript:maplet.setMode(2)">
        <img
			src="/itovManage/styles/images/map/a3.png" id="Image3"
			onMouseOver="MM_swapImage('Image3','','/itovManage/styles/images/map/b3.png',1)"
			onMouseOut="MM_swapImgRestore()"
			onClick="javascript:maplet.setMode(3)"> 
		<img src="/itovManage/styles/images/map/a5.png" id="Image5"
			onMouseOver="MM_swapImage('Image5','','/itovManage/styles/images/map/b5.png',1)"
			onMouseOut="MM_swapImgRestore()"
			onClick="javascript:maplet.clearOverlays();maplet.setMode(3)">
		<img src="/itovManage/styles/images/map/a6.png" id="Image6"
			onMouseOver="MM_swapImage('Image6','','/itovManage/styles/images/map/b6.png',1)"
			onMouseOut="MM_swapImgRestore()"
			onClick="javascript:window.focus();window.print()"> <img
			src="/itovManage/styles/images/map/a7.png" id="Image7"
			onMouseOver="MM_swapImage('Image7','','/itovManage/styles/images/map/b7.png',1)"
			onMouseOut="MM_swapImgRestore()"
			onClick="javascript:maplet.setMode(11)">
		<img
			src="/itovManage/styles/images/map/a4.png" id="Image4"
			onMouseOver="MM_swapImage('Image4','','/itovManage/styles/images/map/b4.png',1)"
			onMouseOut="MM_swapImgRestore()"
			onClick="javascript:maplet.setCursorIcon('/itovManage/styles/images/map/icon1.png');maplet.setMode('bookmark',onBookmark)">

	</div>
</div>
<script>
initMap_All();
changeModel();
</script>