package shiyan3.service;

import shiyan3.pojo.cart;

import java.util.List;

public interface CartService {
    int addcart(cart cart);
    List<cart> getcart(int customerId);
    int ifcart(int productId);
    int deletebook(int productId);
    int deleteall(int customerId);
}
