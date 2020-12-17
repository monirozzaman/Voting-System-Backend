package com.ibcs.votingbackend.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public class VoteResultResponse {

    private String votingDate;

    private String symbolName;

    private int totalVote;
}
