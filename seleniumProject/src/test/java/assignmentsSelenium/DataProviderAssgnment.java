package assignmentsSelenium;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderAssgnment {
  

  @DataProvider(name="successfulLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "carol", "1q2w3e4r" },
    
    };
  }
  
  @DataProvider(name="unSuccessfulLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "carol", "123456" },
      new Object[] { "asdfgh", "1q2w3e4r" },
      new Object[] { "asdfgh", "123456" },
    };
  }
}
