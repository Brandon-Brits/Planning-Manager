import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.time.LocalDate;

public class PlanningMain {
	public static void main(String[] args) throws FileNotFoundException{
		//Try and Catch
		try {
			
			DatabaseManager dblink= new DatabaseManager();

			String stest = null;
			char option = JOptionPane.showInputDialog("What Would You Like To Do?: \nA) Add a Sales Order \nB) Update \nC) Finalize A Project \nD) Check Outdated Projects \nE) Find A Certain Project \nF) Outstanding Parts \nG) Summary \n Q) Exit").toUpperCase().charAt(0);


		if (option != 'Q') {

			if (option == 'A'){
				String sonum = JOptionPane.showInputDialog("Sales Order Info!\n Enter Sales Order Number: ");
				String pump = JOptionPane.showInputDialog("Enter Pump Name and Stages: ");
				String customer = JOptionPane.showInputDialog("Enter Customer and Shaft Name: ");
				String Suction = JOptionPane.showInputDialog("Enter the quantity needed:\n Suction Cover: ");
				String Delivery = JOptionPane.showInputDialog("Enter the quantity needed:\n Delivery Cover: ");
				String Chamber = JOptionPane.showInputDialog("Enter the quantity needed:\n Stage Casings: ");
				String BRGDE = JOptionPane.showInputDialog("Enter the quantity needed:\n Bearing Housing Drive-End: ");
				String BRGNDE = JOptionPane.showInputDialog("Enter the quantity needed:\n Bearing Housing Non-Drive-End: ");
				
				dblink.Insert(sonum, pump, customer, Suction, Delivery, Chamber, BRGDE, BRGNDE);
				System.out.println("Sales Order Added! Sales Order = " + sonum);
			}
//Other Options
			if (option == 'B')
			{
				char option2 = JOptionPane.showInputDialog("What Would You Like To Update: \nA) Suction Cover \nB) Delivery Cover \nC) Stage Casings \nD)Bearing Housing Drive-End \nE)Bearing Housing Non-Drive-End \nQ) Exit").toUpperCase().charAt(0); 
			}
				if (option2 != 'Q')
				{
					String SuctionCover = "SuctionCover";
					String UpdateSuction = JOptionPane.showInputDialog("Enter the updated quantity: ");
					int snum = Integer.parseInt(JOptionPane.showInputDialog("Enter the SO Number: "));
					dblink.Update(SuctionCover, UpdateSuction, snum);
				}
		}

	}catch (Exception e) {
///Catch Error Message
		System.out.println("Error!!!");
	
	}
}
}
