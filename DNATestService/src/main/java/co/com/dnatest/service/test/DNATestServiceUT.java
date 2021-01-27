package co.com.dnatest.service.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import co.com.dnatest.service.implementation.DNATestService;

public class DNATestServiceUT {

	private DNATestService currentDNATestService;
	private String[] dnaStringSequence1 = { "AGGTGF", "AAGTGC", "AAAAGT", "AGGGGG", "CGCCGA", "TCACTG" };// cadena no valida
	private String[] dnaStringSequence2 = { "AGGTGGG", "AAGTGC", "AAAAGT", "AGGGGG", "CGCCGA", "TCACTG" };// cadena no valida
	private String[] dnaStringSequence3 = { "AGG", "AAG", "AAA", "AGG", "CGC", "TCA" };// cadena no valida
	private String[] dnaStringSequence4 = { "AGGTGC", "AAGTGC", "AAAAGT", "AGGGGG", "CGCCGA", "TCACTG" };// cadena no valida

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
}
