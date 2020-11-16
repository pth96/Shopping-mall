package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.CartListDTO;
import service.CartListService;

@WebServlet("/cartlist")
public class CartListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartListController() {
		super();

	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		CartListService clService = new CartListService();
		List<CartListDTO> cartlist = clService.cartlist(request, response);

		if (cartlist != null) {
			request.setAttribute("cartlist", cartlist);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CartList.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("MemberLogin.jsp");
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
