package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.ScrumMasterDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.ScrumMasterDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.ScrumMaster;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
import marcos.filho.compassRESTfulAPI.repository.ScrumMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScrumMasterService {

    @Autowired
    ScrumMasterRepository scrumMasterRepository;

    public ScrumMaster save(ScrumMasterDtoRequest scrumMasterDtoRequest) {
        ScrumMaster scrum = new ScrumMaster(
                null,
                scrumMasterDtoRequest.getName()
        );
        if (scrumMasterDtoRequest.getName() != null) {
            scrumMasterRepository.save(scrum);
            return scrum;
        } else {
            throw new ApiRequestException("Null not allowed");
        }
    }
    public ScrumMasterDtoResponse getScrumMasterById(Long id){
        ScrumMaster scrumMaster = scrumMasterRepository
                .findById(id)
                .orElseThrow(() -> new ApiRequestException(" cannot found Scrum Master"));
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
        throw new ApiRequestException("Scrum Master cannot be found");
    }

    public void deleteScrumMaster(Long id){
        if (scrumMasterRepository.existsById(id)){
            scrumMasterRepository.deleteById(id);
        }else{
            throw new ApiRequestException(" Scrum Master cannot be found");
        }
    }
}
