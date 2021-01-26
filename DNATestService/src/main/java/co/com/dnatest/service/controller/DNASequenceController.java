package co.com.dnatest.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.core.Response;

import co.com.dnatest.service.implementation.DNATestService;
import co.com.dnatest.service.vo.DNASequenceVO;

@RestController
public class DNASequenceController {

	
	@Autowired
	private DNATestService dnaTestService;
	
	@PostMapping("/isMutant")
	public ResponseEntity isMutant(@RequestBody DNASequenceVO obj) {
		try {
			
			//dnaTestService.isMutant(dna);
			
			return new ResponseEntity<>(HttpStatus.OK);//obj.getDna();
		} catch (Exception e) {
			return null;
		}
	}
	
}
