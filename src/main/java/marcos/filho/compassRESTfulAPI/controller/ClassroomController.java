package marcos.filho.compassRESTfulAPI.controller;


import marcos.filho.compassRESTfulAPI.dto.ClassroomDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.ClassroomDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Classroom;
import marcos.filho.compassRESTfulAPI.service.ClassroomService;
import org.springframework.beans.factory.BeanCreationNotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/classroom")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;
    @PostMapping("/post")
    public Classroom post(@RequestBody Classroom classroom){
        return classroomService.save(classroom);
    }

    @GetMapping("/get/{id}")
    public Classroom get(@PathVariable Long idClass){
        return classroomService.getClassroomById(idClass);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Classroom> update(@PathVariable Long id,@RequestBody Classroom updatedClassroom){
        Classroom updated = classroomService.updateClassroom(id, updatedClassroom);
        if(updated != null){
            return ResponseEntity.ok(updated);
        }else{
            throw new RuntimeException("cannot find the classroom");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable Long id){
        classroomService.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/getAll")
    public List<Classroom> getAllClassrooms(){
        return classroomService.getAllClassrooms();
    }

    @PutMapping("/{idClass}/putStudents/{idStudents}")
    public ResponseEntity<Void> addStudent(@PathVariable Long idClass, @PathVariable Long idStudent){
        return classroomService.addStudent(idClass, idStudent);
    }
    @PutMapping("/{idClass}/start")
    public ResponseEntity<String> startClassroom(@PathVariable Long idClass){
        return classroomService.startClassroom(idClass);
    }
    @PutMapping("/{idClass}/finish")
    public ResponseEntity<String> finishClassroom(@PathVariable Long idClass){
        return classroomService.finishClassroom(idClass);
    }
}
