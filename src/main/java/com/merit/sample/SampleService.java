package com.merit.sample;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class SampleService {
    private final SampleRepository sampleRepository;

    public SampleService(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
    }

    public List<SampleEntity> getAllSample() {
        return sampleRepository.findAll();
    }

    public SampleEntity getSampleById(Long sampleId) {
        return sampleRepository.findById(sampleId).orElseThrow(NoSuchElementException::new);
    }

    public SampleEntity addSample(SampleEntity sampleEntity) {
        return sampleRepository.save(sampleEntity);
    }

    public void removeSampleById(Long sampleId) {
        SampleEntity sampleEntityToDelete = sampleRepository.findById(sampleId).orElseThrow(NoSuchElementException::new);
        sampleRepository.delete(sampleEntityToDelete);
    }

    public void removeSampleByEwr(Long ewrId) {

    }

    public List<SampleEntity> findByEwrList(String ewrName) {
        return sampleRepository.findByEwrList(ewrName);
    }
}
