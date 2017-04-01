import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
public class myGUI2 extends myGUI1 {
	int i;
public myGUI2() {
		initialize();
	}
	private void initialize() {
		setbasic();
		myCombo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=(String)myCombo.getSelectedItem();
				switch(s){
					case "Query1":{
						DefaultTableModel model = (DefaultTableModel) mytable.getModel();
						model.setRowCount(0);
						model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
						case1();						
						break;}
					case "Query2":{
						DefaultTableModel model = (DefaultTableModel) mytable.getModel();
						model.setRowCount(0);
						model.addRow(new Object[]{"S.No.", "Authors"});
						case2();
						break;}
					case "Query3":{
						DefaultTableModel model = (DefaultTableModel) mytable.getModel();
						model.setRowCount(0);
						model.addRow(new Object[]{"S.No.", "Author", "No. of publications"});
						case3();
						break;}}}});
reset.addActionListener(new ActionListener()  {
			public void actionPerformed(ActionEvent e)  {
			frame.dispose();
myGUI2 window=new myGUI2();
		window.frame.setVisible(true);}});
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {nint=0;
int tmpp=checkexceptions();
			if(tmpp==0){
			int opt=0;
			String search;
			if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Title Tags") && byrelevence.isSelected()){
				search=(String)nameortagtext.getText();
				title_search a = new title_search(search);
				a.title_parse();
				mydata = a.getPublications();
				byrelev();}
			else if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Title Tags") && bydaterev.isSelected()){
				search=(String)nameortagtext.getText();
				title_search a = new title_search(search);
				a.title_parse();
				mydata = a.getPublications();
				byrelev();}
			else if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Title Tags") && yearbutton.isSelected()){
				nint=0;
				DefaultTableModel model = (DefaultTableModel) mytable.getModel();
				model.setRowCount(0);
				model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
				search=(String)nameortagtext.getText();
				title_search a = new title_search(search);
				a.title_parse();
				mydata = a.getPublications();
				Collections.sort(mydata);
				int count=0;
				for(int j=0;j<mydata.size();j++)
				if(Integer.parseInt(mydata.get(j).getYear())>=Integer.parseInt(sincetext.getText()))
				count++;
				resultlabel.setText(count+"");
				count=0;
				for(i=0;i<mydata.size()&&count<20;i++)
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(sincetext.getText()))
					model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});
				nextbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)  {nint++;
					model.setRowCount(0);
					model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
					int count=20*nint;
					for(;i<mydata.size()&&count<20*(nint+1);i++)	
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(sincetext.getText()))
					model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});}});}
else if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Title Tags") && inbetweenyear.isSelected()){
				nint=0;
				DefaultTableModel model = (DefaultTableModel) mytable.getModel();
				model.setRowCount(0);
				model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
				search=(String)nameortagtext.getText();
				title_search a = new title_search(search);
				a.title_parse();
				mydata = a.getPublications();
				Collections.sort(mydata);int count=0;
				for(int j=0;j<mydata.size();j++)
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(rangel.getText()) && Integer.parseInt(mydata.get(i).getYear())<=Integer.parseInt(ranger.getText()) )
				count++;
				resultlabel.setText(count+"");count=0;
				for(i=0;i<mydata.size()&&count<20;i++)
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(rangel.getText()) && Integer.parseInt(mydata.get(i).getYear())<=Integer.parseInt(ranger.getText()) )
					model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});
				nextbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)  {nint++;
					model.setRowCount(0);
					model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
					int count=20*nint;
					for(;i<mydata.size()&&count<20*(nint+1);i++)	
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(rangel.getText()) && Integer.parseInt(mydata.get(i).getYear())<=Integer.parseInt(ranger.getText()) )
model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});}});}
else if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Author") && byrelevence.isSelected()){
				search=(String)nameortagtext.getText();
				auth_search a = new auth_search();
				a.author_parse(search);
				mydata = a.getPublications();
				byrelev();}
			else if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Author") && bydaterev.isSelected()){
				search=(String)nameortagtext.getText();
				auth_search a = new auth_search();
				a.author_parse(search);
				mydata = a.getPublications();
				byrelev();}
			else if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Author") && yearbutton.isSelected()){
				nint=0;
				DefaultTableModel model = (DefaultTableModel) mytable.getModel();
				model.setRowCount(0);
				model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
				search=(String)nameortagtext.getText();
				auth_search a = new auth_search();
				a.author_parse(search);
				mydata = a.getPublications();
				Collections.sort(mydata);int count=0;
				for(int j=0;j<mydata.size();j++)
			if(Integer.parseInt(mydata.get(j).getYear())>=Integer.parseInt(sincetext.getText()))count++;
				resultlabel.setText(count+"");count=0;
				for(i=0;i<mydata.size()&&count<20;i++)
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(sincetext.getText()))
					model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});
				nextbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)  {nint++;
					model.setRowCount(0);
					model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
					int count=20*nint;
					for(;i<mydata.size()&&count<20*(nint+1);i++)	
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(sincetext.getText()))
					model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});}});}
