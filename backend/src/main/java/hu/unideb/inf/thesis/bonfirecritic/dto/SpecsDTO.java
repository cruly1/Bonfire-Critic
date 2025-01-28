package hu.unideb.inf.thesis.bonfirecritic.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SpecsDTO {
    private String cpu;
    private String ram;
    private String gpu;
    private String storage;
}
