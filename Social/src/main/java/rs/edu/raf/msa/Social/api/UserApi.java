package rs.edu.raf.msa.Social.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.msa.Social.domain.model.User;
import rs.edu.raf.msa.Social.service.UserService;

@RestController
@RequestMapping("user")
public class UserApi {

    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    User get(@PathVariable  Long id) {
        return userService.get(id);
    }

    @PostMapping
    public @ResponseBody
    User save(@RequestParam String name) {
        return userService.save(name);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    Boolean delete(@PathVariable Long id) {
        return userService.delete(id);
    }

    @PostMapping("/follow")
    public @ResponseBody
    Integer follow(@RequestParam Long userId, @RequestParam Long followId) {
        return userService.follow(userId, followId);
    }

}
