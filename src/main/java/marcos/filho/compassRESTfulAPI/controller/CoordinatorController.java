package marcos.filho.compassRESTfulAPI.controller;

import marcos.filho.compassRESTfulAPI.dto.CoordinatorDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.CoordinatorDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Coordinator;
import marcos.filho.compassRESTfulAPI.service.CoordinatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/coordinator")
public class CoordinatorController {

    @Autowired
    CoordinatorService coordinatorService;

    @PostMapping("/post")
    public Coordinator post(@RequestBody CoordinatorDtoRequest coordinatorDtoRequest){
        return coordinatorService.save(coordinatorDtoRequest);
    }

    @GetMapping("/get/{id}")
    public CoordinatorDtoResponse get(@PathVariable Long id){
        return coordinatorService.getCoordinatorById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Coordinator> updateCoordinator(@PathVariable Long id, @RequestBody Coordinator updatedCoordinator){
        Coordinator updated = coordinatorService.updateCoordinator(id, updatedCoordinator);
        if (updated != null){
            return ResponseEntity.ok(updated);
        }else{
            throw new RuntimeException("Coordinator cannot be found");
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCoordinator(@PathVariable Long id) {
        coordinatorService.deleteCoordinator(id);
        return ResponseEntity.noContent().build();
    }
}
