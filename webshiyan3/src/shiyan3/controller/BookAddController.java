package shiyan3.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import shiyan3.pojo.Book;
import shiyan3.service.BookSerice;
import shiyan3.service.impl.BookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

@WebServlet("/product/add")
public class BookAddController extends HttpServlet {


    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book=null;
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
                book=new Book();
            }
            //创建迭代器准备处理表单数据
            Iterator<FileItem> iterator=items.iterator();
            while (iterator.hasNext()){
                FileItem item=iterator.next();
                //判断是表单域还是上传的文件
                if (item.isFormField()){
                    //根据fieldName来判断是哪个表单控件
                    if (item.getFieldName().equals("name")){
                        book.setName(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                    if (item.getFieldName().equals("price")){
                        book.setPrice(new BigDecimal(item.getString()));
                    }
                    if (item.getFieldName().equals("sale")){
                        book.setSale(Integer.parseInt(new String(item.getString().getBytes("iso-8859-1"),"utf-8")));
                    }
                    if (item.getFieldName().equals("stock")){
                        book.setStock(Long.parseLong(new String(item.getString().getBytes("iso-8859-1"),"utf-8")));
                    }
                    if (item.getFieldName().equals("info")){
                        book.setInfo(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                    if (item.getFieldName().equals("marketDate")){
                        book.setMarketDate(Long.parseLong(new String(item.getString().getBytes("iso-8859-1"),"utf-8")));
                    }
                }
                else {
                    //获取上传文件文件名
                    String fileName=item.getName();
                    System.out.println(fileName);
                    File file=new File(savedDir+"//"+fileName);
                    item.write(file);
                    book.setImgUrl(req.getContextPath()+path+"/"+fileName);
                }
            }
        }
        catch (Exception e){
            System.out.println("上传文件出错:"+e.getMessage());
        }

        //向数据库中添加候选人

        BookSerice bookSerice=new BookServiceImpl();
        if (bookSerice.addbook(book)!=0){
            System.out.println("成功了");
        }else {
            System.out.println("失败了");
        }

    }
}
