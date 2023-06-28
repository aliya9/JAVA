public class Investment 
{
    public static void main(String args[])
    {
    double int_bal = 25000;
    double int_rate = 0.04;

    for( int i= 1; i <+ 10; i++)
    {
        double interest = int_bal * int_rate;
            // interest = 25000 * 0.04
            //          = 1000
        int_bal = interest + int_bal;

        
        System.out.println("Balance after " + i + " year: " + interest);

    }
}
}
