package online.db.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class FourCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq")
    @SequenceGenerator(name = "hibernate_seq", sequenceName = "four_category_seq", allocationSize = 1)
    private Long id;

    private String nameCategory;

    @OneToMany(mappedBy = "fourCategory")
    private List<NextCategory> nextCategory;
}
