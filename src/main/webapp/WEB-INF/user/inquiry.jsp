<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Model.companytable"%>
<!DOCTYPE html>
<%
	companytable comp =(companytable) session.getAttribute("COMP");
%>
<html>
<head>
<meta charset="utf-8">
<title>龍冠科技</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>
</head>
<body>


<div data-role="page" id="pageone">
	
	<div data-role="header" data-position="fixed" data-tap-toggle="false" data-theme="b">
	    <p align=center>龍冠科技維護管理系統</p>
	  </div>
	
	<div data-role="main" class="ui-content" data-theme="a">		
	    <form action=" " method="post" name=" ">
	    	<table align="center" border=0 >
	    		<tr>
	    			<td colspan=2 align=center><h1>客戶資料</h1>
	    		<tr>
	    			<td colspan=2><hr>	
	    		<tr>
	    			<td width="25%" ><h5>裝機日期:</h5>
	    			<td width="40%"><input type="date" name="onlyday" id="onlyday" value=<%=comp.getOnlyday() %> readonly="true">
	    		<tr>	
	    			<td ><h5>設備型號:</h5>
	    			<td ><input type="text" name="" value=<%=comp.getIts() %> readonly="true">
	    		<tr>
	    			<td colspan=2><hr>	
	    		
	    		<tr>	
	    			<td ><h5>公司名稱:</h5>
	    			<td ><input type="text" name="company" value=<%=comp.getCompany() %> readonly="true">
	    		<tr>
	    			<td ><h5>統一編號:</h5>
	    			<td><input type="text" name="number" id="number" value=<%=comp.getNumber() %> readonly="true">
	    		<tr>
	    			<td ><h5>公司電話:</h5>
	    			<td><input type="tel" name="tel" value=<%=comp.getTel() %> readonly="true">
	    		<tr>
	    			<td><h5>承辦人姓名:</h5>
	    			<td><input type="text" name="undertake" value=<%=comp.getUndertake() %> readonly="true">
	    		<tr>	
	    			<td ><h5>承辦人電話:</h5>
	    			<td><input type="tel" name="phone" value=<%=comp.getPhone() %> readonly="true">
	    		<tr>
	    			<td ><h5>公司地址:</h5>
	    			<td ><input tyep="text" name="addr" value=<%=comp.getAddr() %> readonly="true">		
	    		<tr>
	    			<td ><h5>備註說明:</h5>
	    			<td><input type="text" name="ps" value=<%=comp.getPs() %> readonly="true" >
	    			<!-- td ><textarea rows="4" cols="20"  value=<%=comp.getPs() %> readonly="true"></textarea-->	
	    		<tr>
	    			<td>
	    			<td><input type="button"  value="回首頁" onclick="location.href='../view/acc'">
	    	</table>
	    </form>
	  </div>
	
	<div data-role="footer" data-position="fixed" data-tap-toggle="false" data-theme="b">
	   <table align=center width="80%">
	    <tr>
	    	<td align="center"><h4>統一編號:80679663</h4>
	    	<td align="center"><h4>地址:新北市中和區圓通路369巷10號1樓</h4>
	    	<td align="center"><a href="http://www.ryu.com.tw" style="text-decoration:none;">R Y U</a>
	    	<input type="button" value="ＲＹＵ" onclick="location.href='http://www.ryu.com.tw'"  >  
	   </table>
	  </div>
</div> 
