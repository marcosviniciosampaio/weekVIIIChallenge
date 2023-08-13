package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.SquadDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.SquadDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Squad;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
import marcos.filho.compassRESTfulAPI.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {


    @Autowired
    SquadRepository squadRepository;
    public Squad save(SquadDtoRequest squadDtoRequest) {
        Squad squad = new Squad(
                null,
                squadDtoRequest.getName()
        );
        if (squadDtoRequest.getName() != null) {
            squadRepository.save(squad);
            return squad;
        } else {
            throw new ApiRequestException("Null not allowed");
        }
    }
    public SquadDtoResponse getSquadById(Long id){
        Squad squad = squadRepository
                .findById(id)
                .orElseThrow(() -> new ApiRequestException(" squad cannot be found"));
        SquadDtoResponse squadDtoResponse = new SquadDtoResponse(
                squad.getId(),
                squad.getName()
        );
        return squadDtoResponse;
    }

    public Squad updateSquad(Long id, Squad updatedSquad){
        if(squadRepository.existsById(id)) {
            updatedSquad.setId(id);
            return squadRepository.save(updatedSquad);
        }
        throw new ApiRequestException("Squad cannot be found");
    }
    public void deleteSquad(Long id){
        if (squadRepository.existsById(id)) {
            squadRepository.deleteById(id);
        }else{
            throw new ApiRequestException("squad cannot be found");
        }
    }
}
