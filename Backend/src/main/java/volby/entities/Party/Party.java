package volby.entities.Party;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import volby.entities.candidate.Candidate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Parties")
public class Party {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @OneToMany(mappedBy = "party")
    @JsonIgnoreProperties("party")
    private List<Candidate> candidates = new ArrayList<>();
}
