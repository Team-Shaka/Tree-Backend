package org.example.tree.domain.comment.dto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CommentRequestDTO {

    @Getter
    public static class createComment {
        private String content;
    }

    @Getter
    public static class updateComment {
        private String content;
    }
}
