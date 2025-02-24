package kh.edu.react.provider.controller;

import kh.edu.react.provider.dto.BoardPost;
import kh.edu.react.provider.service.BoardPostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class BoardPostController {
    @Autowired
    private BoardPostServiceImpl boardPostService;

    @GetMapping
    public List<BoardPost> getAllPosts() {
        return boardPostService.getAllPosts();
    }

    @GetMapping("/{postId}")
    public BoardPost getPostById(@PathVariable int postId) {
        return boardPostService.getPostById(postId);
    }

    /**
     *  -parameters' flag.\r\n\tat org.springframework.web.method.annotation.
     *  keyword 라는 변수이름이 sql 문 까지 제대로 전달 되지 않을 깨 발생
     *  -> maven 기준으로 pom.xml 에 string 관련 설정 진행하거나
     *      gradle 기준으로 build.gradle 에 String 관련 설정 진행
     *      mapper.java 내부에 키워드 String keyword 앞에 @Param("keyword") 설정을 진행 해주거나
     *      keyword 라는 명칭이 제대로 전달되고 있는지 확인
     * @param keyword
     * @return
     */
    @GetMapping("/search")
    public List<BoardPost> searchPost(@RequestParam String keyword) {
        return boardPostService.searchPosts(keyword);
    }


    @PostMapping
    public void insertPost(@RequestBody BoardPost boardPost) {
        boardPostService.insertPost(boardPost);
    }

    @PutMapping("/{postId}")
    public void updatePost(@PathVariable int postId, @RequestBody BoardPost boardPost) {
        boardPost.setPostId(postId);
        boardPostService.updatePost(boardPost);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable int postId) {
        boardPostService.deletePost(postId);
    }
}
