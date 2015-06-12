var maplet = null;
var marker = null;
var  markerArr_mark = new Array();/*标注点*/
/**
 * 地图初始化
 */
function initMap() {
	maplet = new Maplet("mapbar");
	maplet.centerAndZoom(new MPoint('126.64742,45.75183'), 13);
	maplet.addControl(new MStandardControl());
    var str_deviceuid=$("#deviceuid").val();
	var str_date=$("#date").val();
	var str_starttime=$("#starttime").val();
	var str_endtime=$("#endtime").val();
	getViewSpotAllPoi(str_deviceuid);//显示所有景点
	carGj(str_deviceuid,str_date,str_starttime,str_endtime);//显示轨迹
}
function initMap_All() {
	maplet = new Maplet("mapbar");
	maplet.centerAndZoom(new MPoint('126.64742,45.75183'), 13);
	maplet.addControl(new MStandardControl());
	var str_deviceuid=$("#deviceuid").val();
	getViewSpotAllPoi(str_deviceuid);//显示所有景点
}
/**
 * 显示所有景点
 * @param deviceuid
 */
function getViewSpotAllPoi(deviceuid) {
	var send_json = 'Json={"deviceuid":"'+ deviceuid+ '"}';
	$.ajax({
		type : "POST",
		url :  "/itovManage/zdjsmanagement/zdjs/resolveJsonObjectForMap",
		data : send_json,
		dataType : "json",
		success : function(data, textStatus) {
			$.each(data, function(i,items){
				addPoi(items["lonlat"],items["spot_note3"]);
				});	
			  
			 for( var i=0;i<markerArr_mark.length;i++)
			  {
			     maplet.removeOverlay(markerArr_mark[i]); 
			  }
		},
		error : function(XMLHttpRequest, textStatus, errorThrown) {
			alertMsg.error("数据连接异常！");
		}
	}); 
}
/**
 * 添加景点气泡
 * @param mpoint
 * @param name
 */
function addPoi(mpoint,name)
{       
	var arr=mpoint.split(",");
	var name="<a style='cursor:pointer;' ref=\"dlg_page1\"  onclick=a_click1(\"{'lon':"+arr[0]+",'lat':"+arr[1]+"}/"+arr[1]+"\");  target=\"dialog\" mask=\"true\" width=\"800\"  height=\"600\" title=\"查看景点信息\" >"+name+"</a>";
    marker = new MMarker(
         new MPoint(mpoint),
		 new MIcon('<img style="width:20px;height:20px;cursor:pointer;" title=\"右键删除\" src="/itovManage/styles/images/map/markerred.gif"/>',20,20),
         null, 
		 new MLabel(name,-10,-13)
         );
	 var menu = new MContextMenu(); 
	 marker.setContextMenu(menu);  
     addMenuItems();
	 maplet.addOverlay(marker);
}

function a_click1(url)
{

  $("#a_id").attr("href","/itovManage/zdjsmanagement/zdjs/infoedit/"+url);
  $("#a_id").trigger("click")
}
/**
 * 添加右键菜单
 */
function addMenuItems() {  
	  
    var menu = marker.contextmenu;  
    menu.addItem(new MContextMenuItem("<font color='red'>删除</font>",callbackFunction));   
}
/**
 * 右键菜单回调函数
 * @param contextMenu
 * @param contextMenuItem
 * @param overlay
 */
function callbackFunction(contextMenu,contextMenuItem,overlay)
{
	alertMsg.confirm("确定要删除此景点吗？", {
		okCall: function(){
/*			alert(overlay.pt.lon);
		 	alert(overlay.pt.lat);*/
		 	var send_json = 'Json={"lonlat":"'+ overlay.pt.lon+"_"+overlay.pt.lat+ '"}';
			$.ajax({
				type : "POST",
				url :  "/itovManage/zdjsmanagement/zdjs/resolveJsonObjectForDelViewSpot",
				data : send_json,
				dataType : "json",
				success : function(data, textStatus) {
					maplet.removeOverlay(overlay);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					alertMsg.error("数据连接异常！");
				}
			}); 
		 	
		}
	});
}


var aryPts = "";
var counter = 0;
var timer1 = null;
var pline = null;

