package com.cnu.post.model.response;

import com.cnu.post.entity.Post;
import com.cnu.post.model.Advertisement;

public record PostResponse(
        Post post,
        Advertisement advertisement

) {
}
