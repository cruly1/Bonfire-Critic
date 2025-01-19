package hu.unideb.inf.thesis.bonfirecritic.service;

import hu.unideb.inf.thesis.bonfirecritic.model.specs.Specs;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.CPU;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.GPU;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.RAM;
import hu.unideb.inf.thesis.bonfirecritic.model.specs.hardware.Storage;
import hu.unideb.inf.thesis.bonfirecritic.repository.specs.SpecsRepository;
import hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware.CPURepository;
import hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware.GPURepository;
import hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware.RAMRepository;
import hu.unideb.inf.thesis.bonfirecritic.repository.specs.hardware.StorageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpecsService {

    private final GPURepository gpuRepository;
    private final CPURepository cpuRepository;
    private final RAMRepository ramRepository;
    private final StorageRepository storageRepository;
    private final SpecsRepository specsRepository;

    public Specs createSpecs(Specs specs) {
        Optional<GPU> existingGpu = gpuRepository.findByModel(specs.getGpu().getModel());
        if (existingGpu.isPresent()) {
            specs.setGpu(existingGpu.get());
        } else {
            GPU savedGpu = gpuRepository.save(specs.getGpu());
            specs.setGpu(savedGpu);
        }

        Optional<CPU> existingCpu = cpuRepository.findByModel(specs.getCpu().getModel());
        if (existingCpu.isPresent()) {
            specs.setCpu(existingCpu.get());
        } else {
            CPU savedCpu = cpuRepository.save(specs.getCpu());
            specs.setCpu(savedCpu);
        }

        Optional<RAM> existingRam = ramRepository.findBySizeInGB(specs.getRam().getSizeInGB());
        if (existingRam.isPresent()) {
            specs.setRam(existingRam.get());
        } else {
            RAM savedRam = ramRepository.save(specs.getRam());
            specs.setRam(savedRam);
        }

        Optional<Storage> existingStorage = storageRepository.findBySizeInGB(specs.getStorage().getSizeInGB());
        if (existingStorage.isPresent()) {
            specs.setStorage(existingStorage.get());
        } else {
            Storage savedStorage = storageRepository.save(specs.getStorage());
            specs.setStorage(savedStorage);
        }

        return specsRepository.save(specs);
    }
}
