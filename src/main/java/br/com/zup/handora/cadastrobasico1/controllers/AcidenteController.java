package br.com.zup.handora.cadastrobasico1.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.cadastrobasico1.models.Acidente;
import br.com.zup.handora.cadastrobasico1.models.AcidenteDTO;
import br.com.zup.handora.cadastrobasico1.models.Carro;
import br.com.zup.handora.cadastrobasico1.repositories.AcidenteRepository;
import br.com.zup.handora.cadastrobasico1.repositories.CarroRepository;

@RestController
@RequestMapping(CarroController.BASE_URI + "/{carroId}" + AcidenteController.BASE_URI)
public class AcidenteController {

    public final static String BASE_URI = "/acidentes";

    private final CarroRepository carroRepository;
    private final AcidenteRepository acidenteRepository;

    public AcidenteController(CarroRepository carroRepository,
                              AcidenteRepository acidenteRepository) {
        this.carroRepository = carroRepository;
        this.acidenteRepository = acidenteRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@PathVariable Long carroId,
                                       @RequestBody @Valid AcidenteDTO acidenteDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {

        Carro carro = carroRepository.findById(carroId)
                                     .orElseThrow(
                                         () -> new ResponseStatusException(
                                             HttpStatus.NOT_FOUND,
                                             "Não existe um carro com o ID informado."
                                         )
                                     );
        Acidente acidente = acidenteRepository.save(acidenteDTO.paraAcidente(carro));

        URI location = uriComponentsBuilder.path(
            CarroController.BASE_URI + "/{carroId}" + AcidenteController.BASE_URI + "/{id}"
        ).buildAndExpand(carro.getId(), acidente.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
