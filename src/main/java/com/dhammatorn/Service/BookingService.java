package com.dhammatorn.Service;

import com.dhammatorn.Dao.BookingDao;
import com.dhammatorn.Entity.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class BookingService {

    @Autowired
    private BookingDao BookingDao;

}