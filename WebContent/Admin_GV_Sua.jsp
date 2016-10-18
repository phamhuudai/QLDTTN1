<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.bean.GIAOVIEN"%>
<%@page import="model.bean.CHUYENNGANH"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ChuyenNganhDAO"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sửa Giáo Viên</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/datepicker.css"/>
    <script src="js/bootstrap-datepicker.js"></script>
    <script type="text/javascript">
    
	    function validText(value) {
	    	var chaos = new Array ("'","~","@","#","$","%","^","&","*",";","/","\\","|","1","2","3","4","5","6","7","8","9","0");
	    	var sum = chaos.length;
	    	for (var i in chaos) {if (!Array.prototype[i]) {sum += value.lastIndexOf(chaos[i])}}
	    	if (sum) {
	    	
	    	return false;
	    	}
	    	return true;
	    	}
	    function isSpace(value){
	    	var rs =false;
	    	var d=0;
	    	for(i=0;i<value.length;i++){
	    		if(value.charAt(i)==' ') d++;
	    	}
	    	if(d==value.length&&d>0) rs=true;
	    	return rs;
	    }
	    function isEmail(email) {
			var isValid = false;
			var regex = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
			if(regex.test(email)) {
				isValid = true;
			}
			return isValid;
			
		}
	    
    	function check(){
    		email=document.getElementById('email').value;
    		name=document.getElementById('name').value;
    		cn =document.getElementById('cn').value;
    		sdt =document.getElementById('sdt').value;
    		dc=document.getElementById('dc').value;
    		if(""==name&&"0"==cn){
    			alert("Vui lòng nhập đầy đủ thông tin");
    			return false;
    		}else if(""==name){
    			alert("Vui lòng nhập tên GV");
    			return false;
    		}else if(!validText(name)||isSpace(name)){
    			alert("Tên không đúng định dạng!");
    			return false;
    		}
    		else if("0"==cn){
    			alert("Vui lòng chọn tên chuyên ngành");
    			return false;
    		}else if(""!=email&&!isEmail(email)){
    			alert("Email Không đúng định dạng!");
    			return false;
    		}else if(""!=sdt&&isNaN(sdt)||isSpace(sdt)){
    			alert("Số điện thoại không đúng định dạng");
    			return false;
    		}else if(isSpace(dc)){
    			alert("Địa chỉ không hợp lệ");
    			return false;
    		}
    		else{
    			
    			
    			return true;
    		}
    		
    	}
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
					    	<li><p style="margin-top:15px;color:white"><span class="glyphicon glyphicon-user"></span>: Admin</p></li><!-- xuất thông tin người dung ở chỗ nay-->
					      	<li><a href="" action = "#"> |Đăng xuất</a></li>
					    </ul>
					  </div>
					</nav>
		</div> <!-- menu -->
	</div><!-- container -menu -->
	<div class="container">
		<div class="row">
	 <%
			  
	          ArrayList<CHUYENNGANH> arCN = (ArrayList<CHUYENNGANH>)request.getAttribute("arCN");
	          GIAOVIEN objGV =(GIAOVIEN) request.getAttribute("objGV");
	          out.print(objGV);
	          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	 %>
			<div class="col-md-12">
			<div class="well">
				<h4>SỬA GIÁO VIÊN</h4>
                <form class="form-horizontal" action="suagv?id=<%=objGV.getMagvhd()%>" onsubmit="return check()" accept-charset="UTF-8" method="post">
                    <div class="form-group">
                        <label class="control-label col-xs-2">MSGV</label>
                        <div class="col-xs-10">
                            <input class="form-control" id="disabledInput" name="msgv" type="text" placeholder="MSGV" value="<%=objGV.getMagvhd()%>" disabled>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-2">Tên GV (*)</label>
                        <div class="col-xs-10">
                       
                            <input type="text" class="form-control" id="name" name="tenGv" placeholder="Tên GV" value="<%=objGV.getHoten()%>">
        
                        </div>   
                    </div>
                       <div class="form-group">
                        <label class="control-label col-xs-2">Ngày sinh </label>
                        <div class="col-xs-10">         
                        	<div class="hero-unit">
				                <input value=<%=objGV.getNgaysinh()!=null ? sdf.format(objGV.getNgaysinh()) : "-------" %> class="form-control" name="ngaysinh" type="text" placeholder="Ngày sinh"  id="example1">
				            </div>
		                    <script type="text/javascript">
					            // When the document is ready
					            $(document).ready(function () {
					                
					                $('#example1').datepicker({
					                    format: "dd/mm/yyyy"
					                });  
					            
					            });
					        </script>
                               
                        </div>    
                    </div>
                    <div class="form-group">
					<label class="control-label col-md-2">Chuyên ngành (*) </label>
                    <div class="col-md-5">
                    <select class="form-control" name="cn" id="cn">
                	  <option value="0">--------------Chọn chuyên ngành--------------</option>
					  <%for (CHUYENNGANH objCN : arCN){
						  if(objGV.getMacn()==objCN.getMacn()){
						%>
							<option selected='selected' value="<%=objCN.getMacn()%>"><%=objCN.getTencn()%></option>
						<%} 
						  else{
						%>
							<option value="<%=objCN.getMacn()%>"><%=objCN.getTencn()%></option>  
						<%}
					  	}
						%>
					</select>
					</div>
                 	</div>
                      <div class="form-group">
                        <label class="control-label col-xs-2">Email</label>
                        <div class="col-xs-10">
                            <input class="form-control" name="email" id="email" placeholder="Email" value="<%=objGV.getEmail().trim()%>">
                        </div>   
                    </div>
                      
                    <div class="form-group">
                        <label class="control-label col-xs-2" >Địa chỉ</label>
                        <div class="col-xs-10">
                       
                            <input type="text" id="dc" class="form-control" name="dc" placeholder="Địa chỉ" value="<%=objGV.getDiaChi()%>">
        
                        </div>  
                      </div>
                      <div class="form-group">
                        <label class="control-label col-xs-2">SĐT</label>
                        <div class="col-xs-10">
                            <input type="text" class="form-control" name="sdt" placeholder="Số điện thoại" id="sdt" value="<%=objGV.getSdt().trim() %>">
                        </div> 
                    </div>
                      <input class="btn btn-default" id="GV_Nhapbtn" type="submit" name="sua" value="Sửa" ></input>
                    
					  <input class="btn btn-default" type="button" value="Hủy" onclick="window.location='danhsachgv'"></input>
					  
                </form>
               		
               
                </div>
				
					
						
					
				</div>
				
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>