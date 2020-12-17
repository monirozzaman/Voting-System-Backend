package com.ibcs.votingbackend.dto.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class VoteRequest {

    private String symbolName;

    private int totalVote;
}
