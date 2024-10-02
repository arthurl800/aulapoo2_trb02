package br.edu.ifgoias.academico.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifgoias.academico.entities.Disciplina;
import br.edu.ifgoias.academico.repositories.DisciplinaRepository;

@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> listarTodas() {
        return disciplinaRepository.findAll();
    }

    public Disciplina buscarPorId(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

    public Disciplina inserir(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public Disciplina alterar(Long id, Disciplina disciplina) {
        Disciplina disciplinaExistente = disciplinaRepository.findById(id).orElse(null);
        if (disciplinaExistente != null) {
            disciplinaExistente.setNome(disciplina.getNome());
            return disciplinaRepository.save(disciplinaExistente);
        }
        return null;
    }

    public void excluir(Long id) {
        disciplinaRepository.deleteById(id);
    }
}
