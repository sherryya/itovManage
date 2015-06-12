<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
<script type="text/javascript">
    	var request;
    	function test(){
    		if(window.XMLHttpRequest){
    			request = new XMLHttpRequest();
    		}else if(window.ActiveXObject){
    			request = new ActiveXObject("Microsoft.XMLHTTP");
    		}
    		request.onreadystatechange = callback;
    		var s1 = document.getElementById("s1").value;
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
    		var s2 = document.getElementById("s2")
    		s2.length = 0;
    	}
    	function clearDistrict(){
    		var s3 = document.getElementById("s3")
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
         			var s2 = document.getElementById("s2");
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
    		var s2 = document.getElementById("s2").value;
    		//var url1 = "index3.jsp?c_id=" + s2;
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
         			var s3 = document.getElementById("s3");
         			s3[i] = new Option(d_name,d_id);        		
    			} 		
    	}	
</script>

<form method="post" rel="pagerForm" action="<c:url value='/personalmanagement/shop4s/list'/>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<li>
			<select id="s1" name="pId" onchange="test()"> 	
			  	<option selected="selected" value="%">--请选择--</option>
			  			<c:forEach var="item" items="${proList}" varStatus="s">
								<option value="${item.pId}" >${item.pName}</option>
						</c:forEach>
			  	</select>
			  	
			  	<select id="s2" name="cId" onchange="test1()">
			  		<option selected="selected" value="%">--请选择--</option>
			  	</select>
			  	
			  	<select id="s3" name="dId" >
			  		<option selected="selected" value="%">--请选择--</option>
			  	</select>
		</li>
	
		<div class="subBar">
			<span style="margin-left: 5px; line-height: 25px; float: left">总记录数: <strong>${vo.totalCount}</strong></span>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查                  询</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/shop4s/add'/>" title="4s添加"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="personalNav" href="<c:url value='/personalmanagement/shop4s/edit/{slt_objId}'/>" title="4s修改"><span>修改</span></a></li>
<%-- 			<li><a class="delete" target="ajaxTodo" href="<c:url value='/management/test/delete/{slt_testId}'/>" title="您确定要删除吗?"><span>删除</span></a></li> --%>
			<li><a class="edit" target="navTab" rel="newsNav" href="<c:url value='/personalmanagement/shop4s/querylist/{slt_objId}'/>" title="查看用户"><span>查看用户</span></a></li>
			<li><a class="edit" target="navTab" rel="newsNav" href="<c:url value='/personalmanagement/shop4s/adduser/{slt_objId}'/>" title="导入用户"><span>导入用户</span></a></li>
			
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
	<thead>
			<tr>
				<th width="5%">序号</th>
				<th width="5%">4s店</th>
				<th width="5%">地址</th>
			    <th width="5%">责任人</th>
				<th width="5%">4S店电话</th>
				<th width="5%">所在省份</th>
				<th width="5%">所在市</th>
				<th width="5%">所在区</th>
				<th width="5%">是否使用</th>
				<th width="25%">简介</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="item" items="${userList}" varStatus="s">
			<tr target="slt_objId" rel="${item.shop4s_id }">
				<td>${s.index + 1}</td>
				<td>${item.shop4s_name}</td>
				<td>${item.shop4s_address}</td>
				<td>${item.shop4s_principal}</td>
				<td>${item.shop4s_tel}</td>
			    <td>${item.shop4s_province_name}</td>
				<td>${item.shop4s_city_name}</td>
				<td>${item.shop4s_country_name}</td>
				<td>${item.shop4s_isuse}</td>
				<td>${item.shop4s_note}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>