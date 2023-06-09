package com.odnzk.study.model.entity;

import com.odnzk.study.model.Priority;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

import static com.odnzk.study.model.entity.TaskEntity.TABLE_NAME;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@ToString(exclude = "project")
@Table(name = TABLE_NAME)
public class TaskEntity implements Serializable {
    @Transient
    public static final String TABLE_NAME = "tasks";
    @Serial
    @Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "is_completed")
    private Boolean isCompleted;
    @Column(name = "priority")
    @Enumerated(value = EnumType.STRING)
    private Priority priority;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private ProjectEntity project;
}

