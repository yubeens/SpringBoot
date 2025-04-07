package com.example.jpa01.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
@MappedSuperclass
@EntityListeners(value=AuditingEntityListener.class)
@Getter
abstract public class BaseEntity {
    @CreationTimestamp
    @Column(name = "regdate", updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    @UpdateTimestamp
    @Column(name = "updatedate")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updateDate;


}
