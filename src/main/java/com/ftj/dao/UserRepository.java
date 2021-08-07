package com.ftj.dao;

import com.ftj.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by fengtj on 2021/8/7 15:36
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsernameAndPassword(String username, String password);
}
