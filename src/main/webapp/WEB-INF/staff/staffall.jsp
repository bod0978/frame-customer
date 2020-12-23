<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Dao.numberDao"%>
<!DOCTYPE html>
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
	    <form action="login" method="post" name="loginform">
	    	<table align=center border=0 width=60%>
	    		<tr>
	    			<td width="10%" align="center">編號<td width="10%" align=center>帳號
	    			<td width="10%" align=center>名稱<td width="10%" align=center>密碼
	    			<td width="10%" align=center>電話<td width="10%" align="center">刪除
	    			<td width="10%" align="center">編輯
	    			
	    		<%
	    			out.println(new numberDao().queryall());
	    		%>
	    		<tr>
	    			<td>
	    			<td colspan=2 align="left"><input type="button" value="回首頁" onclick="location.href='../view/acc'" >
	    			<td>
	    			<td  colspan=2 align="right"><input type="button"  value="新增帳號" onclick="location.href='../view/addnum'" >
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
</body>
</html>