package co.com.dnatest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.dnatest.service.IDNATestService;
import co.com.dnatest.service.Iterator;
import co.com.dnatest.service.model.DNASequence;
import co.com.dnatest.service.repository.DNASequenceRepository;

@Service
public class DNATestService implements IDNATestService{

	@Autowired
	private DNASequenceRepository dnaSequenceRepository;
	
	@Override
	public Boolean isMutant(String[] dna) {
		
		DNASequence objDNASequence = new DNASequence(dna, false);
		if (validateDNA(dna)) {
			Iterator iterator;
			iterator = objDNASequence.iterator();
			
			iterator.hasHorizontal();
			iterator.hasVertical();
			iterator.hasOblique();
			
			return (int)iterator.getSequenceCount()>1;
		}
		return false;
	}
	
	@Override
	public DNASequence create(String[] dnaSequence, Boolean isMutant) {
		return dnaSequenceRepository.save(new DNASequence(dnaSequence,isMutant));
	}

	@Override
	public List<DNASequence> getAll() {
		return dnaSequenceRepository.findAll();
	}
	
	public boolean validateDNA(String[] dna) {

		for (String string : dna) {

			if (string.length() != dna.length) {
				// No cumple con la regla NxN
				return false;
			} else if (string.length() < 4) {
				// No tiene la longitud minima.
				return false;
			} else {
				for (int i = 0; i < string.length(); i++) {
					
					if (string.charAt(i)!='A' && string.charAt(i)!='T' && string.charAt(i)!='C' && string.charAt(i)!='G') {
						return false;
					}

				}
			}

		}

		return true;

	}

}
