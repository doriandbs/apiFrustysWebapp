package www.api.frustys.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "userweb")
@Data
public class UtilisateurEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

}
