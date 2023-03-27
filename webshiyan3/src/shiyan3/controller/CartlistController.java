package shiyan3.controller;

import shiyan3.pojo.Order;
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
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@WebServlet("/cart")
public class CartlistController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("cart.do").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        req.setCharacterEncoding("utf-8");
        String name=req.getParameter("name");
        String tel=req.getParameter("tel");
        String address=req.getParameter("address");
        String money=req.getParameter("money");
        //订单编号
        Date now = new Date();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyyMMddHHmmss", java.util.Locale.CHINA);
        String str = sdf.format(now);
        String orderId = str + (int) (Math.random() * 1000);
        //时间
        SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar cale = Calendar.getInstance();
        Date date= cale.getTime();//calendar 类型 转为 date类型
        String time=sim.format(date);

        int customerId= (Integer) session.getAttribute("customerId");
        Order order=new Order();
        order.setOrderId(orderId);
        order.setCustomerId(customerId);
        order.setMoney(money);
        order.setProducts(null);
        order.setName(name);
        order.setAddress(address);
        order.setTel(tel);
        order.setStatusCode(0);
        order.setCreateTime(time);
        session.setAttribute("payorder",order);
        System.out.println(order);
        resp.sendRedirect("pay");

    }
}
