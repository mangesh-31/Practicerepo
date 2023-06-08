import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestCalculatorSubtraction {

    @Test(priority = 1, groups = "positive", dataProvider = "subtractionDataFromCSV")
    public void testSubtractTwoIntegers(int a, int b, int expectedResult)
    {
        Calculator calculator = new Calculator();
        double actualResult = calculator.subtraction(a, b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] subtractionDataFromCSV() throws IOException, CsvValidationException {
        String csvFilePath = "src/test/resources/subtractionTestData.csv";
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
            data[row - 1][0] = Integer.parseInt(line[0]);
            data[row - 1][1] = Integer.parseInt(line[1]);
            data[row - 1][2] = Integer.parseInt(line[2]);
            row++;
        }
        reader.close();
        return data;
    }

    @Test(priority = 1, groups = "negative", dataProvider = "subtractionDataProvider")
    public void testSubtractTwoInt(int a, int b, int expectedResult)
    {
        Calculator calculator = new Calculator();
        int actualResult = calculator.subtraction(a,b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] subtractionDataProvider()
    {
        return new Object[][]{
                {-10,-3,-7},
                {-4,4,-8},
                {-6,4,-10},
                {5,0,5}
        };
    }

    @Test(priority = 2, groups = "negative")
    public void testSubtractBothNegative()
    {
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(-4,-15);
        Assert.assertEquals(actualResult,-19, "Actual result is " + actualResult + " and expected is " + -19);
    }

}
