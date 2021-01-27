package co.com.dnatest.service.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import co.com.dnatest.service.implementation.DNATestService;

public class DNATestServiceUT {

	private DNATestService currentDNATestService;
	private String[] dnaStringSequence1 = { "AGGTGF", "AAGTGC", "AAAAGT", "AGGGGG", "CGCCGA", "TCACTG" };// cadena no valida
	private String[] dnaStringSequence2 = { "AGGTGGG", "AAGTGC", "AAAAGT", "AGGGGG", "CGCCGA", "TCACTG" };// cadena no valida
	private String[] dnaStringSequence3 = { "AGG", "AAG", "AAA", "AGG", "CGC", "TCA" };// cadena no valida
	private String[] dnaStringSequence4 = { "AGGTGC", "AAGTGC", "AAAAGT", "AGGGGG", "CGCCGA", "TCACTG" };// cadena no valida
	
	private String[] dnaStringSequence5 = {"AGGTGA","CAGTGC","TTACGT","AGGAGG","CGCCTA","TCACTG"};//1 obliquo + 1 Vertical
	
	private String[] dnaStringSequence6 = {"AGGTGA","CAGTAC","TTCGGT","AGGAGG","CGCCTA","TCACTG"};//ninguna secuencia
	
	private String[] dnaStringSequence7 = {"AGGTGA","CAGTGC","TTTTGT","AGGTGG","CGCGTA","TCACGG"};//1 vertical + 1 horizontal

	@Test
	public void testValidateDNA() {
		currentDNATestService = new DNATestService();
		Boolean result = currentDNATestService.validateDNA(dnaStringSequence1);
		assertTrue(!result);
		result = currentDNATestService.validateDNA(dnaStringSequence2);
		assertTrue(!result);
		result = currentDNATestService.validateDNA(dnaStringSequence3);
		assertTrue(!result);
		result = currentDNATestService.validateDNA(dnaStringSequence4);
		assertTrue(result);

	}
	
	@Test
	public void testIsMutant() {
		currentDNATestService = new DNATestService();
		Boolean result = currentDNATestService.isMutant(dnaStringSequence1);
		assertFalse(result);
		result = currentDNATestService.isMutant(dnaStringSequence5);
		assertTrue(result);
		result = currentDNATestService.isMutant(dnaStringSequence6);
		assertFalse(result);
		result = currentDNATestService.isMutant(dnaStringSequence7);
		assertTrue(result);
	
	}
	
	
}
