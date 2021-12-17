package com.example.roombookingserver.rest;

import com.example.roombookingserver.model.entities.Booking;
import com.example.roombookingserver.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class RestBookingsController {

    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping("/{date}")
    public List<Booking> getBookingByDate(@PathVariable String date){
        Date sqlDate = Date.valueOf(date);
        return bookingRepository.findAllByDate(sqlDate);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id){
        bookingRepository.deleteById(id);
    }

//    @GetMapping
//    public List<Booking> getAllBookings(){
//       return bookingRepository.findAll();
//    }

    @GetMapping
    public Booking getBookingById(@RequestParam Long id){
       return bookingRepository.findById(id).get();
    }
}