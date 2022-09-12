package br.com.zup.bootcamp.seguradora.repository;

import br.com.zup.bootcamp.seguradora.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

}
