package rs.edu.raf.msa.demo.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.msa.demo.domain.model.User;
import rs.edu.raf.msa.demo.service.FollowService;

import java.util.List;

@RestController
@RequestMapping(value = "/follow")
public class FollowApi {

    private FollowService followService;

    @Autowired
    public FollowApi(FollowService followService) {
        super();
        this.followService = followService;
    }

    @GetMapping("/followers/{id}")
    public @ResponseBody
    List<User> getFollowers(@PathVariable Long id) {
        return followService.getFollowers(id);
    }

    @GetMapping("/following/{id}")
    public @ResponseBody
    List<User> getFollowing(@PathVariable Long id) {
        return followService.getFollowing(id);
    }

    @PostMapping
    public @ResponseBody
    Boolean follow(@RequestParam Long id, @RequestParam Long followId) {
        return followService.follow(id, followId);
    }



}
