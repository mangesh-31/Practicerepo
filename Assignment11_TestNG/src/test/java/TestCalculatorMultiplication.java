import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestCalculatorMultiplication {

    @Test(priority = 1, groups = "positive", dataProvider = "multiplyDataFromCSV")
    public void testMultiplyTwoNumbers(double a, double b, double expectedResult)
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.multiplication(a, b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] multiplyDataFromCSV() throws IOException, CsvValidationException {
        String csvFilePath = "src/test/resources/multiplicationTestData.csv";
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

    @Test(priority = 1, groups = "negative", dataProvider = "multiplicationDataProvider")
    public void testMultiplyInt(int a, int b, double expectedResult)
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.multiplication(a,b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] multiplicationDataProvider()
    {
        return new Object[][]{
                {10,3,30},
                {-4,4,-16},
                {-6,4,-24},
                {5,0,0}
        };
    }

    @Test
    public void testMultiplyWithZero()
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.multiplication(-4,0);
        Assert.assertEquals(actualResult,0, "Actual result is " + actualResult + " and expected is " + 0);
    }


}
