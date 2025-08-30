package br.com.cantaruttim.repository;

import br.com.cantaruttim.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // esse repository acessa os dados no banco
}
