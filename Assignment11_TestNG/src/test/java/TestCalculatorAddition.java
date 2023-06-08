import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileReader;
import java.io.IOException;

public class TestCalculatorAddition {

    @Test(priority = 1, groups = "positive", dataProvider = "additionDataFromCSV")
    public void testAddTwoInt(int a, int b, int expectedResult)
    {
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(a, b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] additionDataFromCSV() throws IOException, CsvValidationException {
        String csvFilePath = "src/test/resources/additionTestData.csv";
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

    @Test(priority = 1, groups = "negative", dataProvider = "additionDataProvider")
    public void testNegativeAddTwoInt(int a, int b, int expectedResult)
    {
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(a,b);
        Assert.assertEquals(actualResult,expectedResult);
    }

    @DataProvider
    public Object[][] additionDataProvider()
    {
        return new Object[][]{
                {-10,3,-7},
                {0,0,0},
                {2147483647,1,2147483647},
                {2147483647,-2147483647,0}
        };
    }

    @Test(priority = 2, groups = "negative")
    public void testAddOneCharacter()
    {
        Calculator calculator = new Calculator();
        int actualResult = calculator.add(-4,'m');
        Assert.assertEquals(actualResult,105, "Actual result is " + actualResult + " and expected is " + 105);
    }
}
