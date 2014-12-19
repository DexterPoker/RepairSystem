<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    
<link rel="STYLESHEET" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.css">
<link rel="stylesheet" type="text/css" href="dhtmlxSuite/dhtmlxGrid/codebase/skins/dhtmlxgrid_dhx_skyblue.css">
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgrid.js"></script>        
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxgridcell.js"></script>
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/dhtmlxcommon.js"></script>
<title>Insert title here</title>
 <script>
var mygrid;
window.onload=function() {

    mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("dhtmlxSuite/dhtmlxGrid/codebase/imgs/");
	mygrid.setHeader("维修单编号,物品编号名称,损坏描述,物品地址,维修人,状态,开始维修时间,结束维修时间,申请人,评价,删除",null,["text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center"]);
	mygrid.setColAlign("center,center,center,center,center,center,center,center,center,center,center");
	mygrid.setColTypes("ro,ro,ed,ro,ro,ro,ro,ro,ro,ro,ch");
	mygrid.setColSorting("int,str,str,str,str,str,str,str,str,str,str");
	mygrid.setSkin("dhx_skyblue");
	mygrid.init();
	var url="ordergrid?method=nottaken";
	mygrid.load(url,"json");
	mygrid.attachEvent("onEditCell", doOnCellEdit);
	mygrid.attachEvent("onCheckbox", doOnCheck);
	function doOnCheck(rowId, cellInd, state) {
		if (confirm("Are you sure you want to delete or not delete row")) {
			var url="motifyorder?id="+mygrid.cells(rowId,0).getValue()+"&value="+mygrid.cells(rowId,cellInd).getValue()+"&function=delete";
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
	function doOnCellEdit(stage, rowId, cellInd) {
	    if (stage == 0) {
	    	
	    } else if (stage == 1) {
	    	
	    } else if (stage == 2) {
	    	var url="motifyorder";
	    	var param = "cellid="+cellInd+"&value="+mygrid.cells(rowId,cellInd).getValue()+"&id="+mygrid.cells(rowId,0).getValue();
	    	dhtmlxAjax.post(url,param,function(loader){
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
</head>
<div id="gridbox" style="width:600px;height:270px;background-color:white;"></div>
</body>
</html>