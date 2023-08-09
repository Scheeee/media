package com.media.unimamerica.Media;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "numeros", schema = "public")
public class Numero {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
    @Setter
    @Column(name = "id", nullable = false)
    private Long id;
    @Getter
    @Setter
    @Column(name = "nome")
    float numero;

}
