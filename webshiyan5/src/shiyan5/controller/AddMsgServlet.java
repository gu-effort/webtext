package shiyan5.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

@WebServlet("/addMsg")
public class AddMsgServlet extends HttpServlet {
    MsgService msgService = new MsgServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,

        req.setCharacterEncoding("utf-8");

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
        resp.sendRedirect("login.do");
        return;
        }

        Msg msg = new Msg();
        msg.setUser(user);
        msg.setSubject(req.getParameter("subject"));
        msg.setContent(req.getParameter("content"));

        if (msgService.add(msg)) {
        session.setAttribute("action", "添加留言: " + msg.getSubject());
        }

        resp.sendRedirect("list");
    }
}
