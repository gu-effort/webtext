package shiyan3.service;

import shiyan3.pojo.Customer;


import java.util.List;

public interface CustomerService {
    int addcustomer(Customer customer);
    List<Customer> getcustomer(int page, int pageSize);
    List<Customer> getcustomer(String sPage, String sPageSize);
    int count();
    int login(String name,String password);
    int getcustomerId(String name);
}
