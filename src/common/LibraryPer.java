package common;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.NGUOIDUNG;


public class LibraryPer {
	public static boolean isAdmin(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		NGUOIDUNG sObjND = (NGUOIDUNG)session.getAttribute("sObjND");
		if(sObjND==null){			
			try {
				response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}else{
			if(! "ADMIN".equals(sObjND.getPhanQuyen())){
				try {
					response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		}
		return true;
		
	}
	public static boolean isTeacher(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		NGUOIDUNG sObjND = (NGUOIDUNG)session.getAttribute("sObjND");
		if(sObjND==null){			
			try {
				response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}else{
			if(! "GV".equals(sObjND.getPhanQuyen())){
				try {
					response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		}
		return true;
		
	}
	public static boolean isStudent(HttpServletRequest request, HttpServletResponse response){
		HttpSession session = request.getSession();
		NGUOIDUNG sObjND = (NGUOIDUNG)session.getAttribute("sObjND");
		if(sObjND==null){			
			try {
				response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
		}else{
			if(! "SV".equals(sObjND.getPhanQuyen())){
				try {
					response.sendRedirect(request.getContextPath()+"/HomePage.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return false;
			}
		}
		return true;
		
	}
}
