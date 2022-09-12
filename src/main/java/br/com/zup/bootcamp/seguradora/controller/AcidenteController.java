package br.com.zup.bootcamp.seguradora.controller;

import br.com.zup.bootcamp.seguradora.model.Acidente;
import br.com.zup.bootcamp.seguradora.model.Carro;
import br.com.zup.bootcamp.seguradora.repository.AcidenteRepository;
import br.com.zup.bootcamp.seguradora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/carros/{id}/acidentes")
public class AcidenteController {

    @Autowired
    private final CarroRepository carroRepository;
    private final AcidenteRepository acidenteRepository;

    public AcidenteController(CarroRepository carroRepository, AcidenteRepository acidenteRepository) {
        this.carroRepository = carroRepository;
        this.acidenteRepository = acidenteRepository;
    }

    @PostMapping
    public ResponseEntity<String> cadastra(@PathVariable Long id, @Valid @RequestBody AcidenteRequest request, UriComponentsBuilder uriComponentsBuilder){

        Carro carro = carroRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Carro nao encontrado"));

        Acidente novoAcidente = request.toModel(carro);

        acidenteRepository.save(novoAcidente);

        URI location = uriComponentsBuilder.path("/carros/{id}/acidentes/{id}").buildAndExpand(carro.getId(),novoAcidente.getId()).toUri();

        return ResponseEntity.created(location).body("acidente cadastrado com sucesso");




    }
}
