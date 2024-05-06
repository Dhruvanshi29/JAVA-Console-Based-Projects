import java.util.*; 
public class CurrencyConverter {
 
	public static void main(String[] args) {
 
		double amount, D, P, code, E, Y, R, Rs; 
		Scanner sc = new Scanner(System.in); 
		System.out.println("Hi,");
		System.out.println("Welcome to the Currency Converter!");
 		System.out.println("Which currency You want to Convert? ");		
		System.out.println("1:Ruppe \t2:Dollar \t3:Pound  \t4:Euro  \t5:Yen  \t6:Ringgit ");
		code = sc.nextInt();
		System.out.println("How much Money you want to convert ?");
		amount = sc.nextFloat();
		// For amounts Conversion
		if (code == 1) //for rupee conversion
		{
 
			D = amount / 70;
			System.out.println("Your " + amount + " Rupee is : " + D + " Dollar");
 
			P= amount / 88;
			System.out.println("Your " + amount + " Rupee is : " + P + " Pound");
 
			E = amount / 80;
			System.out.println("Your " + amount + " Rupee is : " + E + " Euro");
 
			Y = amount / 0.63;
			System.out.println("Your " + amount + " Rupee is : " + Y+ " Yen");
 
			R = amount / 16;
			System.out.println("Your " + amount + " Rupee is : " +R + " ringgit");
		}
		else if (code == 2)// For Dollar Conversion
		{
			Rs = amount * 70;
			System.out.println("Your " + amount + " Dollar is : " + Rs+ " Ruppes");
 
			P= amount * 0.78;
			System.out.println("Your " + amount + " Dollar is : " + P+ " Pound");
 
			E = amount * 0.87;
			System.out.println("Your " + amount + " Dollar is : " + E+ " Euro");
 
			Y= amount * 111.087;
			System.out.println("Your " + amount + " Dollar is : " + Y+ " Yen");
 
			R= amount * 4.17;
			System.out.println("Your " + amount + " Dollar is : " + R+ " ringgit");
		} 
		else if (code == 3) //for pound conversion
		{
			Rs= amount * 88;
			System.out.println("Your " + amount + " pound is : " + Rs+ " Ruppes");
 
			D= amount * 1.26;
			System.out.println("Your " + amount + " pound is : " + D+ " Dollar");
 
			E= amount * 1.10;
			System.out.println("Your " + amount + " pound is : " + E + " Euro");
 
			Y= amount * 140.93;
			System.out.println("Your " + amount + " pound is : " +Y+ " Yen");
 
			R= amount * 5.29;
			System.out.println("Your " + amount + " pound is : " +R+ " ringgit");
		} 
		else if (code == 4) // For Euro Conversion
		{ 
			Rs= amount * 80;
			System.out.println("Your " + amount + " euro is : " + Rs+ " Ruppes");
 
			D= amount * 1.14;
			System.out.println("Your " + amount + " euro is : " + D + " Dollar");
 
			P= amount * 0.90;
			System.out.println("Your " + amount + " euro is : " + P+ " Pound");
 
			Y= amount * 127.32;
			System.out.println("Your " + amount + " euro is : " + Y + " Yen");
 
			R= amount * 4.78;
			System.out.println("Your " + amount + " euro is : " +R + " ringgit");
		} 
		else if (code == 5) // For Yen Conversion
		{ 
			Rs = amount * 0.63;
			System.out.println("Your " + amount + " yen is : " + Rs + " Ruppes");
 
			D= amount * 0.008;
			System.out.println("Your " + amount + " yen is : " + D + " Dollar");
 
			P = amount * 0.007;
			System.out.println("Your " + amount + " yen is : " + P + " Pound");
 
			E = amount * 0.007;
			System.out.println("Your " + amount + " yen is : " + E + " Euro");
 
			R = amount * 0.037;
			System.out.println("Your " + amount + " yen is : " + R + " ringgit");
		} 
		else if (code == 6) // For Ringgit Conversion
		{
			Rs = amount * 16.8;
			System.out.println("Your " + amount + " ringgit is : " + Rs + " Ruppes");
 
			D = amount * 0.239;
			System.out.println("Your " + amount + " ringgit is : " + D + " dollar");
 
			P= amount * 0.188;
			System.out.println("Your " + amount + " ringgit is : " + P + " pound");
 
			E = amount * 0.209;
			System.out.println("Your " + amount + " ringgit is : " +E + " euro");
 
			Y = amount * 26.63;
			System.out.println("Your " + amount + " ringgit is : " + Y + " yen");
		} 
		else 
		{
			System.out.println("Invalid input");
		}
		
		System.out.println("Thank you");
	}
 
}