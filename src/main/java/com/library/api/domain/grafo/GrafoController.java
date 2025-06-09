package com.library.api.domain.grafo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recomendaciones")
public class GrafoController {

    @Autowired
    private GrafoService grafoService;

    @GetMapping
    public List<String> obtenerRecomendaciones(@RequestParam String libro, @RequestParam int topN){
        return grafoService.obtenerRecomendaciones(libro, topN);
    }
}
