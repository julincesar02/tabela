package com.youxlab.tabela.anatable.controller;

import com.youxlab.tabela.anatable.dto.CategoriaDTO;
import com.youxlab.tabela.anatable.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriaController {

    private final CategoriaService service;

    public CategoriaController(CategoriaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> salvarCategoria(@RequestBody CategoriaDTO dto){
        service.salvarCategoria(dto);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscarTodasCategorias(){
        return ResponseEntity.ok().body(service.buscarTodasCategorias());
    }

}
