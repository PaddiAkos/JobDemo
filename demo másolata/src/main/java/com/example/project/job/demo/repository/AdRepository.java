package com.example.project.job.demo.repository;

import com.example.project.job.demo.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {


}
