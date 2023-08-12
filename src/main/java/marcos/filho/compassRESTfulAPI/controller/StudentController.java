package marcos.filho.compassRESTfulAPI.controller;

import marcos.filho.compassRESTfulAPI.dto.StudentDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.StudentDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Student;
import marcos.filho.compassRESTfulAPI.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PutMapping("/put/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        Student updated = studentService.updateStudent(id, updatedStudent);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            throw new RuntimeException(" Student cannot be found ");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

}
