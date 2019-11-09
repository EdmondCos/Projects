package tables;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "item_category")
public class ItemCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemCategory_gen")
    @SequenceGenerator(name = "itemCategory_gen", sequenceName = "itemCategory_seq", allocationSize = 1)
    private long id;

    @Column(name = "name")
    private String name;

    // Categorie detine un set de Iteme
    @OneToMany(mappedBy = "category")
    private Set<Item> items;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
