package com.gabransel.Tools.entites;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "student")
    private List<LoanRecord> loanRecords = new ArrayList<>();

    public Student(){
    }

    public Student(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<LoanRecord> getBorrowRecords() {
        return loanRecords;
    }

    public void setBorrowRecords(List<LoanRecord> loanRecords) {
        this.loanRecords = loanRecords;
    }
}
