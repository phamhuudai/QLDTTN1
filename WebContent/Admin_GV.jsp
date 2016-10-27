<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.dao.ChuyenNganhDAO"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="model.bean.GIAOVIEN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Giáo Viên</title>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />
<script src="js/jquery-1.11.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript">
	function them() {
		window.location = "themgvtt";
	}
	$(document).ready(function() {
		$("#btn-tim").click(function() {
			var name = $("#ip-tim").val();
			if (name == "") {
				alert("Vui lòng nhập nội dung tìm kiếm !");
			} else {
				$("#form-tim").submit();
			}
		});

	});
</script>
</head>
<body>
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
		ArrayList<GIAOVIEN> arGV = null;
			int i=0;
			
			ArrayList<String> arError=null;
			ArrayList<GIAOVIEN> arGVS=null;
			if(request.getAttribute("arError")!= null){
		arError=(ArrayList<String>)request.getAttribute("arError");
		
			}
			if(request.getAttribute("arGV")!=null){
		arGV=(ArrayList<GIAOVIEN>)request.getAttribute("arGV");
			}
			if(request.getAttribute("arGVS") !=null){
		arGVS=(ArrayList<GIAOVIEN>)request.getAttribute("arGVS");
		
			}
	%>
	<div class="container">
		<div class="link">
			<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">ADMIN</a>
				</div>
				<ul class="nav navbar-nav">
					<li><a href="#">THÔNG BÁO</a></li>


					<li><a href="#">SINH VIÊN</a></li>
					<li class="active"><a href="danhsachgv">GIÁO VIÊN</a></li>

					<li><a href="#">ĐỀ TÀI</a></li>
					<li><a href="#">ĐĂNG KÍ</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><p style="margin-top: 15px; color: white">
							<span class="glyphicon glyphicon-user"></span>: Admin
						</p></li>
					<!-- xuất thông tin người dung ở chỗ nay-->
					<li><a href="" action="#"> |Đăng xuất</a></li>
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
					<%
						if(arGV== null && request.getParameter("search") == null){
									out.print("<h3 align='center'>Không Có Dữ Liệu!!!</h3>");
									out.print("<button class='btn btn-default' id='themGV' name='themTKGV' onclick='them()''>Thêm TK Giáo Viên </button>");
								}else{
					%>
					<h4>DANH SÁCH GIÁO VIÊN</h4>
					<form action="<%=request.getContextPath()%>/timgv" id="form-tim">
						<div class="input-group panel panel-default">
							<input type="text" class="form-control" name="name"
								placeholder="Tìm kiếm..." id="ip-tim">
							<div class="input-group-btn">
								<a id="btn-tim" class="btn btn-default">Tìm</a>
							</div>
						</div>
					</form>
					<%
						if(request.getParameter("msg")!=null){
										String msg = request.getParameter("msg");
										if("edit".equals(msg)){
											out.print("<span style='color:red'> Sửa thành công !</span>");							
										}else  if("add".equals(msg)){
											out.print("<span style='color:red'> Thêm thành công !</span>");	
										}else  if("del".equals(msg)){
											out.print("<span style='color:red'> Xóa thành công !</span>");	
										}else  if("error".equals(msg)){
											out.print("<span style='color:red'> Có lỗi, vui lòng thử lại !</span>");	
										}
									}
									if(arError!=null){
										out.print("<span style='color:red'> Thêm không thành công !</span><br>");
										for(int j=0;j<arError.size();j++){
											out.print("<span style='color:red'>"+arError.get(j)+"</span><br>");	
										}
									}
									if(request.getParameter("search") !=null ){
										if(arGVS==null){
											out.print("<span style='color:red'>Không tìm thấy dữ liệu</span><br>");
										}else{
											arGV=arGVS;
										out.print("<span style='color:red'>Tìm thấy "+arGV.size()+" kết quả</span><br>");
										}
									}
					%>

					<!-- Do du lieu tai day  -->


					<div class="panel panel-default">
						<table class="table table-bordered">
							<thead>
								<tr>

									<th>MSGV</th>
									<th>Tên GVHD</th>
									<th>Ngày Sinh</th>
									<th>Chuyên Ngành</th>
									<th>Email</th>
									<th>Số Điện Thoại</th>
									<th>Địa chỉ</th>
									<th>D.Sách Quản Lý</th>
									<th>Xóa</th>
								</tr>
							</thead>
							<tbody>
								<%
									SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
								                    	for(GIAOVIEN objGV:arGV){
								                    		
								%>
								<tr>

									<td><%=objGV.getMagvhd()%></td>
									<td><a href="suagv?id=<%=objGV.getMagvhd()%>"><%=objGV.getHoten()%></a></td>
									<td><%=objGV.getNgaysinh()!=null ? sdf.format(objGV.getNgaysinh()) : "--"%></td>
									<td><%=objGV.getTencn()%></td>

									<td><%=objGV.getEmail()%></td>
									<td><%=objGV.getSdt()%></td>
									<td><%=objGV.getDiaChi()%></td>
									<td><a href="javascript:void(0)" class="danhsach" id="<%=objGV.getMagvhd()%>">Danh sách</a></td>
									<td><input type="image" name="del_Btn"
										src="images/recyclebin-512.png" class="image-btn"
										onclick=" if(!confirm('Có muốn xóa ? ')) return false; else window.location='xoagv?id=<%=objGV.getMagvhd()%>';"></td>

								</tr>
								<%
									}
								%>

							</tbody>
						</table>
					</div>
					<!-- Modal -->
					
					<script type="text/javascript">				
						$(document).ready(function() {
							$(".danhsach").click(function(){
								var id= $(this).attr("id");
								$.ajax({
									url : "<%=request.getContextPath()%>/danhsach",
									type: 'POST',
									cache: false,
									data: {
										maGV:id,
									},
									success : function(data) {
										$("#content-ds").html(data);
										$("#myModal").modal();
									}
								});
							});
						});
					</script>
					<div class="modal fade" id="myModal" role="dialog">
					  <div class="modal-dialog modal-lg">					
					    <!-- Modal content-->
					    <div class="modal-content">
					      <div class="modal-header">
					        <button type="button" class="close" data-dismiss="modal">&times;</button>
					        <h4 class="modal-title">Danh sách quản lý</h4>
					      </div>
					      <div class="modal-body" id="content-ds">
					       
					      </div>
					      <div class="modal-footer text-center">
					        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
					      </div>
					    </div>
					
					  </div>
					</div>
						
						
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
						<li><a
							href="<%=request.getContextPath()%>/danhsachgv?page=<%=currentPage-1%>"><</a>

							<%
								}
							%> <%
 	for(int p=currentPage-3;p<=currentPage+3;p++) {
 				
 				if(p>0 && p <=numOfPage){
 %>
						<li><a
							href="<%=request.getContextPath()%>/danhsachgv?page=<%=p%>"
							<%if(p==currentPage){%> style="color: red" <%}%>><%=p%></a></li>

						<%
							}
									}
						%>
						<%
							if(currentPage<numOfPage){
						%>
						<li><a
							href="<%=request.getContextPath()%>/danhsachgv?page=<%=currentPage+1%>">></a>

							<%
								}
							%>
					</ul>
					</nav>

					<!-- End Paging -->
					<a href="<%=request.getContextPath()%>/themgvtt"><button
							class="btn btn-default" id="themGV" name="themTKGV">Thêm
							TK Giáo Viên</button></a>
					<%
						}
					%>
				</div>

			</div>

		</div>

	</div>

	</div>
	<!-- Container- conten  -->

</body>
</html>