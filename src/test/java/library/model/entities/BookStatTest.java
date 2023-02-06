package library.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BookStatTest {
    BookStat bookStat;

    @Before
    public void testBuildBookStat() {
        bookStat = new BookStat.Builder().setId(7).setTotal(10).setInStock(14)
                .setReserved(5).setTimesWasBooked(3).build();
    }

    @Test
    public void testGetMethods() {
        Assert.assertEquals(bookStat.getId(), 7);
        Assert.assertEquals(bookStat.getTotal(), 10);
        Assert.assertEquals(bookStat.getInStock(), 14);
        Assert.assertEquals(bookStat.getReserved(), 5);
        Assert.assertEquals(bookStat.getTimesWasBooked(), 3);
    }

    @Test
    public void testEqualsMethod() {
        BookStat bookStat2 = new BookStat.Builder().setId(7).setTotal(10).setInStock(14).setReserved(5).setTimesWasBooked(3).build();
        Assert.assertEquals(bookStat.equals(bookStat2), true);
    }

    @Test
    public void testHashCodeMethod() {
        BookStat bookStat2 = new BookStat.Builder().setId(7).setTotal(10).setInStock(14)
                .setReserved(5).setTimesWasBooked(3).build();
        Assert.assertEquals(bookStat.hashCode(), bookStat2.hashCode());
    }
}