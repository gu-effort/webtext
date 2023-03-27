package qimo.dao;

import qimo.model.User;

public interface UserDao {
    int insert(User user);
    User login(String name,String password);
    int updateBrowsingRecords(User user,String comicId);
    User selectByUserId(int id);

}
