package br.com.batistalivreacesso.cadibla.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_ibla")
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    private String Name;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate BirthDate;
    private String Email;
    private String CPF;
    private String Phone;
    private String Address;
    private String City;
    private String State;
    private String Zip;
    private String Country;
    private String Description;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate baptism;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate enterChurch;
    private String Password;

    @ManyToOne(fetch = FetchType.EAGER) // Garante que o Position será carregado automaticamente
    @JoinColumn(name = "position_id", nullable = false)
    private Position position;


}
