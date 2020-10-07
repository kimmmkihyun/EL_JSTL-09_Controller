package myPkg;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
//@WebServlet("*.do")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
		ServletContext context = null; //application으로 설정한 것을 알아오기 위함
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		context = config.getServletContext();
		
			
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGet()");
		
		doProcess(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		System.out.println("doPost()");
		
		doProcess(request,response);
	}

	
	public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("doProcess()");
		
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		int len = contextPath.length();
		
		String command = uri.substring(len);
		
		MemberCommand mcommand = null; // MemberCommand의 자식클래스를 관리하기 위해서 변수를 만들어 놓고 자식 객체를 관리한다.
		
		String viewPage = "";
		String flag = (String)context.getAttribute("flag");
		
		if(command.equals("/insertProc.do")) {
			System.out.println("insertProc 요청");
						
			if(flag.equals("false")) {
				mcommand = new MInsertCommand();
				mcommand.excute(request, response);
				context.setAttribute("flag", "true");
				viewPage = "/list.do";
			}
			else {
				viewPage = "/list.do";
			}
			
			
		}
		
		
		else if(command.equals("/list.do")) {
			System.out.println("list 요청");
			
			mcommand = new MListCommand();
			mcommand.excute(request, response);
			
			viewPage = "list.jsp";
			
		}
		
		
		else if(command.equals("/updateForm.do")) {
			System.out.println("updateForm 요청");
			
			mcommand = new MUpdateFormCommand();
			mcommand.excute(request, response);
			
			viewPage = "updateForm.jsp";
			
		}
		
		
		else if(command.equals("/updateProc.do")) {
			System.out.println("updateProc 요청");
			
			mcommand = new MUpdateCommand();
			mcommand.excute(request, response);
			
			viewPage = "/list.do";
		}
		
		
		else if(command.equals("/delete.do")) {
			System.out.println("delete 요청");
			
			mcommand = new MDeleteCommand();
			mcommand.excute(request, response);
			
			viewPage = "/list.do";
		}
		
		RequestDispatcher dis = request.getRequestDispatcher(viewPage);
		dis.forward(request, response);
		
		
		
		
		
	}
	
	
}
