package br.edu.ifgoias.academico.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.services.DisciplinaService;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaResource {
    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina>
 listarTodas() {
        return disciplinaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> buscarPorId(@PathVariable Long id) {
        Disciplina disciplina = disciplinaService.buscarPorId(id);
        return disciplina != null ? ResponseEntity.ok(disciplina) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Disciplina inserir(@RequestBody Disciplina disciplina) {
        return disciplinaService.inserir(disciplina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> alterar(@PathVariable Long id, @RequestBody Disciplina disciplina) {
        Disciplina disciplinaAtualizada = disciplinaService.alterar(id, disciplina);
        return disciplinaAtualizada != null ? ResponseEntity.ok(disciplinaAtualizada) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        disciplinaService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
