package com.cnu.real_coding_server.entity;

import com.cnu.real_coding_server.model.type.Tag;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity(name = "projects")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Setter
    private String title;

    @Column
    @Setter
    private String contents;

    @Setter
    @Enumerated(EnumType.STRING)
    private Tag tag;

    @Builder
    public Project(String title, String contents, Tag tag) {
        this.title = title;
        this.contents = contents;
        this.tag = tag;
    }
}