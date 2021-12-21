package volby.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import volby.entities.vote.Vote;
import volby.entities.vote.VoteCreationDTO;
import volby.services.VoteService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "/api/votes")
public class VoteREST {
    @Autowired
    VoteService voteService;

    @GetMapping
    private ResponseEntity<List<Vote>> getAllCandidates() {
        return voteService.getAllVotes();
    }

    @PostMapping
    private ResponseEntity createCandidate(@RequestBody VoteCreationDTO vote) {
        return voteService.createVote(vote);
    }
}
