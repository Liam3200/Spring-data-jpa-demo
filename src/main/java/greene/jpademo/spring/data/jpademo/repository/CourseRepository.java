package greene.jpademo.spring.data.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import greene.jpademo.spring.data.jpademo.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
