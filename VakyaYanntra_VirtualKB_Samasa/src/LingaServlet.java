

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

//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import readFromXML.Monier;
import readFromXML.ReadXMLDOM;



/**
 * Servlet implementation class SandhiVichedServlet
 */


public class LingaServlet extends HttpServlet {
	
	
	private static ArrayList<Monier> mList= new ArrayList<Monier>();
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		if (request.getCharacterEncoding() == null)
			request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ReadXMLDOM handler = new ReadXMLDOM("monier1.xml");
		
		mList = handler.getList();
		for(Monier word: mList){
			//System.out.println(request.getParameter("data"));
			//System.out.println("word:::"+word.getKey1());
			String[] strCompare=word.getKey1().split("\\(");
			//System.out.println("strcompare::::"+strCompare[0]);
			if(request.getParameter("data").equalsIgnoreCase(strCompare[0])){
				out.println(strCompare[1]);
				
			
			
		}
		

	}



	
	}
}
