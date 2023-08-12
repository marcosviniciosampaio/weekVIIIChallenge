package marcos.filho.compassRESTfulAPI.controller;

import marcos.filho.compassRESTfulAPI.dto.SquadDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.SquadDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Squad;
import marcos.filho.compassRESTfulAPI.service.SquadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/squad")
public class SquadController {

    @Autowired
    SquadService squadService;

    @PostMapping("/post")
    public Squad post(@RequestBody SquadDtoRequest squadDtoRequest){
        return squadService.save(squadDtoRequest);
    }

    @GetMapping("/get/{id}")
    public SquadDtoResponse get(@PathVariable Long id){
        return squadService.getSquadById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<Squad> updateSquad(@PathVariable Long id, @RequestBody Squad updatedSquad){
        Squad updated = squadService.updateSquad(id, updatedSquad);
        if (updated != null){
            return ResponseEntity.ok(updated);
        } else {
            throw new RuntimeException("Student cannot be found");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSquad(@PathVariable Long id){
        squadService.deleteSquad(id);
        return ResponseEntity.noContent().build();
    }
}
