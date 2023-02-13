package library.model.entities;

import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.*;

public class BookingTest {
    private Booking booking;
    private User user;
    private Calendar modified = new GregorianCalendar(2023, Calendar.JANUARY, 25);

    @Before
    public void testBuilderBooking() {
        user = new User.Builder().setId(3).build();
        modified.set(Calendar.HOUR_OF_DAY, 8);
        modified.set(Calendar.MINUTE, 30);
        modified.set(Calendar.SECOND, 55);
        booking = new Booking.Builder().setId(1).setUser(user).setState(Booking.State.BOOKED)
                .setLocated(Booking.Place.LIBRARY).setModified(modified).build();
    }

    @Test
    public void testBookingGetMethods() {
        assertEquals(booking.getId(), 1);
        assertEquals(booking.getUser().getId(), 3);
        assertEquals(booking.getState(), Booking.State.BOOKED);
        assertEquals(booking.getLocated(), Booking.Place.LIBRARY);
        assertEquals(booking.getModified().getTime().toString(), "Wed Jan 25 08:30:55 EET 2023");
    }
}