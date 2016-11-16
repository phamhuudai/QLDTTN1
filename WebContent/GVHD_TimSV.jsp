<%@page import="model.bean.DANHSACHQL"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sinh viên</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
	$(document).ready(function() {
		$("#btn-tim").click(function() {
			var name = $("#ip-tim").val();
			if (name == "") {
				alert("Vui lòng nhập nội dung tìm kiếm !");
				
			} else {
				$("#formtk").submit();
			}
		});

	});
</script>
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
			      <a class="navbar-brand" href="#">GIÁO VIÊN HƯỚNG DẪN</a>
			    </div>
			    <ul class="nav navbar-nav">
			      <li><a href="#">THÔNG BÁO</a></li>
			      <li class="active"><a href="#">QUẢN LÝ SINH VIÊN</a></li>
			      <li><a href="#">QUẢN LÝ ĐỀ TÀI</a></li>
			    </ul>
			    <ul class="nav navbar-nav navbar-right">
			    	<li><p style="margin-top:15px;color:white"><span class="glyphicon glyphicon-user"></span> GVHD: Huỳnh Hữu Hưng</p></li><!-- xuất thông tin người dung ở chỗ nay-->
			      	<li><a href="" action = "#"> |Đăng xuất</a></li>
			    </ul>
			  </div>
			</nav>
		</div> <!-- menu -->
	</div><!-- container -menu -->
	<div class="container">
		<div class="row">
		

			<div class="col-md-12">
				<div class="well">
				<%
					ArrayList<DANHSACHQL> arSV = (ArrayList<DANHSACHQL>)request.getAttribute("arSV");
				if(arSV==null){
					out.print("<span style='color:red'>Không tìm thấy dữ liệu</span><br>");
				}else{
					out.print("<span style='color:red'>Tìm Thấy "+arSV.size()+" kết quả</span><br>");
				
					
				
				%>
				
					<h4>DANH SÁCH SINH VIÊN QUẢN LÝ</h4>
				<form action="<%=request.getContextPath()%>/TimSinhVien" method="GET" id="formtk">
						<div class="input-group panel panel-default">
					<input type="text" name="ten" class="form-control" id="ip-tim" placeholder="Tìm kiếm...">
					<div class="input-group-btn">
						<button type="button" type="submit" id="btn-tim" class="btn btn-default">
							Tìm
						</button>
					</div>
					</div>
				</form>
				
				<!-- Do du lieu tai day  -->
				
	
					<div class="panel panel-default">
						<table class="table table-bordered">
		                    <thead>
		                        <tr>
		                          
		                            <th>MSSV</th>
		                            <th>Tên sinh viên</th>
		                            <th>Lớp</th>
		                            <th>Email</th>
		                            <th>Số Điện thoại</th>
		                        </tr>
		                    </thead>
		                    <tbody>
		                    <%for(DANHSACHQL ds : arSV){ %>
		                    	<tr>
		                    		
		                    		<td><%=ds.getMaSV() %></td>
		                    		<td><%=ds.getTenSV() %></td>
		                    		<td><%=ds.getLop() %></td> 
		                    		<td><%=ds.getEmail()%></td>     
		                    		<td><%=ds.getSdt() %></td>                		
		                    	</tr>
		                    <%} %>                   	
		                    </tbody>
               	 		</table>
					</div>		
			
			<!-- Paging -->			
				<nav>
				  <ul class="pagination">
				    <li class=""><a href="" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
				    <li class="active"><a href=""><%=1 %> <span class="sr-only">(current)</span></a></li>	
				    <li><a href="" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li> 
				  </ul>					 
				</nav>		
					<!-- End Paging -->	
				</div>
			</div>
			<%} %>		
		</div>		
	</div><!-- Container- conten  -->	
</body>
</html>