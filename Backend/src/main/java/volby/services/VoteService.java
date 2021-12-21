package volby.services;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import volby.entities.Party.Party;
import volby.entities.candidate.Candidate;
import volby.entities.vote.Vote;
import volby.entities.vote.VoteCreationDTO;
import volby.repositories.CandidateRepository;
import volby.repositories.PartyRepository;
import volby.repositories.VoteRepository;

import java.util.List;

@Service
public class VoteService {
    CandidateRepository candidateRepository;
    PartyRepository partyRepository;
    VoteRepository voteRepository;
    ModelMapper modelMapper;

    public VoteService(VoteRepository voteRepository, CandidateRepository candidateRepository, PartyRepository partyRepository){
        this.candidateRepository = candidateRepository;
        this.partyRepository = partyRepository;
        this.voteRepository = voteRepository;
        this.modelMapper = new ModelMapper();
    }


    public ResponseEntity<List<Vote>> getAllVotes() {
        return new ResponseEntity<>(voteRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity createVote(VoteCreationDTO vote) {
        Vote newVote = new Vote();
        Candidate candidate = candidateRepository.getById(vote.getCandidateId());
        newVote.setCandidate(candidate);
        newVote.setCpr(vote.getCpr());
        voteRepository.save(newVote);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
