package com.example.thesis.Services;

import com.example.thesis.model.Complain;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComplainService extends JpaRepository<Complain, Integer> {

}
