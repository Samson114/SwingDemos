package test;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Vector;

public class JComboBox1{
public static void main(String[] args){
JFrame f=new JFrame("JComboBox1");
Container contentPane=f.getContentPane();
contentPane.setLayout(new GridLayout(1,2));
String[] s = {"����","�ձ�","��½","Ӣ��","����","�����","����","����"};
Vector v=new Vector();
v.addElement("Nokia 8850");
v.addElement("Nokia 8250");
v.addElement("Motorola v8088");
v.addElement("Motorola v3850");
v.addElement("Panasonic 8850");
    v.addElement("����");
    
    JComboBox combo1=new JComboBox(s);
    combo1.addItem("�й�");//����JComboBox�����ṩ��addItem()����������һ����Ŀ����JComboBox�С�
    combo1.setBorder(BorderFactory.createTitledBorder("����ϲ�����ĸ���������?"));
    JComboBox combo2=new JComboBox(v);
    combo2.setBorder(BorderFactory.createTitledBorder("����ϲ����һ���ֻ��أ�"));   
    contentPane.add(combo1);
    contentPane.add(combo2);
    f.pack();
    f.show();
    f.addWindowListener(new WindowAdapter(){
    public void windowClosing(WindowEvent e){
    System.exit(0); 
    }
    });
}
}
