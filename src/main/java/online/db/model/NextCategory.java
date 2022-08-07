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
public class NextCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq")
    @SequenceGenerator(name = "hibernate_seq", sequenceName = "category_seq", allocationSize = 1)
    private Long id;

    private String name;

    @ManyToOne
    private FourCategory fourCategory;

    @OneToMany(mappedBy = "nextCategory")
    private List<Products> products;
}
