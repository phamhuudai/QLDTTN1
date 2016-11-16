<%@page import="model.bean.TIENDO"%>
<%@page import="model.bean.DETAI"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Theo dõi tiến độ</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		 <div style="background-color: #337ab7; color: white"class="jumbotron">
	  	<div class="row">
	  		<div class="col-md-2">
	  			<img width="150px" height="150px" alt="" src="images/logokhoa.png">
	  		</div>
	  		<div class="" style="align: center">
	  			<h2>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h2>   
	  			<h4>KHOA CÔNG NGHỆ NGHỆ THÔNG TIN<h4>   
	    		<p>HỆ THỐNG QUẢN LÝ THỰC HIỆN ĐỀ TÀI TỐT NGHIỆP </p>	    		
	  		</div>
	    </div>
	  </div>
	</div><!-- container1 -->
	
	<div class="container">
		<div class="link">
					<nav class="navbar navbar-inverse">
					  <div class="container-fluid">
					    <div class="navbar-header">
					      <a class="navbar-brand" href="#">ADMIN</a>
					    </div>
					    <ul class="nav navbar-nav">
					      <li ><a href="#">THÔNG BÁO</a></li>
					        <li><a href="#">SINH VIÊN</a></li> 
					      <li><a href="#">GIÁO VIÊN</a></li>
					      <li class="active"><a href="#">ĐỀ TÀI</a></li>
					      <li><a href="#">ĐĂNG KÍ</a></li>
					    </ul>
					    <ul class="nav navbar-nav navbar-right">
					    	<li><p style="margin-top:15px;color:white"><span class="glyphicon glyphicon-user"></span>: Admin</p></li><!-- xuất thông tin người dung ở chỗ nay-->
					      	<li><a href="" action = "#"> |Đăng xuất</a></li>
					    </ul>
					  </div>
					</nav>
		</div> <!-- menu -->
	</div><!-- container -menu -->
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<div class="well">
				<h4 class="title" style="text-align:center;padding-bottom:10px;">MENU</h4>
				<ul class="nav">
            		<li ><a href="" >Danh sách đề tài</a></li>
            		<li><a href="">Thêm đề tài thông thường</a></li>
            		<li><a href="">Nhập file excel</a></li>
            		<li style="background-color:#99FFFF"><a href="">Theo dõi tiến độ</a></li>
            	</ul>
				</div>
			</div>
			<%
			ArrayList<TIENDO>  arTD=(ArrayList<TIENDO>)request.getAttribute("arTD");			
	
			%>
			<div class="col-md-9">
				<div class="well">
					<h4>THEO DÕI TIẾN ĐỘ</h4>
				
				<!-- Do du lieu tai day  -->
					<form action="">
					<div class="panel panel-default">
						<table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Mã đề tài</th>
                            <th>Tên đề tài</th>
                            <th>Chuyên ngành</th>
                            <th>GVHD</th>
                          	<th>Tiến độ</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    	for(TIENDO td : arTD){
                    %>
                    	<tr>
                    		<td><%=td.getMaDeTai() %></td>
                    		<td><%=td.getTenDeTai() %></td>
                    		<td><%=td.getTenCN() %></td>
                    		<td><%=td.getGvhd() %></td>
                    		<td><%=td.getTienDo()%> %</td>
                    	</tr>
                    	<%} %>
                    	
                    	
                    </tbody>
               	 </table>
					</div>		
					</form>
					
					
					<!-- Paging -->
					
					<%
						int currentPage = (Integer)request.getAttribute("currentPage");
						int numOfPage= (Integer)request.getAttribute("numOfPage");
					%>
					<nav>
					<ul class="pagination">
						<%
							if(currentPage>1){
						%>
						<li><a href="<%=request.getContextPath()%>/theodoitiendo?page=<%=currentPage-1%>"><</a>
						<%
							}
							for(int p=currentPage-3;p<=currentPage+3;p++) {
						 		if(p>0 && p <=numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/theodoitiendo?page=<%=p%>" <%if(p==currentPage){%> style="color: red" <%}%>><%=p%></a></li>
						<%
								}
							}
							if(currentPage<numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/theodoitiendo?page=<%=currentPage+1%>">></a>
						<%
							}
						%>
					</ul>
					</nav>
					<!-- End Paging -->
						<button class="btn btn-default" id="dsbv" name="dsbv">Danh sách được bảo vệ </button>	
				</div>
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>