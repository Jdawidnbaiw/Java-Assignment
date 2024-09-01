import java.io.*;
import java.util.*;

public class Artwork{

	private String title;
	private double price;
	String date_purchased;
	String date_sold;
	private String artist_name;
	private String Buyer_name;
	private ArrayList <Artwork> ArtworkList = new ArrayList <Artwork>();
	FileWriter fw;
	PrintWriter pw;
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String aTitle)
	{
		title = aTitle;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double value)
	{
		price = value;
	}
	
	public void setDatePurchase(String aDate_purchased)
	{
		date_purchased = aDate_purchased;
	}
	public String getDatePurchase()
	{
		return date_purchased;
	}
	
	public void setDateSold(String aDate_sold)
	{
		date_sold = aDate_sold;
	}
	
	public String getDateSold()
	{
		return date_sold;
	}
	
	public void setArtistName(String anartist_name)
	{
		artist_name = anartist_name;
	}
	public String getArtistName()
	{
		return artist_name;
	}

	public void setbuyername(String buyer_name)
	{
		Buyer_name = buyer_name;
	}
	public String getbuyername()
	{
		return Buyer_name;
	}
	public Artwork()
	{
		
	}
	public Artwork(String aTitle, double aPrice, String aDate_purchased, String aDate_sold, String buyer_name, String anartist_name)
	{
		title = aTitle;
		price = aPrice;
		date_purchased = aDate_purchased;
		date_sold = aDate_sold;	
		artist_name = anartist_name;
		Buyer_name = buyer_name;
	}

	public int getNumberOfArtwork()
	{
		return ArtworkList.size();
	}
	public void recordAArtwork(Artwork artwork) throws IOException//artist's data will be split by ','
	{
		//open customer text file and put data to customer text file 
		if(new File("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt").isFile())
		{
			System.out.println("Artwork file can be accessed");
			fw = new FileWriter("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt",true);
			pw = new PrintWriter(fw);
			
			pw.println(artwork.getTitle()+ "," + artwork.getPrice() + "," + artwork.getDatePurchase() + "," + artwork.getDateSold()+ "," + artwork.getbuyername()+ "," + artwork.getArtistName());
		}
		fw.close();
		pw.close();
		//
		
		
	}

	public Artwork [] getArtworkList() throws IOException 
	{
		
		//get artwork list from the artwork file then use ',' to split the artwork's data
		File in_artwork_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
		Scanner cin = new Scanner(in_artwork_file);
		Artwork at;
		if(in_artwork_file.isFile())
		{
            while(cin.hasNextLine())
            {
            	String line = cin.nextLine();
                String[] tokens = line.split(",");
                String name = tokens[0];
                double price = Double.parseDouble(tokens[1]);
                String art_pur_date = tokens[2];
                String art_date_sold = tokens[3];
                String art_buyer_name = tokens[4];
                String Art_Artist_Name = tokens[5];
                
                //add object to artwork array list
                at = new Artwork(name, price,art_pur_date,art_date_sold,art_buyer_name,Art_Artist_Name);
                ArtworkList.add(at);
                //
                
                
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		cin.close();
		//
		
		
		// put array list to an array of objects
		int count = ArtworkList.size();
		Artwork [] list = new Artwork[count];
		for(int i =0; i < getNumberOfArtwork(); i++)
		{
			list[i] = ArtworkList.get(i);
		}
		//
		
		
		return list;
	}
	public void deleteArtwork(Artwork artworkToDelete) throws IOException { 
		
		// get data from artwork text file then put it into an array list
		File in_artwork_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
		Scanner cin = new Scanner(in_artwork_file);
		Artwork at;
		if(in_artwork_file.isFile())
		{
            while(cin.hasNextLine())
            {
            	String line = cin.nextLine();
                String[] tokens = line.split(",");
            	String name = tokens[0];
            	double price = Double.parseDouble(tokens[1]);
                String art_pur_date = tokens[2];
                String art_date_sold = tokens[3];
                String art_buyer_name = tokens[4];
                String Art_Artist_Name = tokens[5];
                
                //add object to artwork array list
                at = new Artwork(name, price,art_pur_date,art_date_sold,art_buyer_name,Art_Artist_Name);
                ArtworkList.add(at);
                //
                
                
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		cin.close();
		//
		
		
		// put array list to an array of objects
		int count = ArtworkList.size();
		Artwork [] list = new Artwork[count];
		for(int i =0; i < getNumberOfArtwork(); i++)
		{
			list[i] = ArtworkList.get(i);
		}
		//
		
		
		//delete chosen object from parameter
	    ArtworkList.remove(artworkToDelete);
	    //
	    
	    
	    //override the text file and put in new data from the modified array list
	    PrintWriter pw = new PrintWriter("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
	    
	    Artwork[] AW = ArtworkList.toArray(new Artwork[ArtworkList.size()]);
	    
	    for(int i = 0;i < ArtworkList.size();i++)
	    {
	    	pw.println(AW[i].getTitle()+ "," + AW[i].getPrice());
	    }
	    
	    pw.close();
	    //
	    
	}
	
	public void modifyartwork(String Artwork_name) throws IOException
	{
		//copy all info from text file array list
		File in_artwork_file = new File("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
		Scanner cin = new Scanner(in_artwork_file);
		Artwork at;
		if(in_artwork_file.isFile())
		{
            while(cin.hasNextLine())
            {
            	String line = cin.nextLine();
                String[] tokens = line.split(",");
            	String name = tokens[0];
            	double price = Double.parseDouble(tokens[1]);
                String art_pur_date = tokens[2];
                String art_date_sold = tokens[3];
                String art_buyer_name = tokens[4];
                String Art_Artist_Name = tokens[5];
                at = new Artwork(name, price,art_pur_date,art_date_sold,art_buyer_name,Art_Artist_Name);
                ArtworkList.add(at);
            }
           
		}
		else
		{
			System.out.println("error: File not found");
		}
		cin.close();
		//
		
		
		//turn array list to an array of objects
		int count = ArtworkList.size();
		Artwork [] list = new Artwork[count];
		for(int i =0; i < getNumberOfArtwork(); i++)
		{
			list[i] = ArtworkList.get(i);
		}
		//
		
		
		//change the name that user want to modify from parameter to have no blank space and all to lower case
		Scanner changed_artwork_name = new Scanner(Artwork_name);
		String modified_artwork_name = "";
		
		while(changed_artwork_name.hasNext())
		{
			modified_artwork_name += changed_artwork_name.next();
		}
		
		modified_artwork_name = modified_artwork_name.toLowerCase();
		//
		
		
		
		int index = -1;
		for(int i = 0 ; i < count;i++)
		{
			//change the name that user want to modify from txt file to have no blank space and all to lower case
			String txt_artwork_title = list[i].getTitle();
			Scanner change_txt_artwork_title = new Scanner(txt_artwork_title);
			String modified_change_txt_artwork_title = "";
			while(change_txt_artwork_title.hasNext())
			{
				modified_change_txt_artwork_title += change_txt_artwork_title.next();
			}
			modified_change_txt_artwork_title = modified_change_txt_artwork_title.toLowerCase();
			//
			
			
			//if this is true, we get the specified artwork object
			if(modified_change_txt_artwork_title.equals(modified_artwork_name))
			{
				index = i;
				break;
			}
			//
			
			
		}
		
		if(index != -1)
		{
			System.out.println("Which data of the artwork you want to modify?");
			Scanner cin_choose_modify = new Scanner(System.in);
			
			boolean quit = false;
			while(quit != true)
			{
				System.out.println("1. Modify Artwork title.");
				System.out.println("2. Modify Price.");
				System.out.println("3. Modify Artwork Purchase Date.");
				System.out.println("4. Modify Artwork's Date Sold.");
				System.out.println("5. Modify Artwork buyer");
				System.out.println("6. Modify Artwork's artist name.");
				System.out.println("7. return");
				int choice = cin_choose_modify.nextInt();
				
				Scanner in_new_data = new Scanner(System.in);
				switch(choice)
				{
				case 1:
					System.out.println("New artwork title?");
					String new_title = in_new_data.nextLine();
					list[index].setTitle(new_title);
					break;
				case 2:
					System.out.println("New artwork price?");
					double new_price = in_new_data.nextDouble();
					list[index].setPrice(new_price);
					break;
				case 3:
					System.out.println("New artwork purchase date?");
					String new_pur_dat = in_new_data.nextLine();
					list[index].setDatePurchase(new_pur_dat);
					break;
				case 4:
					System.out.println("New artwork's date sold?");
					String new_dat_sol = in_new_data.nextLine();
					list[index].setbuyername(new_dat_sol);;
					break;
				case 5:
					System.out.println("New artwork buyer");
					String new_art_buy = in_new_data.nextLine();
					list[index].setbuyername(new_art_buy);
					break;
				case 6:
					System.out.println("New artwork artist?");
					String new_artw_arti= in_new_data.nextLine();
					list[index].setArtistName(new_artw_arti);
					break;
				case 7:
					quit = true;
					break;
				default:
					break;
				}
			}
			
		}
		
		
		//Override the artwork file with a new artwork data from an array of objects
		pw = new PrintWriter("C:\\Users\\60167\\Desktop\\Assignment\\artwork.txt");
		
		for(int i = 0;i < list.length;i++)
		{
			pw.println(list[i].getTitle()+ "," + list[i].getPrice() + "," + list[i].getDatePurchase() + "," + list[i].getDateSold()+ "," + list[i].getbuyername()+ "," + list[i].getArtistName());
		}
		pw.close();
		//
	}
	
	
	
	

}
