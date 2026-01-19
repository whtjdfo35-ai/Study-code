package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] rot = new int[6];
		
        for (int i=0; i<rot.length;i++) {
        	rot[i]=(int)(Math.random()*6);
        	int m=0;
        	do {
        		m=0;
        		for(int k=0; k<i;k++) {
        	      	if (rot[i]==rot[k]) {
        	    		rot[i]=(int)(Math.random()*6); 
        	    		m=1;
        	    	}	
        		}
        	}
        	while(m==1);       
        }
		
        for (int i=0; i<rot.length;i++) {
        	System.out.print(rot[i]+" ");
        }
        
        
		
	}

}
