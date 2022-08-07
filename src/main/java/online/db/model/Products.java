package online.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter
@RequiredArgsConstructor
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq")
    @SequenceGenerator(name = "hibernate_seq", sequenceName = "product_seq", allocationSize = 1)
    @Column(name = "product_id")
    private Long productId;

    private String manufacturer;
    private String model;
    private int weight;
    private Double price;
    private String about;

    @ManyToOne
    private NextCategory nextCategory;

    @ManyToOne
    private FourCategory fourCategory;

    @ManyToMany(cascade = CascadeType.REMOVE)
    @JsonIgnore
    @JoinTable(
            name = "product_basket"
            , joinColumns = @JoinColumn(name = "product_id")
            , inverseJoinColumns = @JoinColumn(name = "basket_id"))
    private List<Basket> basket;
}
