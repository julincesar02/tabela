package com.youxlab.tabela.anatable.controller;

import com.youxlab.tabela.anatable.service.StatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/status")
@CrossOrigin(origins = "http://localhost:5173")
public class StatusController {

    private final StatusService service;

    public StatusController(StatusService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<String>> buscarTodasStatus(){
        return ResponseEntity.ok().body(service.buscarTodosStatus());
    }
}
