package katerinarajmanova.projekty.zahrada.service;

import katerinarajmanova.projekty.zahrada.entity.Rostlina;
import katerinarajmanova.projekty.zahrada.repository.RostlinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TridaService {

    private final RostlinaRepository rostlinaRepository;

    @Autowired
    public TridaService(RostlinaRepository rostlinaRepository) {
        this.rostlinaRepository = rostlinaRepository;
    }

    public List<Rostlina> seznam() {
        return rostlinaRepository.findAll();
    }

    public Page<Rostlina> seznamJaro(Pageable pageable) {
        return rostlinaRepository.findRostlinasByPeceJaroIsNotNull(pageable);
    }

    public Page<Rostlina> seznamPodzim(Pageable pageable) {
        return rostlinaRepository.findRostlinasByPecePodzimIsNotNull(pageable);
    }

    public Rostlina findById(Integer id,Pageable pageable) {
        Optional<Rostlina> rostlina = rostlinaRepository.findById(id);
        return rostlina.get();
    }

    public void novaRostlina(Rostlina rostlina){
        rostlinaRepository.save(rostlina);
    }

    public void smazat(Integer id) {
        rostlinaRepository.deleteById(id);
    }
}