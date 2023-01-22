package it.peppe.departmentservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "departmentId")
    private Long departmentId;

    @Column(name = "departmentName")
    private String departmentName;

    @Column(name = "departmentAddress")
    private String departmentAddress;

    @Column(name = "departmentCode")
    private String departmentCode;

}
