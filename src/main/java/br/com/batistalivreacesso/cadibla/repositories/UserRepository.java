package br.com.batistalivreacesso.cadibla.repositories;


import br.com.batistalivreacesso.cadibla.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

}
