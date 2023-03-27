package shiyan3.dao;

import shiyan3.pojo.Customer;

import java.util.List;

public interface CustomerDao {

    int addcustomer(Customer customer);

    List<Customer> getcustomer(int start,int num);
    List<Customer> findVip(boolean isVip);
    int count();
    int login(String name,String password);
    int getcustomerId(String name);
}
