package br.com.ilog.test.controller;

import br.com.ilog.test.constants.Constants;
import br.com.ilog.test.model.Course;
import br.com.ilog.test.repository.CourseRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping(value = "/courses", produces = "application/json")
    @ResponseBody
    public ResponseEntity<String> getCourses() {
        return ResponseEntity.ok().body(new GsonBuilder().
                serializeNulls().create().toJson(courseRepository.findAll()));
    }

    /**
     * Insere/atualiza um curso no banco de dados.
     *
     * @param course
     * @return
     */
    @PostMapping(value ={"/courses/create", "courses/edit"})
    @ResponseBody
    public ResponseEntity<String> save(@RequestBody(required = true) Course course) {
        courseRepository.save(course);
        return ResponseEntity.ok().body(new Gson().toJson(Constants.SUCCESS));
    }
    
    /**
     * Remove um curso no banco de dados.
     *
     * @param course
     * @return
     */
    @PostMapping("/courses/remove")
    @ResponseBody
    public ResponseEntity<String> remove(@RequestBody(required = true) Course course) {
        courseRepository.delete(course);
        return ResponseEntity.ok().body(new Gson().toJson(Constants.SUCCESS));
    }
}
