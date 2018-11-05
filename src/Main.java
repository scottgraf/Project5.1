import java.sql.*;

public class Main {
    public static void main(String[] args) {

        CreateStoreDB cs = new CreateStoreDB();
        EssentialOilsInterface eoi = new EssentialOils();
        eoi.outputDB();
        eoi.addContent();
        System.out.println("==========================");
        eoi.outputDB();
    }

}
