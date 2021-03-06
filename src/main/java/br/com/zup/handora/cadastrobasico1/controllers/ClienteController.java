package br.com.zup.handora.cadastrobasico1.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.handora.cadastrobasico1.models.Cliente;
import br.com.zup.handora.cadastrobasico1.models.ClienteDTO;
import br.com.zup.handora.cadastrobasico1.repositories.ClienteRepository;

@RestController
@RequestMapping(ClienteController.BASE_URI)
public class ClienteController {

    private final ClienteRepository clienteRepository;

    public static final String BASE_URI = "/clientes";

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid ClienteDTO clienteDTO,
                                       UriComponentsBuilder uriComponentsBuilder) {
        Cliente cliente = clienteRepository.save(clienteDTO.paraCliente());

        URI location = uriComponentsBuilder.path(ClienteController.BASE_URI + "/{id}")
                                           .buildAndExpand(cliente.getId())
                                           .toUri();

        return ResponseEntity.created(location).build();
    }

}
