import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class RosterController extends JPanel implements ActionListener{

	protected JTextField nameEntry = new JTextField();
	protected JButton addBTN = new JButton("ADD");
	protected JButton dropBTN = new JButton("Drop");
	protected JTextArea WaitListArea = new JTextArea();
	protected JTextArea RosterArea = new JTextArea();
	protected JLabel roster= new JLabel("Roster");
	protected JLabel waitlist = new JLabel("WaitList");
	public DoublyLinkedList<String> enrolledStudents = new DoublyLinkedList<String>();
	public DoublyLinkedList<String> waitingStudents = new DoublyLinkedList<String>();
	static final int MAX_ENROLL = 10;
	static final int MAX_WAIT = 10;
	JPanel topBar = new JPanel();
	
	
	public RosterController() {
		super();
		setLayout(new GridLayout(3, 2));
		addBTN.addActionListener(this);
		dropBTN.addActionListener(this);
		setLook();
	}
	
	public void setLook(){
		nameEntry.setSize(500, 200);
		add(nameEntry);
		topBar.add(addBTN);
		topBar.add(dropBTN);
		add(topBar);
		add(roster);
		add(waitlist);
		add(RosterArea);
		add(WaitListArea);
	}
	
	public void addName(){
		String name =  nameEntry.getText();
		System.out.println(name);
//		if (enrolledStudents.getSize()<MAX_ENROLL) {
//			enrolledStudents.insertFirst(name);
//			roster.add(new JLabel(name), -1);
//		}
		enrolledStudents.insertFirst(name + "\n");
		RosterArea.setText(enrolledStudents.toString());
	}
	
	public void dropName(){
		String name = nameEntry.getText();
		
	}

	

	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==addBTN){
			addName();
		}
		if (e.getSource()==dropBTN){
			dropName();
		}
		
	}
	
}
