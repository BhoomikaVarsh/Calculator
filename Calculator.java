package calci;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class Calculator implements ActionListener, MouseListener
{
	static JFrame f;
	static JPanel p;
	static JTextField tf;
	static 	JButton pow;
	static JButton b[]= new JButton[10];
	static JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, bclr, beq, bdec; 
	static String str[]={"1","2","3","4","5","6","7","8","9","0"};
	int status = 0;
	String s1,s0,s2;

	
	//calculator 
	
	Calculator()
	{
		s0=s1=s2="";
    } 
	
		public static void main(String arg[])
	{
		Calculator c= new Calculator();
		
		JTabbedPane ta;
		ta= new JTabbedPane();
		JFrame f = new JFrame("Calculator");
		JPanel p = new JPanel();
		ta.add("calculator",p);
		f.add(ta);
		p.setLayout(null);
		//textfiald
		tf= new JTextField(20);
		tf.setBounds(30,10,180,50);
		tf.setEditable(false);
		tf.setHorizontalAlignment(JTextField.RIGHT);
		tf.setFont(new Font("algerian",Font.BOLD,22));
		tf.setBackground(Color.white);
		pow= new JButton("Power");
		pow.addMouseListener(c);
		pow.setBounds(40,100,80,20);
		p.add(pow);
		int x=40,y=100,l=50,h=20;
		for(int i=0;i<b.length;i++)
		{
			b[i]= new JButton(str[i]);
			if(i%3==0)
			{
				x=40;
				y=y+h+10;
				
			}
						 
			b[i].setBounds(x,y,l,h);
			b[i].setEnabled(false);
			b[i].setToolTipText(str[i]);
			x=x+l+10;
			b[i].addActionListener(c); 
			p.add(b[i]);
		}
		// create operator buttons
		beq = new JButton("=");  
		ba = new JButton("+"); 
		bs = new JButton("-"); 
		bd = new JButton("/"); 
		bm = new JButton("*"); 
		bclr = new JButton("C"); 
		bdec = new JButton(".");
		
		//setbounds
		bclr.setBounds(140,100,60,20);
		ba.setBounds(100,220,50,20); 
		bs.setBounds(160,220,50,20); 
		bm.setBounds(40,250,50,20); 
		bd.setBounds(100,250,50,20); 
		bdec.setBounds(160,250,50,20); 
		beq.setBounds(40,280,50,20); 
		
				//Enabled
				ba.setEnabled(false);
				bs.setEnabled(false);
				bd.setEnabled(false);
				bm.setEnabled(false);
				beq.setEnabled(false);
				bdec.setEnabled(false);
				bclr.setEnabled(false);
				
			//actionlistener
		ba.addActionListener(c); 
		bs.addActionListener(c); 
		bd.addActionListener(c); 
		bm.addActionListener(c); 
		bclr.addActionListener(c);
		bdec.addActionListener(c); 
		beq.addActionListener(c); 
		
			//add
				p.add(beq); 
				p.add(ba); 
				p.add(bs);
				p.add(bd);
				p.add(bm);
				p.add(bclr);
				p.add(bdec);
		
				
		p.add(tf);
		f.setSize(250,400);
		f.setLocation(200,100);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

		public void mousePressed(MouseEvent me)
		{
			
		}
		public void mouseReleased(MouseEvent me)
		{
			
		}
		public void mouseClicked(MouseEvent me)
		{
			if(status==0)
			{
			for(int i=0;i<b.length;i++)
			{
				 
				b[i].setEnabled(true);
				pow.setText("Off");
				
			}
			ba.setEnabled(true);
			bs.setEnabled(true);
			bd.setEnabled(true);
			bm.setEnabled(true);
			beq.setEnabled(true);
			bdec.setEnabled(true);
			bclr.setEnabled(true);
			status=1;
			}
			
		else if (status == 1)  
		{
			for(int i=0;i<b.length;i++)
			{
				 
				b[i].setEnabled(false);
				pow.setText("Power");
			}
			ba.setEnabled(false);
			bs.setEnabled(false);
			bd.setEnabled(false);
			bm.setEnabled(false);
			beq.setEnabled(false);
			bdec.setEnabled(false);
			bclr.setEnabled(false);
			status=0;
			}
				
		}
		public void mouseEntered(MouseEvent me)
		{
		}
		public void mouseExited(MouseEvent me)
		{		
		}
		public void actionPerformed(ActionEvent ae) 
		{ 
			String s = ae.getActionCommand(); 

			if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.')
			{ 
				
				if (!s1.equals("")) 
					s2 = s2 + s; 
				else
					s0 = s0 + s; 

				tf.setText(s0 + s1 + s2); 
			} 
			else if (s.charAt(0) == 'C')
			
			{ 
				s0 = s1 = s2 = ""; 

				tf.setText(s0 + s1 + s2); 
			} 
			else if (s.equals("=")) 
			{ 

				double te; 

				if (s1.equals("+")) 
					te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
				else if (s1.equals("-")) 
					te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
				else if (s1.equals("/")) 
					te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
				else
					te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 

				tf.setText(s0 + s1 + s2 + "=" + te); 

				s0 = Double.toString(te); 

				s1 = s2 = ""; 
			} 
			else 
			{ 
				
				if (s1.equals("") || s2.equals("")) 
				{	
					s1 = s; 
				}	
				else
				{ 
					
					double te; 

					 
					if (s1.equals("+")) 
						te = (Double.parseDouble(s0) + Double.parseDouble(s2)); 
					else if (s1.equals("-")) 
						te = (Double.parseDouble(s0) - Double.parseDouble(s2)); 
					else if (s1.equals("/")) 
						te = (Double.parseDouble(s0) / Double.parseDouble(s2)); 
					else
						te = (Double.parseDouble(s0) * Double.parseDouble(s2)); 

					
					s0 = Double.toString(te); 

					 
					s1 = s; 

					s2 = ""; 
				} 

				tf.setText(s0 + s1 + s2); 
			} 
		} 

}