package online.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernate_seq")
    @SequenceGenerator(name = "hibernate_seq", sequenceName = "basket_seq", allocationSize = 1)
    @Column(name = "basket_id")
    private Long basketId;

    @ManyToMany
    @JoinTable(
            name = "products_basket"
            , joinColumns = @JoinColumn(name = "basket_id")
            , inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Products> products;

    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;

    public void clear() {
        products.removeIf(books -> true);
    }
}
