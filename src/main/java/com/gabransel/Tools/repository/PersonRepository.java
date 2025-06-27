package com.gabransel.Tools.repository;

import com.gabransel.Tools.entites.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}