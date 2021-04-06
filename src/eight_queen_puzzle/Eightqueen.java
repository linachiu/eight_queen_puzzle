package eight_queen_puzzle;

import java.io.*;

public class Eightqueen {
	
	static int[] Queenes = new int[8];
	static int Counts=0;

	public static boolean Check(int line, int list){
	    int index;
	    for (index=0; index<line; index++) {
	        int data = Queenes[index];
	        if (list==data) 
	            return false;
	        else if ((index+data)==(line+list))
	            return false;
	        else if ((index-data)==(line-list))
	            return false;
	    }
	    return true;
	}
	
	public static void printRes() {
		System.out.println("// Solution " + Counts);
		for(int i =0; i< 8;i++) {
			for(int j=0; j<8; j++) {
				if(Queenes[i] == j) {
					System.out.print("Q");
				} else {
					System.out.print(".");
				}
				 
			}
			System.out.println("");
		}
		
		System.out.println("");
	}
	
	public static void eight_queen(int line) {
		for (int i=0; i<8; i++) {
			if(Check(line, i)) {
				Queenes[line] = i; 
				if(line == 7) {	
					Counts ++;
					printRes();
					Queenes[line] = 0;
					return;
				}
				eight_queen(line + 1);
				Queenes[line] = 0;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		eight_queen(0);
	    System.out.println("Eight Queens has " + Counts + " Solutions!");
	}
}
