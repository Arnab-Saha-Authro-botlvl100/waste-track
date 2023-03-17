package com.example.thesis.Services;

import com.example.thesis.model.Bin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinService extends JpaRepository<Bin, Integer> {
}
