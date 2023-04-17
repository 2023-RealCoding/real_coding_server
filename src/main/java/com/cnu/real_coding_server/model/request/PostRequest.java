package com.cnu.real_coding_server.model.request;


import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.type.Tag;
import lombok.Getter;

@Getter
public class PostRequest {
    private String title;
    private String contents;

    private Tag tag;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .contents(contents)
                .tag(tag)
                .build();
    }
}
