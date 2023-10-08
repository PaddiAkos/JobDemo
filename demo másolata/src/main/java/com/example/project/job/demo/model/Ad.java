package com.example.project.job.demo.model;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Ad")
@ToString
@EqualsAndHashCode
@EntityListeners(EntityDate.class)
public class Ad  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Ad_id", nullable = false, unique = true)
    private Long Ad_id;

    @Column(name = "Title_name", nullable = false)
    private String title;

    @Temporal(TemporalType.DATE)
    @Column(name = "CreatedDate")
    private Date createdDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "LastModifiedDate")
    private Date lastModifiedDate;

    @Column(name = "Text", nullable = false)
    private String text;

    @Column(name = "ImageName")
    private String image;

    private String author;

    private int imageId;
}

