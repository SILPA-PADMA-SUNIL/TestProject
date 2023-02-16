package testngSample;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
  @Test(dataProvider = "dp1")
  public void sumOfIntegers(Integer n, Integer s) {
	  System.out.println( n+s);
  }
  
  @Test(priority=1,dataProvider = "dp1")
  public void subtract(Integer n, Integer s) {
	  System.out.println( n-s);
  }
  
  @Test(dataProvider = "dp2")
  public void multiplicatio(Integer n, Integer s) {
	  System.out.println(n*s);
  }

  @DataProvider(name="dp1")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { 10, 5 },
      new Object[] { 12, 4 },
    };
  }
  @DataProvider(name="dp2")
  public Object[][] dp2() {
    return new Object[][] {
      new Object[] { 5, 5 }
      
    };
  }
}
