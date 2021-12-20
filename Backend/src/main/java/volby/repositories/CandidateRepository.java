package volby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volby.entities.candidate.Candidate;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
}
