<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>
<!-- 引入文件上传样式文件 -->
<link href="<c:url value='/styles/css/uploadify.css'/>" rel="stylesheet"
	type="text/css" />
<script src="<c:url value='/styles/js_handle/jquery.uploadify.min.js'/>"
	type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('#file_upload').uploadify({
			'swf' : "<c:url value='/styles/css/uploadify.swf'/>",
			'uploader' : "<c:url value='/pushmanagement/video/insertFile'/>",
			'auto' : true,
			'width' : 100,
			'height' : 20,
			'multi' : false,
			'method' : "post",
			'fileObjName' : 'uploadify',
			'fileSizeLimit' : '600MB',
			'fileTypeDesc' : 'MP4 Files',
			'fileTypeExts' : '*.mp4; *.MP4',
			buttonText : '请选择视频',
			'removeCompleted' : false,
			'onUploadSuccess' : function(file, data, response) {
				/* 	$("#shownode").append(
							"<p>已成功上传" + file.name + "文件</p>"); */
				$("#fileNames").val(file.name);
			},
			'onQueueComplete' : function(queueData) {
				//alert(queueData.uploadsSuccessful + ' 个文件上传成功！');
				/* 				$("#fileNames").append(
										"<p>已成功上传"
												+ queueData.uploadsSuccessful
												+ "个文件</p>"); */
			}
		});
		//
		$('#pic_upload').uploadify({
			'swf' : "<c:url value='/styles/css/uploadify.swf'/>",
			'uploader' : "<c:url value='/pushmanagement/video/insertFile_Pic'/>",
			'auto' : true,
			'width' : 100,
			'height' : 20,
			'multi' : false,
			'method' : "post",
			'fileObjName' : 'uploadify_pic',
			'fileSizeLimit' : '600MB',
			'fileTypeDesc' : 'PNG Files',
			'fileTypeExts' : '*.PNG; *.png',
			buttonText : '请选择视频',
			'removeCompleted' : false,
			'onUploadSuccess' : function(file, data, response) {
				/* 	$("#shownode").append(
							"<p>已成功上传" + file.name + "文件</p>"); */
				$("#picNames").val(file.name);
			},
			'onQueueComplete' : function(queueData) {
				//alert(queueData.uploadsSuccessful + ' 个文件上传成功！');
				/* 				$("#fileNames").append(
										"<p>已成功上传"
												+ queueData.uploadsSuccessful
												+ "个文件</p>"); */
			}
		});
	});
</script>

<div class="pageContent">
	<form method="post"
		action="<c:url value='/pushmanagement/video/insert?navTabId=Video&callbackType=closeCurrent'/>"
		class="pageForm required-validate"
		onsubmit="return validateCallback(this,dialogAjaxDone);">
		<div class="pageFormContent" layoutH="57">
			<p>
				<label> 视频分类信息</label>
				<!-- 视频类型选择 -->
				<select class="combox" name="videoType" ref="videoChild"  refUrl="<c:url value='/pushmanagement/video/gainVideoType?code={value}'/>" >
				    <option value="0">主类型</option>
					<option value="1">体育</option>
					<option value="2">游戏</option>
					<option value="3">汽车</option>
					<option value="4">资讯</option>
					<option value="5">搞笑</option>
					<option value="6">原创</option>
					<option value="7">娱乐</option>
				</select>
				<!-- 视频子类型选择 -->
				<select class="combox" name="videoChild" id="videoChild">
					<option value="0">子类型</option>
				</select>
			</p>
			<p>
				<label> 关键子分类信息</label>
				<!-- 推荐热门 -->
				<select class="combox" name="hotrecommand">
					<option value="0">推荐</option>
					<option value="1">今日热点</option>
					<option value="2">娱乐热点</option>
					<option value="3">综艺</option>
					<option value="4">电视剧</option>
					<option value="5">音乐</option>
					<option value="6">美女主播</option>
					<option value="7">我秀主播</option>
					<option value="8">原创热点</option>
				</select> <select class="combox" name="typerecommand">
					<option value="0">热门</option>
					<option value="1">热点</option>
					<option value="2">原创</option>
					<option value="3">动漫</option>
					<option value="4">音乐</option>
					<option value="5">体育</option>
					<option value="6">游戏</option>
					<option value="7">女性</option>
					<option value="8">搞笑</option>
					<option value="9">汽车</option>
					<option value="10">科教</option>
				</select>
			</p>

			<p>
				<label> 视频详细信息 标题:</label><input type="text" alt="请输入视频标题"
					name="videoTitle">
			</p>
			<p>
				<label> 视频详细信息 时长:</label><input type="text" alt="请输入视频时长"
					name="videoSize">
			</p>
			<p>
				<!-- 在此处采用全新的表单提交视频内容 -->
				<label> 视频详细信息 内容:</label> <input id="file_upload" type="file"
					name="file_upload" />
				<label> 视频详细信息 截图</label> <input id="pic_upload" type="file"
					name="shot_upload" />
			</p>
			<p>
				
			</p>
			 <input id="fileNames" name="fileNames" type="hidden" />
			 <input id="picNames" name="picNames" type="hidden" />
			<div id="fileQueue" class="fileQueue"></div>
		</div>

		<div class="formBar">
			<ul>
				<li><div class="buttonActive">
						<div class="buttonContent">
							<!-- 此处点击保存将上传后文件根据文件生成的URL几相应的视频信息通过调用服务保存到数据库中 -->
							<button type="submit">保存</button>
						</div>
					</div></li>
				<li><div class="button">
						<div class="buttonContent">
							<button type="button" class="close">关闭</button>
						</div>
					</div></li>
			</ul>
		</div>
	</form>
</div>
