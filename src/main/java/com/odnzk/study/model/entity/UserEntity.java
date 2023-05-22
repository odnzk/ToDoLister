package com.odnzk.study.model.entity;

import com.odnzk.study.model.UserRole;
import com.odnzk.study.model.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import static com.odnzk.study.model.entity.UserEntity.TABLE_NAME;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = TABLE_NAME)
public class UserEntity implements Serializable {
    @Transient
    public static final String TABLE_NAME = "users";
    @Transient
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String hashedPassword;

    @Column(name = "status")
    @Enumerated(value = EnumType.STRING)
    private UserStatus status;

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private UserRole role;

    @OneToMany(mappedBy = "user", orphanRemoval = true)
    private List<ProjectEntity> projects;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_achievements",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id", columnDefinition = "integer"),
            inverseJoinColumns = @JoinColumn(name = "achievement_id", referencedColumnName = "id")
    )
    private List<AchievementEntity> achievements;

    public boolean isActive() {
        return status == UserStatus.ACTIVE;
    }

    public boolean isBanned() {
        return status == UserStatus.BANNED;
    }

    public boolean isAdmin() {
        return role == UserRole.ADMIN;
    }

}
