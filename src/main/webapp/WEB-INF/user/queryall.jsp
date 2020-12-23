<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Dao.handleDao"
    import="Model.handle"
    import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>龍冠科技</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.css">
<script src="https://apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="https://apps.bdimg.com/libs/jquerymobile/1.4.5/jquery.mobile-1.4.5.min.js"></script>


</head>
<body>
<%
	handle ha = (handle) session.getAttribute("HAND");
%>

<div data-role="page" id="pageone">
	
	<div data-role="header" data-position="fixed" data-tap-toggle="false" data-theme="b">
	    <p align=center>龍冠科技維護管理系統</p>
	  </div>
	
	<div data-role="main" class="ui-content" data-theme="a">		  
	    <form action="" method="post" name="" >
	    	<table align=center border=0 width="60%">
	    		<tr>
	    			<td colspan=5 align=center><h1>客戶維護紀錄</h1>
	    		<tr>
	    			<td colspan=5><hr>	
	    		<tr>
	    			<td colspan=5 align=center><h4>請輸入公司名稱或統一編號</h4>
	    		<tr>	
	    			<td width="10%" align=center>公司名稱:
	    			<td width="20%"><input type="text" name="company" style="color:#E3241B" disabled="disabled" value=<%=ha.getCompany() %> >
	    		<tr>
	    			<td width="10%" align=center>統一編號:
	    			<td width="20%"><input type="text" name="number" style="color:#E3241B" disabled="disabled" value=<%=ha.getNumber() %>>	
	    		<tr>
	    			<td colspan=5><hr>
	    	</table>
	    	
	    	<table align=center border=1 >		
	    		<tr>
	    			<!-- td width="5%" align=center>編號<td width="12%" align=center>公司名稱-->
	    			<td width="15%" align=center>會同人員<td width="15%" align=center>服務日期
	    			<td width="10%" align=center>服務內容<td width="10%" align=center>交辦事項 
	    		<tr>	
	    		<%	
	    			if(new handleDao().queryNumber(ha.getNumber()).size() != 0 ){	
	    				out.println(new handleDao().StringNumber(ha.getNumber()));
	    			}else{
	    				out.println("<tr><td align=center colspan=4 >查無維修紀錄");
	    			}
	    		%>
	    	</table>
		
	    	<table align=center border=0 width="60%">
	    		<tr>
	    			<td align=center >
	    			<td width="15%">
	    			<input type="button" value="回上一頁" onclick="location.href='../view/acc'" >
	    			<td>
	    			<td width="15%">
	    			<input type="button" value="新增服務內容" onclick="location.href='../view/adddate'" />	
	    			<td align=eenter>
	    			
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