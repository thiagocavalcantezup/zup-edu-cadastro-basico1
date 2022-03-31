package br.com.zup.handora.cadastrobasico1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.cadastrobasico1.models.Carro;

public interface CarroRepository extends JpaRepository<Carro, Long> {

}
