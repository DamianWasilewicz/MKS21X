import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JButton b;
    private JLabel l;
    private JTextField t;
    private JCheckBox cf;
    private JCheckBox fc;
    public TemperatureWindow(){
	this.setTitle("Temperature Converter");
	this.setSize(500,100);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("Convert Temp");
        l = new JLabel("Convert that Temperature!");
	t = new JTextField(4);
	cf = new JCheckBox("C to F");
	fc = new JCheckBox("F to C");
  b.addActionListener(this);
  t.addActionListener(this);
  cf.addActionListener(this);
  fc.addActionListener(this);
	pane.add(b);
	pane.add(l);
	pane.add(t);
	pane.add(cf);
	pane.add(fc);
    }
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event);
  try{
	if(event.equals("Convert Temp")){
    if(cf.isSelected() && fc.isSelected()){
      System.out.println("You can't have both checkboxes selected, silly billy");
      System.exit(1);
    }
	    if(cf.isSelected()){
		t.setText("" + ((double)((((Integer.parseInt(t.getText())) * 9)/5) + 32)));
  }
  if(fc.isSelected()){
    t.setText("" + ((double)((((Integer.parseInt(t.getText())) - 32)*5)/9)));
  }
}
}catch(IllegalArgumentException ex){
  System.out.println("You must put in a number, silly");
}
}
public static void main(String[] args){
  TemperatureWindow g = new TemperatureWindow();
  g.setVisible(true);
}
}
