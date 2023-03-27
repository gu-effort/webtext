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

@WebServlet("/order")
public class OrderListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BookSerice bookSerice=new BookServiceImpl();
        CartService cartService=new CartServiceImpl();
        req.setCharacterEncoding("utf-8");
        HttpSession session=req.getSession();
        int customerId= (Integer) session.getAttribute("customerId");
        List<cart> cartList=cartService.getcart(customerId);
        for (cart cart2:cartList){
            cart2.setBook(bookSerice.getbookbyid(cart2.getProductId()));
        }
        System.out.println(cartList);
        session.setAttribute("orderbook",cartList);
        req.getRequestDispatcher("order.do").forward(req,resp);
    }
}
