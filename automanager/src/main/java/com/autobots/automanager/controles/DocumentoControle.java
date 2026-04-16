package com.autobots.automanager.controles;

import java.util.List;
import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.autobots.automanager.entidades.Documento;
import com.autobots.automanager.modelo.dto.documento.DocumentoDTO;
import com.autobots.automanager.servicos.documento.AtualizadorDocumentoServico;
import com.autobots.automanager.servicos.documento.CadastradorDocumentoServico;
import com.autobots.automanager.servicos.documento.ConsultadorDocumentoServico;
import com.autobots.automanager.servicos.documento.RemovedorDocumentoServico;

@RestController
@RequestMapping("/clientes/{clienteId}/documentos")
public class DocumentoControle {

    @Autowired
    private CadastradorDocumentoServico cadastrador;

    @Autowired
    private ConsultadorDocumentoServico consultador;

    @Autowired
    private AtualizadorDocumentoServico atualizador;

    @Autowired
    private RemovedorDocumentoServico removedor;

    @GetMapping
    public ResponseEntity<List<Documento>> listar(@PathVariable Long clienteId) {
        List<Documento> documentos = consultador.listarPorCliente(clienteId);
        return ResponseEntity.ok(documentos);
    }

    @GetMapping("/{documentoId}")
    public ResponseEntity<Documento> buscarPorId(@PathVariable Long clienteId, @PathVariable Long documentoId) {
        Documento documento = consultador.buscarPorId(clienteId, documentoId);
        return ResponseEntity.ok(documento);
    }

    @PostMapping
    public ResponseEntity<Documento> cadastrar(@PathVariable Long clienteId, @Valid @RequestBody DocumentoDTO dto) {
        Documento criado = cadastrador.cadastrar(clienteId, dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{documentoId}")
                .buildAndExpand(criado.getId())
                .toUri();
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping("/{documentoId}")
    public ResponseEntity<Documento> atualizar(@PathVariable Long clienteId,
                                               @PathVariable Long documentoId,
                                               @Valid @RequestBody DocumentoDTO dto) {
        Documento atualizado = atualizador.atualizar(clienteId, documentoId, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{documentoId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId, @PathVariable Long documentoId) {
        removedor.removerPorId(clienteId, documentoId);
        return ResponseEntity.noContent().build();
    }
}
