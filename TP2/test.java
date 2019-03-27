
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
    // instance variables - replace the example below with your own
    private int x;
    
    /**
     * Constructor for objects of class test
     */
    public test()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static void main()
    {
        // put your code here
        int result = 0;
        for (int i = 0; i < 5; i++) {
            if (i == 3) { 
                result += 10;
            } else {
                result += i;
            }   
        }
        System.out.println(result);
    }
}
