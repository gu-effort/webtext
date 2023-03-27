package shiyan3.controller;

import shiyan3.pojo.Customer;
import shiyan3.service.CustomerService;
import shiyan3.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("name");
        String password=req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        Customer customer=new Customer();
        customer.setName(username);
        customer.setPassword(password);
        System.out.println(customer);
       CustomerService customerService=new CustomerServiceImpl();
        customerService.addcustomer(customer);
        resp.sendRedirect("/product/list");
    }


}
