<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<link rel="STYLESHEET" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>        
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>
<script>
window.onload = function()
{
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("dhtmlxSuite/dhtmlxGrid/codebase/imgs/");
	mygrid.setHeader("编号,用户名,密码,权限",null,["text-align:center","text-align:center","text-align:center","text-align:center"]);
	mygrid.setInitWidths("150,150,150,150");
	mygrid.setColAlign("center,center,center,center");
	mygrid.setColTypes("ro,ro,ed,coro");
	mygrid.setColSorting("int,str,str,str");
	mygrid.getCombo(3).put("admin", "管理员");
	mygrid.getCombo(3).put("repairer", "维修员");
	mygrid.getCombo(3).put("admin", "普通用户");
	mygrid.setSkin("dhx_skyblue");
	mygrid.init();
	var url="usergrid";
	mygrid.load(url,"json");
	mygrid.attachEvent("onEditCell", doOnCellEdit);
	function doOnCellEdit(stage, rowId, cellInd) {
	    if (stage == 0) {
	    	
	    } else if (stage == 1) {
	    	
	    } else if (stage == 2) {
	    	var url="usermotify?cellid="+cellInd+"&value="+mygrid.cells(rowId,cellInd).getValue()+"&id="+mygrid.cells(rowId,0).getValue();
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
	    	});
	    }
	    return true;
	}
}
</script>
<body>
<div id="gridbox" style="width:600px;height:270px;background-color:white;"></div>
</body>
</html>