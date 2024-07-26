package com.example.exercice3.service;


import com.example.exercice3.dto.candidate.CandidateDtoGet;
import com.example.exercice3.dto.candidate.CandidateDtoPost;
import com.example.exercice3.entity.Candidate;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CandidateService {
    List<CandidateDtoGet> getAllCandidates();

    CandidateDtoGet saveCandidate(CandidateDtoPost candidateDtoPost);

    CandidateDtoGet getCandidateById(int id);

    void deleteCandidateById(int id);

//    Page<CandidateDtoGet> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
