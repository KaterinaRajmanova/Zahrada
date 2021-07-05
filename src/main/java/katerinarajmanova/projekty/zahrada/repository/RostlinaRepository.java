package katerinarajmanova.projekty.zahrada.repository;

import katerinarajmanova.projekty.zahrada.entity.Rostlina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RostlinaRepository extends JpaRepository<Rostlina, Integer> {
}
