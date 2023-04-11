package com.cnu.real_coding_server.entity;

import com.cnu.real_coding_server.model.type.Tag;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity(name = "posts") // 해당 클래스가 Entity 임을 나타냄.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity {
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
    public Post(String title, String contents, Tag tag) {
        this.title = title;
        this.contents = contents;
        this.tag = tag;
    }
}
