<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxForm/codebase/skins/dhtmlxform_dhx_skyblue.css">
    <script src="dhtmlxSuite/dhtmlxForm/codebase/dhtmlxcommon.js"></script>
    <script src="dhtmlxSuite/dhtmlxForm/codebase/dhtmlxform.js"></script>
    <script type="text/javascript"></script>
<title>Insert title here</title>
 <script>
var myForm,
formData;
window.onload=function() {
    formData = [{
        type: "settings",
        position: "label-left",
        labelWidth: 130,
        inputWidth: 160
    }, {
        type: "fieldset",
        label: "新建用户",
        inputWidth:"auto",
    list:[{
        type: "input",
        label: "用户名",
        name:"name",
        value: "",
        validate: "NotEmpty"
    }, {
        type: "password",
        label: "密码",
        name:"pwd1",
        value: "",
        validate: "NotEmpty"
    }, {
        type: "password",
        label: "确认密码",
        name:"pwd2",
        value: "",
        validate: "NotEmpty,pwdCheck"
    }, {
        type: "select",
        label: "用户权限",
        name:"level",
        validate: "myFunc",
        options: [{
            value: 0,
            text: ""
        }, {
            value: 1,
            text: "普通用户"
        }, {
            value: 2,
            text: "管理员"
        },{
            value: 3,
            text: "维修员"
        }]
        }, {
        type: "button",
        name:"submit",
        value: "提交"
    }],}];
    myForm = new dhtmlXForm("myForm", formData);
    myForm.enableLiveValidation(true);
    myForm.attachEvent("onButtonClick", function() {
        //myForm.validate();
    	var pwd1 = myForm.getItemValue("pwd1");
    	var pwd2 = myForm.getItemValue("pwd2");
    	var name = myForm.getItemValue("name");
    	var level = myForm.getItemValue("level");
    	if(name==null||name=="")
    		{
    			alert("用户名不能为空！");
    			return;
    		}
    	if (pwd1==null||pwd1=="")
		{
			alert("密码不能为空！");
			return;
		}	
    	if (pwd2==null||pwd2=="")
		{
			alert("密码确认不能为空！");
			return;
		}
    	if (pwd1!=pwd2)
    		{
    			alert("两次密码输入不同！");
    			return;
    		}
    	if(level==null||level==""||level==0)
    		{
    			alert("权限不能为空!");
    			return;
    		}
    	if(level==1)
    		level="normal";
    	else if(level==2)
    		level="admin";
    	else if(level==3)
    		level="repairer"; 
    	var url="adduser";
    	var param="name="+name+"&pwd="+pwd1+"&level="+level;
    	dhtmlxAjax.post(url,param,function (loader){
    		//alert(loader.xmlDoc.responseText);
        	if(loader.xmlDoc.responseText=="success")
        		{
        			alert("添加用户成功");
        			myForm.unload();
        		}
        	else
        		{
        			alert("添加用户失败"); 
        			window.location.reload();
        		}
    	});
    });
}
function myFunc(val) {
    return (val > 0);
}
function pwdCheck()
{
	var pwd1 = myForm.getItemValue("pwd1");
	var pwd2 = myForm.getItemValue("pwd2");
	if(pwd2==null||pwd2=="")
		return false;
	if (pwd1==pwd2) return true;
	else
		{
			alert("两次密码输入不同！"); 
			return false;
		}
}
</script>
</head>
<body><div id="myForm" style="height:510px;"></div>
</body>
</html>