package com.odnzk.study.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

import static com.odnzk.study.model.entity.ProjectEntity.TABLE_NAME;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = TABLE_NAME)
public class ProjectEntity {
    @Transient
    public static final String TABLE_NAME = "projects";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "is_completed", columnDefinition = "boolean default false")
    private boolean isCompleted;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "finish_date")
    private Date deadlineDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToMany(mappedBy = "project", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<TaskEntity> tasks;

    Double calcProgress() {
        return (double) (tasks.stream().filter(TaskEntity::isCompeted).count() / tasks.size());
    }
}
