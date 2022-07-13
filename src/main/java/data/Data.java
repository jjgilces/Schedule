/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import exceptions.InvalidHour;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import modelo.Day;
import modelo.Employee;

/**
 *
 * @author johanjairgilcesreyes
 */
public abstract class Data {
    
    
     public static String matchSchedule(List<Employee> empleados,String name) {

        try ( BufferedWriter w = new BufferedWriter(new FileWriter("src/output/result_"+name))) {
            for (int i = 0; i < empleados.size(); i++) {
            for (int j = 1 + i; j < empleados.size(); j++) {
                Employee e1 = empleados.get(i);
                Employee e2 = empleados.get(j);
                int n = e1.match(e2);
                if (n > 0) {
                    w.write(e1.getName() + "-" + e2.getName() + " " + n);
                    w.write("\n");
                }

            }

        }
           return "The file is in src/output/result_"+name;
        } catch (IOException ex) {
            return "File not created: "+ex;
        }
        
    }

    public static ArrayList<Employee> cargarData(String path) {
        ArrayList<Employee> employees = new ArrayList<>();
        try ( BufferedReader lector = new BufferedReader(new FileReader(path))) {
            String a;
            while ((a = lector.readLine()) != null) {
                String[] info = a.split("=");
                String nombre = info[0];
                Employee e = new Employee(nombre);
                try {
                    for (String date : info[1].split(",")) {
                        String day = date.substring(0, 2);
                        String[] hours = date.substring(2).split("-");
                        Day dayE = Day.valueOf(day);
                        int start = Integer.parseInt(hours[0].strip().split(":")[0]);
                        int end = Integer.parseInt(hours[1].strip().split(":")[0]);

                        //validar que la hora sea la correcta 
                        if(end<start) throw new InvalidHour("The hours are incorrect");
                        e.addDay(dayE, start, end);

                    }
                    employees.add(e);

                } catch (IllegalArgumentException ex) {
                    System.err.println("Argument not valid:" + ex);
                }

            }

        } catch (FileNotFoundException e) {

            System.err.println("File not found " + e);

        } catch (IOException e) {

            System.err.println("Error of I/O" + e);

        }
        return employees;
    }
}
