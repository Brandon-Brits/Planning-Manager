import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class SearchResult implements ActionListener{
	JFrame frame, frame1;
	JTextField textbox;
	JLabel label;
	JButton button;
	JPanel panel;
	static JTable table;
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/record";
	String userName = "root";
	String password = "Brit$2212";
	String[] columnNames = {"Sales Order", "Pump", "Customer", "Date"};
	
	public void createUI()
	{
		frame = new JFrame("Sales Order Report");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		textbox = new JTextField();
		textbox.setBounds(120,30,150,20);
		label = new JLabel("Enter Sales Order Number");
		label.setBounds(10, 30, 100, 20);
		button = new JButton("search");
		button.setBounds(120,130,150,20);
		button.addActionListener(this);
		
		
		frame.add(textbox);
		frame.add(label);
		frame.add(button);
		frame.setVisible(true);
		frame.setSize(500, 400);
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		button = (JButton)ae.getSource();
		System.out.println("Showing Table Data......");
		ShowTableData();
	}
	
	public void ShowTableData()
	{
		
		frame1 = new JFrame("Sales Order Search Result");
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setLayout(new BorderLayout());
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scroll.setVerticalScrollBarPolicy(
						JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				String textvalue = textbox.getText();
				String so = "";
				String pump = "";
				String cus = "";
				String date = "";
				
				try
				{
					Class.forName(driverName);
					Connection con = DriverManager.getConnection(url, userName, password);
					String sql = "select * from sonum where SalesOrder = "+textvalue;
					PreparedStatement ps = con.prepareStatement(sql);
					ResultSet rs = ps.executeQuery();
					int i = 0;
					if(rs.next())
					{
						so = rs.getString("SalesOrder");
						pump = rs.getString("Pump");
						cus = rs.getString("Customer");
						date = rs.getString("Date");
						model.addRow(new Object[] {so, pump, cus, date});
						i++;
					}
					if(i<1)
					{
						JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
					}
					if(i==1)
					{
						System.out.println(i + " Record Found");
					}
					else
					{
						System.out.println(i + " Records Found");
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				frame1.add(scroll);
				frame1.setVisible(true);
				frame1.setSize(400, 300);
	}
	
	public static void main(String args[])
	{
		SearchResult sr = new SearchResult();
		sr.createUI();
	}
	
}
