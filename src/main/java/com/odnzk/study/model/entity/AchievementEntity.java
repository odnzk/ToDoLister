package com.odnzk.study.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.io.Serial;
import java.io.Serializable;

import static com.odnzk.study.model.entity.AchievementEntity.TABLE_NAME;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = TABLE_NAME)
public class AchievementEntity implements Serializable {
    @Transient
    public static final String TABLE_NAME = "achievements";
    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "category")
    private String category;
}

