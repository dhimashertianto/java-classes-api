package com.example.trainingapp.controller;

import com.example.trainingapp.entity.ClassEntity;
import com.example.trainingapp.dto.ApiResponse;
import com.example.trainingapp.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classes")
public class ClassController {
    @Autowired
    private ClassService service;

    @GetMapping
    public ApiResponse<List<ClassEntity>> getAll() {
        List<ClassEntity> classes = service.findAll();
        return new ApiResponse<>(200, "Success", classes);
    }

    @GetMapping("/{id}")
    public ApiResponse<ClassEntity> getClassById(@PathVariable Long id) {
        ClassEntity classEntity = service.findById(id);
        return new ApiResponse<>(200, "Success", classEntity);
    }
    @PostMapping
    public ClassEntity create(@RequestBody ClassEntity classEntity) {
        return service.save(classEntity);
    }

    @PutMapping("/{id}")
    public ClassEntity update(@PathVariable Long id, @RequestBody ClassEntity newClass) {
        ClassEntity existing = service.findById(id);
        existing.setTitle(newClass.getTitle());
        existing.setDescription(newClass.getDescription());
        existing.setPhotoUrl(newClass.getPhotoUrl());
        existing.setInstructor(newClass.getInstructor());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}

