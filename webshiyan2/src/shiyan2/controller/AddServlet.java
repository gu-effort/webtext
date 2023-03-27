package shiyan2.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import shiyan2.model.Candidate;
import shiyan2.service.CandidateService;
import shiyan2.service.impl.CandidateServiceImpl;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@WebServlet("/admin/add")
public class AddServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidate candidate=null;
        //保存位置
        String path="/photo";
        //保存位置的真实物理地址
        String savedDir=req.getServletContext().getRealPath(path);
        //创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //创建文件上传处理器
        ServletFileUpload upload=new ServletFileUpload(factory);
        try {
            //解析请求
            List<FileItem> items=upload.parseRequest(req);
            if (!items.isEmpty()){
                candidate=new Candidate();
            }
            //创建迭代器准备处理表单数据
            Iterator<FileItem> iterator=items.iterator();
            while (iterator.hasNext()){
                FileItem item=iterator.next();
                //判断是表单域还是上传的文件
                if (item.isFormField()){
                    //根据fieldName来判断是哪个表单控件
                    if (item.getFieldName().equals("name")){
                        candidate.setName(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }

                    }
                else {
                    //获取上传文件文件名
                    String fileName=item.getName();
                    File file=new File(savedDir+"//"+fileName);
                    item.write(file);
                    candidate.setPhotoUrl(req.getContextPath()+path+"/"+fileName);
                }
            }
        }
        catch (Exception e){
            System.out.println("上传文件出错:"+e.getMessage());
        }

        //向数据库中添加候选人
        CandidateService candidateService=new CandidateServiceImpl();

        if (candidateService.add(candidate)){
            resp.sendRedirect("list");
        }else {
            resp.sendRedirect("add.html");
        }
    }

}
