package tn.esprit.spring.restcontrollers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.spring.Services.IUserService;
import tn.esprit.spring.entities.Utilisateur;

import java.util.List;

@RestController
// ou bien @Component
// ou bien @Controller + @ResponseBody
@AllArgsConstructor
@RequestMapping("user")
public class UserRestController {

    // POST GET PUT DELETE PATCH ...

    IUserService service;

    @GetMapping
    public List<Utilisateur> findAll()
    {
        return service.selectAllUsers();
    }

    @PostMapping
    public Utilisateur add(@RequestBody Utilisateur user){
        return service.addUser(user);
    }

    @GetMapping("getById/{id}")
    public Utilisateur getById(@PathVariable long id){
        return service.selectUserByIdWithGet(id);
    }

    // http://localhost:8088/api/user/getById/1
    @GetMapping("getById2/{id}")
    public Utilisateur getById2(@PathVariable(name = "id") long idididididididididi){
        return service.selectUserByIdWithGet(idididididididididi);
    }

    //http://localhost:8088/api/user?id=1&...=...
    @DeleteMapping
    public void deleteById(@RequestParam long id){
        service.deleteUserById(id);
    }
}
