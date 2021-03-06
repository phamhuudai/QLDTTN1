<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Nộp báo cáo</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/vertical-tabs.css"/>
    <link rel="stylesheet" href="css/fileinput.min.css"/>
    <link rel="stylesheet" href="css/fileinput.css"/>
    <link rel="stylesheet" href="css/jquery-ui.css"></link>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery-2.1.1.js"></script>
    <script src ="js/vertical-tabs.js"></script>
     <script src ="js/fileinput.min.js"></script>
      <script src ="js/fileinput.js"></script>
    
    <script src="js/jquery-ui.js"></script>
    <!-- <script src="js/jquery-1.12.0.min.js"></script> -->
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
				       <li><a href="#">THÔNG BÁO</a></li>					      
				         <li ><a href="#">ĐỀ TÀI</a></li> 
				      <li  ><a href="#">CẬP NHẬT CÁ NHÂN</a></li>					     
				      <li class="active"><a href="#">KẾT QUẢ</a></li>
				    </ul>
				    <ul class="nav navbar-nav navbar-right">
				    	<li><p style="margin-top:15px;color:white"><span class="glyphicon glyphicon-user"></span>SV: Huỳnh Hữu Hưng</p></li><!-- xuất thông tin người dung ở chỗ nay-->
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
					<div class="form-login" role="form" action="">
						<h4 class="title title-centre" >DANH MỤC MENU</h4>
						<div class="form-group" >
							<i class="fa fa-paste" ></i><a class="group1">Điểm đánh giá quán trình<span class="fa arrow"></span></a>
						</div>
						<div class="form-group" >
							<i class=" fa fa-bell-o"></i><a class="group1">Xem điểm bảo vệ<span class="fa arrow"></span></a>
						</div>
						<div class="form-group">
							<i class="fa fa-pencil-square-o" style="background-color:#99FFFF"></i><a class="group1">Nộp báo cáo<span class="fa arrow"></span></a>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-9">
				<div class="well">
					<div class="content-centre">
						<h4 class="title title-centre">XEM ĐIỂM BẢO VỆ</h4>
						<form class="form-horizontal" action="#">
							<div class="form-group">
		                      	<label class="control-label col-xs-4">Tên Đề Tài:</label>
		                      	<div class="col-xs-6">
		                          <p>Xây dựng hệ thống quản lý đề tài tốt nghiệp</p>
	                      		</div>
	                 		 </div><!--from group1  -->
	                 		 <div class="form-group">
		                      	<label class="control-label col-xs-4">Sinh viên thực hiện:</label>
		                      	<div class="col-xs-6">
		                          <p > Phạm Thị Duyên </p>
		                          <p >Huỳnh Nguyên Hải</p>
	                      		</div>
	                 		 </div><!--from group1  -->	  
	                 		 <div class="form-group">
		                      	<label class="control-label col-xs-4">Bài Báo Cáo:</label>
		                      	<div class="col-xs-6">
		                           <div class="form-group">
	                           			<select class="form-control" name="color">
							                <option value="">Chon đợt nộp báo cáo</option>
							                <option value="lan1">Lần 1</option>
							                <option value="lan2">Lần 2</option>
							                <option value="lan3">Lần 3</option>
							                <option value="lan4">Lần 4</option>
							                <option value="baoVe">Bảo Vệ</option>
							            </select>
	                      		</div>
	                      	 </div><!--from group1  -->	
	                 		 <div class="form-group">
	                 		
	                      		<label class="control-label col-xs-4">Select File</label>
								<input id="input-6" name="input6[]" type="file" multiple class="file-loading col-xs-8">
							
							</div>	                		
						  	 <div>
			                    <button class="btn btn-default"  id="GV_Nhapbtn">Phản Hồi</button>
								<button class="btn btn-default"  id="GV_Huybtn">Trở lại</button>  
							</div>
							
						</form><!-- dong form -->
					</div><!--  -->
				</div><!-- well  -->
			</div>
		</div>
	</div>
</body>
<script>
$(document).on('ready', function() {
    $("#input-6").fileinput({
        showUpload: false,
        maxFileCount: 10,
        mainClass: "input-group-lg"
    });
});
</script>
</html>