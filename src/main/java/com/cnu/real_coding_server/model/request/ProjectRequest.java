package com.cnu.real_coding_server.model.request;

import com.cnu.real_coding_server.entity.Project;
import com.cnu.real_coding_server.model.type.Tag;
import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class ProjectRequest {
    @Valid
    private String title;
    private String contents;

    private Tag tag;

    public Project toEntity() {
        return Project.builder()
                .title(title)
                .contents(contents)
                .tag(tag)
                .build();
    }
}
