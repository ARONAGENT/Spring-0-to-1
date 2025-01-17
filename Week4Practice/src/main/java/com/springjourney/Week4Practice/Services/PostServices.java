package com.springjourney.Week4Practice.Services;

import com.springjourney.Week4Practice.Dtos.PostDTO;
import com.springjourney.Week4Practice.Entities.PostEntity;
import com.springjourney.Week4Practice.Repositories.PostRepository;
import com.springjourney.Week4Practice.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServices implements PostImp{

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;
    @Override
    public List<PostDTO> findAllPost() {
        return postRepository.findAll()
                .stream()
                .map(postEntity ->modelMapper.map(postEntity,PostDTO.class) )
                .collect(Collectors.toList());
    }

    @Override
    public PostDTO addPost(PostDTO obj) {

        PostEntity postEntity=modelMapper.map(obj,PostEntity.class);
        postRepository.save(postEntity);
        return modelMapper.map(postEntity,PostDTO.class);
    }

    @Override
    public PostDTO getPostById(int postId) {
        PostEntity postEntity=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Resource not found by id :"+postId));
        return modelMapper.map(postEntity,PostDTO.class);
    }

    @Override
    public PostDTO updatePostById(PostDTO postDTO, int postId) {
        PostEntity olderpost=postRepository.findById(postId).orElseThrow(()->new ResourceNotFoundException("Resource not found by Id :"+postId));
        postDTO.setPostId(postId);
        modelMapper.map(postDTO,olderpost);
        PostEntity savedEntity=postRepository.save(olderpost);
        return modelMapper.map(savedEntity,PostDTO.class);
    }

    @Override
    public PostDTO deletePostById(int postId) {
        Optional<PostEntity> postEntityOptional = postRepository.findById(postId);
        if (postEntityOptional.isEmpty()) {
            throw new ResourceNotFoundException("Resource not found with ID: " + postId);
        }
        PostDTO postDTO = modelMapper.map(postEntityOptional.get(), PostDTO.class);
        postRepository.deleteById(postId);
        return postDTO;
    }

}
