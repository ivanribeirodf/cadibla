package br.com.batistalivreacesso.cadibla.service;

import br.com.batistalivreacesso.cadibla.domain.Position;
import br.com.batistalivreacesso.cadibla.repositories.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PositionService {

    @Autowired
    private PositionRepository repository;

    public List<Position> listAllPosition(){
        return repository.findAll();
    }

    public Optional<Position> findByID(UUID id) {
        return repository.findById(id);
    }

    public Position salvar(Position position){
        return repository.save(position);
    }

    public void delete(UUID id){
        repository.deleteById(id);
    }
}

