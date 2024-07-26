package com.example.exercice3.service;

import com.example.exercice3.dto.candidate.CandidateDtoGet;
import com.example.exercice3.dto.candidate.CandidateDtoPost;
import com.example.exercice3.entity.Candidate;
import com.example.exercice3.exception.NotFoundException;
import com.example.exercice3.repository.CandidateRepository;
import com.example.exercice3.util.DateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CandidateServiceImpl implements CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Override
    public List<CandidateDtoGet> getAllCandidates() {
        return candidatesTocandidateDtoGets((List<Candidate>) candidateRepository.findAll());
    }

    @Override
    public CandidateDtoGet saveCandidate(CandidateDtoPost candidateDtoPost) {
        Candidate candidate = Candidate.builder()
                .name(candidateDtoPost.getName())
                .identificationNumber(candidateDtoPost.getIdentificationNumber())
                .address(candidateDtoPost.getAddress())
                .phone(candidateDtoPost.getPhone())
                .email(candidateDtoPost.getPhone())
                .birthDate(LocalDate.parse(candidateDtoPost.getBirthDateStr(), DateFormat.DATE_FORMAT))
                .rating(candidateDtoPost.getRating())
                .observation(candidateDtoPost.getObservation())
                .skills(candidateDtoPost.getSkills())
                .technicalArea(candidateDtoPost.getTechnicalArea())
                .jobInterviewDate(LocalDate.parse(candidateDtoPost.getJobInterviewDateStr(), DateFormat.DATE_FORMAT))
                .build();

        this.candidateRepository.save(candidate);

        return candidateToCandidateDtoGet(candidate);
    }

    @Override
    public CandidateDtoGet getCandidateById(int id) {
        Candidate candidate = candidateRepository.findById(id).orElseThrow(NotFoundException::new);
        return candidateToCandidateDtoGet(candidate);
    }

    @Override
    public void deleteCandidateById(int id) {
        candidateRepository.deleteById(id);
    }


    private CandidateDtoGet candidateToCandidateDtoGet (Candidate candidate){
        return CandidateDtoGet.builder()
                .id(candidate.getId())
                .name(candidate.getName())
                .identificationNumber(candidate.getIdentificationNumber())
                .address(candidate.getAddress())
                .phone(candidate.getPhone())
                .email(candidate.getEmail())
                .birthDate(candidate.getBirthDate())
                .rating(candidate.getRating())
                .observation(candidate.getObservation())
                .skills(candidate.getSkills())
                .technicalArea(candidate.getTechnicalArea())
                .jobInterviewDate(candidate.getJobInterviewDate())
                .build();
    }

    private List<CandidateDtoGet> candidatesTocandidateDtoGets (List<Candidate> candidates){
        return candidates.stream().map(this::candidateToCandidateDtoGet).collect(Collectors.toList());
    }
}
