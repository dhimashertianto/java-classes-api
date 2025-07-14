package com.example.trainingapp.service;

import com.example.trainingapp.entity.ClassEntity;
import com.example.trainingapp.exception.ResourceNotFoundException;
import com.example.trainingapp.repository.ClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClassService {
    @Autowired
    private ClassRepository classRepo;

    public List<ClassEntity> findAll() {
        return classRepo.findAll();
    }

    public ClassEntity findById(Long id) {
        return classRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Class not found" + id));
    }

    public ClassEntity save(ClassEntity entity) {
        return classRepo.save(entity);
    }

    public void delete(Long id) {
        classRepo.deleteById(id);
    }
}

