package Test;
/*
 * assertTrue sprawdza czy przekazany argument to true,
assertFalse sprawdza czy przekazany argument to false,
assertNull sprawdza czy przekazany argument to null,
assertNotNull sprawdza czy przekazany argument nie jest nullem,
assertEquals przyjmuje dwa parametry wartoœæ oczekiwan¹ i wartoœæ rzeczywist¹, jeœli s¹ ró¿ne rzuca wyj¹tek,
assertNotEquals przyjmuje dwa parametry wartoœæ oczekiwan¹ i wartoœæ rzeczywist¹, rzuci wyj¹tek jeœli s¹ równe.*/
 



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import Calculator.BasicCalculator;

public class TestBasicCalculator {

	private BasicCalculator basicCalculator;
	
	@BeforeEach
    public void createObject()
    {
		basicCalculator= new BasicCalculator();
		System.out.println("Before");
		

    }
 
    @AfterEach
   public void cleanUp()
   {
    	System.out.println("After");
   }
 
   @BeforeAll
   public static void setUpClass()
   {
    	System.out.println("BeforeClass");
   }
 
    @AfterAll
    public static void cleanUpClass()
    {
    	System.out.println("AfterClass");
    }
    
  
   
    @Test
    public void testSum1()
    {
    	
    	assertEquals(25.0,basicCalculator.calculateSum(5,20));
    	System.out.println("test");
    }
    @Test
    public void testSum2()
    {
    	
    	assertNotNull(basicCalculator.calculateSum(5,20));
    	System.out.println("test");
    }
    @Test
    public void testSum3()
    {
    	
    	assertNotEquals(20.0,basicCalculator.calculateSum(5,20));
    	System.out.println("test");
    }
   
    @Test
    public void testDifference1()
    {
    	
    	assertEquals(-15.0,basicCalculator.calculateDifference(5,20));
    	System.out.println("test1");
    }
    @Test
    public void testDifference2()
    {
    	
    	assertTrue(-18.0<basicCalculator.calculateDifference(5,20));
    	System.out.println("test1");
    }
    @Test
    public void testDifference3()
    {
    	
    	assertNotEquals(-4.0,basicCalculator.calculateDifference(5,20));
    	System.out.println("test1");
    }
    @Test
    public void testMultiplication1()
    {
    	
    	assertEquals(100.0,basicCalculator.calculateMultiplication(5,20));
    	System.out.println("test2");
    }
    @Test
    public void testMultiplication2()
    {
    	
    	assertFalse(-15.0<basicCalculator.calculateDifference(5,20));
    	System.out.println("test2");
    }
    @Test
    public void testMultiplication3()
    {
    	
    	assertNotEquals(70.0,basicCalculator.calculateMultiplication(5,20));
    	System.out.println("test2");
    }
    @Test
    public void testDivision1()
    {
    	
    	assertEquals(4.0,basicCalculator.calculateDivision(20,5));
    	System.out.println("test3");
    }
    @Test
    public void testDivision2()
    {
    	
    	assertFalse(5.0<basicCalculator.calculateDivision(20,5));
    	System.out.println("test3");
    }
    @Test
    public void testDivision3()
    {
    	
    	assertTrue(4.0==basicCalculator.calculateDivision(20,5));
    	System.out.println("test3");
    }
    @Test
    public void testPow1()
    {
    	
    	assertEquals(8.0,basicCalculator.calculatePow(2,3));
    	System.out.println("test4");
    }
    @Test
    public void testPow2()
    {
    	
    	assertTrue(8.0==basicCalculator.calculatePow(2,3));
    	System.out.println("test4");
    }
    @Test
    public void testPow3()
    {
    	
    	assertNotEquals(7.0,basicCalculator.calculatePow(2,3));
    	System.out.println("test4");
    }
    @Test
    public void testSqrt1()
    {
    	
    	assertEquals(2.0,basicCalculator.calculateSqrt(4));
    	System.out.println("test5");
    }
    @Test
    public void testSqrt2()
    {
    	
    	assertNotEquals(3.0,basicCalculator.calculateSqrt(4));
    	System.out.println("test5");
    }
    @Test
    public void testSqrt3()
    {
    	
    	assertFalse(4.0==basicCalculator.calculateSqrt(4));
    	System.out.println("test5");
    }
    @Test
    void exceptionTesting() {
       /* Throwable exception = assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("a message");
        });*/
        //assertEquals("a message", exception.getMessage());
        
        assertThrows(IllegalArgumentException.class, 
        		()->{
        			basicCalculator.calculateSqrt(-2);
        		});
        
    }

    
    

}