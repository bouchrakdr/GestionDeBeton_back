package com.esi.msauth.repository;


import com.esi.msauth.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubredditRepository  extends JpaRepository<Subreddit,Long> {
}
