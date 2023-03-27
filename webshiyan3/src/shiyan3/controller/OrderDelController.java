package shiyan3.controller;

import shiyan3.service.CartService;
import shiyan3.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/deleteall")
public class OrderDelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session= req.getSession();
        int customerId= (Integer) session.getAttribute("customerId");
        CartService cartService=new CartServiceImpl();
        cartService.deleteall(customerId);
        System.out.println("是不是这里清楚购物车");
            resp.sendRedirect("/order");

    }
}
