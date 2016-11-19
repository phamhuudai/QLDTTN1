<%@page import="model.bean.GIAOVIEN"%>
<%@page import="model.bean.CHUYENNGANH"%>
<%@page import="model.bean.DETAI"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa đề tài</title>
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
					<h4>SỬA ĐỀ TÀI</h4>
				<%
					DETAI objDeTai =(DETAI) request.getAttribute("objDeTai");
				%>
				<!-- Do du lieu tai day  -->
					<form class="form-horizontal" action="<%=request.getContextPath()%>/suadetai?madt=<%=objDeTai.getMadetai()%>" method="post">
					<div class="form-group">
                       <label class="control-label col-xs-2">Mã đề tài </label>
                       <div class="col-xs-5">
                           <input class="form-control" id="disabledInput"  type="text"  value="<%=objDeTai.getMadetai()%>" disabled>
                       </div>
                   	</div>
					<div class="form-group">
                       <label class="control-label col-xs-2">Tên đề tài </label>
                       <div class="col-xs-5">
                           <input class="form-control" id="disabledInput" name="tenDeTai" value="<%=objDeTai.getTendetai() %>" type="text"  >
                       </div>
                   	</div>
               
					<div class="form-group">
				
                    <label class="control-label col-md-2">Chuyên ngành </label>
                    <div class="col-md-5">
                    <select class="form-control" name="maCN">
                	  <option value="0">--------------Chọn chuyên ngành--------------</option>
                	  <%
                	  	ArrayList<CHUYENNGANH> arCN =(ArrayList<CHUYENNGANH>)request.getAttribute("arCN");
                	  	for(CHUYENNGANH objCN:arCN){
                	  %>
					  <option value="<%=objCN.getMacn()%>" <%if(objCN.getMacn()==objDeTai.getMacn()){ out.print("selected='selected'");} %>  ><%=objCN.getTencn() %></option>
					 <%} %>
					 
					</select>
					</div>
                 </div>
             
                 
                 <div class="form-group">
                    <label class="control-label col-md-2">GVHD </label>
                    <div class="col-md-5">
                    <select class="form-control" name="maGVHD">
                	  <option value="0">-----------------Chọn GVHD-----------------</option>
					 <%
                	  	ArrayList<GIAOVIEN> arGV =(ArrayList<GIAOVIEN>)request.getAttribute("arGV");
                	  	for(GIAOVIEN objGV:arGV){
                	  %>
					  <option value="<%=objGV.getMagvhd()%>" <%if(objGV.getMagvhd()==objDeTai.getMagvhd()){ out.print("selected='selected'");} %>><%=objGV.getHoten() %></option>
					 <%} %>
					</select>
					</div>
                 </div>
                 
                 <div class="form-group">
                 	<label class="control-label col-md-2" >Nội dung </label>
                 	<div class="col-xs-10">
                            <textarea class="form-control" rows="3" name="noiDung"><%=objDeTai.getThongtinnoidung() %></textarea>
                        </div>  
                 </div>
                 <div class="form-group">
                 <button class="btn btn-default" type="submit" id="GV_Nhapbtn" name="edit" value="edit">Sửa</button>
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