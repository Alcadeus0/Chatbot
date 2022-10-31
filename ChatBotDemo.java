import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Desktop;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.net.URI;
import java.io.*;

class Chatbot extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea ca= new JTextArea();
	private JTextField cf=new JTextField();                                  
	private JButton b=new JButton();
	private JLabel l=new JLabel();
	
	Chatbot(){                                                // Layout and Properties defined in Constructer                                         
		
		JFrame f=new JFrame();                                     
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);                      
		f.setVisible(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setSize(600,400);
		f.getContentPane().setBackground(Color.cyan);
		f.setTitle("ChatBot");
		f.add(ca);
		f.add(cf);
		ca.setSize(600,310);
		ca.setLocation(1, 1);
		ca.setBackground(Color.BLACK);
		cf.setSize(300,50);
		cf.setLocation(1,320);
		f.add(b);
		l.setText("SEND");
		b.add(l);
		b.setSize(600,50);
		b.setLocation(300,320);
		
		b.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                    Desktop desk = Desktop.getDesktop();
					String text=cf.getText().toLowerCase();
					ca.setForeground(Color.GREEN);
					ca.append("You-->"+text+"\n");
					cf.setText("");
					if(text.contains("home")) {                         // input Checking
						replyMeth("Hello I'm an Educational ChatBot \n\n Reply with 1 if you want help in a subject \n\n Reply with 2 if you want know about different training programs \n\n Reply with 3 if you want to know more about me \n");
					}
					else if(text.contains("1")) {
						replyMeth("Choose a subject: \n\n mathematics \n\n data structures \n\n computer graphics");
					}
                    else if(text.contains("mathematics")) {
						replyMeth("A link will now open");
                        try{
                            desk.browse(new URI("https://www.khanacademy.org/math"));
                        }catch(Exception ie){
                            ie.printStackTrace();;
                        }
					}
                    else if(text.contains("data structures")) {
						replyMeth("A link will now open");
                        try{
                            desk.browse(new URI("https://www.geeksforgeeks.org/data-structures/"));
                        }catch(Exception ie){
                            ie.printStackTrace();;
                        }
					}
                    else if(text.contains("computer graphics")) {
						replyMeth("A link will now open");
                        try{
                            desk.browse(new URI("https://www.javatpoint.com/computer-graphics-tutorial"));
                        }catch(Exception ie){
                            ie.printStackTrace();;
                        }
					}
					else if(text.contains("2")) {
						replyMeth("We currently have a winter training program ongoing. Registrations are available.");
					}
					else if(text.contains("bye")) {
						replyMeth("Too Soon :( AnyWays"+"\n"+"STAY HOME STAY SAFE ");
					}
					else 
						replyMeth("I Can't Understand");
					
				}
							
		});
		
	}
	public void replyMeth(String s) {                          // Reply Method
		ca.append("ChatBot-->"+s+"\n");         
	}
			

}


public class ChatBotDemo {                                     //Driver Class

	public static void main(String[] args) {             //main class
		
          new Chatbot();                                  // instantiation 
	}
}