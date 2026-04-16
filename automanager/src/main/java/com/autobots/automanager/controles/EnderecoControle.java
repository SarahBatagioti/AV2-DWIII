package com.autobots.automanager.controles;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.autobots.automanager.entidades.Endereco;
import com.autobots.automanager.modelo.dto.endereco.EnderecoDTO;
import com.autobots.automanager.servicos.endereco.AtualizadorEnderecoServico;
import com.autobots.automanager.servicos.endereco.CadastradorEnderecoServico;
import com.autobots.automanager.servicos.endereco.ConsultadorEnderecoServico;
import com.autobots.automanager.servicos.endereco.RemovedorEnderecoServico;

@RestController
@RequestMapping("/clientes/{clienteId}/endereco")
public class EnderecoControle {

    @Autowired
    private CadastradorEnderecoServico cadastrador;

    @Autowired
    private ConsultadorEnderecoServico consultador;

    @Autowired
    private AtualizadorEnderecoServico atualizador;

    @Autowired
    private RemovedorEnderecoServico removedor;

    @GetMapping
    public ResponseEntity<Endereco> buscarPorCliente(@PathVariable Long clienteId) {
        Endereco endereco = consultador.buscarPorCliente(clienteId);
        return ResponseEntity.ok(endereco);
    }

    @PostMapping
    public ResponseEntity<Endereco> cadastrar(@PathVariable Long clienteId, @Valid @RequestBody EnderecoDTO dto) {
        Endereco criado = cadastrador.cadastrar(clienteId, dto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(location).body(criado);
    }

    @PutMapping
    public ResponseEntity<Endereco> atualizar(@PathVariable Long clienteId, @Valid @RequestBody EnderecoDTO dto) {
        Endereco atualizado = atualizador.atualizar(clienteId, dto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        removedor.remover(clienteId);
        return ResponseEntity.noContent().build();
    }
}
