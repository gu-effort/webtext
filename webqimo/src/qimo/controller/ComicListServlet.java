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

@WebServlet("/comic/list")
public class ComicListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ComicService comicService=new ComicServiceImpl();
        String sPage = req.getParameter("bpage");
        int bpage = 1;
        int bpageSize = 3;
        if (sPage != null && !sPage.equals("")) {
            bpage = Integer.parseInt(sPage);
        }
        HttpSession session=req.getSession();
        String region1=req.getParameter("region");
        int region=0;
        if (region1!=null&&!region1.equals("")){
            region= Integer.parseInt(region1);
            session.setAttribute("region",region);
        }
        if (session.getAttribute("region")!=null&&!session.getAttribute("region").equals("")){
             region= (int) session.getAttribute("region");
        }
        int bcount = comicService.count(region);
        int bpageCount = bcount % bpageSize > 0 ? bcount / bpageSize + 1 : bcount / bpageSize;
        List<Comic> comicList2=comicService.getIndexComic();
        System.out.println("排序的对不对"+comicList2);
        List<Comic> comicList1=comicService.getComic(bpage,bpageSize,region);
        req.setAttribute("comiclist",comicList1);
        req.setAttribute("bpage", bpage);
        req.setAttribute("bpageCount", bpageCount);
        req.setAttribute("bcount", bcount);
        req.getRequestDispatcher("list.do").forward(req,resp);
    }
}
