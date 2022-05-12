package pl.sda.rest1.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.sda.rest1.exceptions.ResourceNotFoundException;
import pl.sda.rest1.model.NearestCity;
import pl.sda.rest1.repos.NearestCityRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NearestCityService {

    private final NearestCityRepository nearestCityRepository;

    public List<NearestCity> fetchAll() {
        return nearestCityRepository.findAll();
    }

    public NearestCity getById(Long id) {
        return nearestCityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Nearest City by ID " + id + " not found"));
    }


}
