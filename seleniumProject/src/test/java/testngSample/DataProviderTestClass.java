package testngSample;

import org.testng.annotations.Test;

public class DataProviderTestClass {
  @Test(dataProvider="dp1",dataProviderClass=DataProviderClass.class)
  public void sumOfIntegers(Integer n, Integer s) {
	  System.out.println( n+s);
  }
  
  @Test(dataProvider = "dp1",dataProviderClass=DataProviderClass.class)
  public void subtract(Integer n, Integer s) {
	  System.out.println( n-s);
  }
  
  @Test(dataProvider = "dp2",dataProviderClass=DataProviderClass.class)
  public void multiplicatio(Integer n, Integer s) {
	  System.out.println(n*s);
  }
}
