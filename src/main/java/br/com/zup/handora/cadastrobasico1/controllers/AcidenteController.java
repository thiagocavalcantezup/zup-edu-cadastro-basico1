package br.com.zup.handora.cadastrobasico1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
