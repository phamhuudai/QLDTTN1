package common;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NGUOIDUNG;
import bean.User;

public class LibraryPer {
	public static String checkUser(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		NGUOIDUNG sObjNguoiDung = (NGUOIDUNG)session.getAttribute("sObjNguoiDung");
		if(sObjNguoiDung==null){
			try {
				response.sendRedirect(request.getContextPath()+"/admin/login");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}
		return true;
	}
}
