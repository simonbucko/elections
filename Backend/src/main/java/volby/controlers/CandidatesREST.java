package volby.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volby.entities.candidate.Candidate;
import volby.entities.candidate.CandidateCreationDTO;
import volby.entities.candidate.CandidateUpdateDTO;
import volby.services.CandidateService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/candidates")
public class CandidatesREST {
    @Autowired
    CandidateService candidateService;

    @GetMapping
    private ResponseEntity<List<Candidate>> getAllCandidates() {
        return candidateService.getAllCandidates();
    }

    @PostMapping
    private ResponseEntity<Candidate> createCandidate(@RequestBody CandidateCreationDTO candidate) {
        return candidateService.createCandidate(candidate);
    }

    @PutMapping
    private ResponseEntity<Candidate> updateCandidate(@RequestBody CandidateUpdateDTO candidate) {
        return candidateService.updateCandidate(candidate);
    }
}
