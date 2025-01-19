package hu.unideb.inf.thesis.bonfirecritic.mapper;

import hu.unideb.inf.thesis.bonfirecritic.dto.PlatformDTO;
import hu.unideb.inf.thesis.bonfirecritic.model.Platform;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PlatformMapper {

    @Mapping(source = "name", target = "platform")
    PlatformDTO toDTO(Platform platform);

    @Mapping(source = "platform", target = "name")
    Platform toEntity(PlatformDTO platformDTO);
}
