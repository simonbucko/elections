package volby.entities.candidate;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import volby.entities.Party.Party;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "Candidates")
public class Candidate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    @ManyToOne(cascade = CascadeType.DETACH)
    //this means that the join this by teacher column in Student table that referes to id in teacher
    @JoinColumn(name="parties_id",referencedColumnName = "id")
    @JsonIgnoreProperties("candidates")
    private Party party;
}