else if(((String)myCombo.getSelectedItem()).equals("Query1") && ((String)comboBox.getSelectedItem()).equals("Search By Author") && inbetweenyear.isSelected()){
				DefaultTableModel model = (DefaultTableModel) mytable.getModel();
				model.setRowCount(0);
				model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
				search=(String)nameortagtext.getText();
				auth_search a = new auth_search();
				a.author_parse(search);
				mydata = a.getPublications();
				Collections.sort(mydata);
				int count=0;
				for(int j=0;j<mydata.size();j++)
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(rangel.getText()) && Integer.parseInt(mydata.get(i).getYear())<=Integer.parseInt(ranger.getText()) )
				count++;
				resultlabel.setText(count+"");count=0;
				for(i=0;i<mydata.size()&&count<20;i++)
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(rangel.getText()) && Integer.parseInt(mydata.get(i).getYear())<=Integer.parseInt(ranger.getText()) )
					model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});
				nextbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)  {nint++;
					model.setRowCount(0);
					model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
					int count=20*nint;
					for(;i<mydata.size()&&count<20*(nint+1);i++)	
				if(Integer.parseInt(mydata.get(i).getYear())>=Integer.parseInt(rangel.getText()) && Integer.parseInt(mydata.get(i).getYear())<=Integer.parseInt(ranger.getText()) )
model.addRow(new Object[]{++count, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});}});}
else if(((String)myCombo.getSelectedItem()).equals("Query3")){
predicting();
				}
else if(((String)myCombo.getSelectedItem()).equals("Query2")){
				nint=0;
				DefaultTableModel model = (DefaultTableModel) mytable.getModel();
				model.setRowCount(0);
				model.addRow(new Object[]{"S.No.", "Authors"});
				int no=Integer.parseInt(q2text.getText());
				query2 ab = new query2();
				ab.k_parse(no);
				java.util.List<String> mydata = ab.getAuthorList();
				resultlabel.setText(mydata.size()+"");
				for(i=0;i<20;i++)
					model.addRow(new Object[]{i+1, mydata.get(i)});
				nextbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)  {nint++;
					model.setRowCount(0);
					model.addRow(new Object[]{"S.No.", "Authors"});
					for(int i=20*nint;i<mydata.size()&&i<20*(nint+1);i++)	
					model.addRow(new Object[]{i+1, mydata.get(i)});}});}}}});
GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(panel, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE).addGroup(groupLayout.createSequentialGroup().addComponent(label, GroupLayout.PREFERRED_SIZE, 1344, Short.MAX_VALUE).addContainerGap()).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(yearbutton).addContainerGap(1211, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(bydaterev).addContainerGap(1180, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(16).addComponent(yearlabel).addPreferredGap(ComponentPlacement.RELATED).addComponent(sincetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addContainerGap(1134, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(16).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(reset).addComponent(submit)).addContainerGap(1244, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(myCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGroup(groupLayout.createSequentialGroup().addGap(6).addComponent(nameortag).addPreferredGap(ComponentPlacement.RELATED).addComponent(nameortagtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(139).addComponent(lblNewLabel)))).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(byrelevence)).addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(inbetweenyear)).addGroup(groupLayout.createSequentialGroup().addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(rangel, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.UNRELATED).addComponent(dash, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(1).addComponent(ranger, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)).addComponent(rangelabel))).addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(q2label).addPreferredGap(ComponentPlacement.RELATED).addComponent(q2text, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(43).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(a1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(q3year).addPreferredGap(ComponentPlacement.RELATED).addComponent(q3yeartext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a2, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a3, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a3text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a4text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(a5, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(a5text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(285).addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addComponent(resulttext).addPreferredGap(ComponentPlacement.RELATED).addComponent(resultlabel))).addPreferredGap(ComponentPlacement.RELATED, 641, Short.MAX_VALUE).addComponent(nextbutton)).addComponent(mytable, GroupLayout.PREFERRED_SIZE, 1004, GroupLayout.PREFERRED_SIZE)).addContainerGap(83, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(542).addComponent(dblplabel).addContainerGap(630, Short.MAX_VALUE)));
				groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(nextbutton).addComponent(resulttext).addComponent(resultlabel)).addGroup(groupLayout.createSequentialGroup().addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(dblplabel).addPreferredGap(ComponentPlacement.RELATED).addComponent(label).addGap(22).addComponent(table, GroupLayout.PREFERRED_SIZE, 1, GroupLayout.PREFERRED_SIZE))).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(myCombo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(nameortag).addComponent(nameortagtext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(18).addComponent(inbetweenyear).addPreferredGap(ComponentPlacement.RELATED).addComponent(rangelabel).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(rangel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(dash).addComponent(ranger, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(9).addComponent(byrelevence).addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(q2label).addComponent(q2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(34).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(yearbutton).addComponent(lblNewLabel)).addGap(18).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(yearlabel).addComponent(sincetext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(30).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(q3year).addComponent(q3yeartext, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a1).addComponent(a1text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a2).addComponent(a2text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a3).addComponent(a3text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a4).addComponent(a4text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(a5).addComponent(a5text, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED, 377, Short.MAX_VALUE).addComponent(bydaterev)).addComponent(mytable, GroupLayout.DEFAULT_SIZE, 980, Short.MAX_VALUE)).addGap(28).addComponent(submit).addPreferredGap(ComponentPlacement.RELATED).addComponent(reset).addGap(18)));
		frame.getContentPane().setLayout(groupLayout);
}}
