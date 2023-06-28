
public class Rabbits
{
    public static void main(String args[])
    {
        int n1= 1, n2=1 ,n3,i,j = 4;  
        
        
        for(int k=2; k<=3; k++)
        {
            System.out.println("Month " + k + ": " + n1 + " pair gave birth to " + n1* n1 + " pair.");        
        }
        
            while(j<6)
            {
            
                n3 = n1 + n2;
                System.out.println("Month " + j + ": " +n3 + " pairs gave birth to " + n3*2 + " pairs.");
                n1 = n2;
                n2 = n3;
                if (n1 == 2 && n2 == 3)
                {
                    for(i=6;i<13;i++)//loop starts from 2 because 0 and 1 are already printed    
                    {    
                        n3=n1 + n2 + n1 ;  
                        System.out.print("Month " + i + ": " +n3 + " pairs gave birth to " + n3*2 + " pairs.\n");    
                        n1=n2;    
                        n2=n3;
                    }
                }
               
            j++;
            }
            

    }
}
        
    
