package shiyan3.dao.impl;

import shiyan3.dao.CustomerDao;
import shiyan3.pojo.Book;
import shiyan3.pojo.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public int addcustomer(Customer customer) {
        System.out.println("运行这一步了");
        int result=0;
        String sql="insert into mydb.customer_table(name,password,isVip) VALUES (?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,customer.getName());
            pstmt.setString(2,customer.getPassword());
            pstmt.setBoolean(3,customer.isVip());
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }



    @Override
    public List<Customer> getcustomer(int start, int num) {
        List<Customer> customerList = new ArrayList<Customer>();
        String sql = "SELECT * FROM customer_table ORDER BY id LIMIT ?,?";
        try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, start);
         pstmt.setInt(2, num);
         rs = pstmt.executeQuery();
         while (rs.next()) {
          Customer customer = new Customer();
           customer.setId(rs.getInt("id"));
           customer.setName(rs.getString("name"));
           customer.setPassword(rs.getString("password"));
           customer.setVip(rs.getBoolean("isVip"));
           customerList.add(customer);
           }
          } catch (SQLException e) {
          System.out.println("DAO 分页获取顾客列表失败: ");
          e.printStackTrace();
          }

         return customerList;
    }

    @Override
    public List<Customer> findVip(boolean isVip) {
        return null;
    }

    @Override
    public int count() {
        int count = 0;
         String sql = "SELECT count(*) FROM customer_table";
         try {
          stmt = conn.createStatement();
          rs = stmt.executeQuery(sql);
          while (rs.next()) {
           count = rs.getInt(1);
           }
          } catch (SQLException e) {
          System.out.println("DAO 获取顾客记录总数失败");
          e.printStackTrace();
          }
         return count;
    }

    @Override
    public int login(String name, String password) {
        int result=0;
        String sql="select *from customer_table where name=? and password=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            rs= pstmt.executeQuery();
            if (rs.next()){
                result=1;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("运行来的"+result);
     return result;

    }

    @Override
    public int getcustomerId(String name) {
        Customer customer=new Customer();
        String sql = "SELECT * FROM customer_table WHERE name=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            rs = pstmt.executeQuery();
            while (rs.next()){
                customer.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            System.out.println("DAO 分页获取顾客列表失败: ");
            e.printStackTrace();
        }
        return customer.getId();
    }


}
