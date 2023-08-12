package marcos.filho.compassRESTfulAPI.controller;

import marcos.filho.compassRESTfulAPI.dto.ScrumMasterDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.ScrumMasterDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.ScrumMaster;
import marcos.filho.compassRESTfulAPI.service.ScrumMasterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/scrumMaster")
public class ScrumMasterController {

    @Autowired
    ScrumMasterService scrumMasterService;

    @PostMapping("/post")
    public ScrumMaster post(@RequestBody ScrumMasterDtoRequest scrumMasterDtoRequest){
        return scrumMasterService.save(scrumMasterDtoRequest);
    }

    @GetMapping("/get/{id}")
    public ScrumMasterDtoResponse get(@PathVariable Long id){
        return scrumMasterService.getScrumMasterById(id);
    }

    @PutMapping("/put/{id}")
    public ResponseEntity<ScrumMaster> updateScrumMaster(@PathVariable Long id, @RequestBody ScrumMaster updateScrumMaster){
        ScrumMaster updated = scrumMasterService.updatedScrumMaster(id, updateScrumMaster);
        if (updated != null){
            return ResponseEntity.ok(updated);
        }else{
            throw new RuntimeException("cannot find Scrum Master");
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteScrumMaster(@PathVariable Long id){
        scrumMasterService.deleteScrumMaster(id);
        return ResponseEntity.noContent().build();
    }
}
