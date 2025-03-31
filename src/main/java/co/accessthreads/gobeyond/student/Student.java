package co.accessthreads.gobeyond.student;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(schema = "student", name = "students")
public class Student {
    @Id
    @GeneratedValue
    @UuidGenerator
    UUID id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "id_no")
    private String idNo;

    @Column(name = "current_course")
    private String currentCourse;

    @Column(name = "icoe_name")
    private String icoeName;

    @Column(name = "icoe_address")
    private String icoeAddress;

    @Column(name = "icoe_contact_no")
    private String icoeContactNo;
}
