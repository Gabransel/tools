package com.gabransel.Tools.controller;

import com.gabransel.Tools.entites.LoanRecord;
import com.gabransel.Tools.entites.Student;
import com.gabransel.Tools.entites.Tool;
import com.gabransel.Tools.service.ToolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tools")
public class ToolController {
    private final ToolService toolService;

    public ToolController(ToolService toolService) {
        this.toolService = toolService;
    }

    @PostMapping("/borrow")
    public String borrowTool(@RequestParam Long toolId, @RequestParam Long personId) {
        return toolService.loanTool(toolId, personId);
    }

    @PostMapping("/return/{recordId}")
    public String returnTool(@PathVariable Long recordId) {
        return toolService.returnTool(recordId);
    }

    @GetMapping("/active-borrows")
    public List<LoanRecord> getActiveLoans() {
        return toolService.getActiveLoans();
    }

    @GetMapping
    public List<Tool> getAllTools() {
        return toolService.getAllTools();
    }

    @GetMapping("/people")
    public List<Student> getAllPeople() {
        return toolService.getAllStudents();
    }
}
