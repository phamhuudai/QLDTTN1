<%@page import="model.bean.GIAOVIEN"%>
<%@page import="model.dao.GiaoVienDAO"%>
<%@page import="model.bean.CHUYENNGANH"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.ChuyenNganhDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Thêm Giáo Viên</title>
<link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/style.css"/>
    <link rel="stylesheet" href="css/datepicker.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
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
    function isID(value) {
    	var chaos = new Array ("'","~","@","#","$","%","^","&","*",";","/","\\","|");
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
    		name= document.getElementById('ten').value;
    		cn =document.getElementById('cn').value; 		
    		sdt =document.getElementById('sdt').value;
    		dc=document.getElementById('dc').value;
    		
    		if(""==name&&"0"==cn){
    			alert("Vui lòng nhập đầy đủ thông tin");
    			return false;
    		}
    		else if(""==name){
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
	<%@ include file="./templates/Admin/Header.jsp" %>
	<div class="container">
		<div class="row">		
			<div class="col-md-3">
				<div class="well">	      
							
				<h4 class="title" style="text-align:center;padding-bottom:10px;">THÊM GIÁO VIÊN</h4>
				<ul class="nav">
            		<li style="background-color:#99FFFF"><a href="" >Thêm thông thường</a></li>
            		<li><a href="<%=request.getContextPath()%>/themGV_file?type=load">Thêm từ file</a></li>
            		
            	</ul>
				</div>
			</div>
			<div class="col-md-9">
			<div class="well">
				<h4>THÊM GIÁO VIÊN</h4>
                <form class="form-horizontal" action="themgvtt" method="POST" onsubmit="return check()" accept-charset="UTF-8" >
                    <div class="form-group">
                        <label class="control-label col-xs-2">MSGV (*)</label>
                        <div class="col-xs-10">
                            <input class="form-control" name="ma" type="text" placeholder="MSGV" id="ma" disabled >
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-2">Tên GV (*)</label>
                        <div class="col-xs-10">
                            <input type="text" class="form-control" id="ten" name="ten" placeholder="Tên GV" >
        
                        </div>   
                    </div>
                       <div class="form-group">
                        <label class="control-label col-xs-2">Ngày sinh </label>
                        <div class="col-xs-10">         
                        	<div class="hero-unit">
				                <input class="form-control" name="ngaysinh" type="text" placeholder="Ngày sinh"  id="example1">
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
                    <%
                    	ChuyenNganhDAO mCN = new ChuyenNganhDAO();
                                        	ArrayList<CHUYENNGANH> arCN=mCN.getList();
                    %>
                	  <option value="0">--------------Chọn chuyên ngành--------------</option>
					  <%for (CHUYENNGANH objCN : arCN){
						%>
						<option value="<%=objCN.getMacn()%>"><%=objCN.getTencn()%></option>
						<%} %>
					</select>
					</div>
                 	</div>
                      <div class="form-group">
                        <label class="control-label col-xs-2">Email</label>
                        <div class="col-xs-10">
                            <input  class="form-control" id="email" name="email" placeholder="Email" >
                        </div>   
                    </div>
                     <div class="form-group">
                        <label class="control-label col-xs-2">Địa chỉ</label>
                        <div class="col-xs-10">                       
                            <input type="text" class="form-control" id="dc" name="dc" placeholder="Địa chỉ" >        
                        </div>  
                      </div>
                      <div class="form-group">
                        <label class="control-label col-xs-2">SĐT</label>
                        <div class="col-xs-10">
                            <input type="text" class="form-control" id="sdt" name="sdt" placeholder="Số điện thoại" >
                        </div> 
                    </div>
                   
                      <input class="btn btn-default" id="GV_Nhapbtn" name="them" type="submit" value="Thêm" ></input>
					<a class="btn btn-default"  href="<%=request.getContextPath()%>/danhsachgv" >Hủy</a>
                </form>
   
                </div>
				
					
						
					
				</div>
				
				</div>
			</div>
		
		</div>
		
	</div><!-- Container- conten  -->
	
</body>
</html>