<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<title>Insert title here</title>
<style>
    html, body {
        width: 100%;
        height: 100%;
        margin: 0px;
        padding: 0px;
        overflow: hidden;
    }
    .hdr_ftr {
			height: 74px;
			background-color: white;
			border: 1px solid #a4bed4;
	}
	.hdr_ftr .text {
			font-family: 微软雅黑;
			font-size: 48px;
			margin: 5px 10px;
	}
</style>
</head>
<body bgcolor="#0099FF">
<div id="my_logo" class="hdr_ftr"><div class="text" >公物报修系统</div></div>
<div id="my_copy" class="hdr_ftr"><div class="" style="text-align:center">Hi! I'm copyright &copy;!</div></div>
<div id="bg" style="width:100%;height:100%;text-align:center"><img src="img/bg2.jpg"/></div>
	<s:form action="Login" method="post" id="loginform" style="padding:25%">
		<s:textfield name="user.userName" placeholder="用户名"></s:textfield>
		<s:password name="user.password" placeholder="密码"></s:password>
		<s:submit value="登陆"></s:submit>
	</s:form>
<script>
var dhxLayout,
dhxMenu;
window.onload=function() {
    dhxLayout = new dhtmlXLayoutObject(document.body, "2U");
    
    dhxLayout.cells("a").hideHeader();
    dhxLayout.cells("b").hideHeader();
    
    dhxLayout.cells("a").attachObject("bg");
    dhxLayout.cells("b").attachObject("loginform");
    
    dhxLayout.attachHeader("my_logo");
    dhxLayout.attachFooter("my_copy");
    
}
</script>
</body>
</html>