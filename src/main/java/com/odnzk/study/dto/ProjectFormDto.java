package com.odnzk.study.dto;

import java.util.Date;

public record ProjectFormDto(
        String title,
        Date startDate,
        Date finishDate
) {
}
