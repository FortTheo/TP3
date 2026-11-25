package main.tp3.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CapaciteRepository extends CrudRepository<Capacite, Integer> {
}
