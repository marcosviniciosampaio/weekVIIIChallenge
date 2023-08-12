package marcos.filho.compassRESTfulAPI.controller;


import marcos.filho.compassRESTfulAPI.dto.ClassroomDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.ClassroomDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Classroom;
import marcos.filho.compassRESTfulAPI.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/classroom")
public class ClassroomController {
    @Autowired
    ClassroomService classroomService;
    @PostMapping("/post")
    public Classroom post(@RequestBody ClassroomDtoRequest classroomDtoRequest){
        return classroomService.save(classroomDtoRequest);
    }

    @GetMapping("/get/{id}")
    public ClassroomDtoResponse get(@PathVariable Long id){
        return classroomService.getClassroomById(id);
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
}
