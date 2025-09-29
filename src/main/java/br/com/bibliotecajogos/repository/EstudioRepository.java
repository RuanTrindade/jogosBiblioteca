
package br.com.bibliotecajogos.repository;

import br.com.bibliotecajogos.entity.Estudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudioRepository extends JpaRepository<Estudio, Long> {
}
