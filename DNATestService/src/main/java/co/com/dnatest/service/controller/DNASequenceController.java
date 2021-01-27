package co.com.dnatest.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;
import java.util.List;

import javax.ws.rs.core.Response;

import co.com.dnatest.service.implementation.DNATestService;
import co.com.dnatest.service.model.DNASequence;
import co.com.dnatest.service.model.DNAStatsVO;

@RestController
public class DNASequenceController {

	
	@Autowired
	private DNATestService dnaTestService;
	
	@PostMapping("/mutant/")
	public ResponseEntity isMutant(@RequestBody DNASequence obj) {
		try {
			Boolean result=false;
			if(dnaTestService.isMutant(obj.getDNA())) {
				result=true;
			}
			obj.setIsMutant(result);
			if(dnaTestService.getByDna(obj.getDNA())==null) {//Se valida para registrar solo una vez la secuencia de ADN evaluada.
				dnaTestService.create(obj.getDNA(), obj.getIsMutant());
			}
			
			if(result) {
				return new ResponseEntity<>(HttpStatus.OK);
			}			
			
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping("/stats")
	public DNAStatsVO stats() {
		try {
			
			List<DNASequence> lsDNASequence= dnaTestService.getAll();
			
			int humanCount=0;
			int mutantCount=0;
			double ratio=0;
			for (Iterator iterator = lsDNASequence.iterator(); iterator.hasNext();) {
				
				DNASequence dnaSequence = (DNASequence) iterator.next();
				if(dnaSequence.getIsMutant()) {
					mutantCount++;
				}
				else {
					humanCount++;
				}
			}
			if(lsDNASequence.size()>0 && humanCount>0) {
				//ratio=mutantCount/lsDNASequence.size();
				ratio=mutantCount/humanCount;
			}
			else {
				ratio=mutantCount;
			}
			
			
			DNAStatsVO obStats = new DNAStatsVO();
			obStats.setCount_human_dna(humanCount);
			obStats.setCount_mutant_dna(mutantCount);
			obStats.setRatio(ratio);
			
			return obStats;
		} catch (Exception e) {
			return null;
		}
	}
	
}
