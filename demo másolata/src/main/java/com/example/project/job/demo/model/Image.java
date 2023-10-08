package com.example.project.job.demo.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Image")
@ToString
@EqualsAndHashCode
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Image_id", nullable = false, unique = true)
    private Long imageId;

    private String fileName;

    @Lob
    private byte[] data;

    public String getExtension(){
        String[] parts = fileName.split("\\.");
        return parts[parts.length -1].toLowerCase();
    }
}
