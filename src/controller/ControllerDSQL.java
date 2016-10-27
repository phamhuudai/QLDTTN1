package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DANHSACHQL;
import model.bo.DanhSachQuanLyBO;
import model.dao.DanhSachQLDAO;

/**
 * Servlet implementation class ControllerDSQL
 */
public class ControllerDSQL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControllerDSQL() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		int maGV = Integer.parseInt(request.getParameter("maGV"));
		DanhSachQuanLyBO ds = new DanhSachQuanLyBO();
		ArrayList<DANHSACHQL> arDS = ds.getList(maGV);
		String result = "";
		if (arDS.size() == 0) {
			result += "<h4 style='text-align:center'>Không có dữ liệu</h4>";
		} else {
			result = "<table class='table table-bordered'>" + "<thead>"
					+ "<tr>" + "<th>Tên sinh viên</th>" + "<th>MSSV</th>"
					+ "<th>Lớp</th>" + "<th>Email</th>" + "<th>SĐT</th>"
					+ "<th>Chuyên ngành</th>" + "<th>Đề tài</th>" + "</tr>"
					+ "</thead>" + "<tbody>";
			for (DANHSACHQL objDS : arDS) {
				result += "<tr>" + "<td>" + objDS.getTenSV() + "</td>" + "<td>"
						+ objDS.getMaSV() + "</td>" + "<td>" + objDS.getLop()
						+ "</td>" + "<td>" + objDS.getEmail() + "</td>"
						+ "<td>" + objDS.getSdt() + "</td>" + "<td>"
						+ objDS.getTenCN() + "</td>" + "<td>"
						+ objDS.getTenDT() + "</td>" + "</tr>";
			}
			result += "</tbody></table>";
		}
		out.print(result);
	}

}
