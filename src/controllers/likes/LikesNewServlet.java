package controllers.likes;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Employee;
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

        HttpSession session = ((HttpServletRequest)request).getSession();

        // セッションスコープに保存された従業員（ログインユーザ）情報を取得
        Employee e = (Employee)session.getAttribute("login_employee");
        Integer login_user = e.getId();

        r.setLike_employee_id(login_user);
        r.setLiked_report_id(Integer.parseInt(request.getParameter("id")));

        em.getTransaction().begin();
        em.persist(r);
        em.getTransaction().commit();
        em.close();

        RequestDispatcher rd = request.getRequestDispatcher("/reports/show?id="+ r.getLiked_report_id());
        rd.forward(request, response);
    }

}

