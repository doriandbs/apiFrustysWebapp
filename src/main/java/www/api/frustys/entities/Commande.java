package www.api.frustys.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "COMMANDES")
@Getter
@Setter
public class Commande {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "DATE")
    private LocalDate date;

    @Column(name = "TOTAL")
    private int total;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "COMMENTARY")
    private String commentary;

}
