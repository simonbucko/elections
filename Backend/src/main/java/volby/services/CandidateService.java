package volby.services;

import com.sun.tools.jconsole.JConsoleContext;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import volby.entities.Party.Party;
import volby.entities.candidate.Candidate;
import volby.entities.candidate.CandidateCreationDTO;
import volby.entities.candidate.CandidateUpdateDTO;
import volby.repositories.CandidateRepository;
import volby.repositories.PartyRepository;

import java.util.List;


@Service
public class CandidateService {
    CandidateRepository candidateRepository;
    PartyRepository partyRepository;
    ModelMapper modelMapper;

    public CandidateService(CandidateRepository candidateRepository, PartyRepository partyRepository){
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
        this.modelMapper = new ModelMapper();
    }

    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return new ResponseEntity<>(candidateRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<Candidate> createCandidate(CandidateCreationDTO candidate) {
        Party party = partyRepository.getById(candidate.getParty());
        Candidate newCandidate = new Candidate();
        newCandidate.setName(candidate.getName());
        newCandidate.setParty(party);
        return new ResponseEntity<>(candidateRepository.save(newCandidate), HttpStatus.OK);
    }

    public ResponseEntity<Candidate> updateCandidate(CandidateUpdateDTO candidate) {
        Candidate savedCandidate = candidateRepository.getById(candidate.getId());
        Party party = partyRepository.getById(candidate.getParty());
        savedCandidate.setName(candidate.getName());
        savedCandidate.setParty(party);
        return new ResponseEntity<>(candidateRepository.save(savedCandidate), HttpStatus.OK);
    }

    public ResponseEntity deleteCandidate(int id) {
        candidateRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
