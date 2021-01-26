package co.com.dnatest.service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import co.com.dnatest.service.model.DNASequence;

@Repository
public interface DNASequenceRepository extends MongoRepository<DNASequence, String>{

	public DNASequence findByDna(String[] dna);
}
