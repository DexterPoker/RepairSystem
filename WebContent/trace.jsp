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
<script  src="dhtmlxSuite/dhtmlxGrid/codebase/ext/dhtmlxgrid_filter.js"></script>
<title>Insert title here</title>
 <script>
var mygrid;
window.onload=function() {

    mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath("dhtmlxSuite/dhtmlxGrid/codebase/imgs/");
	mygrid.setHeader("维修单编号,物品编号名称,损坏描述,物品地址,维修人,状态,开始维修时间,结束维修时间,申请人,评价",null,["text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center","text-align:center"]);
	mygrid.setColAlign("center,center,center,center,center,center,center,center,center,center");
	mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro,ro,ro");
	mygrid.setColSorting("int,str,str,str,str,str,str,str,str,str");
	mygrid.setSkin("dhx_skyblue");
	mygrid.init();
	var url="ordergrid?method=all";
	mygrid.load(url,"json");
	
}
</script>
</head>
<div id="gridbox" style="width:600px;height:270px;background-color:white;"></div>
</body>
</html>