package testing;

public class DriverTester {

    public static void main(String[] args) throws InterruptedException {
        SeleniumClass obj=new SeleniumClass();
        obj.launchBrowserAndApplication();
        obj.filterPrice();

    }
}
