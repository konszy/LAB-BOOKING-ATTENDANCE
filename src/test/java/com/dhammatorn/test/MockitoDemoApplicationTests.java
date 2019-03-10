package com.dhammatorn.test;

import com.dhammatorn.Dao.BookingRepository;
import com.dhammatorn.Service.BookingService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dhammatorn.Entity.Booking;
import java.util.Optional;


@SpringBootTest
//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
public class MockitoDemoApplicationTests {

    @Autowired
    private BookingService bookingService;

    @MockBean
    private BookingRepository bookingRepository;

    @Test
    public void testGetAllBooking() {
        List<Booking> test_booking = new ArrayList<>();
        Booking temp = new Booking();
        temp.setStartTime(9);
        temp.setEndTime(10);
        temp.setDay("MON");
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(0);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);

        Booking temp2 = new Booking();
        temp2.setStartTime(9);
        temp2.setEndTime(10);
        temp2.setDay("MON");
        temp2.setRsop(0);
        temp2.setBnc_croclead(0);
        temp2.setPower_supp(0);
        temp2.setActive8(0);
        temp2.setResistors(0);
        temp2.setSolidCoreWire(0);
        temp2.setCapacitors(0);
        temp2.setStudent(0);
        temp2.setSeatNo("A1");
        temp2.setLength(1);
        temp2.setRs_4mmplug(0);
        temp2.setPrototyping_board(0);
        temp2.setBnc_Tpiece(0);
        temp2.setBnc_lead(0);
        temp2.setLcr400_bridge(0);
        temp2.setWire_strippers(0);
        temp2.setOscilloscope_trim(0);

        test_booking.add(temp);
        test_booking.add(temp2);

        Mockito.when(bookingRepository.findAll()).thenReturn(test_booking);
//        bookingService.saveBooking(temp);
//        List<Booking> bookings = new ArrayList<>();
//        bookingRepository.findAll().forEach(bookings::add);
        assertThat(bookingService.getAllBookings()).isEqualTo(test_booking);
    }

    @Test
    public void testGetbyID(){
        Booking temp = new Booking();
        temp.setStartTime(9);
        temp.setEndTime(10);
        temp.setDay("MON");
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(0);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);
        temp.setId(1);

        Optional<Booking> opt_book = Optional.of(temp);

        Mockito.when(bookingRepository.findById(1)).thenReturn(opt_book);
        assertThat(bookingService.getBookingById(1)).isEqualTo(opt_book);
    }

    @Test
    public void testcreateTicket(){
        Booking temp = new Booking();
        temp.setStartTime(9);
        temp.setEndTime(10);
        temp.setDay("MON");
        temp.setRsop(0);
        temp.setBnc_croclead(0);
        temp.setPower_supp(0);
        temp.setActive8(0);
        temp.setResistors(0);
        temp.setSolidCoreWire(0);
        temp.setCapacitors(0);
        temp.setStudent(0);
        temp.setSeatNo("A1");
        temp.setLength(1);
        temp.setRs_4mmplug(0);
        temp.setPrototyping_board(0);
        temp.setBnc_Tpiece(0);
        temp.setBnc_lead(0);
        temp.setLcr400_bridge(0);
        temp.setWire_strippers(0);
        temp.setOscilloscope_trim(0);
        temp.setId(1);

        Optional<Booking> opt_book = Optional.of(temp);
        Mockito.when(bookingRepository.save(temp)).thenReturn(temp);
        assertThat(bookingService.saveBooking(temp)).isEqualTo(1);
    }
}
