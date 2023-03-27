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
import java.io.PrintWriter;

@WebServlet("/admin/cut")
public class CutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String sid= req.getParameter("id");
        //2.获取要修改的用户数据
        CandidateService candidateService=new CandidateServiceImpl();
        Candidate candidate=candidateService.get(sid);
        int a=candidate.getVotes();
        a--;
        if(a<0){
            resp.setContentType("text/html");
            resp.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();
            out.println("<script>alert('零票就不能在减啦!');"+"window.location.href='/admin/list'</script>}");
            out.close();
            a=0;
        }
        candidate.setVotes(a);
        candidateService.sub(candidate);
        resp.sendRedirect("list");

    }


}
