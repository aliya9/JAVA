

public class RabbitsX 


{
    public static void main(String args[])
    {
        int n1= 0, n2=1 ,n3,i;   
        
        
        //System.out.println()
            for( int j= 1; j<2; j++ )
            {
                System.out.println(n1 + " pairs give birth to " + n1*n1 + " pairs.");
                j++;
            }
            
            {

                //System.out.println(n1 + "pairs" + n1*n1);
                n3 = n1 + n2;
                System.out.println(n3 + " pairs gave birth to " + n3*2 + " pairs.");
                n1 = n2;
                n2 = n3;
                if (n1 == 2 && n2 == 3)
                {
                    for(i=1;i<8;i++)//loop starts from 2 because 0 and 1 are already printed    
                    {    
                        n3=n1 + n2 + n1 ;  
                        System.out.print(n3 + " pairs gave birth to " + n3*2 + " pairs.\n");    
                        n1=n2;    
                        n2=n3;
                    }
                }
            
            
        
          
            }
            
            

    }
}

        
    
