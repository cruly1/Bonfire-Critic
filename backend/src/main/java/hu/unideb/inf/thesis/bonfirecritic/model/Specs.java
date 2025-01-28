package hu.unideb.inf.thesis.bonfirecritic.model;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Specs {

    private String cpu;
    private String gpu;
    private String ram;
    private String storage;
}

