
package br.com.bibliotecajogos.service;

import br.com.bibliotecajogos.entity.Categoria;
import br.com.bibliotecajogos.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Listar todas as categorias
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    // Buscar por ID
    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    // Salvar ou atualizar
    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    // Excluir
    public void excluir(Long id) {
        categoriaRepository.deleteById(id);
    }
}
