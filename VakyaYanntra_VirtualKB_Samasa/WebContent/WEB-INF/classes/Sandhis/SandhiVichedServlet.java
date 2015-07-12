package Sandhis;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wordProcessor.connect;
import wordProcessor.db;

/**
 * Servlet implementation class SandhiVichedServlet
 */
@WebServlet("/SandhiVichedServlet")
public class SandhiVichedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	connect c = new connect();
	Connection con = (Connection) c.connection();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SandhiVichedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//request.setCharacterEncoding("UTF-8");
		if (request.getCharacterEncoding() == null)
			request.setCharacterEncoding("UTF-8");
		String sandhiViched = request.getParameter("data");

		System.out.println(sandhiViched + " sandhi request");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//sandhiViched = new String(sandhiViched.getBytes(), "UTF-8");
		String[] arrayOfWords = sandhiViched.split(" ");
		String result = "";
		for (int i = 0; i < arrayOfWords.length; i++)
			result = result + getSandhiViched(arrayOfWords[i]);

		System.out.println("sending" + result);
		out.print(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	String getSandhiViched(String word) {
		try {

			ResultSet S = null;
			System.out.println("con" + con);
			PreparedStatement stat = (PreparedStatement) con
					.prepareStatement("SELECT meaning FROM dict where word = CONVERT('"
							+ word + "' USING utf8)");
			S = stat.executeQuery();
			if (S.next()) {
				System.out.print("present");
				return S.getString(1);

			} else {
				// PatternMatch pm = new PatternMatch();
				// ArrayList<String> arr1 = new ArrayList<String>();
				// arr1 = pm.sandhiPatternCheck(word);
				// if (arr1.isEmpty()) {

				mulitipleSplit ms = new mulitipleSplit();
				ArrayList<String> solution = ms.process(word);
				String Result = "";
				System.out.println("Result");
				for (int i = 0; i < solution.size(); i++) {
					if (i == solution.size() - 1)
						Result = Result + solution.get(i) + "("
								+ getMeaning(solution.get(i)) + ")";
					else
						Result = Result + solution.get(i) + "("
								+ getMeaning(solution.get(i)) + ")+";
				}
				if (!Result.equals(""))
					return Result + " = " + word;
				// }
			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	String getMeaning(String word) {
		db dbObject = new db();
		String meaning;
		meaning = dbObject.findMeaning(word);
		return meaning;
	}
}
