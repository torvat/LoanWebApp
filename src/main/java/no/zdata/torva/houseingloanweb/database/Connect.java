package no.zdata.torva.houseingloanweb.database;

import no.zdata.torva.houseingloanweb.objects.HouseingLoan;
import no.zdata.torva.houseingloanweb.objects.abstracts.Loan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    //Dropbox har litt forkjellig plassering på hver arbeidsmaskin
    private static final String CONNECTION_STRING = "jdbc:sqlite:C:\\Users\\Torva\\Dropbox\\Databases\\Loans\\loans.db";
    private static final String CONNECTION_FROM_DESKTOP = "jdbc:sqlite:F:\\Dropbox\\Databases\\Loans\\loans.db";

    public static Connection connect(){
        try{
            return DriverManager.getConnection(CONNECTION_STRING);

        }catch (SQLException e){
            System.out.println("Failed to connect to the database: " + e.getMessage());
            return null;
        }

    }
}
