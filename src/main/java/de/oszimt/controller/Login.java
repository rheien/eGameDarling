package de.oszimt.controller;

import de.oszimt.database.client.DBConnection;
import de.oszimt.database.model.versand.Kunden;

import java.sql.ResultSet;
import java.sql.Statement;
public class Login {

    public boolean checkingAccount(Kunden kunden) {
        try {

            Statement statement = DBConnection.toDatabase().createStatement();
            String query = "SELECT * FROM T_Kunden WHERE p_kunden_nr = '" + kunden.getPKundenNr() + "' AND nname = '" + kunden.getNname() + "';";
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()) {
                return (resultSet.getString("p_kunden_nr").equals(kunden.getPKundenNr()) &&
                        resultSet.getString("nname").equals(kunden.getNname()));
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }
}
