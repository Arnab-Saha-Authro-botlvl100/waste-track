package com.example.thesis.Services;
import com.example.thesis.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface UserService extends JpaRepository<User, Integer>{
    @Query("select u from User u where u.email = :email")
    User findByUserName(@Param("email") String email);
}