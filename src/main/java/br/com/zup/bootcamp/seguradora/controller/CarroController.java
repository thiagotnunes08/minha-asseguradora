package br.com.zup.bootcamp.seguradora.controller;

import br.com.zup.bootcamp.seguradora.dto.CarroRequest;
import br.com.zup.bootcamp.seguradora.model.Carro;
import br.com.zup.bootcamp.seguradora.model.Cliente;
import br.com.zup.bootcamp.seguradora.repository.CarroRepository;
import br.com.zup.bootcamp.seguradora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("clientes/{idCliente}/carros")
public class CarroController {

    @Autowired
    private final ClienteRepository clienteRepository;
    private final  CarroRepository carroRepository;

    public CarroController(ClienteRepository clienteRepository, CarroRepository carroRepository) {
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
    }

    @PostMapping
    public ResponseEntity<String> cadastra(@PathVariable Long idCliente, @Valid @RequestBody CarroRequest request, UriComponentsBuilder uriComponentsBuilder){

        Cliente cliente = clienteRepository.findById(idCliente).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "usuário nao encontrado"));

        Carro novoCarro = request.toCarro(cliente);

        carroRepository.save(novoCarro);

        URI location = uriComponentsBuilder.path("clientes/{idCliente}/carros/{id}").buildAndExpand(cliente.getId(),novoCarro.getId()).toUri();

        return ResponseEntity.created(location).body("carro cadastrado com sucesso");

    }
}
