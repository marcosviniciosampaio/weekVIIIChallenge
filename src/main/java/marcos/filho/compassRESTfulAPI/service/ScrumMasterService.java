package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.ScrumMasterDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.ScrumMasterDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.ScrumMaster;
import marcos.filho.compassRESTfulAPI.repository.ScrumMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrumMasterService {

    @Autowired
    ScrumMasterRepository scrumMasterRepository;

    public ScrumMaster save(ScrumMasterDtoRequest scrumMasterDtoRequest){
        ScrumMaster scrum = new ScrumMaster(
                null,
                scrumMasterDtoRequest.getName()
        );
        scrumMasterRepository.save(scrum);
        return scrum;
    }

    public ScrumMasterDtoResponse getScrumMasterById(Long id){
        ScrumMaster scrumMaster = scrumMasterRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(" cannot found Scrum Master"));
        ScrumMasterDtoResponse scrumMasterDtoResponse = new ScrumMasterDtoResponse(
                scrumMaster.getId(),
                scrumMaster.getName()
        );
        return scrumMasterDtoResponse;
    }

    public ScrumMaster updatedScrumMaster(Long id, ScrumMaster updatedScrumMaster){
        if (scrumMasterRepository.existsById(id)){
            updatedScrumMaster.setId(id);
            return scrumMasterRepository.save(updatedScrumMaster);
        }
        return null;
    }

    public void deleteScrumMaster(Long id){
        if (scrumMasterRepository.existsById(id)){
            scrumMasterRepository.deleteById(id);
        }else{
            throw new RuntimeException(" Scrum Master cannot be found");
        }
    }
}
