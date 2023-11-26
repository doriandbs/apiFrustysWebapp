package www.api.frustys.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "burger")
@Getter
@Setter
public class BurgerEntity {

    @Id
    @Column(name = "id_burger")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

}
