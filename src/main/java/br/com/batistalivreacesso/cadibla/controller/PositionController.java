package br.com.batistalivreacesso.cadibla.controller;

import br.com.batistalivreacesso.cadibla.domain.Position;
import br.com.batistalivreacesso.cadibla.repositories.PositionRepository;
import br.com.batistalivreacesso.cadibla.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "/position")
public class PositionController {

    @Autowired
    private PositionService positionService;

    @GetMapping
    public List<Position> findAll(){
        return positionService.listAllPosition();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Position> findById(@PathVariable UUID id){
        Optional<Position> result  = positionService.findByID(id);
        if(result.isPresent()) {
            return ResponseEntity.ok(result.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Position> insert(@RequestBody Position position){
        try {
            Position result = positionService.salvar(position);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }


}
