package com.example.thesis.Services;

import com.example.thesis.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.Month;
import java.util.List;

@Repository
public interface ReportService extends JpaRepository<Report, Integer> {

//    @Query("select r from Report r where r.collector=:collector and r.month=:month")
//    List<Report> findbyNameAndMonth( String collector, Month month);
//
    List<Report> findAllByCollector(String collector);
//
//    List<Report> findAllByCollector();
//    public Report findByID();

//    List<Report> findAllByCollectorAndMonth(String collector, Month month);
}
