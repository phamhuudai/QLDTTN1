<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thông tin</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/datepicker.css"/>
    <script src="js/bootstrap-datepicker.js"></script>
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
					      <li ><a href="#">ĐỀ TÀI</a></li>
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
	<div class="container ">
		<dir class="well">
			<div class="row">
			<h4 align="center">Đổi mật khẩu</h4>             
	          <div class="col-md-6 col-md-offset-3">
	          	<form action="<%=request.getContextPath()%>/DoiThongTin" method="POST">
				  <div class="form-group">
				    <label >Mã truy cập</label>
				    <input type="text" class="form-control" name="id">
				  </div>
				  <div class="form-group">
				    <label for="pwd">Mật khẩu cũ:</label>
				    <input type="password" class="form-control" name="oldPass">
				  </div>
				  <div class="form-group">
				    <label for="pwd">Mật khẩu mới:</label>
				    <input type="password" class="form-control" name="newPass">
				  </div>
				  <div class="form-group">
				    <label for="pwd">Xác nhận :</label>
				    <input type="password" class="form-control" name="cofPass">
				  </div>
				  <div class="text-center">
				 	 <button type="submit" class="btn btn-default text-center">Hủy bỏ</button>
				  	<button type="submit" class="btn btn-warning text-center">Thay đổi</button>
				  </div>
				</form>	
	          </div>
			</div>
		</dir>
		
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>