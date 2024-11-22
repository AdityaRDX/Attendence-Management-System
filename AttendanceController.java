package controller;
import dao.AttendanceDAO;
import model.User;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet("/AttendanceController")
public class AttendanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AttendanceController() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
        AttendanceDAO dao;
        try {
            dao = new AttendanceDAO();
            if ("login".equals(action)) {
                String username = request.getParameter("username");
                String password = request.getParameter("password");
                User user = dao.validateUser(username, password);

                if (user != null) {
                    HttpSession session = request.getSession();
                    session.setAttribute("user", user);

                    if ("admin".equals(user.getRole())) {
                        response.sendRedirect("views/adminDashboard.jsp");
                    } else if ("faculty".equals(user.getRole())) {
                        response.sendRedirect("views/facultyDashboard.jsp");
                    } else if ("student".equals(user.getRole())) {
                        response.sendRedirect("views/studentDashboard.jsp");
                    }
                } else {
                    response.sendRedirect("views/login.jsp?error=invalid");
                }
            } else if ("markAttendance".equals(action)) {
                User user = (User) request.getSession().getAttribute("user");
                dao.markAttendance(user.getId());
                response.sendRedirect("views/facultyDashboard.jsp?success=attendanceMarked");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
   	}

}
