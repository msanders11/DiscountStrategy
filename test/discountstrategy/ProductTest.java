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
public class ProductTest {

    private Product product;

    public ProductTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        DiscountStrategy discount = new PercentageDiscount(.05);
        product = new Product("A101", "Shirt", 10.0, discount);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setName method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldNotBeNull() {
        product.setName(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetNameShouldNotBeEmpty() {
        product.setName("");
    }

    @Test
    public void testSetName() {
        String goodValues[] = {"Shirt", "Shoe", "Hat", "Mens Socks"};
        for (String goodValue : goodValues) {
            try {
                product.setName(goodValue);
            }catch (IllegalArgumentException iae) {
                fail("good values not allowed");
            }
        }
    }

    /**
     * Test of setProductId method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetProductIdShouldNotBeNull() {
        product.setProductId(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProductIdShouldNotBeEmpty() {
        product.setProductId("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetProductIdShouldNotHaveALengthLongerThan4() {
        product.setProductId("A1011");
    }

    /**
     * Test of ProductId using correct 4 character IDS
     */
    @Test
    public void testProductIdForCorrectValues() {
        String goodValues[] = {"A101", "1111", "ABCD", "A1B2"};
        for (String goodValue : goodValues) {
            try {
                product.setProductId(goodValue);
            }catch(IllegalArgumentException iae){
                fail("good values not allowed");
            }
        }
    }

    /**
     * Test of setRetailPrice method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetRetailPriceShouldNotEqual0() {
        product.setRetailPrice(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetRetailPriceShouldNotBeLessThan0() {
        product.setRetailPrice(-1.0);
    }
    
    /**
     * 
     */
    @Test
    public void testRetailPriceWithGoodValues(){
        Double goodValues[] = {0.50, 1.0, 50.0, 100.0, 999.99};
        for (Double goodValue : goodValues) {
            try {
                product.setRetailPrice(goodValue);
            }catch(IllegalArgumentException iae){
                fail("good values not allowed");
            }
        }
    }
    /**
     * Test of setDiscountStrategy method, of class Product.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testSetDiscountStrategyShouldNotBeNull() {
        product.setDiscountStrategy(null);
    }
}
