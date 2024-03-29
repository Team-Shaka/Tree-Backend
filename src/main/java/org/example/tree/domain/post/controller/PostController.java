package org.example.tree.domain.post.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.tree.domain.post.dto.PostRequestDTO;
import org.example.tree.domain.post.dto.PostResponseDTO;
import org.example.tree.domain.post.service.PostService;
import org.example.tree.global.common.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/trees/{treeId}/feed/posts")
    public ApiResponse<PostResponseDTO.createPost> createPost(
            @PathVariable final Long treeId,
            @RequestHeader("Authorization") final String header,
            @RequestBody final PostRequestDTO.createPost request
    ) throws Exception {
        String token = header.replace("Bearer ", "");
        return ApiResponse.onSuccess(postService.createPost(treeId, request, token));
    }

    @GetMapping("/trees/{treeId}/feed")
    @Operation(summary = "피드 조회", description = "특정 트리하우스 속 피드를 불러옵니다.")
    public ApiResponse<PostResponseDTO.getFeed> getFeed(
            @PathVariable final Long treeId,
            @RequestHeader("Authorization") final String header
    ) {
        String token = header.replace("Bearer ", "");
        return ApiResponse.onSuccess(postService.getFeed(treeId, token));
    }

    @GetMapping("/trees/{treeId}/feed/posts/{postId}")
    @Operation(summary = "게시글 조회", description = "특정 게시글을 조회합니다.")
    public ApiResponse<PostResponseDTO.getPost> getPost(
            @PathVariable final Long treeId,
            @PathVariable final Long postId,
            @RequestHeader("Authorization") final String header
    ) {
        String token = header.replace("Bearer ", "");
        return ApiResponse.onSuccess(postService.getPost(treeId, postId, token));
    }

    @GetMapping("/trees/{treeId}/feed/posts")
    @Operation(summary = "특정 멤버의 게시글 조회", description = "특정 멤버가 작성한 게시글 목록을 불러옵니다.")
    public ApiResponse<List<PostResponseDTO.getPost>> getPosts(
            @PathVariable final Long treeId,
            @RequestParam(name = "member") final Long profileId,
            @RequestHeader("Authorization") final String header
    ) {
        String token = header.replace("Bearer ", "");
        return ApiResponse.onSuccess(postService.getTreePosts(treeId, profileId, token));
    }

    @PatchMapping("/trees/{treeId}/feed/posts/{postId}")
    @Operation(summary = "게시글 수정", description = "게시글을 수정합니다.")
    public ApiResponse updatePost(
            @PathVariable final Long treeId,
            @PathVariable final Long postId,
            @RequestHeader("Authorization") final String header,
            @RequestBody final PostRequestDTO.updatePost request
    ) {
        String token = header.replace("Bearer ", "");
        postService.updatePost(treeId, postId, request, token);
        return ApiResponse.onSuccess("");
    }

    @DeleteMapping("/trees/{treeId}/feed/posts/{postId}")
    @Operation(summary = "게시글 삭제", description = "게시글을 삭제합니다.")
    public ApiResponse deletePost(
            @PathVariable final Long treeId,
            @PathVariable final Long postId,
            @RequestHeader("Authorization") final String header
    ) {
        String token = header.replace("Bearer ", "");
        postService.deletePost(treeId, postId, token);
        return ApiResponse.onSuccess("");
    }
}
