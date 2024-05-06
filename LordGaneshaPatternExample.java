public class LordGaneshaPatternExample  
{  
    // main() method start  
    public static void main(String[] args)   
    {  
        // for printing the crown of Ganesha  
          
        // it is for printing 1st half of the crown  
        for(int i = 1; i <= 3; i++)  
        {  
            for(int k = 1; k <= 11-i+1; k++)  
            {  
                System.out.print(" ");  // printing space  
            }  
            for(int j = 1; j <= ((i*i)+2-i)/2; j++)  
            {  
                System.out.print("*");  // printing star  
            }  
            System.out.println();  
        }  
        // it is for printing 2nd half of the crown  
        for(int i = 1; i <= 3; i++)  
        {  
            for(int k = 1; k <= 2*(4-i+1); k++)  
            {  
                System.out.print(" ");  
            }  
            for(int j = 1; j <= 2+(4*i); j++)  
            {  
                System.out.print("*");  
            }  
            System.out.println();  
        }  
        System.out.println();  
          
        // for loop for designing Ganesh's trunk  
        for(int i = 1; i <= 2; i++)  
        {  
            for(int j = 1; j <= 2-i+1; j++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int k = 1; k <= i*(i*i)-(i*i); k++)  
            {  
                System.out.print(" ");  
            }  
            for(int l = 1; l <= 2*(2-i+1)-1; l++)  
            {  
                System.out.print("*");  
            }  
            for(int u = 1; u <= 2*(5-i+1); u++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int v = 1; v <= i*(i*i)-(i*i); v++)  
            {  
                System.out.print(" ");  
            }  
            for(int w = 1; w <= 2*(2-i+1)-1; w++)  
            {  
                System.out.print("*");  
            }  
            System.out.println();  
        }  
    
        for(int a = 1; a <= 3; a++)  
        {  
            for(int b = 1; b <= a; b++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int v = 1; v <= (11-a+1)/2; v++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int w = 1; w <= 5-a+1; w++)  
            {  
                System.out.print(" ");  
            }  
            for(int x = 1; x <= 1-a+1; x++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int y = 1; y <= 5; y++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            System.out.println();  
        }  
    
        for(int i = 1; i <= 4; i++)  
        {  
            for(int j = 1; j <= 8; j++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int k = 1; k <= 3; k++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            System.out.println();  
        }  
    
        for(int u = 1; u <= 4; u++)  
        {  
            for(int v = 1; v <= 8+u; v++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int w = 1; w <= (7-u+1)/2; w++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            System.out.println();  
        }  
  
        for(int u = 1; u <= 2; u++)  
        {  
            for(int v = 1; v <= 12; v++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int w = 1; w <= 2-u+1; w++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            System.out.println();  
        }  
          
        for(int u = 1; u <= 5; u++)  
        {  
            for(int v = 1; v <= 11-u+1; v++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int w = 1; w <= 1; w++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            System.out.println();  
        }  
    
        for(int u = 1; u <= 4; u++)  
        {  
            for(int v = 1; v <= 6+u; v++)  
            {  
                System.out.print(" ");  
            }  
            System.out.print("*");  
            for(int w = 1; w <= (3-u+1)/2; w++)  
            {  
                System.out.print(" ");  
                System.out.print("*");  
            }  
            System.out.println();  
        }  
  
        System.out.println();  
          
        for(int u = 1; u <= 2; u++)  
        {  
            for(int v = 1; v <= 4+(u*2); v++)  
            {  
                System.out.print(" ");  
            }      
            for(int w = 1; w <= 4*(2-u+1)+1; w++)  
            {  
                System.out.print("*");  
            }  
            System.out.println();  
        }  
    
        for(int u = 1; u <= 1; u++)  
        {  
            for(int v = 1; v <= 10; v++)  
            {  
                System.out.print(" ");              
            }  
            System.out.print("*");  
        }  
    }  
}  
