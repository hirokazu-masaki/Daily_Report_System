package controllers.likes;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Like;
import utils.DBUtil;

/**
 * Servlet implementation class ReportsNewEvaluationServlet
 */
@WebServlet("/new_like")
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
        EntityManager em = DBUtil.createEntityManager();

        Like r = new Like();
        request.setAttribute("like", r);

        r.setLike_employee_id(1);
        r.setLiked_report_id(1);

        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();

//        RequestDispatcher rd = request.getRequestDispatcher("/reports/show?id=");
//        rd.forward(request, response);
    }

}

