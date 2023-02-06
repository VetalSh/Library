package library.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AuthorTest {
    private Lang lang;
    private Author author;

    @Before
    public void testBuildAuthor() {
        lang = new Lang.Builder().setId(1).setCode("en").build();
        author = new Author.Builder().setId(10).setName("Blinov").build();
        author.setPrimaryLang(lang);
    }

    @Test
    public void testAuthorGetMethods() {
        Assert.assertEquals(author.getId(), 10);
        Assert.assertEquals(author.getName(), "Blinov");
        Assert.assertEquals(author.getPrimaryLang(), lang);
    }

}