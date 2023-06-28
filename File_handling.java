import java.util.*;
import java.io.*;

public class File_handling
{
    public static void main(String[] args) throws IOException
    {
        
        File obj = new File("Quiz.txt");
        //System.out.println("File Created!");
        

        Scanner myFile = new Scanner(obj);

        String name = myFile.nextLine();
        double hours_worked = myFile.nextDouble();
        double pay_rate = myFile.nextDouble();
        double money_total = myFile.nextDouble();
        double bonus_pay = 0.0;

        //System.out.println(hours_worked);
        //System.out.println(pay_rate);
        //System.out.println(money_total);


        if (money_total/hours_worked > 200)
        {
            double bonus_sales = money_total/hours_worked - 200;
            //System.out.println(bonus_sales);
            bonus_pay = (0.1 * bonus_sales) * hours_worked;
            //System.out.println(bonus_pay);

        }

        double payment = hours_worked * pay_rate + bonus_pay;
        System.out.println(name + " must be paid $" + payment +" this week");

        myFile.close();
       

    }
}