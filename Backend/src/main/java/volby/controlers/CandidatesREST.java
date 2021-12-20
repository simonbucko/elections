package volby.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import volby.entities.candidate.Candidate;
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
}
