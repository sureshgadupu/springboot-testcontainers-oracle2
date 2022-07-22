package dev.fullstackcode.eis.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Getter
@Setter
@ToString
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String first_name;
    private String last_name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birth_date;
    private LocalDate hire_date;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;



    public Employee() {

    }


}