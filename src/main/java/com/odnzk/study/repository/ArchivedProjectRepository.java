package com.odnzk.study.repository;

import com.odnzk.study.model.entity.ArchivedProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchivedProjectRepository extends JpaRepository<ArchivedProjectEntity, Long> {
    // todo
//    @Query("SELECT a FROM ArchivedProjects a WHERE a.title IN " +
//            "(SELECT u FROM Users u WHERE u.userId = :userId ORDER BY a.tasksCount DESC")
//    List<ArchivedProjectEntity> findAllByCategoryNameOrderByPubDateDesc(String category);
    // todo   select archProject where taskCount = :taskCount and userId: userId
    // 1) достаем архивные проекты если это наш юзер


}
