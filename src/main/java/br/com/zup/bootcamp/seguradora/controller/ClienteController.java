package br.com.zup.bootcamp.seguradora.controller;

import br.com.zup.bootcamp.seguradora.dto.ClienteRequest;
import br.com.zup.bootcamp.seguradora.model.Cliente;
import br.com.zup.bootcamp.seguradora.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private final ClienteRepository repository;

    public ClienteController(ClienteRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<String> cadastra(@Valid @RequestBody ClienteRequest request, UriComponentsBuilder uriComponentsBuilder){


        Cliente novoCliente = request.toModel();

        repository.save(novoCliente);

        URI location = uriComponentsBuilder.path("/clientes/{id}").buildAndExpand(novoCliente.getId()).toUri();

        return ResponseEntity.created(location).body("Usuário criado com sucesso");



    }


}
