import java.util.*;
class y
{
    public static void main(String[] args) 
    {
       Scanner sc = new Scanner(System.in);
        String playlistName="";
        Playlist p = new Playlist();
        String title,artist;
        System.out.println("LOGIN");
        p.login();
        System.out.println("LOGIN sucessfully");
       
         boolean flag=true;
        do{
            
            System.out.println("1 To make playlist \n 2 view account details \n 3 To list FM station \n 4 to exit");
            System.out.println("Enter your choice");
            int c= sc.nextInt(); 
            switch(c)
            {      case 1: System.out.println("To make playlist");
                        System.out.println("Enter name of your playlist");
                        playlistName= sc.next();
                        sc.nextLine();
                        System.out.println("*WELCOME*");
                        System.out.println("---"+playlistName+" playlist---");
                       
                        do
                        {
                        System.out.println(" 1 To Add song at start \n 2 To add song at last  \n 3 Play current song \n 4 play next song \n 5 play previous  \n 6 Remove particular song from playlist \n 7  Displaythe queue \n 8 Search song in plyalist  \n 10 exit");
                        int v = sc.nextInt();
                        switch(v)
                        {
                        case 1: System.out.println("Enter song at first");
                                System.out.println("Enter song title");
                                title=sc.nextLine();
                                p.addSongAtFirst(title);
                                break;
                        case 2: System.out.println("Enter song at last");
                                System.out.println("Enter song title");
                                title=sc.next();
                                p.addSongAtLast(title);
                                break;
                        case 3: System.out.println("Play song");     
                                 p.playCurrentSong();
                                 break;
                         case 4: System.out.println("play next song");   
                                 p.playNextSong();
                                 break;
                        case 5: System.out.println("play previous song");
                                 p.playPreviousSong();
                                 break;   
                        case 6: System.out.println("To delete a perticular song");  
                                System.out.println("Enter song title");
                                title=sc.next();
                                p. Remove_particular_song_from_playlist(title);
                                break;
                        case 7: System.out.println("Displaying PLAYLIST");
                                p.display_Queue();
                                break;
                        case 8: System.out.println("ENTER SONG NAME YOU SEARCH IN PLAYLIST");
                                String searchSong=sc.next();
                                p.searchMusicInPlaylist(searchSong);
                                break;

                        case 10: flag=false;
                                break;
                                
                        }
                       }while(flag);
                       break;
                case 2: p.profile(playlistName);
                        break;       
                case 3: p.Fm_Station();
                        break;   
                case 4: System.exit(0); 

            }
          }while(true);
    }
}

