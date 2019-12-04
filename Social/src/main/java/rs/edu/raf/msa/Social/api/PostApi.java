package rs.edu.raf.msa.Social.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.msa.Social.domain.model.Post;
import rs.edu.raf.msa.Social.service.PostService;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostApi {

    private PostService postService;

    @Autowired
    public PostApi(PostService postService) {
        super();
        this.postService = postService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Post get(@PathVariable Long id) {
        return postService.get(id);
    }

    @PostMapping
    public @ResponseBody
    Post post(@RequestParam Long userId, @RequestParam String content) {
        return postService.post(userId, content);
    }

    @GetMapping("/user/{id}")
    public @ResponseBody
    List<Post> user(@PathVariable Long id)  {
        return postService.user(id);
    }

}
