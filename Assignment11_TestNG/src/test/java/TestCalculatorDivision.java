import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestCalculatorDivision {

    @Test(priority = 1, groups = "positive", dataProvider = "divisionDataFromCSV")
    public void testDivideTwoNumbers(double a, double b, double expectedResult)
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.division(a, b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] divisionDataFromCSV() throws IOException, CsvValidationException {
        String csvFilePath = "src/test/resources/divisionTestData.csv";
        CSVReader reader = new CSVReader( new FileReader(csvFilePath));
        String[] line;
        int row = 0;
        Object[][] data = new Object[4][3];
        while((line=reader.readNext())!=null)
        {
            if(row==0){
                row++;
                continue;
            }
            data[row - 1][0] = Double.parseDouble(line[0]);
            data[row - 1][1] = Double.parseDouble(line[1]);
            data[row - 1][2] = Double.parseDouble(line[2]);
            row++;
        }
        reader.close();
        return data;
    }

    @Test(priority = 1, groups = "negative", dataProvider = "divisionDataProvider")
    public void testDivideInt(double a, double b, double expectedResult)
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.division(a,b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] divisionDataProvider()
    {
        return new Object[][]{
                {10,3,3.3333333333333335},
                {-4,4,-1},
                {-55,-5,11},
                {5,0,0}
        };
    }

    @Test(priority = 1, groups = "positive")
    public void testDivideTwoInt()
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.division(12,2);
        Assert.assertEquals(actualResult,6, "Actual result is " + actualResult + " and expected is " + 10);
    }

    @Test(priority = 2, groups = "negative")
    public void testDivideZero()
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.division(4,0);
        Assert.assertEquals(actualResult,"Infinity", "Actual result is " + actualResult + " and expected is " + "Infinity");
    }


}
