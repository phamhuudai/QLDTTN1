package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.GIAOVIEN;
import model.bo.GiaoVienBO;
import model.dao.GiaoVienDAO;
import model.dao.IdProcess;

/**
 * Servlet implementation class ControllerThemGVTT
 */
public class ControllerThemGVTT extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerThemGVTT() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		if(request.getParameter("them")==null){
			response.sendRedirect(request.getContextPath()+"/Admin_GV_ThemThongThuong.jsp");
		}else if("Thêm".equals(request.getParameter("them"))){			
			String hoten=request.getParameter("ten");
			String str_ngaysinh=request.getParameter("ngaysinh");
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date ngaysinh = new Date();
			try {
				ngaysinh =(Date)sdf.parse(str_ngaysinh);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String macn=request.getParameter("cn");
			String email=request.getParameter("email");
			 sdt=request.getParameter("sdt");
			String diachi=request.getParameter("dc");			
			IdProcess idPr = new IdProcess();
			String magv =idPr.getID("MaGVHD", "giaovien")+"";			
			GIAOVIEN objGV = new GIAOVIEN(magv, hoten, ngaysinh, macn, email,diachi, sdt);
			GiaoVienBO gvBo = new GiaoVienBO();
			if(gvBo.insertData(objGV)){
				response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=add");
			}else{
				response.sendRedirect(request.getContextPath()+"/danhsachgv?msg=error");
			}
		}
		
		/*GiaoVienDAO mGV = new GiaoVienDAO();
    	ArrayList<GIAOVIEN> arGV = mGV.getList();
    	boolean check=true;
    	String ma = request.getParameter("ma");
		
		
		
		
		String ten=request.getParameter("ten");
        byte[] t = ten.getBytes("ISO-8859-1");
        ten = new String(t, "UTF-8");
        String dc=request.getParameter("dc");
        byte[] d = dc.getBytes("ISO-8859-1");
        dc = new String(d, "UTF-8");
        
        
    	 for (GIAOVIEN gv : arGV) {
			if(gv.getMagvhd().trim().equals(ma)){
				check=false; 
				break;
			}
		}
    	 if(check){
    		 GIAOVIEN g =new GIAOVIEN(ma, ten, ngaysinh, cn, email, sdt, dc);
    		 mGV.insertGV(g);
    		 out.print("<script type='text/javascript'>");
  			out.print("alert('Đã thêm thành công!'); window.location='danhsachgv'");
  			out.print("</script>");
    	 }else{
    		out.print("<script type='text/javascript'>");
 			out.print("alert('Mã GV đã tồn tại!'); window.location='Admin_GV_ThemThongThuong.jsp'");
 			out.print("</script>");
    	 }*/
	}

}
