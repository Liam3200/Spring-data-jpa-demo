package greene.jpademo.spring.data.jpademo.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Course {
    @Id
    @SequenceGenerator(
        name="course_sequence",
        sequenceName = "course_sequence",
        allocationSize = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(
        mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
        cascade = CascadeType.ALL
    )
    @JoinColumn(
        name = "teacher_id",
        referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany
    @JoinTable(
        name = "student_course_map",
        joinColumns = @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
        ),
        inverseJoinColumns = @JoinColumn(
            name = "student_id",
            referencedColumnName = "studentId"
        )
        
    )
    private List<Student> students;
}
