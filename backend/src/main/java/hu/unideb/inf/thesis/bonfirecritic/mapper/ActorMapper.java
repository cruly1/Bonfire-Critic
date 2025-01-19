package hu.unideb.inf.thesis.bonfirecritic.mapper;

import hu.unideb.inf.thesis.bonfirecritic.dto.ActorDTO;
import hu.unideb.inf.thesis.bonfirecritic.model.Actor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ActorMapper {

    ActorDTO toDTO(Actor actor);

    Actor toEntity(ActorDTO actorDTO);
}
