package com.example.bugtracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BugRepository extends JpaRepository<Bug,Long> {//By extending JpaRepository<Bug, Long>, you are telling Spring Boot:
    // "Hey, create a repository for my Bug class, and the primary key (the ID) is a Long."
}
