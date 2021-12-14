package com.example.roombookingserver.repository;

import com.example.roombookingserver.model.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findAllByBookingDate(LocalDate bookingDate);
}
