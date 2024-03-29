package test;

import java.awt.Dimension; 
import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JPanel; 
import javax.swing.JTable; 
import java.awt.Color; 
import java.awt.GridLayout; 
import javax.swing.table.TableColumn; 
public class JTableDemo 
	{ 
			public static void main (String[] args) 
			{ 
			/* 
			　	构造函数有很多下面先介绍几个: 
			　　JTable() 
			　　JTable(int numRows, int numColumns) 
			　　JTable(Object[][] rowData, Object[] columnNames) 
			　　*/ 
			JTable example1 = new JTable ();//看不到但存在 
			JTable example2 = new JTable (8, 6); //中间的空的没有内容的表格
			final Object[] columnNames = {"姓名", "性别", "家庭地址",//列名最好用final修饰 
											"电话号码", "生日", "工作", "收入", "婚姻状况","恋爱状况"}; 
			Object[][] rowData = { 
			{"ddd", "男", "江苏南京", "1378313210", "03/24/1985", "学生", "寄生中", "未婚", "没"}, 
			{"eee", "女", "江苏南京", "13645181705", "xx/xx/1985", "家教", "未知", "未婚", "好象没"}, 
			{"fff", "男", "江苏南京", "13585331486", "12/08/1985", "汽车推销员", "不确定", "未婚", "有"}, 
			{"ggg", "女", "江苏南京", "81513779", "xx/xx/1986", "宾馆服务员", "确定但未知", "未婚", "有"}, 
			{"hhh", "男", "江苏南京", "13651545936", "xx/xx/1985", "学生", "流放中", "未婚", "无数次分手后没有"} 
			}; 
			JTable friends = new JTable (rowData, columnNames); 
			friends.setPreferredScrollableViewportSize(new Dimension(600, 100));//设置表格的大小 
			friends.setRowHeight (30);//设置每行的高度为30 
			friends.setRowHeight (0, 30);//设置第1行的高度为30 
			friends.setRowMargin (5);//设置相邻两行单元格的距离 
			friends.setRowSelectionAllowed (true);//设置可否被选择.默认为false 
			friends.setSelectionBackground (Color.white);//设置所选择行的背景色 
			friends.setSelectionForeground (Color.red);//设置所选择行的前景色 
			friends.setGridColor (Color.black);//设置网格线的颜色 
			friends.selectAll ();//选择所有行 
			friends.setRowSelectionInterval (0,2);//设置初始的选择行,这里是1到3行都处于选择状态 
			friends.clearSelection ();//取消选择 
			friends.setDragEnabled (true);//不懂这个 
			friends.setShowGrid (false);//是否显示网格线 
			friends.setShowHorizontalLines (false);//是否显示水平的网格线 
			friends.setShowVerticalLines (true);//是否显示垂直的网格线 
			friends.setValueAt ("tt", 0, 0);//设置某个单元格的值,这个值是一个对象 
			friends.doLayout (); 
			friends.setBackground (Color.lightGray); 
			JScrollPane pane1 = new JScrollPane (example1);//JTable最好加在JScrollPane上 
			JScrollPane pane2 = new JScrollPane (example2); 
			JScrollPane pane3 = new JScrollPane (friends); 
			JPanel panel = new JPanel (new GridLayout (0, 1)); 
			panel.setPreferredSize (new Dimension (600,400)); 
			panel.setBackground (Color.black); 
			panel.add (pane1); 
			panel.add (pane2); 
			panel.add (pane3); 
			JFrame frame = new JFrame ("JTableDemo"); 
			frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
			frame.setContentPane (panel); 
			frame.pack(); 
			frame.show();
			}
	}


