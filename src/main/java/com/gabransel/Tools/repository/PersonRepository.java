package com.gabransel.Tools.repository;

import com.gabransel.Tools.entites.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Student, Long> {
}