package www.api.frustys.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "ACCOMPAGNEMENT")
@Getter
@Setter
public class Accompagnement {

    @Id
    @Column(name = "id_accompagnement")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "description")
    private String description;

}

