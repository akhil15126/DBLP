import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.*;
import java.awt.event.*;
import javax.swing.*;
/**
*Base class to handle GUI
*/
public class myGUI {
	protected JFrame frame;
	protected JTextField nameortagtext, sincetext, rangel, ranger, q2text, q3yeartext, a1text, a2text, a3text, a4text, a5text ;
	protected JTable table, mytable;
	protected JLabel lblNewLabel,resulttext,q2label, resultlabel, dblplabel,label,rangelabel, q3year,a1,a2,a3,a4,a5,dash,yearlabel, nameortag;
	protected JPanel panel;
	protected JRadioButton bydaterev, inbetweenyear, byrelevence, yearbutton;
	protected JComboBox myCombo, comboBox;
	protected JButton nextbutton, submit, reset;
	protected ButtonGroup bg;
///Method to set basic frame properties
	protected void setbasic(){
		frame = new JFrame();
		frame.setBounds(800, 800, 1350, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resulttext = new JLabel("No. of results returned - ");
		resultlabel = new JLabel("");
		resulttext.setVisible(false);
		resultlabel.setVisible(false);
		panel = new JPanel();
		lblNewLabel = new JLabel("                            ");
		nextbutton = new JButton("NEXT");
		nextbutton.setVisible(false);
		dblplabel = new JLabel("DBLP QUERY ENGINE");
		dblplabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		submit = new JButton("SUBMIT");
		submit.setEnabled(false);
		table = new JTable();
		mytable = new JTable(new DefaultTableModel(new Object[]{"Column1", "Column2", "Column3", "Column4","Column5", "Column6", "Column7","Column8"}, 0));
		mytable.setRowHeight(25);
		TableColumnModel columnModel = mytable.getColumnModel();
		columnModel.getColumn(0).setWidth(10);
		columnModel.getColumn(1).setWidth(20);
		columnModel.getColumn(2).setWidth(20);
		columnModel.getColumn(3).setWidth(20);
		columnModel.getColumn(4).setWidth(50);
		columnModel.getColumn(5).setWidth(30);
		columnModel.getColumn(6).setWidth(20);
		columnModel.getColumn(7).setWidth(30);
		reset = new JButton("RESET");
		label = new JLabel("------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		String[] mycombo={"Queries","Query1","Query2","Query3"};
		myCombo = new JComboBox(mycombo);
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Choose one", "Search By Author", "Search By Title Tags"}));
		comboBox.setVisible(false);
		rangelabel = new JLabel("Custom Range");
		q3year = new JLabel("Enter year");
		q3yeartext = new JTextField();
		q3yeartext.setColumns(10);
		q3year.setVisible(false);
		q3yeartext.setVisible(false);
		a1 = new JLabel("Author 1");
		a2 = new JLabel("Author 2");
		a3 = new JLabel("Author 3");
		a4 = new JLabel("Author 4");
		a5 = new JLabel("Author 5");
		a1text = new JTextField();
		a1text.setColumns(10);
		a2text = new JTextField();
		a2text.setColumns(10);
		a3text = new JTextField();
		a3text.setColumns(10);
		a4text = new JTextField();
		a4text.setColumns(10);
		a5text = new JTextField();
		a5text.setColumns(10);
		a1.setVisible(false);
		a2.setVisible(false);
		a3.setVisible(false);
		a4.setVisible(false);
		a5.setVisible(false);
		a1text.setVisible(false);
		a2text.setVisible(false);
		a3text.setVisible(false);
		a4text.setVisible(false);
		a5text.setVisible(false);
		rangel = new JTextField();
		rangel.setColumns(10);
		ranger = new JTextField();
		ranger.setColumns(10);
		dash = new JLabel("-");
		yearlabel = new JLabel("Since Year");
		sincetext = new JTextField();
		sincetext.setColumns(10);
		yearlabel.setVisible(false);
		sincetext.setVisible(false);
		rangel.setVisible(false);
		reset.setVisible(false);
		submit.setVisible(false);
		ranger.setVisible(false);
		rangelabel.setVisible(false);
		dash.setVisible(false);
		nameortag = new JLabel("Name/Tag");
		nameortagtext = new JTextField();
		nameortagtext.setColumns(10);
		nameortagtext.setVisible(false);
		nameortag.setVisible(false);
		bydaterev = new JRadioButton("Sort By Date(Reverse)");
		bydaterev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submit.setEnabled(true);
				yearlabel.setVisible(false);
				sincetext.setVisible(false);
				rangel.setVisible(false);
				ranger.setVisible(false);
				rangelabel.setVisible(false);
				dash.setVisible(false);}});
		byrelevence = new JRadioButton("Sort By Relevance");
		byrelevence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			submit.setEnabled(true);
			yearlabel.setVisible(false);
			sincetext.setVisible(false);
			rangel.setVisible(false);
			ranger.setVisible(false);
			rangelabel.setVisible(false);
			dash.setVisible(false);}});
		yearbutton = new JRadioButton("Since some year");
		yearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearlabel.setVisible(true);
				sincetext.setVisible(true);
				submit.setEnabled(true);
				rangel.setVisible(false);
				ranger.setVisible(false);
				rangelabel.setVisible(false);
				dash.setVisible(false);}});
		inbetweenyear = new JRadioButton("In Between years");
		inbetweenyear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rangelabel.setVisible(true);
				rangel.setVisible(true);
				ranger.setVisible(true);
				yearlabel.setVisible(false);
				sincetext.setVisible(false);
				dash.setVisible(false);
				dash.setVisible(true);
				submit.setEnabled(true);}});
		bg =new ButtonGroup();
		bg.add(inbetweenyear);
		bg.add(yearbutton);
		bg.add(byrelevence);
		bg.add(bydaterev);
		inbetweenyear.setVisible(false);
		yearbutton.setVisible(false);
		byrelevence.setVisible(false);
		bydaterev.setVisible(false);
		q2label = new JLabel("No. of publications");
		q2text = new JTextField();
		q2text.setColumns(10);
		q2label.setVisible(false);
		q2text.setVisible(false);}
///Setting visibility of all non essential elements to false
	protected void setvisibility(){
		nextbutton.setVisible(false);
		q2label.setVisible(false);
		q2text.setVisible(false);
		resulttext.setVisible(false);
		resultlabel.setVisible(false);
		a1.setVisible(false);
		a2.setVisible(false);
		a3.setVisible(false);
		a4.setVisible(false);
		a5.setVisible(false);
		q3year.setVisible(false);
		q3yeartext.setVisible(false);
		a1text.setVisible(false);
		a2text.setVisible(false);
		a3text.setVisible(false);
		a4text.setVisible(false);
		a5text.setVisible(false);
		comboBox.setVisible(false);
		rangelabel.setVisible(false);
		rangel.setVisible(false);
		ranger.setVisible(false);
		yearlabel.setVisible(false);
		sincetext.setVisible(false);
		dash.setVisible(false);
		submit.setVisible(false);
		submit.setEnabled(false);
		reset.setVisible(false);
		nameortag.setVisible(false);
		nameortagtext.setVisible(false);
		inbetweenyear.setVisible(false);
		yearbutton.setVisible(false);
		byrelevence.setVisible(false);
		bydaterev.setVisible(false);
}}





