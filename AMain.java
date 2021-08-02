import java.util.*;
import java.io.*;
class HlPortalBase
{
    ArrayList<String> userID  = new ArrayList<String>();
	ArrayList<String> userName  = new ArrayList<String>();
	ArrayList<String> userPWD = new ArrayList<String>();
	ArrayList<Integer> HomeLAmount   = new ArrayList<Integer>();
    ArrayList<Integer> RemLAmount  = new ArrayList<Integer>();
    ArrayList<Integer> LoanENDYear = new ArrayList<Integer>();
    ArrayList<Integer> LoanSTRTYear = new ArrayList<Integer>();
    
    ArrayList<String> userIDlpd  = new ArrayList<String>();
    ArrayList<Integer> AmtPaid = new ArrayList<Integer>();
    ArrayList<Integer> LoanRePayAmt = new ArrayList<Integer>();
    ArrayList<String> Description = new ArrayList<String>();
	ArrayList<Integer> Date = new ArrayList<Integer>();
	ArrayList<Integer> Month  = new ArrayList<Integer>();
    ArrayList<Integer> Year  = new ArrayList<Integer>();
    ArrayList<Integer> Index = new ArrayList<Integer>();

	int payment = 0;
	int i=0;
	Scanner es=new Scanner(System.in);
}
    

