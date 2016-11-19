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
	<%@ include file="./templates/Admin/Header.jsp" %>
	<div class="container">
		<div class="row">
			<%@ include file="./templates/Admin/DeTai-Left.jsp" %>
			<div class="col-md-9">
				<div class="well">
					<h4>DANH SÁCH ĐỀ TÀI</h4>
					<form action="<%=request.getContextPath()%>/timkiemdetai">
						<div class="input-group panel panel-default">
							<input type="text" class="form-control" name="name" placeholder="Tìm kiếm đề tài...">
							<div class="input-group-btn">
								<button  class="btn btn-default dropdown-toggle"  name="search" value="search" type="submit">
									Tìm
								</button>
							</div>
						</div>
					</form>
				
				<!-- Do du lieu tai day  -->
				<%
					ArrayList<DETAI> arDeTai = (ArrayList<DETAI>) request.getAttribute("arDeTai");
					if(arDeTai == null ){
						out.print("<span style='color:red'> Không có dữ liệu để hiển thị !</span>");
						
						
					}
					else{
						if(request.getParameter("msg")!=null || request.getAttribute("arError") !=null){
							String msg=request.getParameter("msg");
							if("add".equals(msg)){
								out.print("<span style='color:red'> Thêm thành công !</span>");
							}else if("del".equals(msg)){
								out.print("<span style='color:red'> Xóa thành công !</span>");
							}else if("error".equals(msg)){
								out.print("<span style='color:red'> Có lỗi, vui lòng thử lại !</span>");
							}else if("edit".equals(msg)){
								out.print("<span style='color:red'> Sửa thành công !</span>");
							}
							if(request.getAttribute("arError") !=null){
								ArrayList<String> arError = (ArrayList<String>) request.getAttribute("arError");
								out.print("<span style='color:red'> Thêm không thành công !</span><br>");
								for(String er : arError){
									out.print("<span style='color:red'>"+er+"</span><br>");
								}
							}
						}
	
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
					%>
					<nav>
					<ul class="pagination">
						<%
							if(currentPage>1){
						%>
						<li><a href="<%=request.getContextPath()%>/danhsachdetai?page=<%=currentPage-1%>"><</a>
						<%
							}
							for(int p=currentPage-3;p<=currentPage+3;p++) {
						 		if(p>0 && p <=numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/danhsachdetai?page=<%=p%>" <%if(p==currentPage){%> style="color: red" <%}%>><%=p%></a></li>
						<%
								}
							}
							if(currentPage<numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/danhsachdetai?page=<%=currentPage+1%>">></a>
						<%
							}
						%>
					</ul>
					</nav>	
					<!-- End Paging -->
						<a class="btn btn-default" id="xuatDt" href="<%=request.getContextPath()%>/taivedanhsach">Xuất DS Excel </a>	
				<%} %>	
				</div>
				</div>
				
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>