package com.springjourney.Week4Practice.Controllers;

import com.springjourney.Week4Practice.Dtos.PostDTO;
import com.springjourney.Week4Practice.Entities.PostEntity;
import com.springjourney.Week4Practice.Services.PostImp;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostImp postImp;
    @GetMapping("/all")
    public List<PostDTO> allPost(){
        return postImp.findAllPost();
    }

    @PostMapping("/add")
    public PostDTO addPost(@RequestBody PostDTO postDTO){
        return postImp.addPost(postDTO);
    }

    @GetMapping("/postId/{postId}")
    public PostDTO getPostById(@PathVariable  int postId){
        return postImp.getPostById(postId);
    }

    @PutMapping("/update/{postId}")
    public PostDTO updatePostById(@RequestBody PostDTO postDTO,@PathVariable  int postId){
        return postImp.updatePostById(postDTO,postId);
    }

    @DeleteMapping("/delete/{postId}")
    public PostDTO deletePostById(@PathVariable  int postId){
        return postImp.deletePostById(postId);
    }

}
