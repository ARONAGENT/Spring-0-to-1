package com.springjourney.Week4Practice.Services;

import com.springjourney.Week4Practice.Dtos.PostDTO;
import com.springjourney.Week4Practice.Entities.PostEntity;

import java.util.List;

public interface PostImp{

    List<PostDTO> findAllPost();
    PostDTO addPost(PostDTO obj);

    PostDTO getPostById(int postId);

    PostDTO updatePostById(PostDTO postDTO, int postId);

    PostDTO deletePostById(int postId);
}
