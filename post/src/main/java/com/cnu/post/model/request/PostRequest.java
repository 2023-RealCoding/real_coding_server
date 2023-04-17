package com.cnu.post.model.request;


import com.cnu.post.model.type.Tag;
import com.cnu.post.entity.Post;
import jakarta.validation.Valid;
import lombok.Getter;

@Getter
public class PostRequest {
    @Valid
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
