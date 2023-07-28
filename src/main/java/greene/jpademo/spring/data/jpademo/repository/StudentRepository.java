package greene.jpademo.spring.data.jpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import greene.jpademo.spring.data.jpademo.entity.Student;
import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByFirstName(String firstName);

    public List<Student> findByFirstNameContaining(String name);

    public List<Student> findByLastNameNotNull();

    public List<Student> findByGuardianName(String guardianName);

    public Student findByFirstNameAndLastName(String firstName, String lastName);

    @Query("select s from Student s where s.emailId = ?1")
    public Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String getStudentFirstNameByEmailAddress(String emailId);

    @Query(
        value = "SELECT * FROM tbl_student s where s.email_address = ?1",
        nativeQuery = true
    )
    public Student getStudentByEmailAddressNative(String emailId);

    @Query(
        value = "SELECT * FROM tbl_student s where s.email_address = :emailId",
        nativeQuery = true
    )
    public Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);

    @Modifying
    @Transactional
    @Query(
        value = "update tbl_student set first_name = ?2 where email_address = ?1",
        nativeQuery = true
    )
    int updateStudentNameByEmailId(String emailId, String firstName);
}
