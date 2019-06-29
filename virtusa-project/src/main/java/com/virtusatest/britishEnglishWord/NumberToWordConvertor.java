package com.virtusatest.britishEnglishWord;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberToWordConvertor {
	//For units place numbers
	private static final String[] singlesAndTens= {"", "one","two","three", "four", "five", "six", "seven", "eight", "nine","ten","eleven","twelve", "thirteen", "fourteen", "fifteen","sixteen", "seventeen", "eighteen", "nineteen"};

	//For multiples of 10 in tens place
	private static final String[] tens={"","","twenty", "thirty","forty","fifty", "sixty", "seventy", "eighty", "ninety"};
	
	public String getBritishEnglishWord(int n){
		
		if(n<1 || n > 999999999){
			return "Input is out of range";
		}
		return convertToWords(n);
	}
	
	public String convertToWords(int n){
		
		if(n<20){//1 to 19
			return singlesAndTens[n];
		}
		if(n>=20 && n<100){ // 20 to 99
			return tens[n/10]+((n%10)!=0?" ":"")+singlesAndTens[n%10];
		}
		if(n>=100 && n<1000){ //100 to 999
			return singlesAndTens[n / 100] + " hundred" + ((n % 100 != 0) ? " and " : "") + convertToWords(n % 100);
		}
		if(n>=1000 && n<100000){// 1000 to 99,999
			return convertToWords(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + convertToWords(n % 1000);
		}
		if(n>=100000 && n<1000000){//100,000 to 999,999
			return convertToWords(n / 1000) + " thousand" + ((n % 1000 != 0) ? " " : "") + convertToWords((n % 1000));
		}
		//100,000,000 to 999,999,999
		return convertToWords(n / 1000000) + " million" + ((n % 10000000 != 0) ? " " : "") + convertToWords(n % 1000000);
	}
    public static void main( String[] args )
    {
    	System.out.println("Please enter a number : ");
    	try(Scanner input= new Scanner(System.in);){
	    	NumberToWordConvertor numToWord = new NumberToWordConvertor();
	    	if(input.hasNext()){
	    		 int num= input.nextInt();
	    		 System.out.println(numToWord.getBritishEnglishWord(num));
	    	}
    	}catch(InputMismatchException ex){
    		System.out.println("Input is invalid or out of range");
    	}
    }
}
