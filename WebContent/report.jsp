<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxForm/codebase/skins/dhtmlxform_dhx_skyblue.css">
<script src="dhtmlxSuite/dhtmlxForm/codebase/dhtmlxcommon.js"></script>
<script src="dhtmlxSuite/dhtmlxForm/codebase/dhtmlxform.js"></script>
    
<link rel="STYLESHEET" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>        
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/ext/dhtmlxgrid_filter.js"></script>
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
        label: "申请物品维修",
        inputWidth:"auto",
    list:[{
        type: "input",
        label: "物品编号",
        name:"assetsid",
        value: "",
        readonly:"true"
    }, {
        type: "input",
        label: "物品损坏描述",
        name:"description",
        value: "",
        rows:5,
        validate: "NotEmpty"
    }, {
        type: "button",
        name:"submit",
        value: "提交"
    }],}];
    myForm = new dhtmlXForm("myForm", formData);
    myForm.enableLiveValidation(true);
    myForm.attachEvent("onButtonClick", function() {
        //myForm.validate();
    	var assetsid = myForm.getItemValue("assetsid");
    	var description = myForm.getItemValue("description");
    	if(assetsid==null||assetsid=="")
    		{
    			alert("请从右边的表格中选取要维修的物品！");
    			return;
    		}
    	if (description==null||description=="")
    		{
    			alert("请认真填写损坏情况！");
    			return;
    		}
    	
    	//alert(assetsid);
    	var url="addorder";
    	param="assetsid="+assetsid+"&description="+description;
    	//var loader = dhtmlxAjax.postSync(url,param);
    	dhtmlxAjax.post(url,param,function (loader){
    		alert(loader.xmlDoc.responseText);
        	if(loader.xmlDoc.responseText=="success")
        		{
        			alert("申请维修成功");
        			//myForm.unload();
        			window.location.reload();
        			//mygrid.unload();
        		}
        	else
        		{
        			alert("申请维修失败,可能该物品已处于维修状态"); 
        			window.location.reload();
        		}
    	});
    });
    
    mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("dhtmlxSuite/dhtmlxGrid/codebase/imgs/");
	mygrid.setHeader("物品编号,物品名称,地址,类型",null,["text-align:center","text-align:center","text-align:center","text-align:center"]);
	//mygrid.setInitWidths("150,150,150,150");
	mygrid.attachHeader(",#text_filter,#text_filter,#text_filter");
	mygrid.setColAlign("center,center,center,center");
	mygrid.setColTypes("ro,ro,ro,ro");
	mygrid.setColSorting("int,str,str,str");
	mygrid.setSkin("dhx_skyblue");
	mygrid.init();
	var url="assetsgrid";
	mygrid.attachEvent("onRowSelect", doOnRowSelected);
	mygrid.load(url,"json");
	function doOnRowSelected(id) {
		//alert(mygrid.cells(id,2).getValue());
		//mygrid.setItem.value(level,"12345");
		myForm.setItemValue("assetsid", mygrid.cells(id,0).getValue());
	}
	
}
function myFunc(val) {
    return (val > 0);
}
</script>
</head>
<body><div id="myForm" style="height:510px;"></div>
<div id="gridbox" style="width:600px;height:270px;background-color:white;"></div>
</body>
</html>