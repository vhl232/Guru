package guru.dataProviderClass;

import org.testng.annotations.DataProvider;

public class Dataprovider {
    @DataProvider(name = "static")
    public Object[][] provideData(){
        return new Object[][]{{"first"},{"second"}};
    }

    @DataProvider(name = "sql")
    public Object[][]provideSQLData(){
        return new Object[][]{{"sql"},{"sql2"}};
    }
}
