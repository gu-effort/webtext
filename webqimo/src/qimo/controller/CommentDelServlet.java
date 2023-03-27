package qimo.controller;

import qimo.model.Comment;
import qimo.service.ComicService;
import qimo.service.CommentService;
import qimo.service.impl.ComicServiceImpl;
import qimo.service.impl.CommentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/comic/delComment")
public class CommentDelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         String id=req.getParameter("id");
        CommentService commentService=new CommentServiceImpl();
        if (commentService.deleteComment(Integer.parseInt(id))==1){
            resp.sendRedirect("list");
        }else {
            System.out.println("没删除");
        }
    }

}
