package rs.edu.raf.msa.Social.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rs.edu.raf.msa.Social.domain.model.User;
import rs.edu.raf.msa.Social.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserApi {

    private UserService userService;

    @Autowired
    public UserApi(UserService userService) {
        super();
        this.userService = userService;
    }

    @GetMapping("/")
    public @ResponseBody
    User get(@RequestParam Long id) {
        return userService.get(id);
    }

    @PostMapping("/save")
    public @ResponseBody
    User save(@RequestParam String name) {
        return userService.save(name);
    }

    @DeleteMapping("/")
    public @ResponseBody
    Boolean delete(@RequestParam Long id) {
        return userService.delete(id);
    }



}
