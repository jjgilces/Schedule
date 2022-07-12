/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package main;

import data.Data;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import modelo.Employee;

/**
 *
 * @author johanjairgilcesreyes
 */
public class Main {

    public static void main(String[] args) {
        File folder = new File("src/data");
        File[] listOfFiles = folder.listFiles();
        Scanner sc = new Scanner(System.in);
        System.out.println("The files are: ");
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println((i + 1) + ")" + listOfFiles[i].getName());
            }
        }
        System.out.print("\t Input the number of the file:");
        int opc = sc.nextInt() ;
        opc--;
        String path = listOfFiles[opc].getPath();
        String name = listOfFiles[opc].getName();
        ArrayList<Employee> employees = Data.cargarData(path);
        String msg=Data.matchSchedule(employees,name);
        System.out.println(msg);
    }

   
}
