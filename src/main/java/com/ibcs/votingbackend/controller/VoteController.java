package com.ibcs.votingbackend.controller;

import com.ibcs.votingbackend.dto.request.VoteRequest;
import com.ibcs.votingbackend.dto.response.VoteResultResponse;
import com.ibcs.votingbackend.services.VoteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.List;

@RestController
@RequestMapping("vote")
@CrossOrigin("*")
@AllArgsConstructor
public class VoteController {
    private final VoteService voteService;

    @PostMapping("/add")
    public ResponseEntity<Void> addNewVote(@RequestBody VoteRequest voteRequest )
    {
       return voteService.addNewVote(voteRequest);
    }

    @GetMapping("/result")
    public ResponseEntity<List<VoteResultResponse>> addNewVote()
    {
        return voteService.getVoteResult();
    }

}
