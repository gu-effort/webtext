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
import java.util.List;

@WebServlet("/customer/list")
public class CustomerController extends HttpServlet {
    CustomerService customerService=new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sPage = req.getParameter("page");
        int page = 1;
        int pageSize = 3;
        if (sPage != null && !sPage.equals("")) {
            page = Integer.parseInt(sPage);
        }
        int count = customerService.count();
        int pageCount = count % pageSize > 0 ? count / pageSize + 1 : count / pageSize;
        List<Customer> customerList=customerService.getcustomer(page,pageSize);
        System.out.println(customerList);
        System.out.println(pageCount);
        System.out.println(page);
        System.out.println(count);
        req.setAttribute("customerList",customerList);
        req.setAttribute("page", page);
        req.setAttribute("pageCount", pageCount);
        req.setAttribute("count", count);

        req.getRequestDispatcher("list.do").forward(req,resp);
    }
}
