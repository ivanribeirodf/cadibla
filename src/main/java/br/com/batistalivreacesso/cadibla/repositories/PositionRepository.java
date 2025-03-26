package br.com.batistalivreacesso.cadibla.repositories;

import br.com.batistalivreacesso.cadibla.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PositionRepository extends JpaRepository<Position, UUID> {

}
