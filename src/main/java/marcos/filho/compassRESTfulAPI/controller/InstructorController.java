package marcos.filho.compassRESTfulAPI.controller;

import marcos.filho.compassRESTfulAPI.dto.InstructorDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.InstructorDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Instructor;
import marcos.filho.compassRESTfulAPI.service.InstructorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Inherited;

@RestController
@RequestMapping(value = "/instructor")
public class InstructorController {
    @Autowired
    InstructorService instructorService;

    @PostMapping("/post")
    public Instructor post(@RequestBody InstructorDtoRequest instructorDtoRequest) {
        return instructorService.save(instructorDtoRequest);
    }

    @GetMapping("/get/{id}")
    public InstructorDtoResponse get(@PathVariable Long id) {
        return instructorService.getInstructorById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Instructor> put(@PathVariable Long id, @RequestBody Instructor updatedInstructor) {
        Instructor updated = instructorService.updatedInstructor(id, updatedInstructor);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            throw new RuntimeException("cannot find the Instructor");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        instructorService.deleteInstructor(id);
        return ResponseEntity.noContent().build();
    }
}
