package springbootweb.main.service;

import springbootweb.main.entity.Users;

public interface UsersService {
    boolean checkLogin(Users users);

    boolean checkExistUser(Users users);

    Users saveUsers(Users users);
}
