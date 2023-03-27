package shiyan3.controller;

import shiyan3.pojo.Order;
import shiyan3.service.CartService;
import shiyan3.service.OrderService;
import shiyan3.service.impl.CartServiceImpl;
import shiyan3.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/payorder")
public class PayDaoController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();
        OrderService orderService=new OrderServiceImpl();
        CartService cartService=new CartServiceImpl();
        Order order=new Order();
        order= (Order) session.getAttribute("payorder");
        System.out.println(order);
        order.setStatusCode(1);
        session.setAttribute("payorder1",order);
        if (orderService.addorder(order)!=0){
            cartService.deleteall(order.getCustomerId());
            req.getRequestDispatcher("paylist.do").forward(req,resp);
        }else {
            System.out.println("支付失败");
        }

    }
}
