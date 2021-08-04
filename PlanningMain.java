import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.swing.*;

public class PlanningMain {
	public static void main(String[] args) throws FileNotFoundException{
		//Try and Catch
		try {

			String stest = null;
			char option = JOptionPane.showInputDialog("What Would You Like To Do?: \nA) Add a Sales Order \nB) Edit \nC) Finalize A Project \nD) Check Outdated Projects \nE) Find A Certain Project \nF) Outstanding Parts \nG) Summary \n Q) Exit").toUpperCase().charAt(0);


		if (option != 'Q') {

			if (option == 'A'){
				String sonum = JOptionPane.showInputDialog("Sales Order Info!\n Enter Sales Order Number: ");
				String pump = JOptionPane.showInputDialog("Enter Pump Name: ");
				String customer = JOptionPane.showInputDialog("Enter Customer and Shaft Name: ");
				String Suction = JOptionPane.showInputDialog("Enter the quantity needed:\n Suction Cover: ");
				String Delivery = JOptionPane.showInputDialog("Enter the quantity needed:\n Delivery Cover: ");
				String Chamber = JOptionPane.showInputDialog("Enter the quantity needed:\n Stage Casings: ");
				String BRGDE = JOptionPane.showInputDialog("Enter the quantity needed:\n Bearing Housing Drive-End: ");
				String BRGNDE = JOptionPane.showInputDialog("Enter the quantity needed:\n Bearing Housing Non-Drive-End: ");

				System.out.println("Sales Order Added! Sales Order = " + sonum);
			}
		}

	}catch (Exception e) {
///Catch Error Message
		System.out.println("Error!!!");
	
	}
}
}
