<%@page import="model.bean.SINHVIEN"%>
<%@page import="model.bean.DETAISINHVIEN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sinh viên</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-2.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body >
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
	<%
		SINHVIEN sinhvien = (SINHVIEN)request.getAttribute("ObjSV");
	%>
	<div class="container">
		<div class="link">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<nav id="primary_nav_wrap">
				<ul class="nav navbar-nav">
					<li class="primary_nav_wrap"><a href="#">THÔNG BÁO</a></li>
					<li class="active"><a href="#">ĐỀ TÀI</a>
						<ul>
							<li><a href="#">Đề tài đã đăng ký</a></li>
						</ul>
					</li>
					<li><a
						href="<%=request.getContextPath()%>/ControllerHienThiThongTinSV">CÁ
							NHÂN</a>
						<ul>
							<li><a href="#">Thông tin giáo viên</a></li>
							<li><a href="#">Thông tin giáo viên</a></li>
						</ul>
					</li>
					<li><a href="<%=request.getContextPath()%>/ControllerXemDiemBaoVeDoAn">KẾT QUẢ</a>
						<ul>
							<li><a href="#">Đánh giá quá trình</a></li>
							<li><a href="#">Điểm bảo vệ đồ án</a></li>
							<li><a href="#">Nộp báo cáo</a></li>
						</ul>
					</li>
					<li><a href="#">PHẢN HỒI</a></li>
					
				</ul>
				</nav>
				<ul class="nav navbar-nav navbar-right">


					<li><p style="margin-top: -1px; color: white">
							<span class="glyphicon glyphicon-user"></span> Sinh viên:
							<%=sinhvien.getHoTen()%>
						</p></li>
					<!-- xuất thông tin người dung ở chỗ nay-->
					<li><a href="<%=request.getContextPath()+"/login"%>"
						action="#"> |Đăng xuất</a></li>
				</ul>
			</div>
			</nav>
			
			
			
			
			
			
			
			
			
			
			
			
		</div>
		<!-- menu -->
	</div>
	<!-- container -menu -->
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="well">
					<div class="content-centre">
						<form action="">
							<h4>ĐĂNG KÍ ĐỀ TÀI</h4>
							<!-- Do du lieu tai day  -->
							<div class="panel panel-default">
								<div class="panel  panel-primary">
									<!-- Default panel contents -->
									<div class="panel-heading">Danh sách đề tài đăng kí</div>

									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th>Mã Đề Tài</th>
													<th>Tên đài</th>
													<th>CN</th>
													<th>GVHD</th>
													<th>Đăng kí</th>
												</tr>
											</thead>
											<%
												ArrayList<DETAISINHVIEN> alDeTaiSinhViens = (ArrayList<DETAISINHVIEN>)request.getAttribute("alDeTaiSinhViens");
																																																																																					for(DETAISINHVIEN objDTSV:alDeTaiSinhViens){
																																																																																						int cid = objDTSV.getMaDeTai();
											%>

											<tbody>
												<tr>
													<td><%=objDTSV.getMaDeTai()%></td>
													<td><%=objDTSV.getTenDeTai()%></td>
													<td><%=objDTSV.getTenChuyenNganh()%></td>
													<td><%=objDTSV.getGiaoVienHuongDan()%></td>
													<td><a
														href="<%=request.getContextPath()%>/ControllerXemDeTaiDuocChon?cid=<%=cid%>"><span
															class="glyphicon glyphicon-hand-right"></span> </a></td>
												</tr>
											</tbody>
											<%
												}
											%>
										</table>
									</div>
								</div>
							</div>
							<!-- Paging -->

							<nav>
							<ul class="pagination">
								<li class=""><a href="" aria-label="Previous"><span
										aria-hidden="true">&laquo;</span></a></li>

								<li class="active"><a href=""><%=1%> <span
										class="sr-only">(current)</span></a></li>

								<li><a href="" aria-label="Next"><span
										aria-hidden="true">&raquo;</span></a></li>
							</ul>
							</nav>
							<!-- End Paging -->
						</form>
						<!-- đóng form -->
					</div>
				</div>
			</div>

		</div>

	</div>
	<!-- Container- conten  -->
</body>
</html>