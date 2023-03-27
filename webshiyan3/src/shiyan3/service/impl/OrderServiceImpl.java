package shiyan3.service.impl;

import shiyan3.dao.OrderDao;
import shiyan3.dao.impl.OrderDaoImpl;
import shiyan3.pojo.Order;
import shiyan3.service.OrderService;

public class OrderServiceImpl implements OrderService {

    OrderDao orderDao=new OrderDaoImpl();
    @Override
    public int addorder(Order order) {
        return orderDao.addOrder(order);
    }
}
