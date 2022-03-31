package br.com.zup.handora.cadastrobasico1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.handora.cadastrobasico1.models.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro, Long> {

}
