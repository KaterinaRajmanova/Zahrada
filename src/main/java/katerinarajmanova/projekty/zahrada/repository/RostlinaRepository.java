package katerinarajmanova.projekty.zahrada.repository;

import katerinarajmanova.projekty.zahrada.entity.Rostlina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RostlinaRepository extends JpaRepository<Rostlina, Integer> {

    Page<Rostlina> findRostlinasByPeceJaroIsNotNull(Pageable pageable);
    Page<Rostlina> findRostlinasByPecePodzimIsNotNull(Pageable pageable);
}

