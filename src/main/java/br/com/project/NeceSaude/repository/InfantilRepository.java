package br.com.project.NeceSaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.NeceSaude.model.Infantil;

public interface InfantilRepository extends JpaRepository<Infantil, Long> {

    Optional<Infantil> findByCpfRespo(String cpfRespo);
    
}
