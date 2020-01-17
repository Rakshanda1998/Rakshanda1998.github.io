package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

/**
 * Servlet implementation class EditMenuItemServlet
 */
@WebServlet({ "/EditMenuItemServlet", "/EditMenuItem" })
public class EditMenuItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMenuItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("static-access")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			long id = Long.parseLong(request.getParameter("menuItemId"));
			String name = request.getParameter("txtName");
			float price = Float.parseFloat(request.getParameter("txtPrice"));

			boolean active = request.getParameter("active").equals("yes");
			Date dateOfLaunch = new DateUtil().convertToDate(request.getParameter("launch"));
			String category = request.getParameter("category");
			boolean freeDelivery = request.getParameter("checkkbox") != null;

			MenuItem menuItem = new MenuItem(id, name, price, active, dateOfLaunch, category, freeDelivery);
			MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
			menuItemDao.modifyMenuItem(menuItem);
			request.setAttribute("msg", "Menu Items Details Saved Successfully");
			RequestDispatcher rqd = request.getRequestDispatcher("edit-menu-item-status.jsp");
			rqd.forward(request, response);

		} catch (Exception ex) {
			ex.getMessage();

		}

	}
}
