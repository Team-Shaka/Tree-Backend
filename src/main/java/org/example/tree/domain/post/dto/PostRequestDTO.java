package org.example.tree.domain.post.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class PostRequestDTO {

    @Getter
    public static class createPost {
        private String content;
    }

    @Getter
    public static class updatePost {
        private String content;
    }
}
