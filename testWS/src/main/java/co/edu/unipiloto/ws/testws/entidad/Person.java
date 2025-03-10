/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws.entidad;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author 57300
 */

@XmlRootElement(name = "persona")
@XmlType(propOrder = {"id", "fullName", "age"})
public class Person {
    
    private int id;
    private String fullName;
    private int age;
    //private final double salarioMinimo = 1623500.0;
    private double salary;
    
    public Person(){
        
    }

    @XmlElement
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlElement
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    @XmlElement
    public double getSalary(){
        return salary;
    }
    
    public void setSalary(double salary){
        this.salary = salary;
    }
    
    
    
}
