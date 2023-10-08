package com.example.project.job.demo.model;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import java.util.Date;

public class EntityDate {

    @PrePersist
    public void prePersist(Ad entity) {
        entity.setCreatedDate(new Date());
        entity.setLastModifiedDate(new Date());
    }
    @PreUpdate
    public void preUpdate(Ad entity) {
        entity.setLastModifiedDate(new Date());
    }
}

