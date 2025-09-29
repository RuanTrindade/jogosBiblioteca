
package br.com.bibliotecajogos.controller;

import br.com.bibliotecajogos.entity.Categoria;
import br.com.bibliotecajogos.entity.Estudio;
import br.com.bibliotecajogos.entity.Jogo;
import br.com.bibliotecajogos.service.CategoriaService;
import br.com.bibliotecajogos.service.EstudioService;
import br.com.bibliotecajogos.service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @Autowired
    private CategoriaService categoriaService;

    @Autowired
    private EstudioService estudioService;


    @GetMapping("/jogos")
    public String listarJogos(Model model, @RequestParam(defaultValue = "titulo") String sortBy) {
        model.addAttribute("jogos", jogoService.listarTodos(sortBy));
        return "jogos";
    }

    @GetMapping("/jogos/novo")
    public String novoJogoForm(Model model) {
        Jogo jogo = new Jogo();
        jogo.setCategoria(new Categoria());
        jogo.setEstudio(new Estudio());
        model.addAttribute("jogo", jogo);
        model.addAttribute("categorias", categoriaService.listarTodos());
        model.addAttribute("estudios", estudioService.listarTodos());
        return "formulario-jogo";
    }


    @PostMapping("/jogos")
    public String salvarJogo(@ModelAttribute("jogo") Jogo jogo) {
        jogoService.salvar(jogo);
        return "redirect:/jogos";
    }

    @GetMapping("/jogos/editar/{id}")
    public String editarJogoForm(@PathVariable Long id, Model model) {
        Jogo jogo = jogoService.buscarPorId(id);
        // Se algum deles for null, inicializa para evitar erro no form
        if (jogo.getCategoria() == null) {
            jogo.setCategoria(new Categoria());
        }
        if (jogo.getEstudio() == null) {
            jogo.setEstudio(new Estudio());
        }

        model.addAttribute("jogo", jogo);
        model.addAttribute("categorias", categoriaService.listarTodos());
        model.addAttribute("estudios", estudioService.listarTodos());
        return "formulario-jogo";
    }

    @GetMapping("/jogos/excluir/{id}")
    public String excluirJogo(@PathVariable Long id) {
        jogoService.excluir(id);
        return "redirect:/jogos";
    }

    @GetMapping("/jogos/pesquisar")
    public String pesquisarJogos(@RequestParam String termo, @RequestParam String tipo, Model model) {
        model.addAttribute("jogos", jogoService.pesquisar(termo, tipo));
        return "jogos";
    }
}