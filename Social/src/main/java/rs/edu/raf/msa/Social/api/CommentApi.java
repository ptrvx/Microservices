package rs.edu.raf.msa.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.msa.demo.domain.model.Comment;
import rs.edu.raf.msa.demo.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentApi {

    private CommentService commentService;

    @Autowired
    public CommentApi(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Comment get(@PathVariable  Long  id) {
        return commentService.get(id);
    }

    @PostMapping
    public @ResponseBody
    Comment post(@RequestParam Long userId, @RequestParam Long postId, @RequestParam String content) {
        return commentService.send(userId, postId, content);
    }

    @GetMapping("/post/{id}")
    public @ResponseBody
    List<Comment> post(@PathVariable Long id) {
        return commentService.post(id);
    }

}
