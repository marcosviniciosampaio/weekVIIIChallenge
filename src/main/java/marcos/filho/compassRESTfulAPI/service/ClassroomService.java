package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.entity.Classroom;
import marcos.filho.compassRESTfulAPI.entity.Student;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
import marcos.filho.compassRESTfulAPI.repository.ClassroomRepository;
import marcos.filho.compassRESTfulAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {
    @Autowired
    ClassroomRepository classroomRepository;
    StudentRepository studentRepository;

    public ResponseEntity<Void> addStudent(Long idClass, Long idStudent){
        Optional<Classroom> optionalClassroom = classroomRepository.findById(idClass);
        if (optionalClassroom.isPresent()){
            Optional<Student> optionalStudent = studentRepository.findById((idStudent));
            if(optionalStudent.isPresent()){
                Classroom classroom = optionalClassroom.get();
                Student student = optionalStudent.get();
                classroom.getStudents().add(student);
                student.getClassrooms().add(classroom);
                classroomRepository.save(classroom);
                studentRepository.save(student);

                return ResponseEntity.status(HttpStatus.OK).body(null);

            }else throw new ApiRequestException("Student couldn't been found");

        }else throw new ApiRequestException(" Classroom couldn't not been  found");
    }

    public List<Classroom> getAllClassrooms(){
        return classroomRepository.findAll();
    }

    public ResponseEntity<String> startClassroom(Long idClass){
        Optional<Classroom> classroomOptional = classroomRepository.findById(idClass);
        if(classroomOptional.isPresent()){
            Classroom classroom = classroomOptional.get();
            if(classroom.getStatus().equals("WAITING")){
                classroom.setStatus(Classroom.ClassStatus.STARTED);
                classroomRepository.save(classroom);
                return ResponseEntity.status(HttpStatus.OK).body("Classroom started.");
            }else{
                throw new ApiRequestException("Classroom is not in the waiting status");
            }
        }else{
            throw new ApiRequestException("Classroom not found");
        }
    }
    public ResponseEntity<String> finishClassroom(Long idClass){
        Optional<Classroom> classroomOptional = classroomRepository.findById(idClass);
        if(classroomOptional.isPresent()){
            Classroom classroom = classroomOptional.get();
            if(classroom.getStatus().equals("STARTED")){
                classroom.setStatus(Classroom.ClassStatus.FINISHED);
                classroomRepository.save(classroom);
                return ResponseEntity.status(HttpStatus.OK).body("Classroom finished.");
            }else{
                throw new ApiRequestException("Classroom is not in Started status.");
            }
        }else{
            throw new ApiRequestException("Classroom not found");
        }
    }

    public Classroom save(Classroom classroom) {
        int minStudents = 15;
        int maxStudents = 30;
        int studentCount = classroom.getStudents().size();

        if (studentCount < minStudents || studentCount > maxStudents) {
            throw new IllegalArgumentException("Number of students must be between 15 and 30");
        } else {
            Classroom clazz = new Classroom(
                    null,
                    classroom.getName(),
                    classroom.getStudents(),
                    classroom.getStatus()
            );
            if (clazz.getName() != null) {
                classroomRepository.save(classroom);
                return classroom;
            } else {
                throw new ApiRequestException("Null not allowed");
            }
        }
    }

    public Classroom getClassroomById(Long idClass){
        Classroom classroom = classroomRepository
                .findById(idClass)
                .orElseThrow(() -> new ApiRequestException("cannot find the Classroom"));
        Classroom clazz = new Classroom(
                classroom.getIdClass(),
                classroom.getName(),
                classroom.getStudents(),
                classroom.getStatus()
        );
        return clazz;
    }

    public Classroom updateClassroom(Long idClass, Classroom updatedClassroom){
       if(classroomRepository.existsById(idClass)){
           updatedClassroom.setIdClass(idClass);
           return classroomRepository.save(updatedClassroom);
        }
       throw new ApiRequestException("cannot update the Classroom");
    }

    public void deleteClassroom(Long idClass){
        if(classroomRepository.existsById(idClass)){
            classroomRepository.deleteById(idClass);
        }else{
            throw new ApiRequestException( "cannot find the Classroom");
        }
    }
}

