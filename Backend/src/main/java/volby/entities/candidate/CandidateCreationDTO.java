package volby.entities.candidate;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CandidateCreationDTO {
    private String name;
    private int party;
}