class Playlist
{    int size;
     Scanner sc = new Scanner(System.in);
     String payment_Method;
     int amount;
     int month;
     String num,name;
       String subsceiption_Type;
    void login()
    {   Scanner sc = new Scanner(System.in);
        
        int count  =1;
        boolean n = false;
        System.out.println("ENTER YOR NAME");
         name=sc.next();
        sc.nextLine();
        do{
		System.out.println("Enter your mobile number[10-digits] :");
		num=sc.nextLine();
			int a=num.length();
			if(a==10){
				for(int i=0;i<a;i++){
					if(num.charAt(i)>='0'  && num.charAt(i)<='9' ){
						n=true;
				}
				else{
					n=false;
					
				}
				}
                
			}
			else{
			System.out.println("Enter Valid mobile number of 10 digits");	
			}
			}
			while(n==false);
             
            System.out.println("OTP sent to your mobile no."+num);
            Random rand= new Random();
            int otp=rand.nextInt(9999);
            System.out.println("Your OTP for music application is :"+otp);
            int c = 0;

		for (int i = 3; i > 0; i--) {
			System.out.println("Enter otp");
			int OTP = sc.nextInt();
			if (OTP == otp) {
				break;
			}
			System.out.println("Attempt left " + (i - 1));
			c++;

		}
		if (c == 3) {
			System.out.println("YOU HAVE EXCEEDED YOUR LOGIN TRIAL LOOGING OUT OF THE SYSTEM");
			System.exit(0);
		} 
         boolean b = true;
        System.out.println("SUBSCRIPTION LIST :");
        do{
            System.out.println("1 FREE ");
            System.out.println("2 FOR 1 MONTH");
            System.out.println("3 FOR 3 MONTH");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1: System.out.println("FREE SUBSCRIPTION WITH ADD");
                        subsceiption_Type="FREE";
                         b=false;
                        break;
                       
                case 2: System.out.println(" 1 MONTH SUBSCRIPYION WITHOUT ADD");   
                        subsceiption_Type="1 MONTH " ;
                        month =1;
                        amount=199;
                        PAYMENT();
                         b=false;
                        break;
                case 3: System.out.println("3 MONTH SUBSCRIPTION"); 
                        subsceiption_Type="3 MONTH ";
                        month=3; 
                        amount=599;        
                        PAYMENT();
                         b=false;
                        break;
                          

            }
        }while(b);
        

            
    }
    class Node 
    {
        String song;
            Node next;
            Node prev;
            public Object songname;
            Node(String song)
        {
            this.song = song ;
            this.songname=song;
            this.next=next;
            this.prev=prev;
        }
    }
        Node first=null;
        Node currentSong=null;
       

   void addSongAtLast(String song)
    {
        Node newnode=new Node(song);
         if(first==null)
         {
            first=newnode;
            currentSong=newnode;
         }
         else 
         {
                Node temp=first;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newnode;
            newnode.prev=temp;

         }
    }
    void addSongAtFirst(String song)
    {
            Node newnode=new Node(song);
        if(first==null)
        {   
            first=newnode;
            currentSong=newnode;
        }
        else 
        {  
            newnode.next=first;
            first.prev=newnode;
            first=newnode;
            currentSong=newnode;
        }
        size++;
    }
    
 
    void Remove_particular_song_from_playlist(String songname)
    {
            
         Node current = first;
        while (current != null) 
        {
            if (current.songname.equals(songname)) {
                
                if (current == first) {
                    first = current.next;
                    if (first != null) {
                        first.prev = null;
                    }
                } else {
                    
                   current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }
                }
                return; 
            }

            current = current.next; 
        }
    size--;
}
    void display_Queue()
    {
    
        if(first==null)
        {
            System.out.println("emptyyy");
        }
        else 
        { 
                Node temp=first;
                System.out.println("TITLES");
                int i=0;
            do
              { i++;
                System.out.println(i+"."+temp.song.toString());
                temp=temp.next;

              }while(temp!=null);

        }
    }
    
     public void playCurrentSong() {
        if (currentSong != null) {
            System.out.println("Playing: " + currentSong.song.toString());
        } else {
            System.out.println("No song is selected.");
        }
    }

    public void playNextSong() {
        if (currentSong != null && currentSong.next != null) {
            currentSong = currentSong.next;
            playCurrentSong();
        } else {
            System.out.println("No next song available.");
        }
    }

    public void playPreviousSong() {
        if (currentSong != null && currentSong.prev != null) {
            currentSong = currentSong.prev;
            playCurrentSong();
        } else {
            System.out.println("No previous song available.");
        }
    }
    void PAYMENT()
    { 
        Scanner sc = new Scanner(System.in);
        int pays = 0, pca = 0, pcv = 0, pu = 0, pc = 0, length = 0, pay = 0;
        String card, cvv, upi, passu;
        System.out.println("------------------------------------------------");
        System.out.println("Which payment mode would you like to choose?");
        System.out.println("1.Debit Card");
        System.out.println("2.G-Pay");

        pay = sc.nextInt();
        switch (pay) {
            case 1: {
                System.out.println("Enter Card No.");
                do {
                    pca++;
                    if (pca == 4) {
                        System.out.println("Sorry you have reached an extent!!");
                        System.out.println("Please sign in after an hour");
                        System.exit(0);
                    }
                    card = sc.nextLine();
                    if (card.length() == 16) {
                        System.out.println("You have enter correct password");
                        break;
                    } else {
                        System.out.println("The card no. should contain 16 digits ");
                        System.out.println("Enter correct card no.");
                    }
                } while (pca < 4);

                System.out.println("Enter CVV No.");
                do {
                    pcv++;
                    if (pcv == 4) {
                        System.out.println("Sorry you have reached an extent!!");
                        System.out.println("EXITING THE CODE...");
                        System.exit(0);
                    }
                    cvv = sc.nextLine();
                    if (cvv.length() == 3) {
                        System.out.println("Your cvv no. is correct");
                        break;
                    } else {
                        System.out.println("Enter correct cvv");
                    }
                } while (pcv < 4);

                System.out.println("Generating OTP.....");
                Random r = new Random();
                length = r.nextInt(10000);
                System.out.println("Your OTP: " + length);
                System.out.println("Enter OTP");
                int otp1 = sc.nextInt();
                if (otp1 == length) {
                    System.out.println("Your payment is successful!!");

                } else {
                    System.out.println("Sorry you have enter wrong otp");
                    System.out.println("Sorry you have reached an extent!!");
                    System.out.println("Please sign in after an hour");
                    System.exit(0);
                }
                break;

            }
            case 2: {
                System.out.println("Enter UPI");

                do {
                    pu++;
                    if (pu == 4) {
                        System.out.println("Sorry you have reached an extent!!");
                        System.out.println("Please sign in after an hour");
                        System.exit(0);
                    }
                    upi = sc.nextLine();
                    if (upi.length() == 16) {
                        System.out.println("Your payment is successful");
                        break;
                    } else {
                        System.out.println("Upi id should contain 16 digits ");
                    }
                } while (pu < 4);

                System.out.print("Enter password: ");
                do {
                    pc++;
                    if (pc == 4) {
                        System.out.println("Sorry you have reached an extent!!");
                        System.out.println("Please sign in after an hour");
                        System.exit(0);
                    }
                    passu = sc.nextLine();
                    if (passu.length() == 4) {
                        System.out.println("Your payment is successful!!");
                        break;
                    } else {

                        System.out.println("password should contain 4 digits");
                        System.out.print("Enter valid password: ");
                    }
                } while (pc < 4);
                break;
            }
            default:
                System.out.println("Sorry!! Invalid choice");
        }

    }
    
    void profile(String playlistName)
    {
        System.out.println("NAME                 :"+name);
        System.out.println("MOBILE NUMBER        :"+num);
        System.out.println("PLAYLIST NAME        :"+playlistName);
        System.out.println("SUBSCIRPTION TYPE    :"+subsceiption_Type);
        System.out.println("SUBSCRIPTION AMOUNT  :"+amount);
        System.out.println("SUBSCRIPTION DURATION:"+month);
       
    }

    void searchMusicInPlaylist(String songName)
    {   int flag=0;
         Node current = first;
        while (current != null) 
        {
            if (current.songname.equals(songName))
            {
                flag=1;
            }
            current=current.next;
        }
        if(flag==0)
        {System.out.println(songName+"SONG NOT FOUND ");}
        else
        { String answer;
            System.out.println("ENTER 'yes' TO INSERT AT FIRST OR 'no'");
            answer=sc.next();
            if(answer.equalsIgnoreCase("yes"))
            {
                addSongAtFirst(songName);
            }
            else
            {addSongAtLast(songName);}

        }
    }
    void Fm_Station()
    { boolean j =true;
        double RadioStation;
        do{
            System.out.println("1.FM STATION 91.5");
            System.out.println("2.FM STATION 93.5");
            System.out.println("3.FM STATION 108.5");
            System.out.println("4.TO EXIT FROM RADIO STATION");
            System.out.println("ENTER YOUR  CHOICE");
            int select=sc.nextInt();
            switch(select)
            {
                case 1: 
                        RadioStation= 91.5;
                        System.out.println("CURRENT RADIO STATION "+RadioStation);
                        break;
                case 2: 
                        RadioStation= 93.5;
                        System.out.println("CURRENT RADIO STATION "+RadioStation);
                        break;
                case 3: 
                        RadioStation= 108.5;
                        System.out.println("CURRENT RADIO STATION "+RadioStation);
                        break;
                case 4: j=false;
                        break;                      
            }
        }while(j);
    }
}