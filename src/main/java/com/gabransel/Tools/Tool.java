package com.gabransel.Tools;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Tool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int totalQuantity;
    private int availableQuantity;

    @OneToMany(mappedBy = "tool")
    private List<BorrowRecord> borrowRecords = new ArrayList<>();

    public Tool() {
    }

    public Tool(String name, int totalQuantity){
        this.name = name;
        this.totalQuantity = totalQuantity;
        this.availableQuantity = totalQuantity;
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

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public List<BorrowRecord> getBorrowRecords() {
        return borrowRecords;
    }

    public void setBorrowRecords(List<BorrowRecord> borrowRecords) {
        this.borrowRecords = borrowRecords;
    }
}
