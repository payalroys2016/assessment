package com.virtusatest.britishEnglishWord;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.virtusatest.britishEnglishWord.*;

@RunWith(MockitoJUnitRunner.class)
public class NumberToWordConvertorTest{

	@InjectMocks
	NumberToWordConvertor numberToWordConvertor;
	
	@Test
	public void testGetBritishEngLishWord(){
		//Outside accepted range
		int inputNum= -1;
		assertEquals("Input is out of range", numberToWordConvertor.getBritishEnglishWord(inputNum));
		
		//Edge cases
		inputNum=1;
		assertEquals("one", numberToWordConvertor.getBritishEnglishWord(inputNum));
		inputNum=999999999;
		assertEquals("nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine", numberToWordConvertor.getBritishEnglishWord(inputNum));
		
		//Invalid format of integer used
		int octalNumber = 014;
		assertNotSame("fourteen",numberToWordConvertor.getBritishEnglishWord(inputNum));
	}
	
	@Test
	public void testConvertToWords(){
		//Input between 1 an 10
		int input = 4;
		assertEquals("four", numberToWordConvertor.convertToWords(input));
		input = 10;
		assertEquals("ten", numberToWordConvertor.convertToWords(input));
		
		//Input between 11 and 100
		input = 13;
		assertEquals("thirteen", numberToWordConvertor.convertToWords(input));
		input = 50;
		assertEquals("fifty", numberToWordConvertor.convertToWords(input));
		input=97;
		assertEquals("ninety seven", numberToWordConvertor.convertToWords(input));
		
		
		//Input between 1000 and 99999
		input= 1067;
		assertEquals("one thousand sixty seven", numberToWordConvertor.convertToWords(input));
		input = 10432;
		assertEquals("ten thousand four hundred and thirty two", numberToWordConvertor.convertToWords(input));
		
		//Input between 100,000 to 999,999
		input = 501200;
		assertEquals("five hundred and one thousand two hundred", numberToWordConvertor.convertToWords(input));
		
		//Input between 100,000,000 to 999,999,999
		input= 921312143;
		assertEquals("nine hundred and twenty one million three hundred and twelve thousand one hundred and forty three", numberToWordConvertor.convertToWords(input));
		
	}
}
