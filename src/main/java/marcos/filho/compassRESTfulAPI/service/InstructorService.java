package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.InstructorDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.InstructorDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Instructor;
import marcos.filho.compassRESTfulAPI.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructorService {
    @Autowired
    InstructorRepository instructorRepository;
    public Instructor save(InstructorDtoRequest instructorDtoRequest){
        Instructor instructor = new Instructor(
                null,
                instructorDtoRequest.getName(),
                instructorDtoRequest.getLastname(),
                instructorDtoRequest.getEmail(),
                instructorDtoRequest.getRole()
        );
        instructorRepository.save(instructor);
        return instructor;
    }

    public InstructorDtoResponse getInstructorById(Long id){
        Instructor instructor = instructorRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("cannot find instructor"));
        InstructorDtoResponse instructorDtoResponse = new InstructorDtoResponse(
                instructor.getId(),
                instructor.getName(),
                instructor.getLastname(),
                instructor.getEmail(),
                instructor.getRole()
        );
        return instructorDtoResponse;
    }

    public  Instructor updatedInstructor(Long id, Instructor updatedInstructor){
        if(instructorRepository.existsById(id)){
            updatedInstructor.setId(id);
            return instructorRepository.save(updatedInstructor);
        }else{
            throw new RuntimeException("cannot find the instructor");
        }
    }

    public void deleteInstructor(Long id){
        if(instructorRepository.existsById(id)){
            instructorRepository.deleteById(id);
        }else{
            throw new RuntimeException("cannot find the instructor");
        }
    }
}
