public class Calculator {

    public int add(int a, int b)
    {
        return a + b;
    }

    public int subtraction(int a, int b)
    {
        return a - b;
    }

    public double multiplication(double a, double b)
    {
        return a * b;
    }

    public double division(double a, double b)
    {
        return a / b;
    }

    public boolean isEven(int a)
    {
        if(a%2 == 0)
        return true;
        else
            return false;
    }
}
