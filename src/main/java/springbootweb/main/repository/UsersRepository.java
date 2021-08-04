package springbootweb.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import springbootweb.main.entity.Users;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long> {

    boolean existsByEmailAndPassword(String email,String password);

    @Query(value = "select u from Users u where u.email = ?1 and u.password = ?2")
    List<Users> checkExistUserByEmailAndPassword(String email,String password);

    // Cho phép chạy nativeQuery(query thuần nếu theo sau đây)
    @Query(value = "select * from users",nativeQuery = true)
    List<Users> getAllUser();


}
