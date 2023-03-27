package qimo.controller;

import qimo.model.Comic;
import qimo.service.ComicService;
import qimo.service.impl.ComicServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/comic/search")
public class ComicSearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session=req.getSession();
        String value=req.getParameter("value");
        String value1=null;
        if (value!=null&&!value.equals("")){
            value1=value;
            session.setAttribute("value",value1);
        }
        if (session.getAttribute("value")!=null&&!session.getAttribute("value").equals("")){
            value1= (String) session.getAttribute("value");
        }
        System.out.println(value1);
        ComicService comicService=new ComicServiceImpl();
        String sPage = req.getParameter("page");
        int page = 1;
        int pageSize = 5;
        if (sPage != null && !sPage.equals("")) {
            page = Integer.parseInt(sPage);
        }
        int count = comicService.searchCount(value1);
        int pageCount = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;
        List<Comic> comicList=comicService.searchComic(page,pageSize,value1);
        req.setAttribute("searchlist",comicList);
        req.setAttribute("page", page);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("count", count);
        req.getRequestDispatcher("search.do").forward(req,resp);
    }
}
