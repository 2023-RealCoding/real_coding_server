package com.cnu.real_coding_server.model.request;


import com.cnu.real_coding_server.entity.Post;
import com.cnu.real_coding_server.model.type.Tag;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

@Getter
public class PostRequest {
    @Length(max = 50, message = "제목은 50자 이내입니다.")
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
