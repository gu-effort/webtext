package shiyan3.service.impl;

import shiyan3.dao.CartDao;
import shiyan3.dao.impl.CartDaoImpl;
import shiyan3.pojo.cart;
import shiyan3.service.CartService;

import java.util.List;

public class CartServiceImpl implements CartService {
    CartDao cartDao=new CartDaoImpl();
    @Override
    public int addcart(cart cart) {
        return cartDao.addcart(cart);
    }

    @Override
    public List<cart> getcart(int customerId) {
        return cartDao.getcart(customerId);
    }

    @Override
    public int ifcart(int productId) {
        return cartDao.ifcart(productId);
    }

    @Override
    public int deletebook(int productId) {
        return cartDao.deletcart(productId);
    }

    @Override
    public int deleteall(int customerId) {
        return cartDao.deletall(customerId);
    }
}
