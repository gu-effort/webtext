package qimo.controller;

import qimo.model.Comic;
import qimo.model.ComicAndComment;
import qimo.model.Comment;
import qimo.service.ComicService;
import qimo.service.CommentService;
import qimo.service.UserService;
import qimo.service.impl.ComicServiceImpl;
import qimo.service.impl.CommentServiceImpl;
import qimo.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/comic/detail")
public class ComicDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取动漫id
        String id = req.getParameter("id");
        ComicService comicService = new ComicServiceImpl();
        CommentService commentService = new CommentServiceImpl();
        UserService userService=new UserServiceImpl();
        // UserService userService=new UserServiceImpl();
        //根据id查找到相应动漫和评论内容
        Comic comic = comicService.getComicById(Integer.parseInt(id));
        List<Comment> commentList = commentService.getComment(Integer.parseInt(id));
        //实例化user
        for(Comment list:commentList){
                list.setReviewer(userService.selectByUserId(list.getUserId()));
                list.setReviewerTo(userService.selectByUserId(list.getOtherId()));
            }
        ComicAndComment comicAndComment=new ComicAndComment(comic,commentList);
        req.setAttribute("detailList",comicAndComment);
        req.getRequestDispatcher("detail.do").forward(req,resp);
    }
}
