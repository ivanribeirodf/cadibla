package br.com.batistalivreacesso.cadibla.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Date BirthDate;
    private String Email;
    private String CPF;
    private String Phone;
    private String Address;
    private String City;
    private String State;
    private String Zip;
    private String Country;
    private String Description;
    private Date baptism;
    private String Password;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;


}
