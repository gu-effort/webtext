package shiyan3.dao;

import shiyan3.pojo.cart;

import java.util.List;

public interface CartDao {
    int addcart(cart cart);
    List<cart> getcart(int customerId);
    int ifcart(int productId);
    int deletcart(int productId);
    int deletall(int customerId);
}
