
package br.com.bibliotecajogos.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String pais;

    @OneToMany(mappedBy = "estudio")
    private List<Jogo> jogos;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public List<Jogo> getJogos() { return jogos; }
    public void setJogos(List<Jogo> jogos) { this.jogos = jogos; }
}
