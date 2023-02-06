package library.model.entities;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LangTest {
    Lang lang;

    @Before
    public void testBuildLang() {
        lang = new Lang.Builder().setId(1).setCode("en").build();
    }

    @Test
    public void testLangGetMethods() {
        Assert.assertEquals(lang.getId(), 1);
        Assert.assertEquals(lang.getCode(), "en");
    }
}