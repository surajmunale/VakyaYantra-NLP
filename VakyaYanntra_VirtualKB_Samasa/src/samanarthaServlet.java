

import java.io.IOException;



import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

import readFromXML.MakeMap;
import readFromXML.Monier;
import readFromXML.ReadXMLDOM;
import semantics.GenerateSynonym;
import semantics.SynonymThread;



/**
 * Servlet implementation class SandhiVichedServlet
 */


public class samanarthaServlet extends HttpServlet {
	
	
	private static ArrayList<Monier> mList= new ArrayList<Monier>();
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		if (request.getCharacterEncoding() == null)
			request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		ReadXMLDOM handler = new ReadXMLDOM("monier2.xml");
		
		mList = handler.getList();
		
		System.out.println("before makemap");
		MakeMap maps= new MakeMap(mList);
		maps.mapWM();
		
		System.out.println("after make map");
		
		GenerateSynonym gs= new GenerateSynonym();
		System.out.println("Generating synonyms");
		gs.synonymMap(request.getParameter("data"));
		
		
		
		
		System.out.println("smaanarth count :::"+GenerateSynonym.samanarthaCount);
		if(GenerateSynonym.samanarthaCount<0){
			out.println("No Such word present in the dictionary");
		}
		else{
		for(int i=0;i<=GenerateSynonym.samanarthaCount;i++){
			String[] strCompare=SynonymThread.samanartha[i].split("\\(");
			if(SynonymThread.samanartha[i]!=null && !(strCompare[0].equalsIgnoreCase(request.getParameter("data"))))
			out.println(SynonymThread.samanartha[i]);
		}
		}
		
		
		//gs.displaySynset();

		
		

		GenerateSynonym.samanarthaCount=-1;
	}



	
}
