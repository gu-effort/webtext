package shiyan4.controller;
import shiyan4.model.Msg;
import shiyan4.model.User;
import shiyan4.service.MsgService;
import shiyan4.service.impl.MsgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
 @WebServlet("/addMsg")
 public class AddMsgServlet extends HttpServlet {

       MsgService msgService = new MsgServiceImpl();

       @Override
 protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

      req.setCharacterEncoding("utf-8");

      HttpSession session = req.getSession();
      User user = (User) session.getAttribute("user");

      Msg msg = new Msg();
      msg.setUser(user);
      msg.setSubject(req.getParameter("subject"));
      msg.setContent(req.getParameter("content"));
      msgService.add(msg);

      resp.sendRedirect("list");
      }
 }
