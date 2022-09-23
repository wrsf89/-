package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.dto;
import service.service;

/**
 * Servlet implementation class controller
 */
@WebServlet({"/joinForm","/memberJoin","/memberList","/memberView","/memberUpdate","/moneyList"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
    
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  RequestDispatcher dispatcher;
	  String url = request.getServletPath();
	  System.out.println("url ::" + url);
	  service service = new service();
	  HttpSession session = request.getSession();	
	  
	  switch(url) {
	  case "/joinForm":
		  System.out.println("joinForm");
		  int nextCno = service.nextCno();
		  session.setAttribute("nextCno",nextCno);
		  dispatcher = request.getRequestDispatcher("joinForm.jsp");
		  dispatcher.forward(request, response);
		  break;
	  case "/memberJoin":
		  System.out.println("memberJoin");
		  dto dto = new dto();
		  dto.setCustno(Integer.parseInt(request.getParameter("custno")));
		  dto.setCustname(request.getParameter("custname"));
		  dto.setPhone(request.getParameter("phone"));
		  dto.setAddress(request.getParameter("address"));
		  dto.setJoindate(request.getParameter("joindate"));
		  dto.setGrade(request.getParameter("greade"));
		  dto.setCity(request.getParameter("city"));
		  System.out.println(dto);
		  int joinResult = service.memberJoin(dto);
		  if(joinResult > 0) {
			  dispatcher = request.getRequestDispatcher("index.jsp");
			  dispatcher.forward(request, response);
		  }
		  break;
	  case "/memberList":
		  System.out.println("memberList");
		  ArrayList<dto> memberList = service.memberList();
		  request.setAttribute("memberList",memberList);
		  dispatcher = request.getRequestDispatcher("memberList.jsp");
		  dispatcher.forward(request, response);
		  break;
	  case "/memberView":
		  System.out.println("memberView");
		  int custno = Integer.parseInt(request.getParameter("custno"));
		  System.out.println("custno ::" + custno);
		  dto memberView = service.memberView(custno);
		  request.setAttribute("memberView",memberView);
		  dispatcher = request.getRequestDispatcher("memberView.jsp");
		  dispatcher.forward(request, response);
		  break;
	  case "/memberUpdate":
		  System.out.println("memberUpdate");
		  dto memberUpdate = new dto();
		  memberUpdate.setCustno(Integer.parseInt(request.getParameter("custno")));
		  memberUpdate.setCustname(request.getParameter("custname"));
		  memberUpdate.setPhone(request.getParameter("phone"));
		  memberUpdate.setAddress(request.getParameter("address"));
		  memberUpdate.setJoindate(request.getParameter("joindate"));
		  memberUpdate.setGrade(request.getParameter("grade"));
		  memberUpdate.setCity(request.getParameter("city"));
		  int updateResult = service.memberUpdate(memberUpdate);
		  if(updateResult > 0) {
			  dispatcher = request.getRequestDispatcher("memberView?custno="+ memberUpdate.getCustno());
			  dispatcher.forward(request, response);
		  }
		  break;
	  case "/moneyList":
		  System.out.println("moneyList");
		  ArrayList<dto> moneyList = service.moneyList();
		  request.setAttribute("moneyList",moneyList);
		  dispatcher = request.getRequestDispatcher("moneyList.jsp");
		  dispatcher.forward(request, response);
		  break;
	  }
	}
}
