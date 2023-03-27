package shiyan3.dao.impl;

import shiyan3.dao.BookDao;
import shiyan3.pojo.Book;
import shiyan3.pojo.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl extends BaseDao implements BookDao {
    @Override
    public int addbook(Book book) {
        int result=0;
        String sql="insert into mydb.product_table(name, price, sale, stock, imgUrl, info, marketDate) VALUES (?,?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,book.getName());
            pstmt.setBigDecimal(2,book.getPrice());
            pstmt.setInt(3,book.getSale());
            pstmt.setLong(4,book.getStock());
            pstmt.setString(5,book.getImgUrl());
            pstmt.setString(6,book.getInfo());
            pstmt.setLong(7,book.getMarketDate());
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<Book> getbook(int start, int num) {
        List<Book> bookList=new ArrayList<Book>();
        String sql = "SELECT * FROM product_table ORDER BY id LIMIT ?,?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, start);
            pstmt.setInt(2, num);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setPrice(rs.getBigDecimal("price"));
                book.setSale(rs.getInt("sale"));
                book.setStock(rs.getLong("stock"));
                book.setImgUrl(rs.getString("imgUrl"));
                book.setInfo(rs.getString("info"));
                book.setMarketDate(rs.getLong("marketDate"));
                bookList.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookList;
    }

    @Override
    public int bcount() {
        int bcount = 0;
        String sql = "SELECT count(*) FROM product_table";
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                bcount = rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println("DAO 获取顾客记录总数失败");
            e.printStackTrace();
        }
        return bcount;
    }


    @Override
    public Book getbookbyid(int id) {
       Book book=new Book();
        String sql = "SELECT * FROM product_table WHERE id=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs = pstmt.executeQuery();
            while (rs.next()){
                book.setId(id);
                book.setName(rs.getString("name"));
                book.setImgUrl(rs.getString("imgUrl"));
                book.setPrice(rs.getBigDecimal("price"));
                book.setSale(rs.getInt("sale"));
            }
        } catch (SQLException e) {
            System.out.println("DAO 分页获取顾客列表失败: ");
            e.printStackTrace();
        }
        return book;
    }
}
