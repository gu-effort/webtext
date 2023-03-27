package shiyan3.dao.impl;

import shiyan3.dao.CartDao;
import shiyan3.pojo.Book;
import shiyan3.pojo.Customer;
import shiyan3.pojo.cart;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public int addcart(cart cart) {
        int result=1;
        String sql="insert into mydb.cart_table(customerId, productId,number) VALUES (?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,cart.getCustomerId());
            pstmt.setInt(2,cart.getProductId());
            pstmt.setInt(3,cart.getNumber());
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<cart> getcart(int customerId) {
        List<cart> cartList=new ArrayList<>();
        String sql = "SELECT * FROM cart_table WHERE customerId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,customerId);
            rs = pstmt.executeQuery();
            while (rs.next()){
                cart cart=new cart();
                cart.setCustomerId(customerId);
                cart.setProductId(rs.getInt("productId"));
                cart.setBook(null);
                cartList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cartList;
    }

    @Override
    public int ifcart(int productId) {
        int result=1;
        String sql = "SELECT * FROM cart_table WHERE productId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,productId);
            rs = pstmt.executeQuery();
            if (rs.next()){
                System.out.println("md已经买过了");
                result=0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deletcart(int productId) {
        int result=0;
        String sql = "DELETE FROM cart_table WHERE productId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,productId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public int deletall(int customerId) {
        int result=0;
        String sql = "DELETE FROM cart_table WHERE customerId=?";
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,customerId);
            result = pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
