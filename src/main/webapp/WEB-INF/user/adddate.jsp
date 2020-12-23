<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="Dao.compDao"
    import="Model.companytable"
    import="java.util.List"
    import="Model.handle"%>
<!DOCTYPE html>
<%
	handle ha = (handle) session.getAttribute("HAND");
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
		 <form action="../Con/adddate" method="post" name="addall">
	    	<table align=center border=0 >
	    		<tr>
	    			<td colspan=4 align=center><h1>客戶維護紀錄表</h1>
	    		<tr>
	    			<td colspan=4><hr>	
	    		<tr>
	    			<td width="15%" align=center>公司名稱:
	    			<td width="23%"><input type="text" name="company" style="color:#E3241B" disabled="disabled" value=<%=ha.getCompany() %>>
	    			<td width="12%" align=center>統一編號:
	    			<td width="23%"><input type="text" name="number" style="color:#E3241B" disabled="disabled" value=<%=ha.getNumber() %>>
	    		<tr>
	    			<td width="15%" align="center"><font color="red">*</font>會同人員:
	    			<td width="20%"><input tepe="text" name="undertake" >	
	    		
	    			<td width="15%" align="center">服務類別:
	    			<td width="30%">
	    			<select name="sort">
	    				<option value="定期保養">定期保養</option>
	    				<option value="設備修護" selected>設備修護</option>
	    				<option value="設備移機">設備移機</option>
	    				<option value="其他">其他</option>
	    			</select>				
	    		<tr>
	    			<td align="center">通知時間:
	    			<td><input type="date" name="noticedate" id="noticedate">
	    			
	    			<td align="center">服務時間:
	    			<td><input type="date" name="servicedate" id="servicedate" >
	    		<tr>
	    			<td align="center"><font color="red">*</font>服務內容:
	    			<td colspan=3><textarea rows="4" cols="20" placeholder="說明處理狀況" name="centent"></textarea>	
	    		<tr>
	    			<td align="center"><font color="red">*</font>交辦事項:
	    			<td colspan=3><textarea rows="4" cols="20" placeholder="是否有後續代辦事項" name="explain"></textarea>	
	    		<tr>
	    			<td colspan=4><hr>	
	    		<tr>
	    			<td colspan=2>
	    			<input type="button" " value="回首頁" onclick="location.href='../view/acc'">
	    			<td colspan=2>
	    			<!-- input type="reset" value="清除資料"-->
	    			<input type="button" value="資料登入" onclick="adddate()" >			
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
<script type="text/javascript">
function adddate(){
	var today=new Date();
	var currentDateTime =today.getFullYear()+ "-" + (today.getMonth()+1) + "-" + today.getDate();
	if(addall.undertake.value==""){
		alert("會同人資料未填寫");
		return ;
	}
	if(addall.centent.value==""){
		alert("服務內容未填寫，如無內容請填寫無");
		return ;
	}
	if(addall.explain.value==""){
		alert("交辦事項未填寫，如無交辦事項請填無");
		return ;
	}
	if(addall.noticedate.value=="" ){
		alert("未輸入通知時間");
		document.getElementById('noticedate').value = currentDateTime;
		return ;
	}
	if(addall.servicedate.value==""){
		alert("未輸入服務時間");
		document.getElementById('servicedate').value = currentDateTime;
		return ;
	}
	addall.submit();
}

</script>
</body>
</html>