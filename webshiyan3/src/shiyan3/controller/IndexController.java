package shiyan3.controller;

import shiyan3.pojo.Book;
import shiyan3.pojo.Customer;
import shiyan3.service.BookSerice;
import shiyan3.service.CustomerService;
import shiyan3.service.impl.BookServiceImpl;
import shiyan3.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/product/list");
    }
}
