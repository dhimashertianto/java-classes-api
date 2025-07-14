package com.example.trainingapp.controller;

import com.example.trainingapp.entity.InstructorEntity;
import com.example.trainingapp.dto.ApiResponse;
import com.example.trainingapp.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/instructors")
  public class InstructorController {
    @Autowired
    private InstructorService service;

    @GetMapping
    public ApiResponse<List<InstructorEntity>> getAll() {
      List<InstructorEntity> instructors = service.findAll();
      return new ApiResponse<>(200, "Success", instructors);
    }

    @GetMapping("/{id}")
    public ApiResponse<InstructorEntity> getOne(@PathVariable Long id) {
      InstructorEntity instructor = service.findById(id);
      return new ApiResponse<>(200, "Success", instructor);
    }

    @PostMapping
    public InstructorEntity create(@RequestBody InstructorEntity instructor) {
        return service.save(instructor);
    }

    @PutMapping("/{id}")
    public InstructorEntity update(@PathVariable Long id, @RequestBody InstructorEntity newInstructor) {
        InstructorEntity existing = service.findById(id);
        existing.setName(newInstructor.getName());
        existing.setBio(newInstructor.getBio());
        existing.setPhotoUrl(newInstructor.getPhotoUrl());
        return service.save(existing);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
      service.delete(id);
    }

}
