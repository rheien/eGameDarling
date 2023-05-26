package de.oszimt;

import de.oszimt.controller.Input;
import de.oszimt.database.client.DBConnection;
import de.oszimt.controller.Login;
import de.oszimt.database.service.EditingKunden;

import java.sql.Statement;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Statement statement = DBConnection.toDatabase().createStatement();
            Scanner scanner = new Scanner(System.in);
            Input input = new Input();

            System.out.println("Willkommen bei eGameDarling!");
            //String userInput = input.values("Drücken Sie \n" + "(1) zum Login\n" + "(2) zum Registrieren\n" ,scanner);

            Login login = new Login();
            while(login.checkingAccount(statement, login.toAccount()) == false) {
                System.out.println("Benutzername oder Passwort falsch! \nBitte versuchen Sie es erneut!");
            }

            System.out.println("\nZum Registrieren:\n");
            EditingKunden editingKunden = new EditingKunden();
            System.out.println("Bitte geben Sie Daten für einen neuen Kunden ein: ");
            editingKunden.insert(input.setKunden(scanner));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println(throwables.getMessage());
        }
    }
}