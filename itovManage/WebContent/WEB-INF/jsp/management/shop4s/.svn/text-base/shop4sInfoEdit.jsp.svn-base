<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include	file="/include.inc.jsp"%>
<%@ page import="dwz.manageRest.dto.TItov_Shop4s_manage"%>
<%@ page import="java.util.List"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"	+ request.getServerName() + ":" + request.getServerPort()	+ path + "/";
%>
<script>
  $(function(){
	 var t =  $("#shop4s_id").val();
	 if(!Math.abs(t) <= 1e-15)
	 {
		 $("#setAccount").addClass("buttonDisabled");
		 $("#setAccount").attr("disabled",true);
		 
		 $("#hideSetAccount").hide();
	 }
	  
  });
</script>
<script type="text/javascript">
    	var request;
    	function test(){
    	
    		if(window.XMLHttpRequest){
    			request = new XMLHttpRequest();
    		}else if(window.ActiveXObject){
    			request = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    		request.onreadystatechange = callback;
    		var s1 = document.getElementById("se1").value;
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
    		var s2 = document.getElementById("se2")
    		s2.length = 0;
    	}
    	function clearDistrict(){
    		var s3 = document.getElementById("se3")
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
         			var s2 = document.getElementById("se2");
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
    		var s2 = document.getElementById("se2").value;
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
         			var s3 = document.getElementById("se3");
         			s3[i] = new Option(d_name,d_id);        		
    			} 		
    	}	
</script>
<div class="pageContent">
	<form method="post"
		action="<c:url value='/personalmanagement/shop4s/editShop4sInfo'/>"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,navTabAjaxDone);">
		<div class="pageFormContent" layoutH="56">
		<c:forEach var="shop4sList" items="${shop4sList}" varStatus="s">
		<p>
		<input type="hidden" id ="shop4s_id" value="${shop4s_id}">
		<input type="hidden" name="shop4s_id" value="${shop4sList.shop4s_id}" />
		    <label>4s店：</label>
				<input name="shop4s_name" class="required"  type="text" size="30"  value="${shop4sList.shop4s_name}"/>
			</p>
			<p>
				<label>地址：</label>
				<input name="shop4s_address" class="required" type="text" size="30" value="${shop4sList.shop4s_address}"/>
			</p>
			
			<p>
				<label>负责人：</label>
				<input name="shop4s_principal" class="required" type="text" size="30" value="${shop4sList.shop4s_principal}"/>
			</p>
			
			<p>
					<label>省份：</label>
					<select id="se1" name="shop4s_province_id" onchange="test()"> 							
					  			
					  			<c:forEach var="item" items="${proList2}" varStatus="s">	
					  					<option value="${item.pId}" <c:if test="${item.pId eq shop4sList.shop4s_province_id}">selected</c:if>>${item.pName}</option>
					  					<!-- 			
										<option value="${item.pId}" ${shop4sList.shop4s_principal==item.pId}?selected:"">${item.pName}</option>
										 -->	
								</c:forEach>
							
					</select>
			</p>
					
			<p>
					<label>城市：</label>
					  	
				  	<select id="se2" name="shop4s_city_id" onchange="test1()">			  		
										<option value="${shop4sList.shop4s_city_id}">${shop4sList.shop4s_city_name}</option>
										 	  				  	
				  	</select>
			</p>	
		
			
			<p>
					<label>市区：</label>
					  	
			  	<select id="se3" name="shop4s_country_id" >
					  					<option value="${shop4sList.shop4s_country_id}">${shop4sList.shop4s_country_name}</option>		  						
				</select>
			</p>
			<!--  
			<p>
				<label>性  别：</label>
				<select name="shop4s_province_id" class="required combox" readonly="readonly" >
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
			-->

			<p>
				<label>联系电话：</label>
				<input name="shop4s_tel" class="phone" type="text" size="30" value="${shop4sList.shop4s_tel}"/>
			</p>
		
			<br>
			<div class="divider"></div>
			<dl class="nowrap">
				<dt>个人简介：</dt>
				<dd><textarea cols="45" rows="5" name="shop4s_note" value="${shop4sList.shop4s_note}">${shop4sList.shop4s_note}</textarea></dd>
			</dl>
		    <div class="divider"></div>
		    </br>
		    <div>
		    
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
