package com.ibcs.votingbackend.services;

import com.ibcs.votingbackend.config.Utility;
import com.ibcs.votingbackend.domain.model.Vote;
import com.ibcs.votingbackend.domain.repositories.VoteRepository;
import com.ibcs.votingbackend.dto.request.VoteRequest;
import com.ibcs.votingbackend.dto.response.VoteResultResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class VoteService {

    private final VoteRepository voteRepository;


    public ResponseEntity<Void> addNewVote(VoteRequest voteRequest) {

        String id = Utility.getUuid();
        Vote vote = new Vote();
        vote.setId(id);
        vote.setDate(Utility.getCurrentDate());
        vote.setSymbolName(voteRequest.getSymbolName());
        vote.setTotalVote(voteRequest.getTotalVote());

        voteRepository.save(vote);
        return new ResponseEntity(HttpStatus.OK);

    }

    public ResponseEntity<List<VoteResultResponse>> getVoteResult() {

        int countFOrDhaKa = 0;
        int countFOrCtg = 0;

        List<VoteResultResponse> voteResultResponseList = new ArrayList<>();
        List<Vote> voteList = voteRepository.findAll();

        if (voteList.isEmpty()) {
            return new ResponseEntity(null, HttpStatus.NO_CONTENT);
        }
        for (Vote vote : voteList) {
            System.out.println(vote.getSymbolName());
            if (vote.getSymbolName().equals("dhaka")) {
                countFOrDhaKa = countFOrDhaKa+vote.getTotalVote();
            } else if(vote.getSymbolName().equals("chittagong")) {
                countFOrCtg = countFOrCtg+vote.getTotalVote();
            }
        }
        System.out.println(countFOrDhaKa +"-------------"+countFOrCtg);
        voteResultResponseList.add(new VoteResultResponse(Utility.getCurrentDate(), "dhaka", countFOrDhaKa));
        voteResultResponseList.add(new VoteResultResponse(Utility.getCurrentDate(), "chittagong", countFOrCtg));
        return new ResponseEntity(voteResultResponseList, HttpStatus.OK);
    }
}
