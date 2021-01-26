package co.com.dnatest.service;

import java.util.List;

import co.com.dnatest.service.model.DNASequence;

public interface IDNATestService {

	Boolean isMutant(String[] dna);
	
	DNASequence create(String[] dna, Boolean isMutant);
	
	List<DNASequence> getAll();
	
	DNASequence getByDna(String[] dna);
}