function mode2_start(vPoint) {
	pline=null;
	aryPts="";
	counter = 0; 
	line_brush = new MBrush("green");
                    line_brush.arrow = true;
                    line_brush.stroke = 5;
                    line_brush.overlap.enable = true; 
	if (vPoint != "") {
		aryPts = vPoint.split("!");
		for ( var i = 0; i < aryPts.length; i++) {
			aryPts[i] = new MPoint(aryPts[i]);
		}
		 /*如果动态画轨迹 屏蔽下面三行  打开  startTimer*/
		  maplet.setCenter(aryPts[1]);  
		  pline = new MPolyline(aryPts,line_brush);  
          maplet.addOverlay(pline);  
		//startTimer();
	}
}
/*
function startTimer() {
	timer1 = window.setInterval(drawLine, 50);
}
function drawLine() {
 if(!pline) {  
                pline = new MPolyline([aryPts[0],aryPts[1]],line_brush);  
                maplet.addOverlay(pline);  
                counter++;  
            } else {  
                pline.appendPoint(aryPts[counter],false);  
                maplet.setCenter(aryPts[counter]);  
            }  

	counter++;
	if (counter >= aryPts.length - 1) {

		window.clearInterval(timer1);
	}
}*/
/**
 * 画轨迹的主函数
 * @param deviceuid
 * @param dates
 * @param starttime
 * @param endtime
 */
function carGj(deviceuid, dates, starttime, endtime) {
	maplet.clearOverlays();
	var points = "";
	var send_json = 'orderJson={"deviceuid":"'+ deviceuid+ '","date":"'+ dates+ '","starttime":"'+ starttime + '","endtime":"' + endtime + '"}';
	$.ajax({
		type : "post",
		dataType : "json",
		url : "/itovManage/zdjsmanagement/zdjs/resolveJsonObject",
		data : send_json,
		cache : false,
		success : function(msg) {
          if (msg.Status == '1') {
				points = msg.Lonlat;
				if (points != "") {
					mode2_start(points);
				}
			} else {
				alertMsg.error("数据连接异常！");
			}
		},
		error : function() {
				alertMsg.error("数据连接异常！");
		}
	});
}
function DateDemo(){
	   var d, s=""; ;           // 声明变量。
	   d = new Date();                           // 创建 Date 对象。
	   s += d.getYear()+"";                         // 获取年份。
	   s += ((d.getMonth() + 1)+"");  // 获取月份。
	   s += (d.getDate()+"");         // 获取日。
	   s += (d.getHours()+"");        // 获取时。
	   s += (d.getMinutes()+"");       // 获取分。
	   s += (d.getSeconds()+"");       // 获取秒。
	   s +=(d.getMilliseconds()+"");
	   s+=(parseInt(Math.random()*(999-100+1)+100)+"");
	   return s;                                // 返回日期。
}
function onBookmark(dataObj) { 
	addPoiMark(dataObj);
   }
/**
 * 标记点
 * @param dataObj
 */
function addPoiMark(dataObj)
{	
    var lon=dataObj.point.lon;
	var lat=dataObj.point.lat;
    var id=DateDemo();
    var marker = new MMarker(   
	new MPoint(lon+","+lat), 
	//new MIcon("/itovManage/styles/images/map/markerred.gif",32,32)
	new MIcon('<div id="div'+id+'"  class="mapBookmark" onclick="a_click();"></div>',16,21)  	
    );  		   
    //maplet.setIwStdSize(375,235);  
     markerArr_mark.push(marker); 

     maplet.addOverlay(marker);  
    //marker.setEditable(true); 
    //MEvent.addListener(maplet, "edit", dragEnd); 
    maplet.setMode("pan"); 
   var json= "{\"lon\":"+lon+",\"lat\":"+lat+"}";
   $("#a_id").attr("href","/itovManage/zdjsmanagement/zdjs/infoedit/"+json+"/"+lon);

   $("#a_id").trigger("click")	
} 
function a_click()
{
 // $("#a_id").trigger("click")
}
/* 		 function dragEnd(overlay) {
	   
        setTimeout(function() {  
            alert("新位置经纬度：" + overlay.pt.pid);  
           // overlay.setEditable(false);  
        },500);  
    }  */ 
function changeModel() {

var b = document.documentElement.clientWidth;
var bb = document.documentElement.clientHeight;
var did_w;
var did_h;
if ($.browser.msie) {
	did_w = 17;
	did_h = 73;
} else {
	did_w = 18;
	did_h = 33;
}
$("#mapbar").height(bb - did_h);
$("#mapbar").width(b - did_w);
}

