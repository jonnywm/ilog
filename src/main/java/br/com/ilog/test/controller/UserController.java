package br.com.ilog.test.controller;

import br.com.ilog.test.constants.Constants;
import br.com.ilog.test.model.User;
import br.com.ilog.test.repository.UserRepository;
import br.com.ilog.test.utils.IgnoreField;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jonny
 */
@RestController
@CrossOrigin(origins = "*")
public class UserController implements Serializable{

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value="/users", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> getUsers() {
        return ResponseEntity.ok().body(new GsonBuilder().
                addSerializationExclusionStrategy(IgnoreField.getStrategy("senha", User.class)).
                serializeNulls().create().toJson(userRepository.findAll()));
    }

    /**
     * Insere/atualiza um usuário no banco de dados.
     *
     * @param user
     * @return
     */
    @PostMapping(value ={"/users/create", "users/edit"})
    @ResponseBody
    public ResponseEntity<String> save(@RequestBody(required = true) User user) {
        userRepository.save(user);
        return ResponseEntity.ok().body(new Gson().toJson(Constants.SUCCESS));
    }
    
    /**
     * Remove um curso no banco de dados.
     *
     * @param user
     * @return
     */
    @PostMapping("/users/remove")
    @ResponseBody
    public ResponseEntity<String> remove(@RequestBody(required = true) User user) {
        userRepository.delete(user);
        return ResponseEntity.ok().body(new Gson().toJson(Constants.SUCCESS));
    }
}
