<%@page import="model.bean.TIENDO"%>
<%@page import="model.bean.DETAI"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Theo dõi tiến độ</title>
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
			<%
			ArrayList<TIENDO>  arTD=(ArrayList<TIENDO>)request.getAttribute("arTD");			
	
			%>
			<div class="col-md-9">
				<div class="well">
					<h4>THEO DÕI TIẾN ĐỘ</h4>
				
				<!-- Do du lieu tai day  -->
					<form action="">
					<div class="panel panel-default">
						<table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Mã đề tài</th>
                            <th>Tên đề tài</th>
                            <th>Chuyên ngành</th>
                            <th>GVHD</th>
                          	<th>Tiến độ</th>
                        </tr>
                    </thead>
                    <tbody>
                    <%
                    	for(TIENDO td : arTD){
                    %>
                    	<tr>
                    		<td><%=td.getMaDeTai() %></td>
                    		<td><%=td.getTenDeTai() %></td>
                    		<td><%=td.getTenCN() %></td>
                    		<td><%=td.getGvhd() %></td>
                    		<td><%=td.getTienDo()%> %</td>
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
						<li><a href="<%=request.getContextPath()%>/theodoitiendo?page=<%=currentPage-1%>"><</a>
						<%
							}
							for(int p=currentPage-3;p<=currentPage+3;p++) {
						 		if(p>0 && p <=numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/theodoitiendo?page=<%=p%>" <%if(p==currentPage){%> style="color: red" <%}%>><%=p%></a></li>
						<%
								}
							}
							if(currentPage<numOfPage){
						%>
						<li><a href="<%=request.getContextPath()%>/theodoitiendo?page=<%=currentPage+1%>">></a>
						<%
							}
						%>
					</ul>
					</nav>
					<!-- End Paging -->
						<button class="btn btn-default" id="dsbv" name="dsbv">Danh sách được bảo vệ </button>	
				</div>
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>