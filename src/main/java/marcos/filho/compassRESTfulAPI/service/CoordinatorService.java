package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.CoordinatorDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.CoordinatorDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Coordinator;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
import marcos.filho.compassRESTfulAPI.repository.CoordinatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoordinatorService {

    @Autowired
    CoordinatorRepository coordinatorRepository;

    public Coordinator save(CoordinatorDtoRequest coordinatorDtoRequest) {
        Coordinator coordinator = new Coordinator(
                null,
                coordinatorDtoRequest.getName()
        );
        if (coordinatorDtoRequest.getName() != null) {
            coordinatorRepository.save(coordinator);
            return coordinator;
        } else {
            throw new ApiRequestException("Null not allowed");
        }
    }
    public CoordinatorDtoResponse getCoordinatorById(Long id){
        Coordinator coordinator = coordinatorRepository
                .findById(id)
                .orElseThrow(() -> new ApiRequestException("Coordinator could not been found"));
        CoordinatorDtoResponse coordinatorDtoResponse = new CoordinatorDtoResponse(
                coordinator.getId(),
                coordinator.getName()
        );
        return coordinatorDtoResponse;
    }

    public Coordinator updateCoordinator(Long id, Coordinator updatedCoordinator) {
        if (coordinatorRepository.existsById(id)) {
            updatedCoordinator.setId(id);
            return coordinatorRepository.save(updatedCoordinator);
        } else {
            throw new ApiRequestException("Coordinator could not been found");
        }
    }
    public void deleteCoordinator(Long id){
        if (coordinatorRepository.existsById(id)){
            coordinatorRepository.deleteById(id);
        }else{
            throw new ApiRequestException("Coordinator could not been found ");
        }
    }
}
