import java.awt.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class myGUI1 extends myGUI
{
public int nint=0;
public int checkexceptions()
{

if(((String)myCombo.getSelectedItem()).equals("Queries"))
{
					JOptionPane.showMessageDialog(null, "Please choose a Query");
return 1;
}
			else if(((String)myCombo.getSelectedItem()).equals("Query1"))
	{
	if(((String)comboBox.getSelectedItem()).equals("Choose one"))
{
				JOptionPane.showMessageDialog(null, "Please choose either Author or Title Tag");
return 1;
}
	else if(nameortagtext.getText().equals(""))
{
					JOptionPane.showMessageDialog(null, "Please enter a valid Author Name/tag");
return 1;
}	
			
	else if(!(byrelevence.isSelected() || bydaterev.isSelected() || yearbutton.isSelected() || inbetweenyear.isSelected()))
{
						JOptionPane.showMessageDialog(null, "Please choose a search option");
return 1;
}
	else if(inbetweenyear.isSelected())  
			{
			if(!(isInteger(rangel.getText()) && isInteger(ranger.getText())))
{
					JOptionPane.showMessageDialog(null, "Year enterrerd is not valid");
return 1;
}
			}
	else if(yearbutton.isSelected())
		{
			if(!(isInteger(sincetext.getText())))
{
					JOptionPane.showMessageDialog(null, "Year enterrerd is not valid");
return 1;
}			
		}
	
	}
else if(((String)myCombo.getSelectedItem()).equals("Query3"))
	{

if(!(isInteger(q3yeartext.getText())))
{
JOptionPane.showMessageDialog(null, "Year enterrerd is not valid");
return 1;
}
else if(a1text.getText().equals("") || a2text.getText().equals("") || a3text.getText().equals("") || a4text.getText().equals("") || a5text.getText().equals("") )
{
JOptionPane.showMessageDialog(null, "Any Author field should not be left blank.");
return 1;
}
}
else if(((String)myCombo.getSelectedItem()).equals("Query2"))
	{
if(!(isInteger(q2text.getText())))
{
JOptionPane.showMessageDialog(null, "Please enter a valid number");
return 1;
}}
return 0;
}
public double myprediction(int aa)
{
Random r=new Random();
int mm=0;
while(mm==0)
mm=r.nextInt(400)-200;
double d=mm/1000.0;
d=aa+d*aa;
return d;
}
public static boolean isInteger(String s) {
    return isInteger(s,10);}
public static boolean isInteger(String s, int radix) {
    if(s.isEmpty()) return false;
    for(int i = 0; i < s.length(); i++) {
        if(i == 0 && s.charAt(i) == '-') {
            if(s.length() == 1) return false;
            else continue;}
        if(Character.digit(s.charAt(i),radix) < 0) return false; }
    return true;
}
	java.util.List<publication> mydata;
	public String getnameortagtext()
	{
	return (String)nameortagtext.getText();
	}
void byrelev(){
DefaultTableModel model = (DefaultTableModel) mytable.getModel();
				nint=0;
				model.setRowCount(0);
				model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
				Collections.sort(mydata);
				resultlabel.setText(mydata.size()+"");
								for(int i=0;i<20;i++)
				model.addRow(new Object[]{i+1, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});
				nextbutton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e)  {
					nint++;
					model.setRowCount(0);
					model.addRow(new Object[]{"S.No.", "Authors", "Title", "Pages", "Year", "Volume", "Journal", "Url"});
					for(int i=20*nint;i<mydata.size()&&i<20*(nint+1);i++)	
					model.addRow(new Object[]{i+1, mydata.get(i).getAuthors(), mydata.get(i).getTitle(), mydata.get(i).getPages(), mydata.get(i).getYear(), mydata.get(i).getVolume(), mydata.get(i).getJourBook(), mydata.get(i).getURL()});}});}
void case1(){
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
						bydaterev.setVisible(true);}
void case2(){
setvisibility();
						nextbutton.setVisible(true);
						q2label.setVisible(true);
						q2text.setVisible(true);
						resulttext.setVisible(true);
						resultlabel.setVisible(true);
						submit.setVisible(true);
						submit.setEnabled(true);
						reset.setVisible(true);}
void case3(){
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
						reset.setVisible(true);}
void predicting(){
DefaultTableModel model = (DefaultTableModel) mytable.getModel();
				model.setRowCount(0);
				model.addRow(new Object[]{"S.No.", "Authors", "Publications"});
				String myyear=(String)q3yeartext.getText();
				String a1=(String)a1text.getText();
				query3 ab1 = new query3();
				ab1.author_parse(a1, myyear);
				int md1=ab1.getPredict();
				model.addRow(new Object[]{"1", a1, myprediction(md1)});
				String a2=a2text.getText();
				ab1.author_parse(a2, myyear);
				int md2=ab1.getPredict();
				model.addRow(new Object[]{"2", a2, myprediction(md2)});
				String a3=a3text.getText();
				ab1.author_parse(a3, myyear);
				int md3=ab1.getPredict();
				model.addRow(new Object[]{"3", a3, myprediction(md3)});
				String a4=a4text.getText();
				ab1.author_parse(a4, myyear);
				int md4=ab1.getPredict();
				model.addRow(new Object[]{"4", a4, myprediction(md4)});
				String a5=a5text.getText();
				ab1.author_parse(a5, myyear);
				int md5=ab1.getPredict();
				model.addRow(new Object[]{"5", a5, myprediction(md5)});}}