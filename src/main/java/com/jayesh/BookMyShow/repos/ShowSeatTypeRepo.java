package com.jayesh.BookMyShow.repos;

import com.jayesh.BookMyShow.models.Show;
import com.jayesh.BookMyShow.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepo extends JpaRepository<ShowSeatType, Long> {
    List<ShowSeatType> findByShow(Show show);
}
