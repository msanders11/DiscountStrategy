/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author msanders11
 */
public class PercentageDiscountTest {

    private PercentageDiscount instance;

    public PercentageDiscountTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new PercentageDiscount(0.0);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getDiscount method, of class PercentageDiscount.
     */
    @Test
    public void testGetDiscount() {
        Double retailPrice = 10.0;
        int qty = 1;
        instance = new PercentageDiscount(.05);
        double expResult = 10 * .05;
        double result = instance.getDiscount(retailPrice, qty);
        assertEquals(expResult, result, 0.01);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    /**
     * Test of setDiscountPercent method, of class PercentageDiscount.
     */
    @Test(expected = IllegalArgumentException.class)
    public void SetDiscountPercentShouldThrowIaeIfPercentBelowRange() {
        instance.setDiscountPercent(-1.0);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test(expected = IllegalArgumentException.class)
    public void SetDiscountPercentShouldThrowIaeIfPercentAboveRange() {
        instance.setDiscountPercent(1.1);
        // TODO review the generated test code and remove the default call to fail.
    }

    @Test
    public void SetDiscountPercentShouldAllowPercentFrom0to1() {
        double values[] = {0.1, .5, .99};
        for(int i = 0; i < values.length; i++){
            try{
                instance.setDiscountPercent(values[i]);
            } catch(IllegalArgumentException iae){
                fail("good values not allowed");
            }
        }
        // TODO review the generated test code and remove the default call to fail.
    }
}
