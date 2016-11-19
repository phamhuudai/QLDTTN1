<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="container">
		<div style="background-color: #337ab7; color: white" class="jumbotron">
			<div class="row">
				<div class="col-md-2">
					<img width="150px" height="150px" alt="" src="images/logokhoa.png">
				</div>
				<div class="" style="align: center">
					<h2>TRƯỜNG ĐẠI HỌC BÁCH KHOA - ĐẠI HỌC ĐÀ NẴNG</h2>
					<h4>
						KHOA CÔNG NGHỆ NGHỆ THÔNG TIN
						<h4>
							<p>HỆ THỐNG QUẢN LÝ THỰC HIỆN ĐỀ TÀI TỐT NGHIỆP</p>
				</div>
			</div>
		</div>
	</div>
	<!-- container1 -->
	<div class="container">
		<div class="link">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="">ADMIN</a>
				</div>
				<ul class="nav navbar-nav">
					<li ><a href="#" >THÔNG BÁO</a></li>
					<li ><a href="#">SINH VIÊN</a></li>
					<li ><a href="<%=request.getContextPath()%>/danhsachgv">GIÁO VIÊN</a></li>
					<li ><a href="<%=request.getContextPath()%>/danhsachdetai">ĐỀ TÀI</a></li>
					<li ><a href="<%=request.getContextPath()%>/thongkedangky">ĐĂNG KÍ</a></li>
					
				</ul>
								
				<ul class="nav navbar-nav navbar-right">
					<li><p style="margin-top: 15px; color: white">
							<span class="glyphicon glyphicon-user"></span>: Admin
						</p></li>
					<!-- xuất thông tin người dung ở chỗ nay-->
					<li><a href="<%=request.getContextPath()%>/logout"> |Đăng xuất</a></li>
				</ul>
			</div>
			</nav>
		</div>
		<!-- menu -->
	</div>