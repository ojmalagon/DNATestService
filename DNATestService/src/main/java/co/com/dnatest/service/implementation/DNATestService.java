package co.com.dnatest.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.dnatest.service.IDNATestService;
import co.com.dnatest.service.model.DNASequence;
import co.com.dnatest.service.repository.DNASequenceRepository;

@Service
public class DNATestService implements IDNATestService{

	@Autowired
	private DNASequenceRepository dnaSequenceRepository;
	
	@Override
	public Boolean isMutant(String[] dnaSequence) {
		
		return true;
	}
	
	@Override
	public DNASequence create(String[] dnaSequence, Boolean isMutant) {
		return dnaSequenceRepository.save(new DNASequence(dnaSequence,isMutant));
	}

	@Override
	public List<DNASequence> getAll() {
		return dnaSequenceRepository.findAll();
	}

}
