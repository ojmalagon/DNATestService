package co.com.dnatest.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import co.com.dnatest.service.Iterator;
import co.com.dnatest.service.model.DNASequence;

public class DNASequenceUT {

	private DNASequence currentDNASequence;
	
	private String[] dnaStringSequence1 = {"AGGTGA","AAGTGC","AAAAGT","AGGGGG","CGCCGA","TCACTG"};
	
	private String[] dnaStringSequence2 = {"AGGTGA","CAGTGC","TTACGT","AGGAGG","CGCCTA","TCACTG"};//1 obliquo + 1 Vertical
	
	private String[] dnaStringSequence3 = {"AGGTGA","CAGTAC","TTCGGT","AGGAGG","CGCCTA","TCACTG"};//ninguna secuencia
	
	private String[] dnaStringSequence4 = {"AGGTGA","CAGTGC","TTTTGT","AGGTGG","CGCGTA","TCACGG"};//1 vertical + 1 horizontal
	@Test 
	public void testSetIndexI() {
		currentDNASequence = new DNASequence(dnaStringSequence1,false);
		Iterator iterator;
		iterator = currentDNASequence.iterator();
		char charValue = (char)iterator.getCharValue(0, 0);
		assertTrue(charValue =='A');
	}
	@Test
	public void testNextCharHorizontal(){
	
		currentDNASequence = new DNASequence(dnaStringSequence2,false);
		Iterator iterator;
		iterator = currentDNASequence.iterator();
		char charValue = (char)iterator.nextCharHorizontal();
		assertTrue(charValue =='G');
	}
	@Test
	public void testNextCharVertical(){
	
		currentDNASequence = new DNASequence(dnaStringSequence2,false);
		Iterator iterator;
		iterator = currentDNASequence.iterator();
		char charValue = (char)iterator.nextCharVertical();
		assertTrue(charValue =='C');
	}
	@Test
	public void testPreviousChar(){
		currentDNASequence = new DNASequence(dnaStringSequence2,false);
		Iterator iterator;
		iterator = currentDNASequence.iterator();
		char charValue = (char)iterator.nextCharHorizontal();
		iterator.nextCharHorizontal();
		char preiousCharValue = (char)iterator.previousChar();
		assertTrue(charValue == preiousCharValue);
	}
	@Test
	public void testNextCharOblique(){
		currentDNASequence = new DNASequence(dnaStringSequence2,false);
		Iterator iterator;
		iterator = currentDNASequence.iterator();
		char charValue = (char)iterator.nextCharOblique();
		assertTrue(charValue =='A');
	}
	@Test
	public void testPreviousCharOblique(){
		currentDNASequence = new DNASequence(dnaStringSequence2,false);
		Iterator iterator;
		iterator = currentDNASequence.iterator();
		iterator.nextCharOblique();
		iterator.nextCharOblique();
		char charValue = (char)iterator.getCharValue(3, 1);
		char preiousCharValue = (char)iterator.previousCharOblique();
		 
		assertTrue(charValue == preiousCharValue);
	}
	/*@Test
	public void testGetCharValue(int i, int j){
	
	}
	@Test
	public void testHasNextChar(){
	
	}
	@Test
	public void testHasPreviousChar(){
	
	}
	@Test
	public void testHasNextCharOblique(){
	
	}
	@Test
	public void testHasPreviousCharOblique(){
	
	}
	@Test
	public void testHasOblique(){
	
	}
	@Test
	public void testHasHorizontal(){
	
	}
	@Test
	public void testHasVertical(){
	
	}
	@Test
	public void testGetSequenceCount(){
	
	}*/
}
