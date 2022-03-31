package br.com.zup.handora.cadastrobasico1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(CarroController.BASE_URI + "/{carroId}" + AcidenteController.BASE_URI)
public class AcidenteController {

    public final static String BASE_URI = "/acidentes";

}
