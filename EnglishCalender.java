import java.util.*;
public class EnglishCalender 
{
    public static void main(String a[])
    {
        Scanner sc=new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("HI ENTER MONTH AND YEAR YOU WANT CALENDER FOR");
			System.out.println("1.Enter month & year \n2.exit");
			System.out.println("ENTER YOUR CHOICE");
			choice =sc.nextInt();
			switch(choice)
			{
				case 1:
				{
					Scanner s= new Scanner(System.in);
					System.out.print("Enter the year : ");//for entering year
					int year = s.nextInt();
					System.out.print("Enter month : ");// for entering month
					int Month= s.nextInt();
					int day = 1;
					int mon = 1;
					int yr = 1;
					int dy = 1;
					String days[] = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };
					String month[] = { "JANUARY", "FEBRUARY", "MARCH",
								"APRIL",   "MAY",      "JUNE",
								"JULY",    "AUGUST",   "SEPTEMBER",
								"OCTOBER", "NOVEMBER", "DECEMBER" };
					int ar[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
					while (true) 
					{  
						if (day == 1 && mon == Month && yr == year) 
						{
							break;
						}
						if (yr % 4 == 0 && yr % 100 != 0|| yr % 400 == 0) //To check leap year
						{
							ar[1] = 29;
						}
						else
						{
							ar[1] = 28;
						}
						dy++;// for every month starts with different day of week
						day++;// for days of month to b entered in sequence
						if (day > ar[mon - 1]) 
						{
							mon++;
							day = 1;
						}
						if (mon > 12) 
						{
							mon = 1;
							yr++;
						}
						if (dy == 7) 
						{
							dy = 0;
						}
					}
					int c = dy;
					if (yr % 4 == 0 && yr % 100 != 0 || yr % 400 == 0) 
					{
						ar[1] = 29;
					}
					else 
					{
						ar[1] = 28;
					}
					System.out.println();
					System.out.println();
					System.out.println("MONTH--->" + month[Month - 1]+","+year);
					System.out.println();
					for (int k = 0; k < 7; k++) //printing days according to week.
					{
						System.out.print("   " + days[k]);
					}
					System.out.println();
					for (int i = 1; i <= (ar[Month - 1] + dy); i++)
					{
						if (i > 6) 
						{
							dy = dy % 6;
						}
					}
					int sp= dy;
					if (sp < 0)
					{
						sp = 6;
					}
					for (int j = 0; j < sp; j++)// for giving space between 2 days.
					{
						System.out.print("      ");
					}
					for (int k= 1; k <= ar[Month - 1]; k++) //for dividng into weeks
					{
						System.out.printf(" %4d ", k);
						if (((k + sp) % 7 == 0)|| (k == ar[Month - 1]))
						{
							System.out.println();
						}
					}
				}
				break;
				case 2:
				{
					System.out.println("Exiting Program");
				}
				break;
				default:
				{
					System.out.println("enter valid choice");
				}
				break;
			}
		}
		while(choice!=2);
    }
}