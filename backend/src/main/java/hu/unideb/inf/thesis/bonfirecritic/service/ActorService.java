package hu.unideb.inf.thesis.bonfirecritic.service;

import hu.unideb.inf.thesis.bonfirecritic.model.Actor;
import hu.unideb.inf.thesis.bonfirecritic.repository.ActorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActorService {

    private final ActorRepository actorRepository;

    public Actor createActor(String name) {
        Optional<Actor> existingActor = actorRepository.findByName(name);

        if (existingActor.isPresent()) {
            return existingActor.get();
        }

        Actor newActor = Actor.builder()
                .name(name)
                .build();
        return actorRepository.save(newActor);
    }
}
