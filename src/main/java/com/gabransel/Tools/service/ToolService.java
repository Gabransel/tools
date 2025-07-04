package com.gabransel.Tools.service;

import com.gabransel.Tools.entites.LoanRecord;
import com.gabransel.Tools.entites.Student;
import com.gabransel.Tools.entites.Tool;
import com.gabransel.Tools.repository.LoanRecordRepository;
import com.gabransel.Tools.repository.PersonRepository;
import com.gabransel.Tools.repository.ToolRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {

    private final ToolRepository toolRepository;
    private final PersonRepository personRepository;
    private final LoanRecordRepository loanRecordRepository;

    public ToolService(ToolRepository toolRepository, PersonRepository personRepository, LoanRecordRepository loanRecordRepository){
        this.toolRepository = toolRepository;
        this.personRepository = personRepository;
        this.loanRecordRepository = loanRecordRepository;
    }

    @Transactional
    public String loanTool(Long toolId, Long personId) {
        Tool tool = toolRepository.findById(toolId)
                .orElseThrow(() -> new RuntimeException("FERRAMENTA NÃO ENCONTRADA"));

        Student student = personRepository.findById(personId)
                .orElseThrow(() -> new RuntimeException("ALUNO NÃO IDENTIFICADO"));

        if (tool.getAvailableQuantity() <= 0) {
            return "FERRAMENTA INDISPONÍVEL";
        }

        tool.setAvailableQuantity(tool.getAvailableQuantity() - 1);
        toolRepository.save(tool);

        LoanRecord record = new LoanRecord(student, tool);
        loanRecordRepository.save(record);

        return "FERRAMENTA RETIRADA POR " + student.getName() + ".";
    }

    @Transactional
    public String returnTool(Long recordId) {
        LoanRecord record = loanRecordRepository.findById(recordId)
                .orElseThrow(() -> new RuntimeException("REGISTRO DE EMPRÉSTIMO NÃO ENCONTRADO"));

        if (record.getReturnDate() != null) {
            return "ESTA FERRAMENTA JÁ FOI DEVOLVIDA";
        }

        Tool tool = record.getTool();
        tool.setAvailableQuantity(tool.getAvailableQuantity() + 1);
        toolRepository.save(tool);

        record.returnTool();
        loanRecordRepository.save(record);

        return "FERRAMENTA DEVOLVIDA COM SUCESSO!";
    }

    public List<LoanRecord> getActiveLoans() {
        return loanRecordRepository.findByReturnDateIsNull();
    }

    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }

    public List<Student> getAllStudents() {
        return personRepository.findAll();
    }
}


