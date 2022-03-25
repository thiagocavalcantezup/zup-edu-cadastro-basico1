package br.com.zup.handora.cadastrobasico1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.handora.cadastrobasico1.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
