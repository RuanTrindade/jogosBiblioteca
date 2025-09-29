
package br.com.bibliotecajogos.service;

import br.com.bibliotecajogos.entity.Estudio;
import br.com.bibliotecajogos.repository.EstudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstudioService {

    @Autowired
    private EstudioRepository estudioRepository;

    public List<Estudio> listarTodos() {
        return estudioRepository.findAll();
    }

    public Estudio buscarPorId(Long id) {
        return estudioRepository.findById(id).orElse(null);
    }

    public Estudio salvar(Estudio estudio) {
        return estudioRepository.save(estudio);
    }

    public void excluir(Long id) {
        estudioRepository.deleteById(id);
    }
}
