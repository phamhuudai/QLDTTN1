<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm từ file</title>
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
				<h4>NHẬP TỪ FILE</h4>
                <form action="<%=request.getContextPath()%>/themdetai-file"	enctype="multipart/form-data" method="post">
                  
				   <div class="form-group">
						<label class="control-label col-xs-2">Chọn file</label>
						<div class="col-xs-10">
							<input type="file" class="file" name="danhSachGV">
							<p class="help-block">Chọn file .xlsx</p>
						</div>
					</div>				  
				<button class="btn btn-default" id="GV_Nhapbtn" type="submit">Nhập</button>
				<a class="btn btn-default" href="<%=request.getContextPath()%>/danhsachdetai">Hủy</a>
                      
                </form>
                
                </div>
				
					
						
					
				</div>
				
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>