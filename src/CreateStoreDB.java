import java.sql.*;


public class CreateStoreDB
{

    public CreateStoreDB() {

        try {
            // Create a named constant for the URL.
            // NOTE: This value is specific for Java DB.
            final String DB_URL = "jdbc:derby:StoreDB;create=true";

            // Create a connection to the database.
            Connection conn =
                    DriverManager.getConnection(DB_URL);

            // If the DB already exists, drop the tables.
            dropTables(conn);

            // Build the Store table.
            buildProductTable(conn);

            // Build the Store table.
            buildCartTable(conn);

            // Close the connection.
            conn.close();
        } catch (Exception e) {
            System.out.println("Error Creating the Store Table");
            System.out.println(e.getMessage());
        }
    }

    public static void dropTables (Connection conn){
        System.out.println("Checking for existing tables.");

        try {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            try {
                // Drop the Customer table.
                stmt.execute("DROP TABLE Product");
                System.out.println("Product table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }

            try {
                // Drop the Coffee table.
                stmt.execute("DROP TABLE Cart");
                System.out.println("Cart table dropped.");
            } catch (SQLException ex) {
                // No need to report an error.
                // The table simply did not exist.
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
            ex.printStackTrace();

        }

    }

    public static void buildProductTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Product (" +
                    "Description CHAR(25), " +
                    "ProdNum CHAR(10) NOT NULL PRIMARY KEY, " +
                    "Price DOUBLE " +
                    ")");

            // Insert row #1.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Lemon Oil', " +
                    "'1', " +
                    "8.95 )");

            // Insert row #2.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Lemon Grass Oil', " +
                    "'2', " +
                    "9.95 )");

            // Insert row #3.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Cinnamon Oil', " +
                    "'3', " +
                    "7.95 )");

            // Insert row #4.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Rosemary Oil', " +
                    "'4', " +
                    "6.95 )");

            // Insert row #5.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Peppermint Oil', " +
                    "'5', " +
                    "5.55 )");

            // Insert row #6.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Tea Tree Oil', " +
                    "'6', " +
                    "4.95 )");

            // Insert row #7.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Sweet Orange Oil', " +
                    "'7', " +
                    "10.95 )");

            // Insert row #8.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Eucalyptus Oil', " +
                    "'8', " +
                    "7.95 )");

            // Insert row #9.
            stmt.execute("INSERT INTO Product VALUES ( " +
                    "'Lavender Oil', " +
                    "'9', " +
                    "8.95 )");

            System.out.println("Product table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

    public static void buildCartTable(Connection conn)
    {
        try
        {
            // Get a Statement object.
            Statement stmt = conn.createStatement();

            // Create the table.
            stmt.execute("CREATE TABLE Cart (" +
                    "CustomerNumber CHAR(10) NOT NULL PRIMARY KEY," +
                    "ProdNum CHAR(10), " +
                    "Description CHAR(25), " +
                    "Price DOUBLE " +
                    ")");


            System.out.println("Cart table created.");
        } catch (SQLException ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }

}
