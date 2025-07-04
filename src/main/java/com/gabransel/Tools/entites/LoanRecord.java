package com.gabransel.Tools.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LoanRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Student student;
    @ManyToOne
    private Tool tool;
    private LocalDateTime borrowDate;
    private LocalDateTime returnDate;

    public LoanRecord(){
    }

    public LoanRecord(Student student, Tool toll){
        this.student = student;
        this.tool = tool;
        this.borrowDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getPerson() {
        return student;
    }

    public void setPerson(Student student) {
        this.student = student;
    }

    public Tool getTool() {
        return tool;
    }

    public void setTool(Tool tool) {
        this.tool = tool;
    }

    public LocalDateTime getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDateTime borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDateTime returnDate) {
        this.returnDate = returnDate;
    }

    public void returnTool() {
        this.returnDate = LocalDateTime.now();
    }
}
