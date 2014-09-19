package two;

import javax.swing.*;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import bean.InfoBean;

import dao.BaseConnection;

import java.awt.event.*;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Chart extends JFrame implements ActionListener  {
	
		String str=null;
		JTextField jt1=null;
			
		JLabel j2=null;
		JLabel j3=null;
		JLabel j4=null;
		JLabel j5=null;
		JLabel j6=null;
		JLabel j7=null;
		JLabel j8=null;
		JLabel j9=null;
		JLabel j10=null;
		JLabel j11=null;
		
		JLabel jImage=null;
		
		JPanel jB2=new JPanel();

		JTable friends=null;
		
		ImageIcon background2=null;
		
		String path2=null;
		
		JComboBox comBox=null;
		
		AudioStream as=null;
		 ExtMethod extMethod=new ExtMethod();
		 ArrayList infoList =extMethod.getConn();
		 
		 InfoBean info=null;
		 int size=infoList.size();
		 
		 int i=0;
		 int musicNum=0;
		public Chart(){
			first();
			setVisible(true);
		    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
		
		public void first(){
		
			//************************************************************************
			
			//************************************************************************			  

			 ImageIcon background = new ImageIcon("/5555.jpg"); 
			 background.setImage(background.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT)); 

			 JLabel label = new JLabel(background);  
			 label.setBounds(0, -10, 1200,670);  	
			 this.getLayeredPane().add(label,new Integer(Integer.MIN_VALUE));  
			 JPanel jp = (JPanel)this.getContentPane();  //�����JPanel�Ͳ��ܱ�͸��		 
			 jp.setOpaque(false);  			
			  
			  setLayout(null);	  
			  setTitle("������ͨ��ѧƽʱ�ɼ�����ϵͳ");
			  setBounds(100,10,1200,670);
			  setResizable(false);
			  JMenuBar bar;
			  JMenu setTimeItem;
			  JMenu addC;
			  
			  bar=new JMenuBar();
			  bar.setBackground(Color.white);
			
			  setTimeItem=new JMenu("ϵͳ��������");
			  addC=new JMenu("�½��༶");
			  bar.add(addC);
			  bar.add(setTimeItem);
			 
			  setJMenuBar(bar);
			  
//************************************************************************			
//			  ѧ��ƽʱ�ɼ�������
			 
			  JLabel sN=new JLabel("ѧ�ţ�");
			  jt1=new JTextField(10);
			  jt1.setText("1018120627");
			  JButton button=new JButton("Next");
			  button.addActionListener(this); //��Ӽ�����
			  button.setBackground(Color.cyan);
			  JButton button1=new JButton("+3");
			  button1.addActionListener(this); //��Ӽ�����
			  button1.setBackground(Color.GREEN);
			  JButton button2=new JButton("+5");
			  button2.addActionListener(this); //��Ӽ�����
			  button2.setBackground(Color.GREEN);
			  JButton button3=new JButton("+10");
			  button3.addActionListener(this); //��Ӽ�����
			  button3.setBackground(Color.GREEN);
			  JButton button4=new JButton("����");
			  button4.addActionListener(this); //��Ӽ�����
			  button4.setBackground(Color.red);
			  JButton button5=new JButton("�¼�");
			  button5.addActionListener(this); //��Ӽ�����
			  button5.setBackground(Color.red);
			  JButton button6=new JButton("�ٵ�");
			  button6.addActionListener(this); //��Ӽ�����
			  button6.setBackground(Color.red);
			  JButton button7=new JButton("����");
			  button7.addActionListener(this); //��Ӽ�����
			  button7.setBackground(Color.GREEN);
//			  JButton button8=new JButton("�¼�");
//			  button8.addActionListener(this); //��Ӽ�����
//			  button8.setBackground(Color.GREEN);
			  JButton button9=new JButton("����");
			  button9.addActionListener(this); //��Ӽ�����
			  button9.setBackground(Color.red);
//			  JButton button10=new JButton("����");
//			  button10.addActionListener(this); //��Ӽ�����
//			  button10.setBackground(Color.red);
			  JPanel jB1=new JPanel();
			  jB1.setBorder(BorderFactory.createTitledBorder("ѧ��ƽʱ�ɼ�������"));	  
			  jB1.setOpaque(false);

			 
//************************************************************************			  
//			  ����������		
			 
			  JButton button11=new JButton("��ʼ����");
			  button11.addActionListener(this);
			  button11.setBackground(Color.LIGHT_GRAY);
			  JButton button12=new JButton("����");
			  button12.addActionListener(this);
			  button12.setBackground(Color.lightGray);
			  JButton button13=new JButton("����");
			  button13.addActionListener(this);
			  button13.setBackground(Color.lightGray);
			  
			  JRadioButton radio1=new JRadioButton("˳�����");
			  radio1.setOpaque(false);
			  JRadioButton radio2=new JRadioButton("�������");
			  radio2.setOpaque(false);
			  
			  
//			  ѧ��������Ϣ
			  baseInfo();
			  
			  
//			  JLabel jTime=new JLabel("��       ��       ��      ʾ     ʱ      ��");
			  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
			  JLabel jTime=new JLabel(df.format(new Date()));
			  JButton bT=new JButton("ʱ��ȷ��");
			  bT.setBackground(Color.orange);
			  JButton jA=new JButton("�ѵ�");
			  jA.addActionListener(this);
			  jA.setBackground(Color.green);
			  JButton jB=new JButton("ȱϯ");
			  jB.addActionListener(this);
			  jB.setBackground(Color.red);
			  
			  
			  JPanel jB3=new JPanel();
			  jB3.setBorder(BorderFactory.createTitledBorder("����������"));
			  jB3.setOpaque(false);
			  
			  JPanel jB4=new JPanel();
			  jB4.setBorder(BorderFactory.createTitledBorder("����������"));
			  jB4.setOpaque(false);
			  
			  JPanel jB5=new JPanel();
			  jB5.setBorder(BorderFactory.createTitledBorder("��ǰʱ��"));
			  jB5.setOpaque(false);
			  
			  JPanel jB6=new JPanel();
			  jB6.setBorder(BorderFactory.createTitledBorder("������ʽ"));
			  jB6.setOpaque(false);
			  
//************************************************************************			  
//			�����ʾ  ��			  
			  
			  JTextArea jArea=new JTextArea();
			  jArea.setEditable(false);
			  jArea.setOpaque(false);
			  jArea.setText("��ʾ�������");
			  
			  
			  JPanel jB7=new JPanel();
			  jB7.setBorder(BorderFactory.createTitledBorder("�����ʾ��"));
			  jB7.setOpaque(false);
			  
			  String[] s = {"R111","R112","R113","R114","R115","R116","R117"};
			  JLabel jName=new JLabel("�༶ѡ��");
			  comBox=new JComboBox(s);
			  comBox.addActionListener(this);
			  
			  JButton jS=new JButton("ѡ��༶");
			  jS.setBackground(Color.gray);
			  JButton jD=new JButton("ɾ���༶");
			  jD.setBackground(Color.gray);
			  JPanel jB8=new JPanel();
			  jB8.setBorder(BorderFactory.createTitledBorder("�༶ѡ����"));
			  jB8.setOpaque(false);
			  
//************************************************************************			  
			  
			  //one.setBounds(95, 50,150,30);
			  sN.setBounds(40,55,50,30);
			  jt1.setBounds(95,55,100,30);
			  button.setBounds(210,55,60,30);
			  button1.setBounds(40, 115, 90, 30);
			  button2.setBounds(40, 165, 90, 30);
			  button3.setBounds(40, 215, 90, 30);
			  button7.setBounds(40, 265, 90, 30);
//			  button8.setBounds(40, 315, 90, 30);
			  
			  button4.setBounds(180, 115, 90, 30);
			  button5.setBounds(180, 165, 90, 30);
			  button6.setBounds(180, 215, 90, 30);
			  button9.setBounds(180, 265, 90, 30);
//			  button10.setBounds(180, 315, 90, 30);
			  jB1.setBounds(15,20,280,370);
			  
			 // j1.setBounds(370,90 , 130, 30);
			  j2.setBounds(350,90 , 110, 30);
			  j4.setBounds(350,160 , 110, 30);
			  j6.setBounds(350,230 , 110, 30);
			  j8.setBounds(350,290 , 110, 30);
			  j10.setBounds(350,360 , 110, 30);
			  j3.setBounds(450,90 , 110, 30);
			  j5.setBounds(450,160 , 110, 30);
			  j7.setBounds(450,230 , 110, 30);
			  j9.setBounds(450,290 , 110, 30);
			  j11.setBounds(450,360 , 110, 30);
			  
			  jB2.setBounds(300,20,470,370);
			  
			  
			  jImage.setBounds(520, 50, 250, 320);
			  
			  
			  button11.setBounds(40, 440, 200,70);
			  button12.setBounds(40,510,100,70);
			  button13.setBounds(140,510,100,70);
			  
			  
			  radio1.setBounds(300,470,80,30);
			  radio2.setBounds(300,520,80,30);
			  
			  jB6.setBounds(280,445,110,130);
			  
			  jTime.setBounds(450, 465, 200, 30);
			  bT.setBounds(470, 510, 130, 50);
			  
			  jB5.setBounds(400,440,260,150);
			  
			  jB4.setBounds(260,420,510,180);
			  
			  jA.setBounds(675,460,80,60);
			  jB.setBounds(675,520,80,60);
			  
			  jB3.setBounds(10,400,770,210);
			  
			  jArea.setBounds(820,40,330,330);
			  
			  jB7.setBounds(800,20,370,370);
			  
			  jName.setBounds(840,455,80,40);
			  comBox.setBounds(910,455,200,40);
			  jS.setBounds(840,530,120,40);
			  jD.setBounds(980,530,120,40);
			  
			  jB8.setBounds(800,400,360,205);
			  
			  //*****************
//			  �����ʾ�б�
			  setResult();
			  //****************
			  
			  //add(one);
			  add(sN);
			  add(button);
			  add(jt1);
			  add(button1);
			  add(button2);
			  add(button3);
			  add(button4);
			  add(button5);
			  add(button6);
			  add(button7);
//			  add(button8);
			  add(button9);
//			  add(button10);
			  add(jB1);
			  
			  //add(j1);
			  add(j2);
			  add(j4);
			  add(j6);
			  add(j8);
			  add(j3);
			  add(j5);
			  add(j7);
			  add(j9);
			  add(j10);
			  add(j11);
			  
			  add(jB2);
			  
			  add(jImage);
			  
			  add(button11);
			  add(button12);
			  add(button13);
			  
			  add(radio1);
			  add(radio2);
			  
			  add(jB6);
			  
			  add(jTime);
			  add(jB5);
			  add(jB4);
			  
			  add(bT);
			  
			  add(jA);
			  add(jB);
			  add(jB3);
			  
			  add(jArea);
			  add(jB7);
			  
			  add(jName);
			  //add(tName);
			 // add(bName);
			  
			  add(comBox);
			  add(jS);
			  add(jD);
			  add(jB8);
			 // add(bg);
			     //ImageIcon background = new ImageIcon("1111.jpg"); 
				 //JLabel label = new JLabel();  
				 //label.setIcon(background);
				 //label.setBounds(0, 0, this.getWidth(), this.getHeight());  	
				 //add(label);
			  validate();
			 
		}
		
		public void actionPerformed(ActionEvent e) {
			
			  String value = (String) comBox.getSelectedItem();
			  System.out.println("value="+value);
			  ArrayList grade_infoList =extMethod.getGradeConn(value);
			  InfoBean info2=null;
			  
			  
			  if (e.getActionCommand().equals("Next")) {
//				  System.out.println("����");
				  str = jt1.getText();  // ��ȡ�ı��������(����ֵΪString����)
//				  int i=Integer.parseInt(str);
				  
//				  System.out.println("infoList="+infoList.toString());
				  
				  
				  info=(InfoBean) grade_infoList.get(i);
				  j3.setText(info.getName());
				  j5.setText(info.getNum());
				  jt1.setText(info.getNum());
				  j7.setText(info.getAcademic());
				  j9.setText(String.valueOf(info.getScore()));
				  j11.setText(String.valueOf(info.getAcount()));
				  
				  i++;
				  if(i==grade_infoList.size()){
					  i=0;
					  ArrayList new_grade_infoList =extMethod.getGradeConn(value);
//					  ArrayList new_infoList =extMethod.getConn();
					  System.out.println("����");
					  setNewResult(new_grade_infoList);
					  friends.repaint();
				  }
				  path2 =info.getImage_path(); 
				  background2= new ImageIcon(path2);
				  jImage.setIcon(background2);
//				  
//				  path2 ="http://www.muu.com.cn/img/d/848aae3922f63684f34cc09f91f86bb4a1a5d7ea791bc2a8bd9fc90ae2f70f8f92d1d271fc28d9b6.jpg"; 
//				  setBackground(path2);
				  
				  System.out.println("path2="+path2);
				  
//			 	  System.out.println("Str="+str);
			  }else  if(e.getActionCommand().equals("+3")) {
				  	str = jt1.getText();
				  	int now_score=extMethod.operate(str,"+3");
				  	j9.setText(String.valueOf(now_score));
					System.out.println("+3");
//			   System.exit(0);
			  }else  if(e.getActionCommand().equals("+5")) {
				  	str = jt1.getText();
				  	int now_score=extMethod.operate(str,"+5");
				  	j9.setText(String.valueOf(now_score));
					System.out.println("+5");
	//				   System.exit(0);  
			  }else  if(e.getActionCommand().equals("+10")) {
				  	str = jt1.getText();
				  	int now_score=extMethod.operate(str,"+10");
				  	j9.setText(String.valueOf(now_score));
					System.out.println("+10");
	//				   System.exit(0);  	  	     
			  }else  if(e.getActionCommand().equals("����")) {
				  	str = jt1.getText();
				  	int now_score=extMethod.operate(str,"����");
				  	j9.setText(String.valueOf(now_score));
					System.out.println("����");
//			   System.exit(0);
				}else  if(e.getActionCommand().equals("�¼�")) {
				  	str = jt1.getText();
				  	int now_score=extMethod.operate(str,"�¼�");
				  	j9.setText(String.valueOf(now_score));
					System.out.println("�¼�");
		//	   System.exit(0);
			  }else  if(e.getActionCommand().equals("�ٵ�")) {
				  	str = jt1.getText();
				  	int now_score=extMethod.operate(str,"�ٵ�");
				  	j9.setText(String.valueOf(now_score));
					System.out.println("�ٵ�");
		//	   System.exit(0);
			  }else  if(e.getActionCommand().equals("����")) {
				  	str = jt1.getText();
				  	int now_score=extMethod.operate(str,"����");
				  	j9.setText(String.valueOf(now_score));
					System.out.println("����");
		//	   System.exit(0);
			  }else  if(e.getActionCommand().equals("����")) {
				  	str = jt1.getText();
				  	int acount=extMethod.operate_acount(str,"����");
				  	j11.setText(String.valueOf(acount));
					System.out.println("����");
		//	   System.exit(0);
			  }else  if(e.getActionCommand().equals("��ʼ����")) {
					System.out.println("��ʼ����");
					info2=(InfoBean) grade_infoList.get(0);
					System.out.println("info2.getVoice(��ʼ����)"+info2.getVoice());
					  playMusic(info2.getVoice());
			  }else  if(e.getActionCommand().equals("�ѵ�")) {
				  	AudioPlayer.player.stop(as);
					System.out.println("�ѵ�");
					if(musicNum<grade_infoList.size()){
						musicNum++;
					}else{
						musicNum=0;
					}
					info2=(InfoBean) grade_infoList.get(musicNum);
					System.out.println("info2.getVoice(�ѵ�)"+info2.getVoice());
					System.out.println("musicNum(�ѵ�)"+musicNum);
					System.out.println("grade_infoList.size()(�ѵ�)"+grade_infoList.size());
					
					
					playMusic(info2.getVoice());
			  }
			  
			  
			  
			  
			  if (e.getSource() == comBox) {   
				  int index = comBox.getSelectedIndex();   
				  switch (index) {   
				  case 0:    //���������������飬����дֻ��Ϊ�˸����������������    //box.getSelectedItem() �ķ���ֵ�� object    
					  System.out.println(comBox.getSelectedItem().toString());    
					  break;   
				  case 1:    
					  System.out.println(comBox.getSelectedItem().toString());    
					  break;   
				  case 2:    
					  System.out.println(comBox.getSelectedItem().toString());    
					  break;   
					}
			  }
			  
		}
		
		 public void baseInfo(){
				//************************************************************************			  
//				  ѧ��������Ϣ��
				  
				  j2=new JLabel("ѧ��������");//name num academic acount  
				  j3=new JLabel("   NULL");
//				  JLabel j3=new JLabel(info.getName());
				  
				  j4=new JLabel("ѧ�ţ�");
				  j5=new JLabel("   NULL");
//				  JLabel j5=new JLabel(info.getNum());
				  j6=new JLabel("ѧԺ��");
				  j7=new JLabel("   NULL");
//				  JLabel j7=new JLabel(info.getAcademic());
				  j8=new JLabel("ƽʱ�ɼ���");
				  j9=new JLabel("   NULL");
				  j10=new JLabel("���δ�����");
				  j11=new JLabel("   NULL");
//				  JLabel j9=new JLabel(info.getAcount());
				  
//				  http://jw.djtu.edu.cn/academic/getCaptcha.do   ��֤��ͼƬ����
				  
				  
				  j2.setFont(new Font("Dialog",1,15));   
				  j3.setFont(new Font("Dialog",1,15));   
				  j4.setFont(new Font("Dialog",1,15));   
				  j5.setFont(new Font("Dialog",1,15));   
				  j6.setFont(new Font("Dialog",1,15));   
				  j7.setFont(new Font("Dialog",1,15));   
				  j8.setFont(new Font("Dialog",1,15));   
				  j9.setFont(new Font("Dialog",1,15));  
				  j10.setFont(new Font("Dialog",1,15));   
				  j11.setFont(new Font("Dialog",1,15));
				   
				  path2="D:\\0bishe\\22222.jpg";
//				  background2= new ImageIcon(path2);
//				  path2 ="http://www.muu.com.cn/img/d/848aae3922f63684f34cc09f91f86bb4a1a5d7ea791bc2a8bd9fc90ae2f70f8f92d1d271fc28d9b6.jpg"; 
				  setBackground(path2);
			      
				  jB2.add(jImage); 
				  jB2.setBorder(BorderFactory.createTitledBorder("ѧ��������Ϣ"));
				  //JLabel j1=new JLabel("");
				  jB2.setOpaque(false);
	//************************************************************************	
			  }
		 public void setBackground(String path2){
			 
			  background2= new ImageIcon(path2);//
//			  System.out.println("background2="+background2);
			  jImage=new JLabel(background2);//background
//			  jImage.s
//			  jImage.setIcon(background2);
//			  jB2.repaint();
			  
//			  System.out.println("setBackground");
//			 background2 = new ImageIcon(path2); 
//			 jImage=new JLabel(background2);
//			 background2.setImage(path2);
//			 jImage.setName(background2);
		 }
		 public void setResult(){
			 String results=null;
				for(int i=0;i<size;i++){
					info=(InfoBean) infoList.get(i);
//					Object[][i] rowData = { 
//							{info.getNum(),info.getName(),info.getOne_score() , "", "", "", "", "", "û"}, 
					
					String result=info.getNum()+","
									+info.getName()+","
									+info.getOne_score()+","
									+info.getTwo_score()+","
									+info.getThree_score()+","
									+info.getFour_score()+","
									+info.getScore();
					
					if(i==0){
						results=result;
					}else{
						results=results+"a"+result;
					}
					
				}
				System.out.println("results="+results); 
				
				Object [] splitFirst = results.split("a"); 
				String [] splitFirst1 = results.split("a"); 
				for (int i = 0; i < splitFirst.length; i++) { 
//					System.out.println("splitFirst1="+splitFirst1[i]); 
				}
				
//				Object [][] splitSecond = null;
				String[] temp1 = splitFirst1[i].split(",");
				Object [][] splitSecond = new Object[splitFirst.length][temp1.length];
				for (int i = 0; i < splitFirst.length; i++) { 
					String[] temp = splitFirst1[i].split(","); 
					 
					for (int j = 0; j < temp.length; j++) { 
						splitSecond[i][j] = temp[j]; 
//						System.out.println("��"+i+"�С���"+j+"�е�Ԫ���ǣ�"+splitSecond[i][j]); 
					} 
				} 
				
			  final Object[] columnNames = {"ѧ��", "����", " ",//���������final���� 
						" ", " "," ","ƽʱ�ɼ�"}; 
				Object[][] rowData = { 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"},
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"},
				}; 
				
				    
				friends = new JTable (splitSecond, columnNames); 
				friends.setPreferredScrollableViewportSize(new Dimension(400, 100));//���ñ��Ĵ�С 
//				friends.setRowHeight (30);//����ÿ�еĸ߶�Ϊ30 
//				friends.setRowHeight (0, 30);//���õ�1�еĸ߶�Ϊ30 
//				friends.setRowMargin (2);//�����������е�Ԫ��ľ��� 
				friends.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse 
				friends.setSelectionBackground (Color.white);//������ѡ���еı���ɫ 
				friends.setSelectionForeground (Color.red);//������ѡ���е�ǰ��ɫ 
				friends.setGridColor (Color.black);//���������ߵ���ɫ 
//				friends.selectAll ();//ѡ�������� 
//				friends.setRowSelectionInterval (0,2);//���ó�ʼ��ѡ����,������1��3�ж�����ѡ��״̬ 
//				friends.clearSelection ();//ȡ��ѡ�� 
//				friends.setDragEnabled (true);//������� 
				friends.setShowGrid (false);//�Ƿ���ʾ������ 
				friends.setShowHorizontalLines (false);//�Ƿ���ʾˮƽ�������� 
				friends.setShowVerticalLines (true);//�Ƿ���ʾ��ֱ�������� 
//				friends.setValueAt ("tt", 0, 0);//����ĳ����Ԫ���ֵ,���ֵ��һ������ 
				friends.doLayout (); 
				friends.setBackground (Color.lightGray); 
				//JScrollPane pane1 = new JScrollPane (example1);//JTable��ü���JScrollPane�� 
				//JScrollPane pane2 = new JScrollPane (example2); 
				JScrollPane pane3 = new JScrollPane (friends); 
//				JPanel panel = new JPanel (new GridLayout (0, 1)); 
//				panel.setPreferredSize (new Dimension (600,400)); 
//				panel.setBackground (Color.black); 
				//panel.add (pane1); 
				//panel.add (pane2); 
//				panel.add (pane3); 
//				JFrame frame = new JFrame ("JTableDemo"); 
//				frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
//				frame.setContentPane (panel); 
//				frame.pack(); 
//				frame.show();
				pane3.setBounds(820,40,330,330);
				add(pane3);
		 }
		 public void setNewResult(ArrayList new_infoList){
			 System.out.println("setNewResult="); 
			 String results=null;
				for(int i=0;i<new_infoList.size();i++){
					info=(InfoBean) new_infoList.get(i);
//					Object[][i] rowData = { 
//							{info.getNum(),info.getName(),info.getOne_score() , "", "", "", "", "", "û"}, 
					
					String result=info.getNum()+","
									+info.getName()+","
									+info.getOne_score()+","
									+info.getTwo_score()+","
									+info.getThree_score()+","
									+info.getFour_score()+","
									+info.getScore();
					
					if(i==0){
						results=result;
					}else{
						results=results+"a"+result;
					}
					
				}
				System.out.println("results="+results); 
				
				Object [] splitFirst = results.split("a"); 
				String [] splitFirst1 = results.split("a"); 
				for (int i = 0; i < splitFirst.length; i++) { 
//					System.out.println("splitFirst1="+splitFirst1[i]); 
				}
				
//				Object [][] splitSecond = null;
				String[] temp1 = splitFirst1[i].split(",");
				Object [][] splitSecond = new Object[splitFirst.length][temp1.length];
				for (int i = 0; i < splitFirst.length; i++) { 
					String[] temp = splitFirst1[i].split(","); 
					 
					for (int j = 0; j < temp.length; j++) { 
						splitSecond[i][j] = temp[j]; 
//						System.out.println("��"+i+"�С���"+j+"�е�Ԫ���ǣ�"+splitSecond[i][j]); 
					} 
				} 
				
			  final Object[] columnNames = {"ѧ��", "����", " ",//���������final���� 
						" ", " "," ","ƽʱ�ɼ�"}; 
				Object[][] rowData = { 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"},
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"}, 
				{"1018120627", "��ƽ", "", "", "", "", "", "", "û"},
				}; 
				
				    
				friends = new JTable (splitSecond, columnNames); 
				friends.setPreferredScrollableViewportSize(new Dimension(400, 100));//���ñ��Ĵ�С 
//				friends.setRowHeight (30);//����ÿ�еĸ߶�Ϊ30 
//				friends.setRowHeight (0, 30);//���õ�1�еĸ߶�Ϊ30 
//				friends.setRowMargin (2);//�����������е�Ԫ��ľ��� 
				friends.setRowSelectionAllowed (true);//���ÿɷ�ѡ��.Ĭ��Ϊfalse 
				friends.setSelectionBackground (Color.white);//������ѡ���еı���ɫ 
				friends.setSelectionForeground (Color.red);//������ѡ���е�ǰ��ɫ 
				friends.setGridColor (Color.black);//���������ߵ���ɫ 
//				friends.selectAll ();//ѡ�������� 
//				friends.setRowSelectionInterval (0,2);//���ó�ʼ��ѡ����,������1��3�ж�����ѡ��״̬ 
//				friends.clearSelection ();//ȡ��ѡ�� 
//				friends.setDragEnabled (true);//������� 
				friends.setShowGrid (false);//�Ƿ���ʾ������ 
				friends.setShowHorizontalLines (false);//�Ƿ���ʾˮƽ�������� 
				friends.setShowVerticalLines (true);//�Ƿ���ʾ��ֱ�������� 
//				friends.setValueAt ("tt", 0, 0);//����ĳ����Ԫ���ֵ,���ֵ��һ������ 
				friends.doLayout (); 
				friends.setBackground (Color.lightGray); 
				//JScrollPane pane1 = new JScrollPane (example1);//JTable��ü���JScrollPane�� 
				//JScrollPane pane2 = new JScrollPane (example2); 
				JScrollPane pane3 = new JScrollPane (friends); 
//				JPanel panel = new JPanel (new GridLayout (0, 1)); 
//				panel.setPreferredSize (new Dimension (600,400)); 
//				panel.setBackground (Color.black); 
				//panel.add (pane1); 
				//panel.add (pane2); 
//				panel.add (pane3); 
//				JFrame frame = new JFrame ("JTableDemo"); 
//				frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
//				frame.setContentPane (panel); 
//				frame.pack(); 
//				frame.show();
				pane3.setBounds(820,40,330,330);
				add(pane3);
		 }
		 public void playMusic(String musicNum){
			 
//			 String Filename="D:\\0bishe\\1.wav";
				
				try{ 
					// ����������һ��Ƶ�ļ� 
					InputStream in = new FileInputStream(musicNum);//FIlename ������ص������ļ���(��game.wav��) 
					// ���������д���һ��AudioStream���� 
					as = new AudioStream(in); 
					AudioPlayer.player.start(as);//�þ�̬��Աplayer.start�������� 
					
//					AudioPlayer.player.stop(as);//�ر����ֲ��� 
					//���Ҫʵ��ѭ�����ţ��������������ȡ������ġ�AudioPlayer.player.start(as);����� 
					/*AudioData data = as.getData(); 
					ContinuousAudioDataStream gg= new ContinuousAudioDataStream (data); 
					AudioPlayer.player.start(gg);// Play audio. 
					*/ 
					//���Ҫ��һ�� URL ��Ϊ��������Դ(source)����������Ĵ�����ʾ�滻�������������������� 
					/*AudioStream as = new AudioStream (url.openStream()); 
					*/ 
				} catch(FileNotFoundException ex){ 
					System.out.print("FileNotFoundException "); 
				} catch(IOException ex){ 
					System.out.print("�д���!"); 
				} 
		 }
}

