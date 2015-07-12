package Samasa;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import transliteration.choose_encoding;

/**
 * Servlet implementation class samasaServlet
 */
@WebServlet("/samasaServlet")
public class samasaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public samasaServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		if (request.getCharacterEncoding() == null)
			request.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String samasa = request.getParameter("data");
		System.out.println(samasa + " samasa request");
		String split = samasaSelected(samasa);
		System.out.println("sending" + split);
		out.print(split);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	private String samasaSelected(String str) {

		String inputtoSamas = null;

		if (!str.trim().equals("")) {

			inputtoSamas = str.trim();
			System.out.println("inputtosamas" + inputtoSamas);

			Dwanda_Formatted d = new Dwanda_Formatted();

			String vigraha = d.getVigraha(inputtoSamas);
			System.out.println(vigraha + " vigraha");
			if (vigraha != "")
				return vigraha;
			else
				return "Sorry, couldnt get the individual words";
		} else {
			return "Enter a proper text";

		}
	}

}
