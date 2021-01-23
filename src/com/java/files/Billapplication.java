package com.java.files;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class Billapplication implements ActionListener {

	JFrame f;
	JTextField tf;
	JLabel[] label;
	JButton b;
	JTable table;
	
	
	public static void main(String[] args) {
		new Billapplication();
	}

	Billapplication(){
		
		f = new JFrame();
		
		label = new JLabel[3];
		for(int i=0;i<label.length;i++) {
			label[i]=new JLabel();
		}
		
	
		tf = new JTextField();
		tf.setBounds(25, 65, 135, 25);
		
		b = new JButton("Calculate");
		b.setBounds(190, 65, 135, 25);
	
		JScrollPane scroll = new JScrollPane(); 
		
		scroll.setBounds(25, 180, 300, 148);
		
		table = new JTable();
		table.setRowHeight(25);
		
		scroll.add(table);
		
		scroll.setViewportView(table);
		
		label[0].setText("Electricity Bill Calculator");
		label[1].setText("No. of Units Consumed");
		label[2].setText("Bill Breakup:");
		
		label[0] .setBounds(100, 0, 150,30);
		label[1].setBounds(25, 35, 200, 25);
		label[2].setBounds(25, 125, 200, 25);
	
		b.addActionListener(this);
		
		f.add(scroll);
		f.add(b);
		f.add(tf);
		for(int i=0;i<label.length;i++) {
			f.add(label[i]);
		}
		
		f.setSize(365, 400);
		f.setLayout(null);
		f.setVisible(true);	
	}


	
	public void actionPerformed(ActionEvent e) {
	
		String s= tf.getText();
		int units  = Integer.parseInt(s);
		BillCalculator b = new BillCalculator();
		float[] bill = b.getBill(units);
		
		String[] amounts = new String[bill.length];
		for(int i=0;i<bill.length;i++) {
			
			amounts[i]=String.valueOf(bill[i]);
		}
		
		String[] charges =
			{"Fixed Charges","Electricity and FAC charges","Wheeling charges","Electricity Tax","Total Bill Amount"};
		
			DefaultTableModel model = new DefaultTableModel(0,0);
		
			model.addColumn("Charges", charges);
			model.addColumn("Amount", amounts);
			table.setModel(model);
		
	}
}
