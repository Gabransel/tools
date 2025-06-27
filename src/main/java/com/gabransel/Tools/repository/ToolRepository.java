package com.gabransel.Tools.repository;

import com.gabransel.Tools.entites.Tool;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolRepository extends JpaRepository<Tool, Long> {
}