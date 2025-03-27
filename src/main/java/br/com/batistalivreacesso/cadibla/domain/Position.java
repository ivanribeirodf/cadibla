package br.com.batistalivreacesso.cadibla.domain;

import io.swagger.v3.oas.annotations.media.Schema;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "position_ibla")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(example = "0361c0c4-8da6-11ef-88cd-cecb03cd8761")
    private UUID id;

    @Schema(example = "John Lennon")
    private String name;

    @Schema(example = "Description of the position")
    private String description;

    @OneToMany(mappedBy = "position", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<User> users;

}
