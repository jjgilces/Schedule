/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package modelo;

import java.util.HashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johanjairgilcesreyes
 */
public class EmployeeTest {
    
    public EmployeeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addDay method, of class Employee.
     */
    @Test
    public void testAddDay() {
        System.out.println("addDay");
        Day d = null;
        int s = 0;
        int e = 0;
        Employee instance = null;
        instance.addDay(d, s, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Employee.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Employee instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSchedule method, of class Employee.
     */
    @Test
    public void testGetSchedule() {
        System.out.println("getSchedule");
        Employee instance = null;
        HashMap<Day, Hours> expResult = null;
        HashMap<Day, Hours> result = instance.getSchedule();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of match method, of class Employee.
     */
    @Test
    public void testMatch() {
        System.out.println("match");
        Employee o = null;
        Employee instance = null;
        int expResult = 0;
        int result = instance.match(o);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
    
}
