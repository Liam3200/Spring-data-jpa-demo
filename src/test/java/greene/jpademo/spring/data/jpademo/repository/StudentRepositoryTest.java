package greene.jpademo.spring.data.jpademo.repository;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import greene.jpademo.spring.data.jpademo.entity.Guardian;
import greene.jpademo.spring.data.jpademo.entity.Student;


@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .firstName("John")
                .lastName("Doe")
                .emailId("john.doe@domain")
                // .guardianName("Jane Doe")
                // .guardianEmail("jane.doe@domain")
                // .guardianMobile("555-555-5555")
                .build();
        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian() {
        Guardian guardian = Guardian.builder()
                .name("Jane Doe")
                .email("jane.doe@domain")
                .mobile("555-555-5555")
                .build();

        Student student = Student.builder().
                firstName("John")
                .lastName("Doe")
                .emailId("john.doe@domain")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }
    
    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("John");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Jo");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Jane Doe");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByLastNameNotNull() {
        List<Student> studentList = studentRepository.findByLastNameNotNull();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameAndLastName() {
        Student student = studentRepository.findByFirstNameAndLastName("John", "Doe");

        System.out.println("student = " + student);
    }

    @Test
    public void printStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("john.doe@domain");

        System.out.println("student = " + student);
    }

    @Test
    public void printStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("john.doe@domain");

        System.out.println("firstName = " + firstName);
    }
}
