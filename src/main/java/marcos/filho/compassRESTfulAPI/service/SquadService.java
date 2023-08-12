package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.SquadDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.SquadDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Squad;
import marcos.filho.compassRESTfulAPI.repository.SquadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SquadService {


    @Autowired
    SquadRepository squadRepository;
    public Squad save(SquadDtoRequest squadDtoRequest){
        Squad squad = new Squad(
                null,
                squadDtoRequest.getName()
        );
        squadRepository.save(squad);
        return squad;
    }

    public SquadDtoResponse getSquadById(Long id){
        Squad squad = squadRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException(" squad cannot be found"));
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
        return null;
    }
    public void deleteSquad(Long id){
        if (squadRepository.existsById(id)) {
            squadRepository.deleteById(id);
        }else{
            throw new RuntimeException("squad cannot be found");
        }
    }
}
