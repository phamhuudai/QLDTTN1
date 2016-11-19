<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cài đặt thời gian</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
   <link rel="stylesheet" href="css/datepicker.css"/>
    <script src="js/bootstrap-datepicker.js"></script>
</head>
<body>

	<%@ include file="./templates/Admin/Header.jsp" %>
	<div class="container">
		<div class="row">
		<%@ include file="./templates/Admin/ThoiGian-left.jsp" %>
			<div class="col-md-9">
				<div class="well">
					<h4 align="center">CÀI ĐẶT THỜI GIAN ĐĂNG KÝ</h4>
					<form class="form-horizontal" action="<%=request.getContextPath()%>/DatThoiGian">                        
                        <div class="form-group">
                        <label class="control-label col-xs-2">Thời gian BĐ </label>
	                  	<div class="col-xs-5">
                            <div class="hero-unit">
				                <input class="form-control" name="tgBatDau" type="text" placeholder="dd/mm/yyy"  id="tgBatDau" >
				            </div>
		                    <script type="text/javascript">
					            // When the document is ready
					            $(document).ready(function () {
					                
					                $('#tgBatDau').datepicker({
					                    format: "dd/mm/yyyy"
					                });  
					            
					            });
					        </script>
                        </div>
   						</div>                            
                     
                    	<div class="form-group">
                        <label class="control-label col-xs-2">Thời gian KT </label>
	                  	<div class="col-xs-5">
                            <div class="hero-unit">
				                <input class="form-control" name="tgKetThuc" type="text" placeholder="dd/mm/yyyy"  id="tgKetThuc" >
				            </div>
		                    <script type="text/javascript">
					            // When the document is ready
					            $(document).ready(function () {
					                
					                $('#tgKetThuc').datepicker({
					                    format: "dd/mm/yyyy"
					                });  
					            
					            });
					        </script>
                        </div>
   						</div> 

               
					<div class="form-group">
					<label class="control-label col-md-2">Thời gian TH </label>
                    <div class="col-md-5">
                    <select class="form-control" name="tgThucHien">
                	  <option >--------------Chọn thời gian--------------</option>
					  <option value="3">3 tháng</option>
					  <option value="4">4 tháng</option>
					  <option value="5"> 5 tháng</option>
					</select>
					</div>
                 	</div>           
	                 <button class="btn btn-default" id="DT_btnTao" type="submit" name="tao">Tạo</button>
					<a class="btn btn-default" href="<%=request.getContextPath()%>/CacDotDK">Hủy</a>
                 </form>
                
				
					
				</div>
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>