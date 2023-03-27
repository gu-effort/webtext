package qimo.service;

import qimo.model.User;

public interface UserService {
    User selectByUserId(int id);
}
