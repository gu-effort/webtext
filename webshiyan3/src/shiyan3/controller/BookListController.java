package shiyan3.controller;

import shiyan3.pojo.Book;
import shiyan3.service.BookSerice;
import shiyan3.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/product/list")
public class BookListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookSerice bookSerice=new BookServiceImpl();

        String sPage = req.getParameter("bpage");
        int bpage = 1;
        int bpageSize = 5;
        if (sPage != null && !sPage.equals("")) {
            bpage = Integer.parseInt(sPage);
        }
        int bcount = bookSerice.bcount();
        int bpageCount = bcount % bpageSize > 0 ? bcount / bpageSize + 1 : bcount / bpageSize;
        List<Book> bookList=bookSerice.getbook(bpage,bpageSize);
        req.setAttribute("bookList",bookList);
        req.setAttribute("bpage", bpage);
        req.setAttribute("bpageCount", bpageCount);
        req.setAttribute("bcount", bcount);
        HttpSession session=req.getSession();
        String name=(String) session.getAttribute("name");
        req.getRequestDispatcher("list.do").forward(req,resp);
    }
}
