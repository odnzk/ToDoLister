package com.odnzk.study.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class ArchiveRequestDto {
    private Long projectId;
}
