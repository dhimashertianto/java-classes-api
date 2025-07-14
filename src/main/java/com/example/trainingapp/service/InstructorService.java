package com.example.trainingapp.service;

import com.example.trainingapp.entity.InstructorEntity;
import com.example.trainingapp.exception.ResourceNotFoundException;
import com.example.trainingapp.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InstructorService {
    @Autowired
    private InstructorRepository instructorRepo;

    public List<InstructorEntity> findAll() {
        return instructorRepo.findAll();
    }

    public InstructorEntity findById(Long id) {
        return instructorRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));
    }

    public InstructorEntity save(InstructorEntity entity) {
        return instructorRepo.save(entity);
    }

    public void delete(Long id) {
        instructorRepo.deleteById(id);
    }
}

