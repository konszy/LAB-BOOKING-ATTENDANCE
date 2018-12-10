package com.dhammatorn.Dao;

import com.dhammatorn.Entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface Booking_interface extends JpaRepository<Booking,Integer>{

}
