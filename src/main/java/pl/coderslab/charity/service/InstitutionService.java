package pl.coderslab.charity.service;

import org.springframework.stereotype.Service;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.InstitutionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstitutionService {
    private InstitutionRepository institutionRepository;

    public InstitutionService(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    public List<Institution> showAll(){
        return institutionRepository.findAll();
    }

    public Optional<Institution> show(Long id){
        return institutionRepository.findById(id);
    }

    public void saveInstitution(Institution institution) {
        institutionRepository.save(institution);
    }

}
