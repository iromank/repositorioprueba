/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author BACA VARGAS
 */
public class ventaTest {
    
    public ventaTest() {
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
     * Test of conectarJDBC method, of class venta.
     */
    @Test
    public void testConectarJDBC() {
        System.out.println("conectarJDBC");
        venta instance = new venta();
        instance.conectarJDBC();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of limpiar method, of class venta.
     */
    @Test
    public void testLimpiar() {
        System.out.println("limpiar");
        venta instance = new venta();
        instance.limpiar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registrar method, of class venta.
     */
    @Test
    public void testRegistrar() {
        System.out.println("registrar");
        venta instance = new venta();
        instance.registrar();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class venta.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        venta.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
