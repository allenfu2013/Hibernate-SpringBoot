package com.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
public class TennisPlayer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    // This will disable insert batching - AVOID IT!
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    // This will work, but better use the below solution
    // @GeneratedValue(strategy = GenerationType.AUTO)

    // This will allow insert batching and optimizes the identifiers
    // generation via the hi/lo algorithm
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hilo")
    @GenericGenerator(name = "hilo", 
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                @Parameter(name = "sequence_name", value = "sequence"),
                @Parameter(name = "initial_value", value = "1"),
                @Parameter(name = "increment_size", value = "10"),
                @Parameter(name = "optimizer", value = "hilo")
            })
    private Long id;

    private String name;
    private String city;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", city=" + city + ", age=" + age + '}';
    }
}
