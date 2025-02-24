package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.BoardPost;
import kh.edu.react.provider.mapper.BoardPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardPostServiceImpl implements BoardPostService {

    @Autowired
    private BoardPostMapper boardPostMapper;

    @Override
    public List<BoardPost> getAllPosts() {
        return boardPostMapper.getAllPosts();
    }

    @Override
    public BoardPost getPostById(int postId) {
        return boardPostMapper.getPostById(postId);
    }

    @Override
    public List<BoardPost> searchPosts(String keyword) {
        return boardPostMapper.searchPosts(keyword);
    }

    @Override
    public void insertPost(BoardPost boardPost) {
            boardPostMapper.insertPost(boardPost);
    }

    @Override
    public void updatePost(BoardPost boardPost) {
            boardPostMapper.updatePost(boardPost);
    }

    @Override
    public void deletePost(int postId) {
            boardPostMapper.deletePost(postId);
    }
}
