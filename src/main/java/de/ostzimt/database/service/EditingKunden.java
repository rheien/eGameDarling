package de.ostzimt.database.service;

import de.ostzimt.database.client.DBConnection;
import de.ostzimt.database.model.versand.Kunden;

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
                    kunden.getP_kunden_nr() + "', '" +
                    kunden.getStatus() + "', '" +
                    kunden.getZahlung() + "', '" +
                    kunden.getVname() + "', '" +
                    kunden.getNname() + "', '" +
                    kunden.getStrasse() + "', '" +
                    kunden.getPlz() + "', '" +
                    kunden.getOrt() + "')";

            statement.executeUpdate(insertQuery);

            System.out.println("Kunde " + kunden.getNname() + " wurde erfolgreich angelegt!");
            DBConnection.exitingDatabase(connection);
        } catch (SQLException e) {
            System.out.println("Fehler: Unvollständige Eingabe!" + e);
        }
    }

    @Override
    public void delete(Kunden kunden) {
        try{
            Connection connection = DBConnection.toDatabase();
            Statement statement = connection.createStatement();

            String deleteQuery = "DELETE FROM T_Kunden WHERE p_kunden_nr = '" + kunden.getP_kunden_nr() + "'";
            statement.executeUpdate(deleteQuery);

            System.out.println("Kunde " + kunden.getNname() + " wurde erfolgreich gelöscht!");
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

            String updateQuery = "UPDATE T_Kunden SET nname = '" + kunden.getNname() + "' WHERE p_kunden_nr = '" + kunden.getP_kunden_nr() + "'";

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
