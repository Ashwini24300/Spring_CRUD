package com.example.demo.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long studentId;

    @Column(name="first_name",length = 30,nullable = false)
    private String firstName;

    @Column(name="last_name",length = 30,nullable = false)
    private String lastName;

    // mappedBy : addresses field in the Student class is the inverse side of the relationship, 
    //            and the "student" property in the Address class owns the relationship.
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)

    @ToString.Exclude // exclude this field from to string so that recursive toString calls can be avoided.
    private Set<Address> addresses = new HashSet<>();   
}
