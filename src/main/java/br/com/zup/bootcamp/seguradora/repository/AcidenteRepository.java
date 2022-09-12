package br.com.zup.bootcamp.seguradora.repository;

import br.com.zup.bootcamp.seguradora.model.Acidente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcidenteRepository extends JpaRepository<Acidente,Long> {
}
