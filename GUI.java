import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import javax.swing.*;
public class GUI {
	private JFrame frame;
	private JTextField nameortagtext, sincetext, rangel, ranger, q2text, q3yeartext, a1text, a2text, a3text, a4text, a5text ;
	private JTable table, mytable;
	private JLabel lblNewLabel,resulttext,q2label, resultlabel, dblplabel,label,rangelabel, q3year,a1,a2,a3,a4,a5,dash,yearlabel, nameortag;
	private JPanel panel;
	private JRadioButton bydaterev, inbetweenyear, byrelevence, yearbutton;
	private JComboBox myCombo, comboBox;
	private JButton nextbutton, submit, reset;
	private ButtonGroup bg;
	public static void main(String[] args) {
		GUI window=new GUI();
		window.frame.setVisible(true);}
	public GUI() {
		initialize();}
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(800, 800, 1350, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		resulttext = new JLabel("No. of results returned - ");
		resultlabel = new JLabel("Nil");
		resulttext.setVisible(false);
		resultlabel.setVisible(false);
		panel = new JPanel();
		nextbutton = new JButton("NEXT");
		nextbutton.setVisible(false);
		dblplabel = new JLabel("DBLP QUERY ENGINE");
		dblplabel.setFont(new Font("Times New Roman", Font.BOLD, 17));
		submit = new JButton("SUBMIT");
		submit.setEnabled(false);
		table = new JTable();
		mytable = new JTable(new DefaultTableModel(new Object[]{"Column1", "Column2", "Column3", "Column4","Column5", "Column6", "Column7","Column8"}, 0));
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
				dash.setVisible(false);
			}});
		byrelevence = new JRadioButton("Sort By Relevance");
		byrelevence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			submit.setEnabled(true);
			yearlabel.setVisible(false);
			sincetext.setVisible(false);
			rangel.setVisible(false);
			ranger.setVisible(false);
			rangelabel.setVisible(false);
			dash.setVisible(false);
			}});
		yearbutton = new JRadioButton("Since some year");
		yearbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				yearlabel.setVisible(true);
				sincetext.setVisible(true);
				submit.setEnabled(true);
				rangel.setVisible(false);
				ranger.setVisible(false);
				rangelabel.setVisible(false);
				dash.setVisible(false);
			}});
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
				submit.setEnabled(true);
			}});
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
		q2text.setVisible(false);
		myCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=(String)myCombo.getSelectedItem();
				switch(s){
					case "Query1":{
						DefaultTableModel model = (DefaultTableModel) mytable.getModel();
						model.setRowCount(0);
						model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
						setvisibility();
						nextbutton.setVisible(true);
						resulttext.setVisible(true);
						resultlabel.setVisible(true);
						comboBox.setVisible(true);
						submit.setVisible(true);
						reset.setVisible(true);
						nameortag.setVisible(true);
						nameortagtext.setVisible(true);
						inbetweenyear.setVisible(true);
						yearbutton.setVisible(true);
						byrelevence.setVisible(true);
						bydaterev.setVisible(true);
						break;}
					case "Query2":{
						DefaultTableModel model = (DefaultTableModel) mytable.getModel();
						model.setRowCount(0);
						model.addRow(new Object[]{"S.No.", "Authors"});
						setvisibility();
						nextbutton.setVisible(true);
						q2label.setVisible(true);
						q2text.setVisible(true);
						resulttext.setVisible(true);
						resultlabel.setVisible(true);
						submit.setVisible(true);
						submit.setEnabled(true);
						reset.setVisible(true);
						break;}
					case "Query3":{
						DefaultTableModel model = (DefaultTableModel) mytable.getModel();
						model.setRowCount(0);
						model.addRow(new Object[]{"S.No.", "Author", "No. of publications"});
						setvisibility();
						a1.setVisible(true);
						a2.setVisible(true);
						a3.setVisible(true);
						a4.setVisible(true);
						a5.setVisible(true);
						q3year.setVisible(true);
						q3yeartext.setVisible(true);
						a1text.setVisible(true);
						a2text.setVisible(true);
						a3text.setVisible(true);
						a4text.setVisible(true);
						a5text.setVisible(true);
						submit.setVisible(true);
						submit.setEnabled(true);
						reset.setVisible(true);
						break;}}}});
				lblNewLabel = new JLabel("                            ");
				GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
				groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE).addGroup(groupLayout.createSequentialGroup().addComponent(label, GroupLayout.PREFERRED_SIZE, 1344, Short.MAX_VALUE).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(yearbutton).addContainerGap(1211, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(bydaterev).addContainerGap(1180, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(16).addComponent(yearlabel).addPreferredGap(ComponentPlacement.RELATED).addComponent(sincetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(1134, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(16).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(reset).addComponent(submit)).addContainerGap(1244, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(myCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(nameortag).addPreferredGap(ComponentPlacement.RELATED).addComponent(nameortagtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(139).addComponent(lblNewLabel)))).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(byrelevence)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(inbetweenyear)).addGroup(groupLayout.createSequentialGroup().addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(rangel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(dash, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(1).addComponent(ranger, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)).addComponent(rangelabel))).addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(q2label).addPreferredGap(ComponentPlacement.RELATED).addComponent(q2text, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(43).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(q3year).addPreferredGap(ComponentPlacement.RELATED).addComponent(q3yeartext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a3text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a4text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a5text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(285).addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(resulttext).addPreferredGap(ComponentPlacement.RELATED).addComponent(resultlabel))).addPreferredGap(ComponentPlacement.RELATED, 641, Short.MAX_VALUE).addComponent(nextbutton)).addComponent(mytable, GroupLayout.PREFERRED_SIZE, 1004, GroupLayout.PREFERRED_SIZE)).addContainerGap(83, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(542).addComponent(dblplabel).addContainerGap(630, Short.MAX_VALUE)));
				groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(nextbutton).addComponent(resulttext).addComponent(resultlabel)).addGroup(groupLayout.createSequentialGroup().addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(dblplabel).addPreferredGap(ComponentPlacement.RELATED).addComponent(label).addGap(22).addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(myCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(nameortag).addComponent(nameortagtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18).addComponent(inbetweenyear).addPreferredGap(ComponentPlacement.RELATED).addComponent(rangelabel).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rangel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(dash).addComponent(ranger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(9).addComponent(byrelevence).addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(q2label).addComponent(q2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(34).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(yearbutton).addComponent(lblNewLabel)).addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(yearlabel).addComponent(sincetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(30).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(q3year).addComponent(q3yeartext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a1).addComponent(a1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a2).addComponent(a2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a3).addComponent(a3text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a4).addComponent(a4text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a5).addComponent(a5text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 377, Short.MAX_VALUE).addComponent(bydaterev)).addComponent(mytable, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)).addGap(28).addComponent(submit).addPreferredGap(ComponentPlacement.RELATED).addComponent(reset).addGap(18)));
		frame.getContentPane().setLayout(groupLayout);
	}
	private void setvisibility(){
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
}
}
