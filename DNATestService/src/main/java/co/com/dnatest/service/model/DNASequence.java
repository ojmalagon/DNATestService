package co.com.dnatest.service.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class DNASequence {

	



	@Id
	private String id;
	
	private String[] DNASecuence;
	private Boolean isMutant;

	public DNASequence(String[] dNASecuence, Boolean isMutant) {
		super();
		DNASecuence = dNASecuence;
		this.isMutant = isMutant;
	}


	
	public String[] getDNASecuence() {
		return DNASecuence;
	}


	public void setDNASecuence(String[] dNASecuence) {
		DNASecuence = dNASecuence;
	}


	public Boolean getIsMutant() {
		return isMutant;
	}


	public void setIsMutant(Boolean isMutant) {
		this.isMutant = isMutant;
	}


	
	
	
	@Override
	public String toString() {
		return "DNASequence [id=" + id + ", DNASecuence=" + DNASecuence + ", isMutant=" + isMutant + "]";
	}
	
}
