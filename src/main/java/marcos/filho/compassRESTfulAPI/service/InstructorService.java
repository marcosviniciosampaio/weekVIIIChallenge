package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.InstructorDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.InstructorDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Instructor;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
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
        if(instructorDtoRequest.getName() != null &&
                instructorDtoRequest.getLastname() != null &&
                    instructorDtoRequest.getEmail() != null &&
                        instructorDtoRequest.getRole() != null){
        if(instructorDtoRequest.getRole().equalsIgnoreCase("instructor") ||
                instructorDtoRequest.getRole().equalsIgnoreCase("scrum master") ||
                    instructorDtoRequest.getRole().equalsIgnoreCase("coordinator"))
        {
            instructorRepository.save(instructor);
            return instructor;
        }else{
            throw new ApiRequestException("must be instructor/scrum master/coordinator");
        }
        }else{
            throw new ApiRequestException("NULL NOT ALLOWED");
        }
        }

    public InstructorDtoResponse getInstructorById(Long id){
        Instructor instructor = instructorRepository
                .findById(id)
                .orElseThrow(() -> new ApiRequestException("cannot find instructor"));
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
            throw new ApiRequestException("cannot find the instructor");
        }
    }

    public void deleteInstructor(Long id){
        if(instructorRepository.existsById(id)){
            instructorRepository.deleteById(id);
        }else{
            throw new ApiRequestException("cannot find the instructor");
        }
    }
}
