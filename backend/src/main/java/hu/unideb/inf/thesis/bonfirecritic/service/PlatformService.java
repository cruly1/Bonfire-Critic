package hu.unideb.inf.thesis.bonfirecritic.service;

import hu.unideb.inf.thesis.bonfirecritic.model.Platform;
import hu.unideb.inf.thesis.bonfirecritic.repository.PlatformRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlatformService {

    private final PlatformRepository platformRepository;

    public Platform createPlatform(String platformName) {
        Optional<Platform> existingPlatform = platformRepository.findByName(platformName);

        if (existingPlatform.isPresent()) {
            return existingPlatform.get();
        }

        Platform platform = Platform.builder()
                .name(platformName)
                .build();
        return platformRepository.save(platform);
    }
}
