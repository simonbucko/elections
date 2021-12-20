package volby.entities.candidate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CandidateUpdateDTO {
    private int id;
    private String name;
    private int party;
}
