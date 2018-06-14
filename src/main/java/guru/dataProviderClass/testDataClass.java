package guru.dataProviderClass;

import org.testng.annotations.Test;

public class testDataClass {
    @Test(dataProvider = "sql",dataProviderClass = Dataprovider.class )
    public void aa(String a){

        System.out.println(a);
    }
}
