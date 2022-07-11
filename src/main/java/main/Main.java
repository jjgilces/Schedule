/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import modelo.Day;
import modelo.Employee;

/**
 *
 * @author johanjairgilcesreyes
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Date fecha = new Date();
        ArrayList<Employee> employees= new ArrayList<>();
        try ( BufferedReader lector = new BufferedReader(new FileReader("src/main/java/main/data.txt"))) {

            String a;

            while ((a = lector.readLine()) != null) {
                String[] info = a.split("=");
                String nombre= info[0];
                Employee e = new Employee(nombre);
                try{
                    for(String date: info[1].split(",")){
                    String day= date.substring(0, 2); 
                    String[] hours= date.substring(2).split("-"); 
                    Day dayE= Day.valueOf(day);
                    int start = Integer.parseInt(hours[0].strip().split(":")[0]);
                    int end = Integer.parseInt(hours[1].strip().split(":")[0]);

                    //validar que la hora sea la correcta 
                    
                    e.addDay(dayE, start, end);
                   
                }
                employees.add(e);
                         
                }catch (IllegalArgumentException ex){
                    System.err.println("No es un dia valido:"+ex);
                }

            }
            matchSchedule(employees);

        } catch (FileNotFoundException e) {

            System.err.println("Archivo no encontrado " + e);

        } catch (IOException e) {

            System.err.println("Error de entrada/salida" + e);

        }
        System.out.println(employees);
    }
    public static void matchSchedule(List<Employee> empleados){
      for(int i=0; i<empleados.size(); i++){
       for(int j=1; j<empleados.size(); j++){
           Employee e1= empleados.get(i);
           Employee e2= empleados.get(j);
           e1.match(e2);
       }
        
      }
    }
}
