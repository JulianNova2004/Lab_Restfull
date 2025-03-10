/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.ws.testws.entidad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author 57300
 */
@Path("service")
public class Service {
    
    private static Map<Integer, Person> persons = new HashMap<Integer, Person>();
    
    static{
        for (int i = 0; i < 10; i++) {
            Person person = new Person();
            int id = i + 1;
            person.setId(id);
            person.setFullName("My wonderfull person " + id);
            person.setAge(new Random().nextInt(40)+1);
            person.setSalary(person.getAge()*1623500/3);
            persons.put(id, person);
        }
    }
    @GET
    @Path("/getPersonByIdXML/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public Person getPersonByIdXML(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getAllPersonsInXML")
    @Produces(MediaType.APPLICATION_XML)
    public List<Person> getAllPersonsInXML(){
        return new ArrayList<Person>(persons.values());
    }
    
    @GET
    @Path("/getPersonByIdJson/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonByIdJson(@PathParam("id") int id){
        return persons.get(id);
    }
    
    @GET
    @Path("/getAllPersonsInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAllPersonsInJson(){
        return new ArrayList<Person>(persons.values());
    }
    
    @POST
    @Path("/addPersonInJson")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Person addPersonInJson(Person person){
        System.out.println("Se esta agregando persona con id : " + person.getId());
        persons.put(new Integer(person.getId()), person);
        return person;
    }
    
    @GET
    @Path("/getAverageSalaryInXML")
    @Produces(MediaType.APPLICATION_XML)
    public String getAverageSalaryInXML(){
        double promedio = 0.0;
        ArrayList<Person> lista = new ArrayList<Person>(persons.values());
        int count = 0;
        for(Person p: lista){
            count++;
            promedio += p.getSalary()/count;
        }
        //return "El salario promedio de las personas es: $" + promedio;
        
        return "<?xml version=\"1.0\" encoding=\"UTF-8\"?><response>El salario promedio de las personas es: $" + promedio + "</response>";
    }
    
    @GET
    @Path("/getAcumulateSalariesInJson")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAcumulateSalariesInJson(){
        ArrayList<Person> lista = new ArrayList<Person>(persons.values());
        double suma = 0.0;
        for(Person p: lista){
            suma += p.getSalary();
        }
        return "La suma salarial de las personas es: $" + suma;
    }
    
    
    
    
}
