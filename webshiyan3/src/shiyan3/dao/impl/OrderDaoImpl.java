package shiyan3.dao.impl;

import shiyan3.dao.OrderDao;
import shiyan3.pojo.Order;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int addOrder(Order order) {

        int result=0;
        String sql="insert into mydb.order_table(orderId, customerId, money, products, name, address, tel, statusCode, createTime) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,order.getOrderId());
            pstmt.setInt(2,order.getCustomerId());
            pstmt.setString(3,order.getMoney());
            pstmt.setString(4,order.getProducts());
            pstmt.setString(5,order.getName());
            pstmt.setString(6,order.getAddress());
            pstmt.setString(7,order.getTel());
            pstmt.setInt(8,order.getStatusCode());
            pstmt.setString(9,order.getCreateTime());
            result=pstmt.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
