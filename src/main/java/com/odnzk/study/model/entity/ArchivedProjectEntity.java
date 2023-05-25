package com.odnzk.study.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Transient;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import static com.odnzk.study.model.entity.ArchivedProjectEntity.TABLE_NAME;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = TABLE_NAME)
public class ArchivedProjectEntity implements Serializable {
    @Transient
    public static final String TABLE_NAME = "archived_projects";
    @Serial
    @jakarta.persistence.Transient
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "title")
    private String title;
    @Column(name = "completed_task_count")
    private Integer completedTasksCount;
    @Column(name = "task_count")
    private Integer tasksCount;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "finish_date")
    private Date deadlineDate;
    @Column(name = "project_id")
    private Long projectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    public Double getProgress() {
        if (tasksCount == 0) {
            return 100.0;
        } else {
            return completedTasksCount * 100.0 / tasksCount;
        }
    }
}

