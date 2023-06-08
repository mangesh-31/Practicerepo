import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestIsEven {

    @Test(priority = 1, groups = "positive", dataProvider = "isEvenDataProvider")
    public void testIsEven(int a, boolean expectedResult)
    {
        Calculator calculator = new Calculator();
        boolean actualResult = calculator.isEven(a);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] isEvenDataProvider()
    {
        return new Object[][]{
                {-10,true},
                {0,true},
                {-11,false},
                {22,true}
        };
    }

}
