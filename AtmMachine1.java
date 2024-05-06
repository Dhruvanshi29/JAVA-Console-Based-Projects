import java.util.*;
// Outer Class 
class Atm
{
	// Intialized the Data Members 
	double Balance;
	double SavingBalance;
	int accountnumber;
    String atmpin;
	int count=0;
	long Old_Number;
	long New_Number;	
	int choice;
	do
	{
		System.out.println("HI WELCOME , ENTER YOUR CHOICE");
		System.out.println("1.WELCOME TO ATM PLEASE ENTER FURTHUR DETAILS /n2.EXIT");
		System.out.println("enter your choice");
		choice =s.nextInt();
		switch(choice)
		{
			case 1:
			{
				Scanner s= new Scanner (System.in);
				public void acceptdata()
				{
					System.out.println("enter Account number");
					this.accountnumber=s.nextInt();
					boolean flag = false;
					do 
					{
						System.out.print("Enter 4 digit Atm Pin: ");
						this.atmpin = s.next();
						if (this.atmpin.length() == 4) 
						{
							for (int i = 0; i < atmpin.length(); i++) 
							{
								if (atmpin.charAt(i) >= '0' && atmpin.charAt(i) <='9') 
								{
									flag = true;
								}
								else 
								{
									flag = false;
									System.out.println("Invalid atm pin. Please try again.");
									break;
								}
							}
						}
						else 
						{
							System.out.println("Invalid pin. Please try again.");
						}
					}
					while (flag == false);
					System.out.println("enter Balance");
					this.Balance=s.nextDouble();
					System.out.println("enter Saving balance");
					this.SavingBalance=s.nextDouble();
				}			
				public void checkpin()
				{
					System.out.println();
					System.out.println();
					System.out.println("Welcome to ATM Machine !!!");
					System.out.println("Insert A Card ");
					System.out.println("Enter ACCOUNT Number : ");
					System.out.println("Enter ACCOUNT Number Pin : ");
					while(count<3)
					{
					count++;
					int AccountNumber=s.nextInt();
					int AtmPin=s.nextInt();
					if((accountnumber==AccountNumber)&&(AtmPin==atmpin))
					{
						System.out.println();
						System.out.println("      [ WELCOME USER ] ");
						System.out.println();
						option();
					}
					else 
					{
						 System.out.println("Incorrect Atm Number or pin");
						 System.out.println("Please Try Again");
						 
					}
					}
					if(count==3)
					{
						System.out.println("YOUR ACCOUNT IS BLOCK FOR 24 HRS PLEASE TRY AGAIN LATER");
						 System.exit(0);
					}	
				}
				//Method Name Option to select Task 
				public void option()
				{	
					Scanner sc=new Scanner(System.in);
					System.out.println("Select The Choice You Want to Perform: ");
					System.out.println();
					System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
					System.out.println("* 1.View Available Balance\n* 2.Withdraw Amount\n* 3.Deposit Amount\n* 4.ATM PIN RESET\n* 5.To Change Phone Number\n* 6.EXIT");
					System.out.println("*=*=*=*=*=*=*=*=*=*=*=*=*=*=*");
					int ch=sc.nextInt();
					if(ch==1)
					{
						CheckBalance();
					}
					else  if(ch==2) 
					{
						WithdrawAmount();
					}
					else if(ch==3)
					{
						DepositAmount();
					}
					else if (ch==4)
					{
						AtmPinReset();
					}
						else if (ch==5)
					{
						UpdatePhoneNumber();
					}
					else if (ch==6)
					{
						System.out.println("Collect your ATM Card\n Thank you for using ATM Machine!!");
						System.exit(0);
					}
					else
					{
						System.out.println("Please enter correct choice");
						option();
					}
					
				}
				// Method Name Check Balance to  See Available Balance  
				public void CheckBalance()
				{
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter Account Type To Check The Balance:\n1.Saving Account\n2.Current Account ");
					int opt=sc.nextInt();
					if(opt==1)
					{
						System.out.println("You Have Choosen Saving Accounnt");
						System.out.println("Available Balance is : "+SavingBalance);
						System.out.println();
						option();
						
					}
					if(opt==2)
					{
						System.out.println("You Have Choosen Current Accounnt");
						System.out.println("Available Balance is : "+Balance);
						System.out.println();
						option();
					}
					else
					{
						System.out.println("Select Any One Option");
						CheckBalance();
					}
				  option();
				}
				//Method Name Withdraw Amount For Withdrawing The Amount
				//current
				public void WithdrawAmount()
				{
					Scanner sc = new Scanner(System.in);
					System.out.println("SELECT THE ACCOUNT TYPE FOR WITHDRAWING MONEY \n1.SAVING \n2.CURRENT");
					System.out.println("SELECT YOUR CHOICE");
					int ac= sc.nextInt();
					if(ac==1)
					{
						System.out.println("YOU HAVE SELECTED SAVING ACCOUNT ");
						SavingWithdraw();
					}
					else if(ac==2)
					{
						System.out.println("YOU HAVE SELECTED CURRENT ACCOUNT ");
						CurrentWithdraw();
					}
					else if(ac>2)
					{
						System.out.println("SELECT VALID CHOICE ");
						WithdrawAmount();
					}
				}
				public void CurrentWithdraw()
				{
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter Amount To Withdraw");
					float WithdrawAmount=sc.nextFloat();
					if (WithdrawAmount>Balance) 
					{
						System.out.println("!!INSUFFICIENT BALANCE !!");
					}
					else
					{
						Balance=Balance-WithdrawAmount;
						System.out.println("Amount Withdrawn !!");
						System.out.println("!!COLLECT THE CASH!!");
					}
					option();
				}
				public void SavingWithdraw()
				{
					
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter Amount To Withdraw");
					float Withdrawamount=sc.nextFloat();
					if (Withdrawamount>SavingBalance) 
					{
						System.out.println("!!Insufficient Balance !!");
						System.out.println();
					}
					else
					{
						SavingBalance=SavingBalance-Withdrawamount;
						System.out.println("Amount Withdrawn !!");
						System.out.println("!!COLLECT THE CASH!!");
					}
					option();
				}
				//Method Name DepositAmount to Deopsit the Money 
				//current 
				public void DepositAmount()
				{
					Scanner sc = new Scanner(System.in);
					System.out.println("SELECT THE ACCOUNT \n1.SAVING \n2.CURRENT");
					System.out.println("SELECT YOUR CHOICE");
					int ac= sc.nextInt();
					if(ac==1)
					{
						System.out.println("YOU HAVE SELECTED SAVING ACCOUNT ");
						SavingDeposit();
					}
					else if(ac==2)
					{
						System.out.println("YOU HAVE SELECTED CURRENT ACCOUNT ");
						CurrentDeposit();
					}
					else if(ac>2)
					{
						System.out.println("SELECT VALID CHOICE ");
						DepositAmount();
					}
				}
				public void CurrentDeposit()
				{
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter Amount to Deposit :");
					float DepositAmount=sc.nextFloat();
					Balance=DepositAmount+Balance;
					System.out.println(" Deposited Successfully !!");
					option();
				}
				public void SavingDeposit()
				{
					Scanner sc=new Scanner(System.in);
					System.out.println("Enter Amount to Deposit :");
					float Depositamount=sc.nextFloat();
					SavingBalance=Depositamount+SavingBalance;
					System.out.println(" Deposited Successfully !!");
					option();
				}
				//Method Name AtmPinReset to Reset The Atm Pin
				public void AtmPinReset()
				{
					Scanner sc = new Scanner(System.in);
					System.out.print("Enter your current PIN: ");
					int inputPin = sc.nextInt();
					if(inputPin==atmpin)
					{
					   System.out.print("Enter Your New PIN: ");
						int newPin = sc.nextInt();
						
						System.out.print("Confirm Your New PIN: ");
						int confirmNewPin = sc.nextInt();
						 if (newPin == confirmNewPin) {
							atmpin = newPin;
							System.out.println("Your PIN has been updated successfully.");
						} else {
							System.out.println("The new PIN and confirmation PIN do not match. Please try again.");
						}
					} else {
						System.out.println("Invalid PIN. Please try again.");
						AtmPinReset();
					}
					option();
				}
				 //Method Name UpdatePhoneNumber To Update Phone Number 
				public void UpdatePhoneNumber()
				{
					Scanner sc=new Scanner(System.in);
					 
					System.out.println("Enter Your Old Phone Number");
					String Old_Number  = sc.next();
					char c;
					int  l = Old_Number.length();
					c = Old_Number.charAt(0);
					if(l==10)
					{
						
						if(c=='7' || c=='8'|| c=='9')
						System.out.println(" NUMBER IS VALID ");
					}
					else
					{
						System.out.println( " Not VALID NUMBER ");
						UpdatePhoneNumber();
					}
					System.out.println("Enter Your New Phone Number To Update");
					String New_Number  = sc.next();
					char c2;
					int  l2 = New_Number.length();
					c2 = New_Number.charAt(0);
					if(l2==10)
					{
						
						if(c2=='7' || c2=='8'|| c2=='9')
						System.out.println("NUMBER IS VALID ");
					}
					else
					{
						// 10 number hoy toj update thay nikr pchu faarvu joiye  
						System.out.println( "  not VALID NUMBER");
					}
					System.out.println("Your New Number Is Updated to "+New_Number+"  from   "+Old_Number);
					option();
				}
			}
			break;
			case 2:
			{
				System.out.println("THANK YOU VISIT AGAIN");
			}
			break;
			default:
			{
				System.out.println("ENTER VALID CHOICE");
			}
			break;
		}
		while(choice!=2);
	}
}
class AtmMachine
{
		public static void main(String[] args)
	{
		Atm a=new Atm();
		
		}
	}
}