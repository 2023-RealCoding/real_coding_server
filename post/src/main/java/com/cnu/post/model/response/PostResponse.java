package com.cnu.post.model.response;

import com.cnu.post.Advertisement;
import com.cnu.post.entity.Post;

public record PostResponse(
        Post post,
        Advertisement advertisement
) {
}
