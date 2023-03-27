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

@WebServlet("/product/mod")
public class BookModController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookSerice bookSerice=new BookServiceImpl();
        CartService cartService=new CartServiceImpl();
        cart cart=new cart();
        req.setCharacterEncoding("utf-8");



        int id= Integer.parseInt(req.getParameter("id"));

        HttpSession session=req.getSession();
        List<Book> orderbook=new ArrayList<>();
        int customerId= (Integer) session.getAttribute("customerId");
        cart.setCustomerId(customerId);
        cart.setProductId(id);
        if (cartService.ifcart(id)==1){
            cartService.addcart(cart);
            System.out.println("添加成功");
        }else {
            System.out.println("添加了");
        }
        resp.sendRedirect("/product/list");
    }
}
