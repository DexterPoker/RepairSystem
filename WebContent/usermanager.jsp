<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	overflow: hidden;
}
</style>

<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>

<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxForm/codebase/skins/dhtmlxform_dhx_skyblue.css">
    <script src="dhtmlxSuite/dhtmlxForm/codebase/dhtmlxcommon.js"></script>
    <script src="dhtmlxSuite/dhtmlxForm/codebase/dhtmlxform.js"></script>

<script type="text/javascript" src="dhtmlxSuite/dhtmlxToolbar/codebase/dhtmlxcommon.js"></script>
<script type="text/javascript" src="dhtmlxSuite/dhtmlxToolbar/codebase/dhtmlxtoolbar.js"></script>
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxToolbar/codebase/skins/dhtmlxtoolbar_dhx_skyblue.css"></link>

<script>
var dhxLayout, toolbar;
window.onload=function() {
    dhxLayout = new dhtmlXLayoutObject(document.body, "1c");
    dhxLayout.cells("a").hideHeader();
    //dhxLayout.cells("b").hideHeader();
    //dhxLayout.cells("c").hideHeader();
	
    //dhxLayout.cells("b").setHeight(2);
    //dhxLayout.cells("c").setHeight(1);
    
    //dhxLayout.cells("a").attachObject(url);
    //dhxLayout.cells("b").attachObject("motifydiv");
    
    
    
    toolbar = dhxLayout.attachToolbar();
    toolbar.setIconsPath("dhtmlxSuite/dhtmlxToolbar/samples/common/imgs/");
    toolbar.addButton("new", 0, "新建用户", "open.gif", "open_dis.gif");
    toolbar.addSeparator("sep1", 1);
    toolbar.addButton("mofity", 2, "修改用户信息", "save.gif", "save_dis.gif");
    toolbar.addSeparator("sep2", 3);
    toolbar.addButton("delete", 4, "删除用户", "save_as.gif", "save_as_dis.gif");
    toolbar.attachEvent("onClick", function(id) {
    	if(id=='new') newuser();
    	else if(id=='mofity') motifyuser();
    	else if(id=='delete');
    });
    toolbar.setIconSize(32);
}
</script>
<script type="text/javascript">
	function newuser() {
		//document.getElementById("newdiv").style.visibility="visible";
		//document.getElementById("motifydiv").style.visibility="hidden";
		dhxLayout.cells("a").attachURL("adduser.jsp");
		}
	function motifyuser() {
		//document.getElementById("motifydiv").style.visibility="visible";
		//document.getElementById("newdiv").style.visibility="hidden";
		dhxLayout.cells("a").attachURL("http://tv.sohu.com");
		}
	function deleteuser() {
		//document.getElementById("newdiv").style.visibility="visible";
		}
</script>
</head>
<body>
<div id = "newdiv" style="visibility:hidden;">
<s:form action="Login" method="post" id="loginform">
		<s:textfield name="user.userName" placeholder="用户名"></s:textfield>
		<s:password name="user.password" placeholder="密码"></s:password>
		<s:submit value="登陆"></s:submit>
	</s:form>
</div>
<div id="motifydiv"><ul class="dhtmlxForm" name="myForm">
     <li ftype="fieldset" name="data" inputWidth="auto">Welcome
        <ul>
             <li ftype="input" name="name">Login</li>
             <li ftype="password" name="pass">Password</li>
	     <li ftype="button" name="save" value="Proceed"/>
        </ul>
     </li>
</ul></div>
</body>
</html>