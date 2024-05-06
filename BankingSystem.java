import java.util.*;
class Bankdetails
{
	Scanner s=new Scanner (System.in);
	String accno;
	String name;
	String acc_type;
	long balance;
	Bankdetails()
	{
		System.out.println("enter Account number");
		accno=s.nextLine();
		System.out.println("enter name");
		name=s.nextLine();
		System.out.println("enter acc_type saving or current");
		acc_type=s.nextLine();
		System.out.println("enter Balance");
		balance=s.nextLong();
	}
	public void showaccount()
	{
		System.out.println("Account number="+accno);
		System.out.println("Name="+name);
		System.out.println("Account type="+acc_type);
		System.out.println("Balance="+balance);
	}
	public void deposit()
	{
		long amt;
		System.out.println("enter amount you want to deposit");
		amt=s.nextLong();
		balance=balance+amt;
	}
	public void withdrawal()
	{
		long amt;
		System.out.println("enter amount you want to withdraw");
		amt=s.nextLong();
		if(balance>=amt)
		{
			balance=balance-amt;
		}
		else
		{
			System.out.println("insufficient balance");
		}
	}
	public boolean search(String ac_no)
	{
		if(accno.equals(ac_no))
		{
			showaccount();
			return true;
		}
		else
		{
			return false;
		}
	}
}
class BankingSystem
{
	public static void main(String args[])
	{
		Scanner s=new Scanner (System.in);
		System.out.println("enter number of account you want to open");
		int n=s.nextInt();
		Bankdetails a[]=new Bankdetails[n];
		for(int i=0;i<a.length;i++)
		{
			System.out.println("enter customer details"+(i+1)+":");
			a[i]=new Bankdetails();
		}
		int choice;
		do
		{
			System.out.println("Hi");
			System.out.println("Welcomr to Banking System");
			System.out.println("1.Display all account details \n 2.Search by account number \n 3.Deposit amount \n 4.Withdraw amount \n 5.exit");
			System.out.println("enter your choice");
			choice=s.nextInt();
			switch(choice)
			{
				case 1:
				{
					for(int i=0;i<a.length;i++)
					{
						a[i].showaccount();
					}
				}
				break;
				case 2:
				{
					System.out.println("enter acccount number you want to search");
					String ac_no=s.next();
					boolean found=false;
					for(int i=0;i<a.length;i++)
					{
						found=a[i].search(ac_no);
						if(found)
						{
							break;
						}
					}
					if(!found)
					{
						System.out.println("Account not found!,Please Try Again!!!");
					}
				}
				break;
				case 3:
				{
					System.out.println("enter acccount number you want to search");
					String ac_no=s.next();
					boolean found=false;
					for(int i=0;i<a.length;i++)
					{
						found=a[i].search(ac_no);
						if(found)
						{
							a[i].deposit();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Account not found!,Please Try Again!!!");
					}
				}
				break;
				case 4:
				{
					System.out.println("enter acccount number you want to search");
					String ac_no=s.next();
					boolean found=false;
					for(int i=0;i<a.length;i++)
					{
						found=a[i].search(ac_no);
						if(found)
						{
							a[i].withdrawal();
							break;
						}
					}
					if(!found)
					{
						System.out.println("Account not found!,Please Try Again!!!");
					}
				}
				break;
				case 5:
				{
					System.out.println("Exiting Program");
				}
				break;
			}
		}
		while(choice!=5);
	}
}