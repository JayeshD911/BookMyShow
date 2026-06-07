package com.jayesh.BookMyShow.repos;

import com.jayesh.BookMyShow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long> {
}
