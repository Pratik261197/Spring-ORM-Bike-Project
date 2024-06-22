package com.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.java.dao.BikeDAO;
import com.java.entities.Bike;
import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext ctx=new ClassPathXmlApplicationContext("Config.xml");
        BikeDAO bikeDAO=ctx.getBean("bikeDAO",BikeDAO.class);
        
       BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
       boolean itr=true;
       while(itr)
       {
    	   System.out.println("****************************************");
    	   System.out.println("Press 1::Add New Bike");
    	   System.out.println("Press 2::Display All Bikes");
    	   System.out.println("Press 3::Get Bike Number");
    	   System.out.println("Press 4::Delete Bike");
    	   System.out.println("Press 5::Update Bike");
    	   System.out.println("Press 6::Exit");
    	   
       try {
    	   System.out.println("Enter Choice:");
    	   int choice=Integer.parseInt(bufferedReader.readLine());
    	   switch (choice) {
		case 1:
			Bike bike=createBikeObject();
			if(bikeDAO.insertBike(bike)>0) {
				System.out.println("New Bike Add Successfully with Data:"+display(bike));
			}
			else
			{
				System.out.println("New Bike Not Add Successfully with Data:"+display(bike));
			}
			break;
		case 2:
			for (Bike b:bikeDAO.getAll()) {
				display(b);
			}
			break;
		case 3:
	        System.out.println("Enter Bike Number to fetch Data :");
	        int bikeNo=Integer.parseInt(bufferedReader.readLine());
	        display(bikeDAO.getByNumber(bikeNo));
			break;
		case 4:
			System.out.println("Enter Bike Number to Delete Data :");
	        int bikeNos=Integer.parseInt(bufferedReader.readLine());
	        bikeDAO.deleteBikeByNumber(bikeNos);
	        System.out.println("Deleted:");
			break;
		case 5:
			System.out.println("Enter Bike Number to fetch Data :");
	        int bikeNum=Integer.parseInt(bufferedReader.readLine());
	        Bike bikeObjToUpdate=bikeDAO.getByNumber(bikeNum);
	        
	        Bike updateBikeObj=updateBike(bikeObjToUpdate);
	        bikeDAO.updateBikeByNumber(updateBikeObj);
	        System.out.println("Updated:"+bikeDAO.getByNumber(bikeNum));
			break;
		case 6:
	        itr=false;
			break;
	
		default:
			break;
		}
    	   
		
	} catch (Exception e) {
	       System.out.println("Invalid Input..");
	       System.out.println("Error::"+e.getMessage());
	}
    	   
    }
       
       System.out.println("Thank you for using this application,Please visit again..");
       
  }

	private static Bike updateBike(Bike bikeObjToUpdate) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bike Model:");
		String model=sc.nextLine();
		System.out.println("Enter Bike Company:");
		String company=sc.nextLine();
		System.out.println("Enter Bike isDualABS:Y or N");
		String isDABS=sc.nextLine();
		Boolean flag=true;
		if(isDABS.equalsIgnoreCase("Y"))
			flag=true;
		else if(isDABS.equalsIgnoreCase("N"))
			flag=false;
		
		System.out.println("Enter Bike Price:");
		double price=sc.nextDouble();
		return new Bike(bikeObjToUpdate.getBikeNumber(),model,company,flag,price);
	
	}

	private static String display(Bike bike) {
		
		System.out.println("********************");
		System.out.println("Bike Number:"+bike.getBikeNumber());
		System.out.println("Bike Model:"+bike.getBikeModel());
		System.out.println("Bike Company:"+bike.getBikeCompany());
		System.out.println("Bike is Dual ABS:"+bike.getIsDualAbs());
		System.out.println("Bike Price:"+bike.getBikePrice());
		return null;
	}

	private static Bike createBikeObject() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Bike Model:");
		String model=sc.nextLine();
		System.out.println("Enter Bike Company:");
		String company=sc.nextLine();
		System.out.println("Enter Bike isDualABS:Y or N");
		String isDABS=sc.nextLine();
		Boolean flag=true;
		if(isDABS.equalsIgnoreCase("Y"))
			flag=true;
		else if(isDABS.equalsIgnoreCase("N"))
			flag=false;
		
		System.out.println("Enter Bike Price:");
		double price=sc.nextDouble();
		return new Bike(model,company,flag,price);
	
	}
    
    
}
