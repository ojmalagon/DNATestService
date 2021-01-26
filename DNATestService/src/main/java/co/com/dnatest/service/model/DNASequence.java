package co.com.dnatest.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.dnatest.service.implementation.DNASequenceIterator;

@Document
public class DNASequence {

	@Id
	private String id;
	
	private String[] dna;
	private Boolean isMutant;

	public DNASequence(String[] dNASecuence, Boolean isMutant) {
		super();
		dna = dNASecuence;
		this.isMutant = isMutant;
	}


	
	public String[] getDNA() {
		return dna;
	}


	public void setDNA(String[] dNASecuence) {
		dna = dNASecuence;
	}


	public Boolean getIsMutant() {
		return isMutant;
	}


	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}

	
	@Override
	public String toString() {
		return "DNASequence [id=" + id + ", DNASecuence=" + dna + ", isMutant=" + isMutant + "]";
	}
	
	public DNASequenceIterator iterator() {
		return new DNASequenceIterator(dna);
	}
	
}
