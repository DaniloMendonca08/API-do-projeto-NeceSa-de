package br.com.project.NeceSaude.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.NeceSaude.model.Exame;

public interface ExameRepository extends JpaRepository<Exame, Integer>{
}
