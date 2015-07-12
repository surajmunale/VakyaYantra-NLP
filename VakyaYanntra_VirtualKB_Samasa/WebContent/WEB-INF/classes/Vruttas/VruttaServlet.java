package Vruttas;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wordProcessor.join;
import Matra.Matra;

/**
 * Servlet implementation class VruttaServlet
 */
@WebServlet("/VruttaServlet")
public class VruttaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VruttaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getCharacterEncoding() == null)
			request.setCharacterEncoding("UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		//response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String vrutta = request.getParameter("data");
		String vruttaResult = getvrutta(vrutta);
		System.out.println(vrutta + " vrutta request");
		System.out.println("sending " + vruttaResult);
		out.print(vruttaResult);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	String getvrutta(String str){
		  String string1 = "";
	        if(!str.trim().equals(""))
	        
	            string1=str.trim();
	      
	        string1=string1.trim();
	        Matra m=new Matra();
	        join j=new join();
	        string1=j.StoE(string1);
	        return m.vrutta(string1);
		
	}

}
