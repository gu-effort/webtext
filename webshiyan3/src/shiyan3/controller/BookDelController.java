package shiyan3.controller;

import shiyan3.pojo.Book;
import shiyan3.pojo.cart;
import shiyan3.service.BookSerice;
import shiyan3.service.CartService;
import shiyan3.service.impl.BookServiceImpl;
import shiyan3.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/delbook")
public class BookDelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       System.out.println("是不是这里");
        req.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(req.getParameter("id"));
        System.out.println(id);
        CartService cartService=new CartServiceImpl();
        if(cartService.deletebook(id)!=0) {
            resp.sendRedirect("/order");
        }else {
            System.out.println("删除失败");
        }

    }
}
