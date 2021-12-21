package volby.entities.vote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import volby.entities.Party.Party;
import volby.entities.candidate.Candidate;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Votes")
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String cpr;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="candidates_id",referencedColumnName = "id")
    @JsonIgnoreProperties("votes")
    private Candidate candidate;

}
