package marcos.filho.compassRESTfulAPI.service;

import marcos.filho.compassRESTfulAPI.dto.StudentDtoRequest;
import marcos.filho.compassRESTfulAPI.dto.StudentDtoResponse;
import marcos.filho.compassRESTfulAPI.entity.Student;
import marcos.filho.compassRESTfulAPI.exception.ApiRequestException;
import marcos.filho.compassRESTfulAPI.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student save(StudentDtoRequest studentDtoRequest) {
        Student student = new Student(
                null,
                studentDtoRequest.getName());
        if (studentDtoRequest.getName() != null) {
            studentRepository.save(student);
            return student;
        } else {
            throw new ApiRequestException("Null not allowed");
        }
    }
    public StudentDtoResponse getStudentById(Long idStudent){
        Student student = studentRepository
                .findById(idStudent)
                .orElseThrow(()-> new ApiRequestException("student cannot be found"));
        StudentDtoResponse studentDtoResponse = new StudentDtoResponse(
                student.getIdStudent(),
                student.getName());
        return studentDtoResponse;
    }

    public Student updateStudent(Long idStudent, Student updatedStudent) {
        if (studentRepository.existsById(idStudent)) {
            updatedStudent.setIdStudent(idStudent);
            return studentRepository.save(updatedStudent);
        }
        throw new ApiRequestException(" Student cannot be found ");
    }

    public void deleteStudent(Long idStudent) {
        if (studentRepository.existsById(idStudent)) {
            studentRepository.deleteById(idStudent);
        }else{
            throw new ApiRequestException("student cannot be found");
        }
    }
}


