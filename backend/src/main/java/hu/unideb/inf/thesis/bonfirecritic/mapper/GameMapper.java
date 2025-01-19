package hu.unideb.inf.thesis.bonfirecritic.mapper;

import hu.unideb.inf.thesis.bonfirecritic.dto.GameDTO;
import hu.unideb.inf.thesis.bonfirecritic.model.Game;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ActorMapper.class, PlatformMapper.class})
public interface GameMapper {

    @Mapping(source = "actors", target = "actorsDTO")
    @Mapping(source = "platforms", target = "platformsDTO")
    GameDTO toDTO(Game game);

    @Mapping(source = "actorsDTO", target = "actors")
    @Mapping(source = "platformsDTO", target = "platforms")
    Game toEntity(GameDTO gameDTO);
}
