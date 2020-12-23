<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Model.number"%>
<!DOCTYPE html>
<html>
<%
	number num = (number)session.getAttribute("alter");
%>
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
	
	<div data-role="header" data-position="fixed" data-tap-toggle="false">
	    <p align=center>龍冠科技維護管理系統</p>
	  </div>
	
	<div data-role="main" class="ui-content">		
	    <form action="../Con/numup" method="post" name="">
	    	<table align=center border=1 >
	    		<tr>
	    			<td align=center>名稱:
	    			<td><input type="text" name="name" value=<%=num.getName() %> >
	    		<tr>
	    			<td align=center>帳號:
	    			<td><input type="text" name="user" value=<%=num.getUser() %> readonly="true" >
	  	    	<tr>
	    			<td align=center>密碼:
	    			<td><input type="text" name="password" value=<%=num.getPassword() %> >
	    		<tr>
	    			<td align=center>電話:
	    			<td><input type="number" name="phone" value=<%=num.getPhone() %> >
	    		<tr>
	    			<td align=center>生日:
	    			<td><input type="date" name="body" value=<%=num.getBody() %> >
	    		<tr>
	    			<td align=center>帳號權限:
	    			<td><input type="number"  min="0" max="1" name="type" value=<%=num.getType() %> >
	  	    	<tr>
	  	    		<td><input type="button" value="上一頁" onclick="location.href='../view/staffview'" />
	  	    		<td><input type="submit" value="更新" />
	    	</table>
	    </form>
	  </div>
	
	<div data-role="footer" data-position="fixed" data-tap-toggle="false">
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