package shiyan3.controller;

import shiyan3.service.CartService;
import shiyan3.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/product/del")
public class CartdelController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id= Integer.parseInt(req.getParameter("id"));
        CartService cartService=new CartServiceImpl();
        cartService.deleteall(id);
    }
}
