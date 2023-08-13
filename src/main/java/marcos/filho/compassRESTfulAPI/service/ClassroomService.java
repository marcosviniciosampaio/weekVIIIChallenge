package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.ClassroomDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.ClassroomDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Classroom;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
import marcos.filho.compassRESTfulAPI.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;
    public Classroom save(ClassroomDtoRequest classroomDtoRequest){
        Classroom classroom = new Classroom(
                null,
                classroomDtoRequest.getName()
        );
        if(classroomDtoRequest.getName() != null) {
            classroomRepository.save(classroom);
            return classroom;
        }else{
            throw new ApiRequestException("Null not allowed");
        }
    }

    public ClassroomDtoResponse getClassroomById(Long id){
        Classroom classroom = classroomRepository
                .findById(id)
                .orElseThrow(() -> new ApiRequestException("cannot find the Classroom"));
        ClassroomDtoResponse classroomDtoResponse = new ClassroomDtoResponse(
                classroom.getId(),
                classroom.getName()
        );
        return classroomDtoResponse;
    }

    public Classroom updateClassroom(Long id, Classroom updatedClassroom){
       if(classroomRepository.existsById(id)){
           updatedClassroom.setId(id);
           return classroomRepository.save(updatedClassroom);
        }
       throw new ApiRequestException("cannot update the Classroom");
    }

    public void deleteClassroom(Long id){
        if(classroomRepository.existsById(id)){
            classroomRepository.deleteById(id);
        }else{
            throw new ApiRequestException( "cannot find the Classroom");
        }
    }
}
