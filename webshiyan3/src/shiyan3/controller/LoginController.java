package shiyan3.controller;

import shiyan3.pojo.Customer;
import shiyan3.service.CustomerService;
import shiyan3.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    CustomerService customer=new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.do").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("name");
        String password=req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        int customerId=customer.getcustomerId(username);
        System.out.println(customerId);
        if (customer.login(username,password)==1){
            HttpSession session=req.getSession();
            session.setAttribute("customerId",customerId);
            session.setAttribute("name",username);
            resp.sendRedirect("/product/list");
        }else {
            resp.sendRedirect("/login");
        }

    }
}
