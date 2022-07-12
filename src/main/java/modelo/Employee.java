/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;

/**
 * Core class thats has information about an employee
 * @author johanjairgilcesreyes
 */
public class Employee {
    String name;
    HashMap<Day,Hours> schedule;
    
    public Employee(String n){
       name=n;
       schedule= new HashMap<>();
    }
    
    /**
    * Add day
    * Create an hour and add it with the day.
    * @param d day of the week.
    * @param s start of the shift.
    * @param e end of the shift.
*/
    public void addDay(Day d,int s, int e ){
        Hours h = new Hours(s, e);
        schedule.put(d,h);
    }

    public String getName() {
        return name;
    }

    public HashMap<Day, Hours> getSchedule() {
        return schedule;
    }
    /**
    * Coincidence in schedules
    * Check the schedules to see if there are days when they are together in office.
    * @param o an employee to be compare.
    * @return qué devuelve el método.
    * @exception tipo de excepción que lanza el método y en qué caso
    * @see paquete.Clase#metodo Código al que se hace referencia
    * @throws IllegalArgumentException el param1 no tiene el formato deseado
    */
    public int match(Employee o){
       int n=0;
       for(Day d: this.schedule.keySet()){
           Hours h=schedule.getOrDefault(d, null);
           Hours other= o.schedule.getOrDefault(d, null);
           if(other!= null && h.start < other.end && other.start < h.end){
               n+=1;
           }
           
       }
      return n;
    }
    @Override
    public String toString() {
        return  name + schedule ;
    }
    
}
