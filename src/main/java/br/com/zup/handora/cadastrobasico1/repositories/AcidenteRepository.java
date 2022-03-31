package br.com.zup.handora.cadastrobasico1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.handora.cadastrobasico1.models.Acidente;

public interface AcidenteRepository extends JpaRepository<Acidente, Long> {

}
