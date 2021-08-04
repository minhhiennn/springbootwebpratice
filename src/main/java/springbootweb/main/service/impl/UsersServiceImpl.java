package springbootweb.main.service.impl;

import org.springframework.stereotype.Service;
import springbootweb.main.entity.Users;
import springbootweb.main.repository.UsersRepository;
import springbootweb.main.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public boolean checkLogin(Users users) {
        boolean bool = this.usersRepository.existsByEmailAndPassword(users.getEmail(),users.getPassword());
        return bool;
    }

    @Override
    public boolean checkExistUser(Users users) {
        return this.usersRepository.checkExistUserByEmailAndPassword(users.getEmail(),users.getPassword()).size() > 0;
    }

    @Override
    public Users saveUsers(Users users) {
        return this.usersRepository.save(users);
    }

}
