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

	<%@ include file="./templates/Admin/Header.jsp" %>
	<div class="container">
		<div class="row">
		<%@ include file="./templates/Admin/ThoiGian-left.jsp" %>
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
				<div class="text-center">
					<h4 >CÁC ĐỢT ĐĂNG KÝ</h4>
				</div>
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