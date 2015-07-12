import java.awt.HeadlessException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;



import readFromXML.Monier;
import readFromXML.ReadXMLDOM;
import scala.Console;
import transliteration.*;
import java.sql.Connection;
/**
 * Servlet implementation class SandhiVichedServlet
 */

public class ArthaServlet extends HttpServlet {

	private static ArrayList<Monier> mList = new ArrayList<Monier>();
	public String findMeaning(String word)  
	{
		Connection con=null;
		String url = "jdbc:mysql://localhost:3306/chitrakavya?characterSetResults=UTF-8&characterEncoding=UTF-8&useUnicode=yes";
        
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "root";
        try 
        {
            Class.forName(driver).newInstance();
            
            con = DriverManager.getConnection(url, user,null);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        StringBuffer meaning=new StringBuffer();
        ResultSet S = null;
		PreparedStatement stat = null;
		try 
		{
			stat = (PreparedStatement)
					con.prepareStatement("SELECT meaning FROM dict where word = CONVERT('"
							+ word + "' USING utf8)");
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			S = stat.executeQuery();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			while (S.next()) 
			{
				System.out.print("present");
			//	JOptionPane.showMessageDialog(null, S.getString(1));
				
				String tmpstr= S.getString(1);
				meaning.append(tmpstr);
				//meaning.concat(tmpstr);
			}
		}
		catch (HeadlessException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return meaning.toString();
    }

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		boolean flag = false;
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		request.setCharacterEncoding("UTF-8");
	
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		/*
		ReadXMLDOM handler = new ReadXMLDOM("monier1.xml");
		mList = handler.getList();
		*/
		String inputstring=request.getParameter("data");
		devanagari d = new devanagari();
		
		System.out.println(d.transform(inputstring));
		
		DvnTOSLP slp=new DvnTOSLP();
		inputstring=slp.transform(inputstring);
		System.out.println(inputstring);
		String mean=findMeaning(inputstring);
		System.out.println(mean);
		
		
		
		/*
		for (Monier word : mList) 
		{
			// System.out.println(request.getParameter("data"));
			// System.out.println("word:::"+word.getKey1());
			
			String[] strCompare = word.getKey1().split("\\(");
			// System.out.println("strcompare::::"+strCompare[0]);
			String sanskutWord= d.transform(strCompare[0]);
			System.out.println(sanskutWord);
			
			if (inputstring.equalsIgnoreCase(strCompare[0])) 
			{
				out.println(word.getC());
				flag = true;
				System.out.println("meaning is ::::" + word.getC());
			}
			/*
			if (inputstring.equalsIgnoreCase(strCompare[0])) {
				out.println(word.getC());
				flag = true;
				System.out.println("meaning is ::::" + word.getC());
			}
			
		}
		*/
		if (mean == null)
			out.println("No such word found");
		else
			out.println(mean);
	}
}