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
import java.util.List;

@WebServlet("/admin/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CandidateService candidateService=new CandidateServiceImpl();
        List<Candidate> candidateList=candidateService.findAll();
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html");
        PrintWriter out=resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<style type='text/css'> ");
        out.println("h1 {color: purple;}");
        out.println("table{margin-left:200px;margin-top:50px}");
        out.println("td,th{width:150px;height:50px;text-align:center}");
        out.println("th{background-color:rgb(123,205,252)}");
        out.println("</style>");
        out.println("<title>用户列表</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<a href='add.html'>添加用户</a>");
        //
        if (null==candidateList||candidateList.isEmpty())  {
            out.println("<h1>暂时无用户</h1>");
        }      else {
            out.println("<table border='1'>");
            out.println("<caption>用户列表</caption>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>name</th>");
            out.println("<th>照片</th>");
            out.println("<th>票数</th>");
            out.println("<th>操作</th>");
            out.println("<th>投票操作</th>");
            out.println("<th></th>");
            out.println("</tr>");
            for (Candidate user : candidateList) {
                out.println("<tr>");
                out.println("<td>" + user.getId() + "</td>");
                out.println("<td>" + user.getName() + "</td>");
                out.println("<td> <img  height=100px width=100px src='"+ user.getPhotoUrl() +"'></td>");
                out.println("<td>" + user.getVotes() + "</td>");
                out.println("<td><a href='del?id=" + user.getId() + "'>删除</a></td>");
                out.println("<td><a href='sub?id=" + user.getId() + "'>投一票</a> </td>");
                out.println("<td><a href='cut?id=" + user.getId() + "'>减一票</a> </td>");
                out.println("</tr>");
            }
            out.println("</table>");
        }
        out.println("</body>");
        out.println("</html>");











    }
}
