package de.oszimt.database.service;

import de.oszimt.database.client.DBConnection;
import de.oszimt.database.model.versand.Kunden;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class EditingKunden implements EditingDatabase<Kunden> {

    @Override
    public void insert(Kunden kunden) {
        try {
            Connection connection = DBConnection.toDatabase();
            Statement statement = connection.createStatement();

            String insertQuery = "INSERT INTO T_Kunden (p_kunden_nr, status, zahlung, vname, nname, strasse, plz, ort) VALUES ('" +
                    kunden.getPKundenNr() + "', '" +
                    kunden.getStatus() + "', '" +
                    kunden.getZahlung() + "', '" +
                    kunden.getVname() + "', '" +
                    kunden.getNname() + "', '" +
                    kunden.getStrasse() + "', '" +
                    kunden.getPlz() + "', '" +
                    kunden.getOrt() + "')";

            statement.executeUpdate(insertQuery);

            DBConnection.exitingDatabase(connection);
        } catch (SQLException e) {
            //TODO: Exception handling
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Kunden kunden) {
        try{
            Connection connection = DBConnection.toDatabase();
            Statement statement = connection.createStatement();

            String deleteQuery = "DELETE FROM T_Kunden WHERE p_kunden_nr = '" + kunden.getPKundenNr() + "'";
            statement.executeUpdate(deleteQuery);

            DBConnection.exitingDatabase(connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Kunden kunden) {
        try {
            Connection connection = DBConnection.toDatabase();
            Statement statement = connection.createStatement();

            String updateQuery = "UPDATE T_Kunden SET nname = '" + kunden.getNname() + "' WHERE p_kunden_nr = '" + kunden.getPKundenNr() + "'";

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Kunden selectById(Kunden kunden) {
        return null;
    }

    @Override
    public Kunden selectAll(Kunden kunden) {
        return null;
    }
}
