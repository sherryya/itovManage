<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<script type="text/javascript">
    	var request;
    	function test(){
    	
    		if(window.XMLHttpRequest){
    			request = new XMLHttpRequest();
    		}else if(window.ActiveXObject){
    			request = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    		request.onreadystatechange = callback;
    		var s1 = document.getElementById("sa1").value;
    		
    		var url="personalmanagement/shop4s/citylist/"+s1;
    		request.open("get",url,true);
    		request.send(null);	
    	}
    	
    	
    	function callback(){
    		if(request.readyState==4){
    			if(200 == request.status){
    				var dom = request.responseXML;
    				var provinceEle = dom.getElementsByTagName("city");
    				innerContent(provinceEle);
    			}
    		}
    	} 	
    	function clearCity(){
    		var s2 = document.getElementById("sa2")
    		s2.length = 0;
    	}
    	function clearDistrict(){
    		var s3 = document.getElementById("sa3")
    		s3.length = 0;
    	}
    	
    	
    	function innerContent(provinceEle){
    		clearCity();
    		clearDistrict();  	
    		for(i = 0; i < provinceEle.length;i++){
    				var c_idEle = provinceEle[i].getElementsByTagName("c_id");
    				var c_id = c_idEle[0].firstChild.data;
    				var c_nameEle =  provinceEle[i].getElementsByTagName("c_name");
         			var c_name = c_nameEle[0].firstChild.data;
         			var s2 = document.getElementById("sa2");
         			s2[i] = new Option(c_name,c_id);					
    			}
    			test1();			
    	}
    	
    	function test1(){
    		if(window.XMLHttpRequest){
    			request = new XMLHttpRequest();
    		}else if(window.ActiveXObject){
    			request = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    		request.onreadystatechange = callback1;
    		var s2 = document.getElementById("sa2").value;
    	    var url1="personalmanagement/shop4s/countrylist/"+s2;
    		request.open("get",url1,true);
    		request.send(null);	
    	}
    	
    	function callback1(){
    		if(request.readyState==4){
    			if(200 == request.status){
    				var dom1 = request.responseXML;
    				var citeEle = dom1.getElementsByTagName("district");
    				innerContent1(citeEle);
    			}
    		}
    	} 
    	
    	
    	
    	function innerContent1(citeEle){
    		clearDistrict();		
    			for(i = 0; i < citeEle.length;i++){
    				var d_idEle = citeEle[i].getElementsByTagName("d_id");
    				var d_id = d_idEle[0].firstChild.data;
    				var d_nameEle =  citeEle[i].getElementsByTagName("d_name");
         			var d_name = d_nameEle[0].firstChild.data;
         			var s3 = document.getElementById("sa3");
         			s3[i] = new Option(d_name,d_id);        		
    			} 		
    	}	
</script>

<div class="pageContent">
	<form method="post" action="<c:url value='/personalmanagement/shop4s/insertShop4s?navTabId=shop4s&callbackType=closeCurrent'/>" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">			
		<p>
				<label>省份：</label>
				<select id="sa1" name="shop4s_province_id" onchange="test()"> 
							<option selected="selected" value="%">--请选择--</option>
									
				  			<c:forEach var="item" items="${proList2}" varStatus="s">
									<option value="${item.pId}">${item.pName}</option>
							</c:forEach>
				</select>
		</p>
				
		<p>
				<label>城市：</label>
				  	
			  	<select id="sa2" name="shop4s_city_id" onchange="test1()">
			  				  	<option selected="selected" value="%">--请选择--</option>
			  	
			  	</select>
		</p>	
	
		
		<p>
				<label>市区：</label>
				  	
		  	<select id="sa3" name="shop4s_country_id" >
				  				  	<option selected="selected" value="-9999">--请选择--</option>
			</select>
		</p>	
			
			
			
			<p>
				<label>4s店名：</label>
				<input name="shop4s_name" class="required" type="text" size="30"  alt="请输入店名"/>
			</p>
			<p>
				<label>地址：</label>
				<input name="shop4s_address" class="required" type="text" size="30"  alt="请输入地址"/>
			</p>
			<p>
				<label>责任人：</label>
				<input name="shop4s_principal"  type="text" size="30"  />
			</p>
			<p>
				<label>4s店联系电话：</label>
				<input name="shop4s_tel" class="phone" type="text" size="30"/>
			</p>
			
			<dl class="nowrap">
				<dt>4s店简介：</dt>
				<dd><textarea cols="45" rows="5" name="shop4s_note"></textarea></dd>
			</dl>

			
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

