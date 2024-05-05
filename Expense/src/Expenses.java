import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.text.NumberFormat;
import javax.swing.JButton;


/*******************************************************************************
'Project: Expense
'Programmer: Karvel T Washington 
'Date: 11 02 2024 
'    
'   This program is meant to add expense from user and output total
	The program should save/store user input 
	This program should also have error handling if input is less than 0 
'
'
0........1.........2.........3.........4.........5.........6.........7.........8
12345678901234567890123456789012345678901234567890123456789012345678901234567890
*/



public class Expenses extends JFrame implements ActionListener  {
	
	
	
	//Label for expense
	JLabel ExpenseLabel = null; 
	//Label for total 
	JLabel TotalLabel = null;
	//Text Field for Expense 
    JTextField ExpenseField = null;
	//Text Field for Total
	JTextField TotalField = null;
	//Button for calculation of expenses  
	JButton Calc = null;
	 //parameter to keep running totals 
	static double  total =0;
	  
	
	
	
	  public Expenses() {
		  
		  setTitle("Expense");
		  
		  //Creates Label for Expenses and Totals 
		  GridBagConstraints layoutConst = null;
		  
		  ExpenseLabel = new JLabel("Expenses");
		  TotalLabel = new JLabel("Total");
		  
		  //specifies label for Expenses
		  ExpenseField = new JTextField(5);
		  ExpenseField.setEditable(true);
		  ExpenseField.setText("");
		  
		  //specifies label for total
		  TotalField = new JTextField(5);
		  TotalField.setEditable(true);
		  TotalField.setText("");
		  
		 
		  
		 //creates GridBagLayout for readability 
	      setLayout(new GridBagLayout());
	      layoutConst = new GridBagConstraints();
	      
	      //creates Calculation button and position on bottom
	      Calc = new JButton("Calculate");
	      Calc.addActionListener(this);
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 35;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(Calc, layoutConst);
	      

	      // Specify component's grid location
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 0;

	      // 10 pixels of padding around component
	      layoutConst.insets = new Insets(10, 10, 10, 10);

	      // Add component using the specified constraints
	      add(ExpenseLabel, layoutConst);
	      
	      //Add totalLabel at  0,20
	      layoutConst.gridx = 0;
	      layoutConst.gridy = 20;
	      add(TotalLabel,layoutConst);

	      //Adds ExpenseField at 1,0
	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 1;
	      layoutConst.gridy = 0;
	      layoutConst.insets = new Insets(10, 10, 10, 10);
	      add(ExpenseField, layoutConst);
	      
	      //Adds TotalField at 1,20
	      layoutConst = new GridBagConstraints();
	      layoutConst.gridx = 1;
	      layoutConst.gridy = 20;
	      layoutConst.insets = new Insets(10, 20, 10, 20);
	      add(TotalField, layoutConst);
	  }
	      
	      @Override
	      public void actionPerformed(ActionEvent event) {
	    	  
	    	  //String that will get textField
	    	  String userInput;
	    	  
	    	  //double that will hold  userInput 
	    	  double expense; 
	    	  
	    	  //Get user input from field 
	          userInput = ExpenseField.getText();
	          
	          //convert user input  to double  
	          expense = Double.parseDouble(userInput);
	          
	          // statement runs if expense is greater than 0 
	          if(expense >0 ) {
	          
	          //Add previous input to static total
	          total = total + expense;
	          
	          //display to TotalField 
	          TotalField.setText(Double.toString(total));
	          }
	          else {
	        	  
	        	  //displays if input is less than 0
	        	  JOptionPane.showMessageDialog(this, "Enter a positive value!");
	          
	          }
	            
	            
	     
	          
		
	  
	  }
	  
	  
		   public static void main(String[] args) {
			   
			   Expenses myFrame = new Expenses();

			      myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			      myFrame.pack();
			      myFrame.setVisible(true);
			 
			   
		     
		   }
	  }
	  
