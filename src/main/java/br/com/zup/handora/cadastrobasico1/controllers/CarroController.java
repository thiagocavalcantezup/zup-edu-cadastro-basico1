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

import br.com.zup.handora.cadastrobasico1.models.Carro;
import br.com.zup.handora.cadastrobasico1.models.CarroDTO;
import br.com.zup.handora.cadastrobasico1.models.Cliente;
import br.com.zup.handora.cadastrobasico1.repositories.CarroRepository;
import br.com.zup.handora.cadastrobasico1.repositories.ClienteRepository;

@RestController
@RequestMapping(ClienteController.BASE_URI + "/{clienteId}" + CarroController.BASE_URI)
public class CarroController {

    public final static String BASE_URI = "/carros";

    private final ClienteRepository clienteRepository;
    private final CarroRepository carroRepository;

    public CarroController(ClienteRepository clienteRepository, CarroRepository carroRepository) {
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@PathVariable Long clienteId,
                                       @RequestBody @Valid CarroDTO carroDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {

        Cliente cliente = clienteRepository.findById(clienteId)
                                           .orElseThrow(
                                               () -> new ResponseStatusException(
                                                   HttpStatus.NOT_FOUND,
                                                   "Não existe um cliente com o ID informado."
                                               )
                                           );
        Carro carro = carroRepository.save(carroDTO.paraCarro(cliente));

        URI location = uriComponentsBuilder.path(
            ClienteController.BASE_URI + "/{clienteId}" + CarroController.BASE_URI + "/{id}"
        ).buildAndExpand(cliente.getId(), carro.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

}
