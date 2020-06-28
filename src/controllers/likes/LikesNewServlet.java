package controllers.likes;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Like;

/**
 * Servlet implementation class ReportsNewEvaluationServlet
 */
@WebServlet("/new_evaluation")
public class LikesNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikesNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());

        Like r = new Like();
        request.setAttribute("like", r);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/reports/new_like.jsp");
        rd.forward(request, response);
    }

}
