<%@page import="model.bean.DATTG"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Các đợt đăng ký</title>
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
            		
            		<li ><a href="">Thống kê đăng ký</a></li>
            		<li style="background-color:#99FFFF"><a href="">Các đợt đăng ký</a></li>
            		<li  ><a href="" >Cài đặt thời gian đăng ký</a></li>
            	</ul>
				</div>
			</div>
			<%ArrayList<DATTG> arTG = (ArrayList<DATTG> )request.getAttribute("arTG"); 
				if(request.getParameter("msg")!=null){
					String msg = request.getParameter("msg");
					if("edit".equals(msg)){
						out.print("<span style='color:red'> Sửa thành công !</span>");							
					}else  if("add".equals(msg)){
						out.print("<span style='color:red'> Thêm thành công !</span>");	
					}else  if("del".equals(msg)){
						out.print("<span style='color:red'> Xóa thành công !</span>");	
					}else  if("err".equals(msg)){
						out.print("<span style='color:red'> Có lỗi, vui lòng thử lại !</span>");	
					}
				}
			%>
			<div class="col-md-9">
				<div class="well">
				<table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Mã Đợt</th>
                            <th>TG Bắt Đầu</th>
                            <th>TG Kết Thúc</th>
                            <th>TG Thực Hiện</th>
                            <th>Xóa</th>
                        	
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    for(DATTG tg : arTG){
                    %>
                    	<tr>
                    		<td><%=tg.getMaDot() %></td>
                    		<td><%=tg.getThoiGianBD()%></td>
                    		<td><%=tg.getThoiGianKT()%></td>
                    		<td><%=tg.getThoiGianTH()+" Tháng"%> </td>
							<td><input type="image" name="del_Btn"	src="images/recyclebin-512.png" class="image-btn"
								onclick=" if(!confirm('Có muốn xóa ? ')) return false; else window.location='XoaDangKy?id=<%=tg.getMaDot()%>';"></td>
                    	</tr>
                    <%} %>	
                    	
                    	
                    </tbody>
               	 </table>
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>