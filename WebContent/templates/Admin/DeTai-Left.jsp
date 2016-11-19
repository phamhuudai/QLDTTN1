<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-md-3">
	<div class="well">
	<h4 class="title" style="text-align:center;padding-bottom:10px;">MENU</h4>
	<ul class="nav">
   		<li><a href="<%=request.getContextPath()%>/danhsachdetai" >Danh sách đề tài</a></li>
   		<li><a href="<%=request.getContextPath()%>/themdetaitt">Thêm đề tài thông thường</a></li>
   		<li><a href="<%=request.getContextPath()%>/themdetai-file?type=load">Nhập file excel</a></li>
   		<li><a href="<%=request.getContextPath()%>/theodoitiendo">Theo dõi tiến độ</a></li>
   	</ul>

	</div>
</div>