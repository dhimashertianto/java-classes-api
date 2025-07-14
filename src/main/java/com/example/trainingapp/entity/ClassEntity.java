package com.example.trainingapp.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "classes")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "instructor")
    private InstructorEntity instructor;

    private Integer price;
    private String photoUrl;
    
    @Column(length = 1000)
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    @Column(updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public ClassEntity orElseThrow(Object object) {
      // TODO Auto-generated method stub
      throw new UnsupportedOperationException("Unimplemented method 'orElseThrow'");
    }
}
