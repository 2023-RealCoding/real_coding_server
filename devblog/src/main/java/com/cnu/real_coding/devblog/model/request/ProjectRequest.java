package com.cnu.real_coding.devblog.model.request;

import com.cnu.real_coding.common.entity.Project;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProjectRequest {
    private String title;

    private String summary;

    private String description;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Boolean isInProgress;

    public Project toEntity() {
        return Project.builder()
                .title(title)
                .summary(summary)
                .description(description)
                .startDate(startDate)
                .endDate(endDate)
                .isInProgress(isInProgress)
                .build();
    }
}
