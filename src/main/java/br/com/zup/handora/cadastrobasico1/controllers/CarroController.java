package br.com.zup.handora.cadastrobasico1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
