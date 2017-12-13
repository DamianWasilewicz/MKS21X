import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TemperatureWindow extends JFrame implements ActionListener{
    private Container pane;
    private JButton b;
    private JLabel l;
    private JTextField t;
    private JCheckBox cf;
    private JCheckbox fc;
    public TemperatureWindow(){
	this.setTitle("Temperature Converter");
	this.setSize(500,500);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout());

	b = new JButton("Convert Temp");
        l = new JLabel("Conver that Temperature!");
	t = new JTextField(4);
	cf = new JCheckBox("C to F");
	fc = new JCheckBox("F to C");
	pane.add(b);
	pane.add(l);
	pane.add(t);
	pane.add(cf);
	pane.add(fc);
    }
    public void actionPerformed(ActionEvent e){
	String event = e.getActionCommand();
	System.out.println(event);
	if(event.equals.("Convert Temp")){
	    if(cf.isSelected()){
		t.setText(
