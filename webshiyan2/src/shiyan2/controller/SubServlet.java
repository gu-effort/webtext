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

@WebServlet("/admin/sub")
public class SubServlet extends HttpServlet {
    CandidateService candidateService=new CandidateServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid= req.getParameter("id");
        //2.获取要修改的用户数据
        CandidateService candidateService=new CandidateServiceImpl();
        Candidate candidate=candidateService.get(sid);
        System.out.println(""+candidate.getName());
      System.out.println(""+candidate.getVotes());
      int a=candidate.getVotes();
      a++;
      candidate.setVotes(a);
      candidateService.sub(candidate);
        resp.sendRedirect("list");

    }


}
