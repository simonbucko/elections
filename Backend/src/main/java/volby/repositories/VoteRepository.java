package volby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volby.entities.vote.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Integer> {
}
