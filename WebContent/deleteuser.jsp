<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="STYLESHEET" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>        
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>

<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxlayout.css">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxLayout/codebase/skins/dhtmlxlayout_dhx_skyblue.css">
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxcommon.js"></script>
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxlayout.js"></script>
<script src="dhtmlxSuite/dhtmlxLayout/codebase/dhtmlxcontainer.js"></script>
<style>
html, body {
	width: 100%;
	height: 100%;
	margin: 0px;
	overflow: hidden;
}
</style>
<script>
window.onload = function()
{
	dhxLayout = new dhtmlXLayoutObject(document.body, "1c");
    dhxLayout.cells("a").setText("删除用户");
	
	mygrid = dhxLayout.cells("a").attachGrid();
	mygrid.setImagePath("dhtmlxSuite/dhtmlxGrid/codebase/imgs/");
	mygrid.setHeader("id,name,password,level,delete",null,["text-align:center","text-align:center","text-align:center","text-align:center","text-align:center"]);
	//mygrid.setInitWidths("150,150,150,150,150");
	mygrid.setColAlign("center,center,center,center,center");
	mygrid.setColTypes("ro,ed,ro,ro,ch");
	mygrid.setColSorting("int,str,str,str,str");
	mygrid.setSkin("dhx_skyblue");
	mygrid.init();
	var url="usergrid";
	mygrid.load(url,"json");
	mygrid.attachEvent("onCheckbox", doOnCheck);
	function doOnCheck(rowId, cellInd, state) {
		if (confirm("Are you sure you want to delete or not delete row")) {
			var url="userdelete?id="+mygrid.cells(rowId,0).getValue()+"&state="+mygrid.cells(rowId,cellInd).getValue();
			dhtmlxAjax.get(url,function(loader){
				if(loader.xmlDoc.responseText=="success")
    			{
    				alert("success");
    				return true;
    			}
    		else
    			{
    				alert("fail");
    				return false;
    			}
			}) 
					//alert(mygrid.cells(rowId,cellInd).getValue());
	        return true;
	    }
		else {
			//state=!state;
			//alert(state);
			//alert(mygrid.cells(rowId,cellInd).getValue());
			if(mygrid.cells(rowId,cellInd).getValue()==0)
				mygrid.cells(rowId,cellInd).setValue(1);
			else if(mygrid.cells(rowId,cellInd).getValue()==1)
				mygrid.cells(rowId,cellInd).setValue(0);
	        return true;
	    }
	}
}
</script>
</head>
<body>
</body>
</html>