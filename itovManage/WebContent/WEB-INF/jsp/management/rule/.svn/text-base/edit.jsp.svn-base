<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>


<div class="pageContent">
	<form method="post" action="demo/common/ajaxDone.html"  class="pageForm required-validate"   onsubmit="return validateCallback(this)">
		
		<ul id="t2" class="tree treeFolder treeCheck " oncheck="getClickContent">


			<li><a tname="name" tvalue="test1"  checked="true">Test 1</a>
				<ul>
					<li><a tname="name" tvalue="test1.1" checked="true">Test 1.1</a>
						<ul>
							<li><a tname="name" tvalue="test1.1.1" checked="true">Test 1.1.1</a></li>
							<li><a tname="name" tvalue="test1.1.2">Test 1.1.2</a></li>
						</ul>
					</li>
					<li><a tname="name" tvalue="test1.2">Test 1.2</a></li>
				</ul>
			</li>

		</ul>
		<input type="submit" value="Submit" />
	</form>
</div>
<div id="resultBox"></div>
<script type="text/javascript">
<% //System.out.println("%%%%%%%%%%%%%%%%%%%");       %>
function kkk(){
	var json = arguments[0], result="";
	
	alert(json.checked);
	$(json.items).each(function(i){
	alert(i);
		result += "<p>name:"+this.name+":"+this.checked + ": value:"+this.value+" text: "+this.text+"</p>";
	});
	
	 var oidStr=""; //定义一个字符串用来装值的集合    
    
//jquery循环t2下的所有选中的复选框    
  $("#t2 input:checked").each(function(i,a){    
    //alert(a.value);    
    oidStr +=a.value+',';  //拼接字符串    
  });    
  alert(oidStr); 
	
	
	var res=$("#resultBox").html();
	$("#resultBox").html(res+result);
}

function getClickContent()
{
 var oidStr=""; //定义一个字符串用来装值的集合 
   $("#t2 input:checked").each(function(i,a){    
    oidStr +=a.value+',';  //拼接字符串    
  }); 
  $("#resultBox").html(oidStr);
}
</script>