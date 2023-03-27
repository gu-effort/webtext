package shiyan2.controller;

import shiyan2.model.Candidate;
import shiyan2.service.CandidateService;
import shiyan2.service.impl.CandidateServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/del")
public class DelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        if (sid==null||"".equals(sid)){resp.sendRedirect("list");return;}
        //2.获取要修改的用户数据
        CandidateService candidateService=new CandidateServiceImpl();
        candidateService.del(Integer.parseInt(sid));
        resp.sendRedirect("list");
    }
}
