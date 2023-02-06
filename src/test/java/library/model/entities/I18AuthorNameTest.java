package library.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class I18AuthorNameTest {
    I18AuthorName i18AuthorName;

    @Before
    public void testBuildI18AuthorName() {
        i18AuthorName = new I18AuthorName.Builder().setId(10).setName("Blinov")
                .setLang((new Lang.Builder().setCode("en")).build()).build();
    }

    @Test
    public void testI18AuthorGetMethods() {
        Assert.assertEquals(i18AuthorName.getId(), 10);
        Assert.assertEquals(i18AuthorName.getName(), "Blinov");
        Assert.assertEquals(i18AuthorName.getLang().getCode(), "en");
    }
}