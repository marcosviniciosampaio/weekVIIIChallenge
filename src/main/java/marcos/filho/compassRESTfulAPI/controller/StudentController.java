package marcos.filho.compassRESTfulAPI.controller;

import marcos.filho.compassRESTfulAPI.dto.StudentDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.StudentDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Student;
import marcos.filho.compassRESTfulAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/post")
    public Student post(@RequestBody StudentDtoRequest studentDtoRequest){
        return studentService.save(studentDtoRequest);
    }

    @GetMapping("/get/{id}")
    public StudentDtoResponse get( @PathVariable Long id){
        return studentService.getStudentById(id);
    }

}
