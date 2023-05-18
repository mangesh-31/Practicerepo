public class Assignment_DataTypes {
    public static void main(String[] args) {
        //Assignment 1.1 - Age Comparator
        String name = "";
        name = "";
        int currentYear = 0, birthYear = 0, age = 0;

        name = "Mangesh";
        currentYear = 2023;
        birthYear = 1995;

        age = currentYear - birthYear;
        String message = (age > 18) ? ", your age is greater than 18!" : " your age is less than 18!" ;
        System.out.println("Hello " + name + message);

        //Assignment 1.2 - Age calculator
        System.out.println("Hi " + name + ", your age is " + (currentYear-birthYear) + " years.");
    }
}
