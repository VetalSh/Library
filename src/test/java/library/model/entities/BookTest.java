package library.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
    Book book;

    @Before
    public void testBuildBook() {
        book = new Book.Builder().setId(10).setTitle("Java").setIsbn("978-985-581-391-1")
                .setLangCode("en").setKeepPeriod(14).setYear(2021).build();
    }

    @Test
    public void testBookGetMethods() {

        Assert.assertEquals(book.getId(), 10);
        Assert.assertEquals(book.getTitle(), "Java");
        Assert.assertEquals(book.getIsbn(), "978-985-581-391-1");
        Assert.assertEquals(book.getLangCode(), "en");
        Assert.assertEquals(book.getKeepPeriod(), 14);
        Assert.assertEquals(book.getYear(), 2021);
    }
}