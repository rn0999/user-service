package com.rn.userservice.repo;

import com.rn.userservice.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepository extends JpaRepository<User,Integer> {

}
