package com.media.unimamerica.Media;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


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
    @Size(min = 20, max = 20, message = "A quantidade de caracteres é inválida")

    @Column(name = "numeros")
    private List<Float> numeros;

}
