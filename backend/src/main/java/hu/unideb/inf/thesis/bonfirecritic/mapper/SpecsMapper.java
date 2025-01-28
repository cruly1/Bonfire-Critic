package hu.unideb.inf.thesis.bonfirecritic.mapper;

import hu.unideb.inf.thesis.bonfirecritic.dto.SpecsDTO;
import hu.unideb.inf.thesis.bonfirecritic.model.Specs;
import org.springframework.stereotype.Component;

@Component
public class SpecsMapper {

    public SpecsDTO toDTO(Specs specs) {
        return SpecsDTO.builder()
                .cpu(specs.getCpu())
                .gpu(specs.getGpu())
                .ram(specs.getRam())
                .storage(specs.getStorage())
                .build();
    }

    public Specs toEntity(SpecsDTO dto) {
        return Specs.builder()
                .cpu(dto.getCpu())
                .gpu(dto.getGpu())
                .ram(dto.getRam())
                .storage(dto.getStorage())
                .build();
    }
}
