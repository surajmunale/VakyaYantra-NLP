package transliteration;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetTransliterateServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public void doGet (HttpServletRequest request,HttpServletResponse response) 
			throws ServletException, IOException 
	{
		
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//choose_encoding getText= new choose_encoding();
		//getText.get_raw_to_dvn_view(request.getParameter("t"));
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String trans=request.getParameter("trans");
		 System.out.println(trans + " trans request");
		 choose_encoding getText= new choose_encoding();
		 
		 String getString = getText.get_raw_to_dvn_view(trans);
		 System.out.println("sending" + getString);
		 out.print(getString);
	}
	
	 @Override
	    public void doPost(HttpServletRequest req, HttpServletResponse res)
	            throws ServletException, IOException {
		// System.out.println("doPost");
		 PrintWriter out = res.getWriter();
		 String trans=req.getParameter("trans");
		 System.out.println(trans + " trans");
		 choose_encoding getText= new choose_encoding();
		 out.println(getText.get_raw_to_dvn_view(trans));

	    }
}