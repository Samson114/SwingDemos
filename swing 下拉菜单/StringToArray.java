package test;

public class StringToArray { 
	public static void main(String[] args) { 
	
		StringToArray sa = new StringToArray(); 
		String str = "ss,dd,sddf@ssd,sd,sdf@ss,sdf,sd"; 
		String[][] temp = sa.stringSplit(str); 
	
	} 
	
	private String[][] stringSplit(String sp) { 
		String[] splitFirst = sp.split("@"); 
		
		for (int i = 0; i < splitFirst.length; i++) { 
			System.out.println(splitFirst[i]); 
		} 
	
	String[][] splitSecond = null; 
	
	for (int i = 0; i < splitFirst.length; i++) { 
		String[] temp = splitFirst[i].split(","); 
		splitSecond = new String[splitFirst.length][temp.length]; 
		for (int j = 0; j < temp.length; j++) { 
				splitSecond[i][j] = temp[j]; 
					System.out.println("第" + i + "行、第" + j + "列的元素是：" 
								+ splitSecond[i][j]); 
		} 
	} 
	
	return splitSecond; 
	
	} 
} 
	
