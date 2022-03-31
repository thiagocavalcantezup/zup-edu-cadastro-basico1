package br.com.zup.handora.cadastrobasico1.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ClienteController.BASE_URI + "/{clienteId}" + CarroController.BASE_URI)
public class CarroController {

    public final static String BASE_URI = "/carros";

}
