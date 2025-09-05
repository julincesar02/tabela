package com.youxlab.tabela.anatable.controller;

import com.youxlab.tabela.anatable.dto.TarefaDTO;
import com.youxlab.tabela.anatable.dto.TarefaEditarDTO;
import com.youxlab.tabela.anatable.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<TarefaDTO> salvarTarefa(@RequestBody TarefaDTO dto){
        return ResponseEntity.ok().body(service.salvar(dto));
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> buscarTodasTarefas(){
        return ResponseEntity.ok().body(service.buscarTodasTarefas());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TarefaDTO> atualizar(@PathVariable("id") Long id, @RequestBody TarefaDTO dto){
        return ResponseEntity.ok().body(service.atualizar(id , dto));
    }

    @PatchMapping("/editar/{id}")
    public ResponseEntity<TarefaEditarDTO> atualizarTabela(@PathVariable("id") Long id , @RequestBody TarefaEditarDTO dto){
        return ResponseEntity.ok().body(service.atuatizarTabela(id , dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarDTO(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(service.deletarDTO(id));
    }
//    @GetMapping("/status")
//    public ResponseEntity<List<String>> status(){
//        return ResponseEntity.ok().body(service.buscarStatus());
//    }
}
