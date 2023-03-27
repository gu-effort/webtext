package shiyan3.controller;

import shiyan3.pojo.Order;
import shiyan3.service.OrderService;
import shiyan3.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/order/gsaf")
public class OrderController extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService=new OrderServiceImpl();

        Order order=new Order();

        req.getRequestDispatcher("order.do").forward(req,resp);
    }

}
