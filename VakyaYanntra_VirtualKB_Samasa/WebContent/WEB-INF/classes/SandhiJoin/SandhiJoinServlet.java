package SandhiJoin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import wordProcessor.join;

/**
 * Servlet implementation class SandhiJoinServlet
 */
@WebServlet("/SandhiJoinServlet")
public class SandhiJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SandhiJoinServlet() {
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
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String sandhiJoin = request.getParameter("data");
		String result = getSandhiJoin(sandhiJoin);
		System.out.println(sandhiJoin + " sandhi join request");
		System.out.println("sending" + result);
		out.print(result);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	String getSandhiJoin(String str){
		 String word=null;
		 String joinResult = "" ;
	        word=str;
	        String[] arr = null;
	        if( word!=null)
	        {
	         arr=word.split(" ");
	        }
	       
	        if(arr.length>1)
	        {
	        join j=new join();
	        String[] finalResult= new String[arr.length];
	        System.out.println(arr.length);
	        String result=j.performJoin(arr[0],arr[1]);
	        int x=0;
	        if(result.indexOf(" ")!=-1)
	        {
	        	String[] temp=result.split(" ");
	        	finalResult[0]=temp[0];
	        	finalResult[1]=temp[1];
	        	x++;
	        }
	        else
	        {
	        	finalResult[0]=result;
	        	
	        }
	        for(int i=2;i<arr.length;i++)
	        {
	            if(arr[i].trim()!="")
	            { 
	            	System.out.println(x+" "+i);
	            	System.out.println(" "+finalResult[x]);
	                result=j.performJoin(finalResult[x],arr[i]); 
	                if(result.indexOf(" ")!=-1)
	                {
	                	x++;
	                	finalResult[x]=getLastWord(result);
	                }
	                else
	                {
	                	finalResult[x]=result;
	                }
	            }
	        }
	      
	        for(int i=0;i<=x;i++)
	        {
	        	System.out.println(finalResult[i]);
	        	joinResult = joinResult + " " + finalResult[i];
	            //jTextPane3.setText(jTextPane3.getText()+" "+finalResult[i]);
	        }
	        }
return joinResult;
	    }
	
public String getLastWord(String word)
{
	String lastWord;
	String array[] = word.split(" ");
	lastWord=array[array.length-1];
	return lastWord;
}
}
