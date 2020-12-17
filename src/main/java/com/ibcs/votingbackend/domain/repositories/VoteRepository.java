package com.ibcs.votingbackend.domain.repositories;

import com.ibcs.votingbackend.domain.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoteRepository extends JpaRepository<Vote, String> {
}
