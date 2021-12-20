package volby.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import volby.entities.Party.Party;

@Repository
public interface PartyRepository extends JpaRepository<Party, Integer> {
}
