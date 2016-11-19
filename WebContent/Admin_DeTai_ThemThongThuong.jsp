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
	<%@ include file="./templates/Admin/Header.jsp" %>
	<div class="container">
		<div class="row">
			<%@ include file="./templates/Admin/DeTai-Left.jsp" %>
			<div class="col-md-9">
				<div class="well">
					<h4 class="text-center">THÊM ĐỀ TÀI</h4>
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
					<a class="btn btn-default" href="<%=request.getContextPath()%>/danhsachdetai">Hủy</a>
	                 </div>
                 </form>
                
				
					
				</div>
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>