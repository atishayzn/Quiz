
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Quiz extends JFrame implements Runnable {
	JPanel p1,inputPanel,centerPanel,buttonPanel;
	JLabel L1;
	JRadioButton r0,r1,r2,r3;
	ButtonGroup grp;
	JButton b1,b2;
	Thread th1;
	
	String Name;
	int cnt=0;
	int Marks=0;
	String uAns="";
	
	String q[]= {"Q1.What is the capital of Madhya pradesh ? ",
			"Q2. What is the capital of Uttar pradesh ? ",
			"Q3. What is the capital of Gujrat ? ",
			"Q4. What is the capital of Rajasthan ? ",
			"Q5. What is the capital of Maharashtra ? "};
	
	String choice[][]= {
			{"A.Gwalior","B.Indore","C.Jabalpur","D.Bhopal"},
			{"A.Banaras","B.Lucknow","C.Allahabad","D.Azamgarh"},
			{"A.Surat","B.Ahmedabad","C.Gandhi Nagar","D.Varodra"},
			{"A.Ajmer","B.Udaipur","C.Kota","D.Jaipur"},
			{"A.Mumbai","B.Nagpur","C.Pune","D.Thane"}
	};
	String ans[] = {"D","B","C","D","A"}; 
	boolean chk;
public Quiz()
{
	setVisible(true);
	setSize(400,400);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	th1 = new Thread(this);
	th1.start();
	p1 = new JPanel();
	inputPanel = new JPanel();
	centerPanel = new JPanel();
	buttonPanel = new JPanel();

   L1 = new JLabel();
   r0 =new JRadioButton();
   r1 =new JRadioButton();
   r2 =new JRadioButton();
   r3 =new JRadioButton();
   grp = new ButtonGroup();
   b1 = new JButton("Next");
   b2 = new JButton("Cancel");
   grp.add(r0);grp.add(r1);
   grp.add(r2);grp.add(r3); 
   
   p1.setLayout(new BorderLayout());
   inputPanel.add(L1);
   p1.add(inputPanel,"North");
   centerPanel.setLayout(new GridLayout(4,1));
   centerPanel.add(r0); centerPanel.add(r1); centerPanel.add(r2);
   centerPanel.add(r3);
   p1.add(centerPanel,"Center");
   buttonPanel.add(b1);
   buttonPanel.add(b2);
   p1.add(buttonPanel,"South");
   
   getContentPane().add(p1);
   p1.setBorder(BorderFactory.createTitledBorder("Quiz"));
   centerPanel.setBorder(BorderFactory.createTitledBorder("Options"));
   buttonPanel.setBorder(BorderFactory.createTitledBorder("Controls"));
   
	 b1.addActionListener(e->actionB1(e));
	 b2.addActionListener(e->actionB2(e));

	 Name = JOptionPane.showInputDialog(null,"Enter Name:");
	 setTitle("Canditate Name:"+Name);
	 showQ();
	 
}
public void run() {
	for(int i=60;i<=60;i++) {
		try {
			setTitle("Candidate Name"+Name+"Reamaining time:"+i+"Seconds");
			th1.sleep(1000);
		}
		catch(Exception ex){
			
		}
	}
}
public void showQ(){
	L1.setText(q[cnt]);
	r0.setText(choice[cnt][0]);
	r1.setText(choice[cnt][1]);
	r2.setText(choice[cnt][2]);
	r3.setText(choice[cnt][3]);
	grp.clearSelection();
}
public void result() {
  	if(r0.isSelected()) {
  		uAns="A";
  	}
  	else if(r1.isSelected()) {
  		uAns="B";
  	}
  	else if(r2.isSelected()) {
  		uAns="C";
  	}
  	else if(r3.isSelected()) {
  		uAns="D";
  	}
	else {
		JOptionPane.showMessageDialog(this, "Choose ans");
		chk= true;
		return;
	}
	if(uAns.equals(ans[cnt])) {
		Marks++;
	   JOptionPane.showMessageDialog(this,"Correct ans");
	}
	else {
		JOptionPane.showMessageDialog(this,"Incorrect ans");
	}
}
public void actionB1(ActionEvent e){
	if(b1.getText().contentEquals("Next")) {
		if(cnt<3) {
		result();
		if(chk==false)
		cnt++;
		showQ();
		}
	
	else {
		result();
		if(chk==false)
		cnt++;
		showQ();
		b1.setText("Finish");
	}}
	else {
		result();
		String msg = "Dear"+Name+"\n"+"Your marks is"+Marks+" out of 5.";
		JOptionPane.showMessageDialog(null, msg);
		System.exit(0);
	}
}	
	public void actionB2(ActionEvent e){
	System.exit(0);
}
public static void main (String args[]) {
	  new Quiz();
}
}
