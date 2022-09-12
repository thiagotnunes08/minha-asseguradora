package br.com.zup.bootcamp.seguradora.repository;

import br.com.zup.bootcamp.seguradora.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroRepository extends JpaRepository<Carro,Long> {
}
