/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repasoexamenjava;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author josel
 */
public class ControladorTest {
    
    public ControladorTest() {
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
     * Test of controlarLogin method, of class Controlador.
     */
    @Test
    public void testControlarLogin() {
        System.out.println("controlarLoginTEST");
        String username = "prueba";
        String password = "1234";
        int expResult = 1;
        int result = Controlador.controlarLogin(username, password);
        assertEquals(expResult, result);
    }
    
}
