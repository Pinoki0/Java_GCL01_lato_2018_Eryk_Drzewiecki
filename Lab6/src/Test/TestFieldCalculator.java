package Test;



import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Calculator.FieldCalculator;



public class TestFieldCalculator {

	private FieldCalculator fieldCalculator;
	
	@BeforeEach
    public void createObject()
    {
		fieldCalculator= new FieldCalculator();
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
    public void testSquare1()
    {
    	assertEquals(16.0,fieldCalculator.calculateSquare(4));
    	System.out.println("test");
    }
    @Test
    public void testSquare2()
    {
    	assertNotEquals(15.0,fieldCalculator.calculateSquare(4));
    	System.out.println("test");
    }
    @Test
    public void testSquare3()
    {
    	assertTrue(16.0==fieldCalculator.calculateSquare(4));
    	System.out.println("test");
    }
    @Test
    public void testCircle1()
    {
    	assertEquals(Math.PI*2*2,fieldCalculator.calculateCircle(2));
    	System.out.println("test1");
    }
    @Test
    public void testCircle2()
    {
    	assertFalse(Math.PI*2*2*2==fieldCalculator.calculateCircle(2));
    	System.out.println("test1");
    }
    @Test
    public void testCircle3()
    {
    	assertNotEquals(Math.PI*2*2*2,fieldCalculator.calculateCircle(2));
    	System.out.println("test1");
    }

    @Test
    public void testTriangle1()
    {
    	assertEquals(4.0,fieldCalculator.calculateTriangle(2,4));
    	System.out.println("test2");
    }
    @Test
    public void testTriangle2()
    {
    	assertNotEquals(3.0,fieldCalculator.calculateTriangle(2,4));
    	System.out.println("test2");
    }
    @Test
    public void testTriangle3()
    {
    	assertTrue(4.0==fieldCalculator.calculateTriangle(2,4));
    	System.out.println("test2");
    }

    @Test
    public void testRectangle1()
    {
    	assertEquals(8.0,fieldCalculator.calculateRectangle(2,4));
    	System.out.println("test3");
    }
    @Test
    public void testRectangle2()
    {
    	assertNotEquals(7.0,fieldCalculator.calculateRectangle(2,4));
    	System.out.println("test3");
    }
    @Test
    public void testRectangle3()
    {
    	assertFalse(8.0!=fieldCalculator.calculateRectangle(2,4));
    	System.out.println("test3");
    }
  /* @Test(expected=IllegalArgumentException.class)
    public void aaaaa()
    {
    	
    }*/
    
   

}
