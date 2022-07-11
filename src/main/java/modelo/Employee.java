/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author johanjairgilcesreyes
 */
public class Employee {
    String name;
    HashMap<Day,Hours> schedule;
    
    public Employee(String n){
       name=n;
       schedule= new HashMap<>();
    }
    
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

    public int match(Employee o){
        Set<Day> sameDays=o.schedule.keySet();
        System.out.println(sameDays);
        sameDays.retainAll(this.schedule.keySet());
                System.out.println(sameDays);

      return 1;
    }
    @Override
    public String toString() {
        return  name + schedule ;
    }
    
}
