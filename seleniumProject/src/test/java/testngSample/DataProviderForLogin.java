package testngSample;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderForLogin {
  

  @DataProvider(name="successfulLogin")
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { "admin", "admin" },
     
    };
  }
  @DataProvider(name="unSuccessfulLogin")
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { "admin45", "admin123" },
      new Object[] { "admin", "admin1" },
      new Object[] { "admin1", "admin" },
     
    };
  }
}
