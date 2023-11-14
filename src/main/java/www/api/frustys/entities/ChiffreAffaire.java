package www.api.frustys.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "ChiffreAffaire")
public class ChiffreAffaire {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "MONTH")
    private String month;

    @Column(name = "TotalMontant")
    private BigDecimal totalMontant;

}