class User extends HlPortalBase
{
    void UserInfo()
    {
        es = new Scanner(System.in);
        System.out.print("\n----------------------------------------------------------------------------\n");
        System.out.print("                    New-User Login UI : Please Enter Your INfo ");
        System.out.print("\n----------------------------------------------------------------------------\n");
        while(true)
        {
        System.out.print("\t\t\tEnter Your UserId : ");
		String uid = new String();
		uid = es.next();
        if(userID.contains(uid)!=true)
        {
            userID.add(uid);
        System.out.print("\t\t\tEnter Your Name (Without Spaces): ");
        char[] nmech = es.next().toCharArray();
		String name = new String(nmech);
        userName.add(name);
		System.out.print("\n\t\t\tEnter a Password : ");
		char[] ch = es.next().toCharArray();
		String k = new String(ch);
		System.out.print("\n\t\t\tPlease Re-enter Password for Confirmation : ");
		char[] chc = es.next().toCharArray();
		String kc = new String(chc);
		while(k.equals(kc)!=true)
		{
            System.out.print("\n----------------------------------------------------------------------------\n");
            System.out.print("\n\t\t\tPlease Re-enter the correct UserID : ");
            uid = es.next();
            userID.add(uid);
            System.out.print("----------------------------------------------------------------------------\n");
			System.out.print("\n\t\t\tPlease Re-enter the correct Password for Confirmation : ");
			chc = es.next().toCharArray();
			kc = new String(chc);
            System.out.print("----------------------------------------------------------------------------\n");
            
		}
        userPWD.add(kc);
        System.out.print("\t\t\tEnter Home Loan Amount : ");
        int hla = es.nextInt();
        es.nextLine();
        HomeLAmount.add(hla);
        System.out.print("\t\t\tEnter Remaining Loan AMount : ");
        int remlam = es.nextInt();
        es.nextLine();
        RemLAmount.add(remlam);
        System.out.print("\t\t\tEnter Loan Tenure Start Year : ");
        int stryr = es.nextInt();
        es.nextLine();
        LoanSTRTYear.add(stryr);
        System.out.print("\t\t\tEnter Loan Tenure End Year : ");
        int endyr = es.nextInt();
        es.nextLine();
        LoanENDYear.add(endyr);
        break;
        }
        else
        {
            System.out.println("The user-ID exists already. !! Please Enter a Valid New Login.");
        }
        }
        
    }
    void LoanPaymentDetails(String idname)
    {
            es = new Scanner(System.in);
            System.out.print("\n----------------------------------------------------------------------------\n");
            System.out.print("                    Loan Payment Details UI : Please Enter the Details ");
            System.out.print("\n----------------------------------------------------------------------------\n");
            
            userIDlpd.add(idname);
            System.out.print("\t\t\tEnter Day of Month : ");
            int d = es.nextInt();
            es.nextLine();
            System.out.print("\t\t\tEnter Month Number : ");
            int mn = es.nextInt();
            es.nextLine();
            int mw = 0;
            while(mw==0)
            {
                    if(mn>=1 && mn<=12)
                    {
                        mw=1;
                    }
                    else
                    {
                        System.out.print("\t\t\tPlease Enter a Valid Month Number : ");
                        mn = es.nextInt();
                        mw=0;
                    }
            }
            System.out.print("\t\t\tEnter Year : ");
            int y = es.nextInt();
            int k = nmeIndex(idname);
            int jw = 0;
            while(jw==0)
            {
                    if(y>=LoanSTRTYear.get(k) && y<=LoanENDYear.get(k))
                    {
                        jw=1;
                    }
                    else
                    {
                        System.out.print("\t\t\tPlease Enter a Valid Year : ");
                        y = es.nextInt();
                        jw=0;
                    }
            }
            int mjw = 0;
            while(mjw==0)
            {
                for(int j=0;j<Year.size();j++)
                        {
                            String le = userIDlpd.get(j);
                            if( le.equals(idname)==true && ((Year.get(j)==y && Month.get(j)== mn) || Date.get(j)==d))
                            {
                                    System.out.print("\n----------------------------------------------------------------------------\n");
                                    System.out.print("\t\t Same Date as Any Previous Payment cannot be entered");
                                    System.out.print("\n----------------------------------------------------------------------------\n");
                                    System.out.print("\n       Please Re-enter Date Information -- ");
                                    System.out.print("\n\t\t Day of Month : ");
                                    d = es.nextInt();
                                    System.out.print("\n\t\t Month : ");
                                    mn = es.nextInt();
                                    mw = 0;
                                    while(mw==0)
                                    {
                                            if(mn>=1 && mn<=12)
                                            {
                                                mw=1;
                                            }
                                            else
                                            {
                                                System.out.print("\t\t\tPlease Enter a Valid Month Number : ");
                                                mn = es.nextInt();
                                                mw=0;
                                            }
                                    }
                                    System.out.print("\n\t\t Year : ");
                                    y = es.nextInt();
                                    jw = 0;
                                    while(jw==0)
                                    {
                                            if(y>=LoanSTRTYear.get(k) && y<=LoanENDYear.get(k))
                                            {
                                                jw=1;
                                            }
                                            else
                                            {
                                                System.out.print("\t\t\tPlease Enter a Valid Year : ");
                                                y = es.nextInt();
                                                jw=0;
                                            }
                                    }
                                }
                                else
                                {
                                    mjw=1;
                                }
                        }
            }
            String l = new String();
                switch(mn)
                    {
                    case 1: l = "January";break;
                    case 2: l = "February";break;
                    case 3: l = "March";break;
                    case 4: l = "April";break;
                    case 5: l = "May";break;
                    case 6: l = "June";break;
                    case 7: l = "July";break;
                    case 8: l = "August";break;
                    case 9: l = "September";break;
                    case 10: l = "October";break;
                    case 11: l = "November";break;
                    case 12: l = "December";break;
                    }
                String m = l+" Payment";
                Description.add(m);
                Date.add(d);
                Month.add(mn);           
                Year.add(y);
                Index.add((Index.get(Index.size()-1))+1);
                System.out.print("\n\t\t\tEnter the Amount Paid : ");
                int kc = es.nextInt();
                es.nextLine();
                AmtPaid.add(kc);
    }
    boolean confirmDetails(String name , String pwd)
	{
		int i =0;
		while(i<userID.size())
		{
			if(name.equals(userID.get(i))== true && pwd.equals(userPWD.get(i)) == true)
			{
				return true;
			}
			i++;
		}
		return false;

    }
    void PrintSummary(String rnm)
	{
        es = new Scanner(System.in);
        System.out.print("\n----------------------------------------------------------------------------\n");
        System.out.print("                     Summary of Your Loan Payments");
        System.out.print("\n----------------------------------------------------------------------------\n");
        System.out.print("\n----------------------------------------------------------------------------\n");
        int rcdIn = nmeIndex(rnm);
        int yr = LoanSTRTYear.get(rcdIn);
        int fnlpay=0;
        while(yr<=LoanENDYear.get(rcdIn))
        {
            int paym = 0;
            System.out.print("\n----------------------------------------------------------------------------\n");
            System.out.print("                     Your "+yr+" Loan Details");
            System.out.print("\n----------------------------------------------------------------------------\n");
            System.out.print("\n\t\t\t Name                                     : " + userName.get(rcdIn));
            System.out.print("\n\t\t\t User ID    	                            : " + userID.get(rcdIn));
            System.out.print("\n\t\t\t Home Loan AMount    	                    : " + HomeLAmount.get(rcdIn));
            for(int i = 0;i<userIDlpd.size();i++)
            {
                String b = userIDlpd.get(i);
                int  k = Year.get(i);
                if(b.equals(rnm)==true && k==yr)
                {
                    paym = paym + AmtPaid.get(i);
                }

            }
            fnlpay = fnlpay + paym;
            System.out.print("\n\t\t\t Current Remaining Loan Amount            : " + (RemLAmount.get(rcdIn)-fnlpay));
            System.out.print("\n\t\t\t Loan Re-Payment Amount in Year "+yr+"      : " + paym);
            System.out.print("\n----------------------------------------------------------------------------\n");
            System.out.print("----------------------------------------------------------------------------\n");    
            yr++;
        }
		
    }
    void PrintYrSummary(String idnme)
	{
        es = new Scanner(System.in);
        System.out.print("\n----------------------------------------------------------------------------\n");
        System.out.print("  |     Year       |      Month    |      Total Amount of Loan Repayment     |");
        System.out.print("\n----------------------------------------------------------------------------\n");
        int m = nmeIndex(idnme);
        int yr = LoanSTRTYear.get(m);
        do
        {
            for(int i = 1;i<=12;i++)
            {
                for(int k = 0;k<userIDlpd.size();k++)
                    {
                        String b = userIDlpd.get(k);
                        int mnth = Month.get(k);
                        int yrr = Year.get(k);
                            if( b.equals(idnme)==true && mnth==i && yrr==yr)
                            {
                                System.out.println("");
        System.out.println("  |     "+Year.get(k)+"           |      "+Month.get(k)+"    |      "+AmtPaid.get(k)+"     |");
                                System.out.println("");
                            }
                    
                    }
            }
            yr++;
        }while(yr<=LoanENDYear.get(nmeIndex(idnme)));
        System.out.print("\n----------------------------------------------------------------------------\n");
        
        
		System.out.print("             Total Amount of Loan-Repayment : "+HomeLAmount.get(nmeIndex(idnme))+"\n");
		
        System.out.print("----------------------------------------------------------------------------\n");
        
    }
    int nmeIndex(String idnamechk)
    {
        int u =0;
        while(u<userID.size())
		{
			if(idnamechk.equals(userID.get(u))== true)
			{
                return u;
			}
			u++;
        }
        return 0;
    
    }
}
class HLPInstance extends User
{
    HLPInstance()
    {
        setUD();
        setLPD();
        setReUD();
        setReLPD();
    }
    void filehandle(File  file , int fch)
    {
                    String data=new String();
                    String rname=new String();
                    String a = userID.get(userID.size()-1); 
                    String b = userName.get(userName.size()-1);
                    String name = a;
                    String c = userPWD.get(userPWD.size()-1);
                    int f = HomeLAmount.get(HomeLAmount.size()-1);
                    int h = RemLAmount.get(RemLAmount.size()-1);
                    int sT = LoanSTRTYear.get(LoanSTRTYear.size()-1);
                    int wT = LoanENDYear.get(LoanENDYear.size()-1);

                    try
                    {
                            
                        if (!file.exists())
                                {
                                    // Create a new file if not exists.
                                    file.createNewFile();
                                }
                            // Opening file in reading and write mode.
                            RandomAccessFile raf = new RandomAccessFile(file, "rw");
                            
                            boolean found = false;
                                switch(fch)
                                {
                                case 1 : 
                                {
                                        while (raf.getFilePointer() < raf.length()) 
                                        {
                                            data = raf.readLine();
                                            int index = data.indexOf('|');
                                            rname=data.substring(0,index);
                                            if(rname.equals(name))
                                            {
                                                found=true;
                                                break;
                                            }
                                        }
                                        
                                        if(found==false)
                                        {
                                            String d = a+'|'+b+'|'+c+'|'+f+'|'+h+'|'+sT+'|'+wT;
                                            raf.writeBytes(d);
                                        // To insert the next record in new line.
                                            raf.writeBytes(System.lineSeparator());
                                        // Print the message
                                            System.out.print("--------------------- Record Added ------------------------");
                                            // Closing the resources.
                                            raf.close();
                                            
                                            
                                        }
                                        else
                                        { 
                                            raf.close();
                                            System.out.println(" Input name already exist...");
                                        }
                                    break;
                                }
                                case 2:
                                {
                                    long pos = raf.length();
                                    raf.seek(pos-1);
                                    String l = userIDlpd.get(userIDlpd.size()-1);
                                        int n = AmtPaid.get(AmtPaid.size()-1);
                                        String o = Description.get(Description.size()-1);
                                        int p = Date.get(Date.size()-1);
                                        int q = Month.get(Month.size()-1);
                                       int r = Year.get(Year.size()-1);
                                        int hij = Index.get(Index.size()-1);
                                        String d = l+'|'+n+'|'+o+'|'+p+'|'+q+'|'+r+'|'+hij;
                                            raf.writeBytes(System.lineSeparator());
                                            raf.writeBytes(d);
                                            raf.writeBytes(System.lineSeparator());
                                            raf.seek(0);
                                            raf.close();
                                            break;
                                }
                                case 3:
                                    {   
                                        for(int i=0;i<userID.size();i++)
                                        {

                                                String aq = userID.get(i);
                                                String nmea = aq;
                                                    while (raf.getFilePointer() < raf.length()) 
                                                {
                                                    data = raf.readLine();
                                                    int index = data.indexOf('|');
                                                    rname=data.substring(0,index);
                                                    if(rname.equals(nmea))
                                                    {
                                                        found=true;
                                                        break;
                                                    }
                                                }
                                                
                                                if(found==false)
                                                {
            String d = userID.get(i)+'|'+userName.get(i)+'|'+userPWD.get(i)+'|'+HomeLAmount.get(i)+'|'+RemLAmount.get(i)+'|'+LoanSTRTYear.get(i)+'|'+LoanENDYear.get(i);
                                                    raf.writeBytes(d);
                                                    raf.writeBytes(System.lineSeparator());
                                                }
                                        }
                                        raf.close();
                                        
                                    }
                                case 4:
                                    {
                                        
                                        for(int i = 0;i<userIDlpd.size();i++)
                                        {
                                        String l = userIDlpd.get(i);
                                        int n = AmtPaid.get(i);
                                        String o = Description.get(i);
                                        int p = Date.get(i);
                                        int q = Month.get(i);
                                        int r = Year.get(i);
                                        int hi = Index.get(i);
                                        String d = l+'|'+n+'|'+o+'|'+p+'|'+q+'|'+r+'|'+hi;
                                            raf.writeBytes(d);
                                        // To insert the next record in new line.
                                            raf.writeBytes(System.lineSeparator());
                                        }
                                    
                                    raf.close();
                                    break;
                                    }
                                            
                            }
                    }
                    catch(IOException e) 
                    {
                        System.out.println("Exception Occurred:");
                        e.printStackTrace();
                        
                    }
                    catch(ArrayIndexOutOfBoundsException e)
                    {
                        System.out.println("Usage: File Already in use F1");
                    }
    }
    void setUD()
    {
        
        List<String> userIDList = Arrays.asList("rajeshs", "rameshj", "darshanr", "vipulp");
        userID.addAll(userIDList);
        List<String> userNameList = Arrays.asList("RajeshPatel", "RameshJoshi", "DarshanRaval", "VipulPatel");
        userName.addAll(userNameList);
        List<String> userPWDList = Arrays.asList("Rpatel@11", "Rjoshi@23", "Draval@34", "Vpatel@99");
        userPWD.addAll(userPWDList);
        List<Integer> HLAList = Arrays.asList(3000000,1500000,1000000,5000000);
        HomeLAmount.addAll(HLAList);
        List<Integer> RemLAList = Arrays.asList(1800000,900000,700000,3800000);
        RemLAmount.addAll(RemLAList);
        List<Integer> TstrtList = Arrays.asList(2019,2019,2019,2019);
        LoanSTRTYear.addAll(TstrtList);
        List<Integer> TendList = Arrays.asList(2020,2022,2021,2021);
        LoanENDYear.addAll(TendList);
        File fileE = new File("UserDetails.txt");
        filehandle(fileE,3);       
    }
    void setLPD()
    {
        List<String> userIDlpdList = Arrays.asList("rajeshs","rajeshs","rajeshs","rajeshs", "rameshj", "rameshj", "rameshj", "rameshj", "darshanr","darshanr","darshanr","darshanr", "vipulp","vipulp", "vipulp", "vipulp");
        userIDlpd.addAll(userIDlpdList);
        List<Integer> APList = Arrays.asList(57000,81000,91000,95000,82000,91000,112000,76000,91000,89000,67000,78000,112000,340000,57000,222000);
        AmtPaid.addAll(APList);
        List<String> DescList = Arrays.asList("April-Payment", "May-Payment", "June-Payment", "July-Payment","April-Payment", "May-Payment", "June-Payment", "July-Payment","April-Payment", "May-Payment", "June-Payment", "July-Payment","April-Payment", "May-Payment", "June-Payment", "July-Payment");
        Description.addAll(DescList);
        List<Integer> DayList = Arrays.asList(9,8,12,6,5,4,22,11,25,26,27,28,21,2,3,7);
        Date.addAll(DayList);
        List<Integer> MonthList = Arrays.asList(4,5,6,7,4,5,6,7,4,5,6,7,4,5,6,7);
        Month.addAll(MonthList);
        List<Integer> YearList = Arrays.asList(2019,2019,2020,2020,2019,2020,2021,2022,2019,2020,2020,2021,2019,2019,2020,2021);
        Year.addAll(YearList);
        List<Integer> IndexList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16);
        Index.addAll(IndexList);
        File fileR = new File("LoanPaymentDetails.txt");
        filehandle(fileR,4);

    }
    void setReUD()
    {
        try
        {
            File file = new File("UserDetails.txt"); 
        String[] words = new String[10];
        String s = new String();
        BufferedReader br = new BufferedReader(new FileReader(file));
        while ((s= br.readLine())!=null) 
        {
           words=s.split("\\|");
           if(userID.contains(words[0])!=true)
           {
               userID.add(words[0]);
               userName.add(words[1]);
               userPWD.add(words[2]);
               HomeLAmount.add(Integer.parseInt(words[3]));
               RemLAmount.add(Integer.parseInt(words[4]));
               LoanSTRTYear.add(Integer.parseInt(words[5]));
               LoanENDYear.add(Integer.parseInt(words[6]));

           }
                
        }
        br.close(); 
        }
        catch(IOException e) 
        {
        System.out.println("Exception Occurred:");
        e.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        System.out.println("Usage: File Already in use F2");
        }
    }
    void setReLPD()
    {
        try
        {
            File fileS = new File("LoanPaymentDetails.txt"); 
        String[] wordsa = new String[10];
        String sf = new String();
        BufferedReader brc = new BufferedReader(new FileReader(fileS));
        while ((sf= brc.readLine())!=null) 
        {
           wordsa=sf.split("\\|");
           int fchk = Integer.parseInt(wordsa[6]);
           if(fchk>16)
           {
               userIDlpd.add(wordsa[0]);
               AmtPaid.add(Integer.parseInt(wordsa[1]));
               Description.add(wordsa[2]);
               Date.add(Integer.parseInt(wordsa[3]));
               Month.add(Integer.parseInt(wordsa[4]));
               Year.add(Integer.parseInt(wordsa[5]));
               Index.add(Integer.parseInt(wordsa[6]));
           }
                
        }
        brc.close(); 
        }
        catch(IOException e) 
        {
        System.out.println("Exception Occurred:");
        e.printStackTrace();
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
        System.out.println("Usage: File Already in use F3");
        }
    }
}
public class AMain
{
    public static void main(String[] args) throws IOException
	{

        
          
			HLPInstance HLPob = new HLPInstance();
			Scanner sca = new Scanner(System.in);  
			 boolean end = false;
	
	System.out.print("\n----------------------------------------------------------------------------\n");
	System.out.print("                           OOP Comprehensive ASSIGNMENT "                    );
	System.out.print("\n----------------------------------------------------------------------------");
	System.out.print("\n----------------------------------------------------------------------------\n");
	System.out.print("                          Welcome to Home Loan Portal :"                    );
	System.out.print("\n----------------------------------------------------------------------------\n");
	
	System.out.print("    			    Developer :    Rushir Bhavsar - 19bce229                \n");

			 
	do{
			 int choice;
			 
			System.out.print("\n----------------------------------------------------------------------------\n");
			System.out.print("                            Home Loan Portal :  MAIN MENU"                    );
			System.out.print("\n----------------------------------------------------------------------------\n");
        	System.out.print("\t\t\t Log in as: \n");
            System.out.print("\n\t\t 1. Already Signed Up User \n\n\t\t 2. New User-Login \n\n\t\t 0. EXIT");
            System.out.print("\n----------------------------------------------------------------------------\n");
            System.out.print("\n----------------------------------------------------------------------------\n\n");
            System.out.print("\n!! 				Enter Login Choice : ");
            choice = sca.nextInt();
            sca.nextLine();
            if(choice>2 || choice<0 )
            {
                System.out.print("\n\t !!  Please Enter a valid Choice : ");
                choice=sca.nextInt();
                sca.nextLine();
            }
            switch(choice)
            {
                case 1:
                {
                    System.out.print("\n----------------------------------------------------------------------------\n");
                    System.out.print("                     Please Enter Your Username Password to LOGIN"                    );
                    System.out.print("\n----------------------------------------------------------------------------\n");
                    String name = new String();

                    System.out.print("\n Enter Username : ");
                    name = sca.nextLine();
                    System.out.print("\n Enter  Password : ");
                    char[] pwdch = sca.next().toCharArray();
                    String pwd = new String(pwdch);
                    boolean found = HLPob.confirmDetails(name, pwd);
                    if(found==true)
                    {
                        
                        do
                        {
                            
                            System.out.print("\n---------------------------------------------\n");
                            System.out.print("                   User Menu                    ");
                            System.out.print("\n---------------------------------------------\n");
                            System.out.print("\n\t1. Review Loan Payment Details\n\t");
                            System.out.print("2. Add New Entry for Loan Payment");
                            System.out.print("\n\t0. Exit \n\n\t");
                            System.out.print("Choice:\t");
                            choice = sca.nextInt();
                            sca.nextLine();
							if(choice>5 || choice<0 )
							{
								System.out.print("\n\t !!  Please Enter a valid choice : ");
                                choice=sca.nextInt();
                                sca.nextLine();
							}
                            switch(choice)
                                {
                                    case 0: break;
                                    case 1:
                                    {   
                                        
                                        if(HLPob.userIDlpd.contains(name)!=true)
                                        {
                                            System.out.print("\n----------------------------------------------------------------------------\n");
                                            System.out.print("                     There are 0 Records Created\n");
                                            System.out.print("             Please Enter a Record and Return to Review it");
                                            System.out.print("\n----------------------------------------------------------------------------\n");
                                        }
                                        else
                                        {
                                            do
                                            {
                                                
                                                System.out.print("\n---------------------------------------------\n");
                                                System.out.print("                   Review Menu                    ");
                                                System.out.print("\n---------------------------------------------\n");
                                                System.out.print("\n\t1. Review Year-Wise - Month-Wise Details\n\t");
                                                System.out.print("2. Review Year-Wise Details");
                                                System.out.print("\n\t0. Exit \n\n\t");
                                                System.out.print("Choice:\t");
                                                choice = sca.nextInt();
                                                sca.nextLine();
                                                switch(choice)
                                                {
                                                    case 1: 
                                                    {
                                                        HLPob.PrintYrSummary(name);
                                                        break;
                                                    }
                                                    case 2:
                                                    {
                                                        HLPob.PrintSummary(name);
                                                        break;
                                                    }
                                                   default:
                                                    {
                                                        break;
                                                    }
                                                }
                                                System.out.print("\n----------------------------------------------------------------------------\n");
                                                System.out.print("\n\tWant to Continue back to [Review Menu] (1.Yes / 2.No ):\t");
                                                int k = sca.nextInt();
                                                sca.nextLine();
                                                    if(k>3 || k<1 )
                                                    {
                                                        System.out.print("\n\t !!  Please Enter a valid number : ");
                                                        k=sca.nextInt();
                                                        sca.nextLine();
                                                    }

                                                    if(k==2)
                                                    {
                                                        break;
                                                    }
        
                                            }while(true);
                                        }
                                        break;
                                    } 
                                    case 2: 
                                    {
                                        HLPob.LoanPaymentDetails(name);
                                            File filea = new File("LoanPaymentDetails.txt");
                                            HLPob.filehandle(filea,2);
                                        
                                        break;
                                    }
                                }
                                System.out.print("\n----------------------------------------------------------------------------\n");
                                System.out.print("\n\tWant to Continue back to [User Menu] (1.Yes / 2.No ):\t");
                                int k = sca.nextInt();
                                sca.nextLine();
								if(k>3 || k<1 )
									{
										System.out.print("\n\t !!  Please Enter a valid number : ");
                                        k=sca.nextInt();
                                        sca.nextLine();
									}

                                    if(k==2)
                                    {
                                    System.exit(0);
                                    }
                            }
                            while(true);

                    }
                    else
                    {
                        System.out.print("\n\n\n\t!! INVALID CREDENTIALS ...... Enter Correct Username And Password !!\n\n");
                    }
                    break;
                }
				case 2:
                {
                    System.out.print("\n----------------------------------------------------------------------------\n");
                    System.out.print("                     Please Enter Your Details"                    );
                    System.out.print("\n----------------------------------------------------------------------------\n");
                        HLPob.UserInfo();
                        File file= new File("UserDetails.txt");
                        HLPob.filehandle(file,1);

					System.out.print("\n----------------------------------------------------------------------------\n");
                    System.out.print("----------------------------------------------------------------------------\n");
                    break;                        
                }
                case 0: 
                {
                   	System.exit(0);
                   	end=true;
                	break;
                }
            }

        }while(end==false);
		sca.close();
	}
	
}
