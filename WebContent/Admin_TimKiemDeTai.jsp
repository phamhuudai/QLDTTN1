<%@page import="model.bean.DETAI"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách đề tài</title>
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
            		<li style="background-color:#99FFFF"><a href="" >Danh sách đề tài</a></li>
            		<li><a href="">Thêm đề tài thông thường</a></li>
            		<li><a href="">Nhập file excel</a></li>
            		<li><a href="">Theo dõi tiến độ</a></li>
            	</ul>
				</div>
			</div>
			<div class="col-md-9">
				<div class="well">
					<h4>DANH SÁCH ĐỀ TÀI</h4>
					<form action="<%=request.getContextPath()%>/timkiemdetai" >
						<div class="input-group panel panel-default">
						<input type="text" class="form-control" name="name" placeholder="Tìm kiếm đề tài...">
						<div class="input-group-btn">
							<button  class="btn btn-default dropdown-toggle" type="submit" name="search" value="search">
								Tìm
							</button>
							
						</div>
						</div>
					</form>
				
				<!-- Do du lieu tai day  -->
				<%
					ArrayList<DETAI> arDeTai = (ArrayList<DETAI>) request.getAttribute("arDeTai");
					if(arDeTai == null ){
						out.print("<span style='color:red'> Không có tìm thấy dữ liệu!</span>");
						
					}
					else{
						out.print("<span style='color:red'>Hiển thị "+arDeTai.size()+" trên "+(Integer)request.getAttribute("numOfRecord")+" kết quả</span><br>");	
				%>
					<form action="">
					<div class="panel panel-default">
						<table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Mã đề tài</th>
                            <th>Tên đề tài</th>
                            <th>Chuyên ngành</th>
                            <th>GVHD</th>
                            <th>Xóa</th>
                            <th>Sửa</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%for(DETAI objDeTai : arDeTai) {%>
                    	<tr>
                    		<td><%=objDeTai.getMadetai() %></td>
                    		<td><%=objDeTai.getTendetai() %></td>
                    		<td><%=objDeTai.getTenCN() %></td>
                    		<td><%=objDeTai.getTenGVHD() %></td>
                    		<td><a href="javascript:void{0}" onclick=" if(!confirm('Bạn có muốn xóa ? ')) return false; else window.location='xoadetai?maDeTai=<%=objDeTai.getMadetai()%>';"><span class="glyphicon glyphicon-trash"></span></a></td>
                    		<td><a href="<%=request.getContextPath()%>/suadetai?madt=<%=objDeTai.getMadetai() %>" class="glyphicon glyphicon-pencil"> </td>
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
						String name = String.valueOf(request.getAttribute("name"));
					%>
					<nav>
					<ul class="pagination">
						<%
							if(currentPage>1){
						%>
						<li><a href="<%=request.getContextPath()%>/timkiemdetai?page=<%=currentPage-1%>&search=search&name=<%=name%>"><</a>
						<%
							}
							for(int p=currentPage-3;p<=currentPage+3;p++) {
						 		if(p>0 && p <=numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/timkiemdetai?page=<%=p%>&search=search&name=<%=name%>" <%if(p==currentPage){%> style="color: red" <%}%>><%=p%></a></li>
						<%
								}
							}
							if(currentPage<numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/timkiemdetai?page=<%=currentPage+1%>&search=search&name=<%=name%>"></a>
						<%
							}
						%>
					</ul>
					</nav>	
					<!-- End Paging -->
						<button class="btn btn-default" id="xuatDt">Xuất DS Excel </button>	
				<%} %>	
				</div>
				</div>
				
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>