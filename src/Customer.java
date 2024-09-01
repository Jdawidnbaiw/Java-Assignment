import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Customer {
	private String name;
	private int contactNumber;
	private String artistPreference;
	private int numberofartworkpurchased;
	private ArrayList <Customer> CustomerList = new ArrayList <Customer>();
	FileWriter fw;
	PrintWriter pw;
	public void setName(String aName)
	{
		name = aName;
	}
	public String getName()
	{
		return name;
	}
	public int getnumberofartworkpurchased()
	{
		return numberofartworkpurchased;
	}
	public String getArtistPreference()
	{
		return artistPreference;
	}
	public void setArtistPreference(String ANartistpreference)
	{
		artistPreference = ANartistpreference;
	}
	public int getContactNumber()
	{
		return contactNumber;
	}
	public void setContactNumber(int aContactNumber)
	{
		contactNumber = aContactNumber;
	}
	public Customer()
	{
		
	}
	public Customer(String aName, int aContactNumber, String aArtistPreference)
	{
		name = aName;
		contactNumber = aContactNumber;
		artistPreference = aArtistPreference;
	}
	public int getNumberOfCustomer()
	{
		return CustomerList.size();
	}
	public void recordACustomer(Customer customers)throws IOException
	{
		//open customer text file and put data to customer text file 
		if(new File("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt").isFile())
		{
			System.out.println("Customer file can be accessed");
			fw = new FileWriter("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt",true);
			pw = new PrintWriter(fw);
			
			pw.println(customers.getName() + "," + customers.getContactNumber()+ "," + customers.getArtistPreference());
		}
		
		fw.close();
		pw.close();
		//
		
	}
	
	public Customer [] getCustomerList()throws IOException 
	{
		//get customer list from the customer file then use ',' to split the customer's data
		File in_customer_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt");
		Scanner cin = new Scanner(in_customer_file);
		Customer c;
		if(in_customer_file.isFile())
		{
            while(cin.hasNextLine())
            {
            	String line = cin.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                int contactNumber = Integer.parseInt(tokens[1]);
                String artistPreference = tokens[2];
                
                
                //add object to customer array list
                c = new Customer(name, contactNumber,artistPreference);
                CustomerList.add(c);
                //
                
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		//
		cin.close();
	
		// put customer list to an array of objects
		int count = CustomerList.size();
		Customer [] list = new Customer[count];
		
		for(int i =0; i < getNumberOfCustomer(); i++)
		{
			list[i] = CustomerList.get(i);
		}
		//
		
		
		return list;
	}
	
	public void deleteCustomer(Customer customerToDelete) throws IOException { 
		
		// get data from customer file then put it into an array list
		File in_customer_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt");
		Scanner cin = new Scanner(in_customer_file);
		Customer c;
		if(in_customer_file.isFile())
		{
            while(cin.hasNextLine())
            {
            	String line = cin.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                int contactNumber = Integer.parseInt(tokens[1]);
                String artistPreference = tokens[2];
                
                //add object to customer array list
                c = new Customer(name, contactNumber, artistPreference);
                CustomerList.add(c);
                //
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		
		cin.close();
	
		
		int count = CustomerList.size();
		Customer [] list = new Customer[count];
		
		for(int i =0; i < getNumberOfCustomer(); i++)
		{
			list[i] = CustomerList.get(i);
		}
		//
		
		//delete chosen object from parameter
	    CustomerList.remove(customerToDelete);
	    //
	    
	    //override the text file and put in new data from the modified array list
        PrintWriter pw = new PrintWriter("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt");// put the new array list into the overridden file
	    
        Customer[] CR = CustomerList.toArray(new Customer[CustomerList.size()]);
	    
	    for(int i = 0;i < CustomerList.size();i++)
	    {
	    	pw.println(CR[i].getName() + "," + CR[i].getContactNumber()+"," + CR[i].getArtistPreference());
	    }
	    
	    pw.close();
	    //
	    
	    
	}
	public void modifyCustomer(String aName) throws IOException
	{
		//copy all info from text file array list
		File in_customer_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt");
		Scanner cin = new Scanner(in_customer_file);
		Customer c;
		if(in_customer_file.isFile())
		{
            while(cin.hasNextLine())
            {
            	String line = cin.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                int contactNumber = Integer.parseInt(tokens[1]);
                String artistPreference = tokens[2];
                
                
                c = new Customer(name, contactNumber, artistPreference);
                CustomerList.add(c);
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		
		cin.close();
		//
	
		
		//turn array list to an array of objects
		int count = CustomerList.size();
		Customer [] list = new Customer[count];
		
		for(int i =0; i < getNumberOfCustomer(); i++)
		{
			list[i] = CustomerList.get(i);
		}
		//
		
		
		//change the name that user want to modify from parameter to have no blank space and all to lower case
		Scanner changed_customer_name = new Scanner(aName);
		String modified_customer_name = "";
		
		while(changed_customer_name.hasNext())
		{
			modified_customer_name += changed_customer_name.next();
		}
		
		modified_customer_name = modified_customer_name.toLowerCase();
		//
		System.out.println(modified_customer_name);
		
		int index = -1;
		for(int i = 0 ; i < count;i++)
		{
			//change the name that user want to modify from txt file to have no blank space and all to lower case
			String txt_customer_name = list[i].getName();
			Scanner change_txt_customer = new Scanner(txt_customer_name);
			String modified_txt_customer_name = "";
			while(change_txt_customer.hasNext())
			{
				modified_txt_customer_name += change_txt_customer.next();
			}
			modified_txt_customer_name = modified_txt_customer_name.toLowerCase();
			//
			
			
			//if this is true, we get the specified customer object
			if(modified_txt_customer_name.equals(modified_customer_name))
			{
				index = i;
				break;
			}
			//
		}
			
		
		boolean quit = false;
		if(index != -1)
		{
			System.out.println("Which data of the customer you want to modify?");
			Scanner cin_choose_modify = new Scanner(System.in);
			int choice = 0;
			
			while(quit != true)
			{
				System.out.println("1. Modify Customer Name");
				System.out.println("2. Modify Contact Number");
				System.out.println("3. Modify Customer Preference");
				System.out.println("4. return");
	            choice = cin_choose_modify.nextInt();
				
					
				}
				Scanner in_new_data = new Scanner(System.in);
				switch(choice)
				{
				case 1:
					System.out.println("New Customer Name?");
					String new_name = in_new_data.nextLine();
					list[index].setName(new_name);
					break;
				case 2:
					System.out.println("New Customer Contact Number?");
					int new_cont_num = in_new_data.nextInt();
					list[index].setContactNumber(new_cont_num);
					break;
				case 3:
					System.out.println("New Customer Preference?");
					String new_pre = in_new_data.nextLine();
					list[index].setArtistPreference(new_pre);
					break;
				case 4:
					quit = true;
					break;
				default:
					break;
				}
				
			}
		else
		{
			System.out.println("User not found");
		}
		

		
		
		//Override the customer file with a new customer data
        pw = new PrintWriter("C:\\Users\\60167\\Desktop\\Assignment\\customer.txt");
		
		for(int i = 0;i < list.length;i++)
		{
			pw.println(list[i].getName() + "," + list[i].getContactNumber()+"," + list[i].getArtistPreference());
		}
		pw.close();
		//
		
		
	}


}
