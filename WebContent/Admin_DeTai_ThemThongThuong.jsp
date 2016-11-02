<%@page import="model.bean.GIAOVIEN"%>
<%@page import="model.bean.CHUYENNGANH"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm thông thường</title>
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
            		<li style="background-color:#99FFFF"><a href="">Thêm đề tài thông thường</a></li>
            		<li><a href="">Nhập file excel</a></li>
            		<li><a href="">Theo dõi tiến độ</a></li>
            	</ul>
				</div>
			</div>
			<div class="col-md-9">
				<div class="well">
					<h4>THÊM ĐỀ TÀI</h4>
				<%
				ArrayList<CHUYENNGANH>	arCN =(ArrayList<CHUYENNGANH>) request.getAttribute("arCN"); 
				ArrayList<GIAOVIEN>	arGV =(ArrayList<GIAOVIEN>) request.getAttribute("arGV"); 
				
				%>
				<!-- Do du lieu tai day  -->
					<form class="form-horizontal" action="<%=request.getContextPath()%>/themdetaitt" method="GET">  
					<div class="form-group">
						<label class="control-label col-md-2">Tên đề tài </label>
						<div class="col-md-5">
							<input class="form-control" name="tenDeTai" placeholder="Nhập tên đề tài">
						</div>
						
					</div>            
					<div class="form-group">				
                    	<label class="control-label col-md-2">Chuyên ngành </label>
                    <div class="col-md-5">
                    <select class="form-control" name="maCN">
                	  <option value="0">--------------Chọn chuyên ngành--------------</option>
					 <%
					 	for(CHUYENNGANH objCN : arCN){
					 		
					 %>		
					 	<option value="<%=objCN.getMacn()%>"><%=objCN.getTencn() %></option>
					 <%	
					 	}
					 %>
					 
					</select>
					</div>
                 </div>
             
                 
                 <div class="form-group">
                    <label class="control-label col-md-2">GVHD </label>
                    <div class="col-md-5">
                    <select class="form-control" name="maGVHD">
                	  <option >-----------------Chọn GVHD-----------------</option>
					 <%
					 	for(GIAOVIEN objGV : arGV){
					 		
					 %>		
					 	<option value="<%=objGV.getMagvhd()%>"><%=objGV.getHoten() %></option>
					 <%	
					 	}
					 %>
					</select>
					</div>
                 </div>
                 
                 <div class="form-group">
                 	<label class="control-label col-md-2">Nội dung chi tiết </label>
                 	<div class="col-md-5">
                            <textarea class="form-control" rows="3" name="noiDung"></textarea>
                        </div>  
                 </div>
                 <div class="form-group">
	                 <button class="btn btn-default" type="submit" id="GV_Nhapbtn"  name="them" value="Thêm">Tạo</button>
					<button class="btn btn-default" id="GV_Huybtn">Hủy</button>
	                 </div>
                 </form>
                
				
					
				</div>
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>