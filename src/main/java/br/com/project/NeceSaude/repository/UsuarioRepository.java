package br.com.project.NeceSaude.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.project.NeceSaude.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    public Optional<Usuario> findByEmail(String email);
    public Optional<Usuario> findBySenha(String senha);
}
