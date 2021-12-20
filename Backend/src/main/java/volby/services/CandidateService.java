package volby.services;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import volby.entities.candidate.Candidate;
import volby.repositories.CandidateRepository;

import java.util.List;


@Service
public class CandidateService {
    CandidateRepository candidateRepository;
    ModelMapper modelMapper;

    public CandidateService(CandidateRepository candidateRepository){
        this.candidateRepository = candidateRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return new ResponseEntity<>(candidateRepository.findAll(), HttpStatus.OK);
    }
}
