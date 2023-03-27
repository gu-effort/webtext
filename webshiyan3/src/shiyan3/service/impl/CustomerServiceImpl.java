package shiyan3.service.impl;

import shiyan3.dao.CustomerDao;
import shiyan3.dao.impl.CustomerDaoImpl;
import shiyan3.pojo.Customer;
import shiyan3.service.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public int addcustomer(Customer customer) {
        return customerDao.addcustomer(customer);
    }

    @Override
    public List<Customer> getcustomer(int page, int pageSize) {
        return customerDao.getcustomer((page - 1) * pageSize, pageSize);
    }

    @Override
    public List<Customer> getcustomer(String sPage, String sPageSize) {
        int page = 1;
        int pageSize = 3;
        if (sPage != null || !sPage.equals("")) {
          page = Integer.parseInt(sPage);
          if (page < 1) {
            page = 1;
            }
          }
        if (sPageSize != null || !sPageSize.equals("")) {
          pageSize = Integer.parseInt(sPageSize);
          }

        return getcustomer(page, pageSize);

    }

    @Override
    public int count() {
       return customerDao.count();
    }

    @Override
    public int login(String name, String password) {
       return customerDao.login(name,password);
    }

    @Override
    public int getcustomerId(String name) {
        return customerDao.getcustomerId(name);
    }


}
