package com.example.demo.entity;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Auditable {
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private String createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private String updatedAt;
}
