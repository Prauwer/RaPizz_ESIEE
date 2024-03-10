package com.example.rapizzapp.utils;

import com.example.rapizzapp.entities.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {
    private DatabaseHandler dbHandler;

    public CustomerService() {
        dbHandler = new DatabaseHandler();
    }

    public List<Client> getAllClients() {
        List<Client> clients = new ArrayList<>();
        String sql = "SELECT * FROM Client";
        try (Connection conn = dbHandler.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                clients.add(new Client(rs.getInt("IdClient"), rs.getString("Nom"), rs.getString("Prenom"), rs.getInt("NumeroAbonnement"), rs.getInt("Solde")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return clients;
    }

    public Client getClientInformation(int clientId) {
        String sql = "SELECT * FROM Client WHERE IdClient = ?";
        try (Connection conn = dbHandler.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Client(rs.getInt("IdClient"), rs.getString("Nom"), rs.getString("Prenom"), rs.getInt("NumeroAbonnement"), rs.getInt("Solde"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean insertClient(Client client) {
        String sql = "INSERT INTO Client (Nom, Prenom, NumeroAbonnement, Solde) VALUES (?, ?, ?, ?)";
        try (Connection conn = dbHandler.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getNom());
            pstmt.setString(2, client.getPrenom());
            pstmt.setInt(3, client.getNumeroAbonnement());
            pstmt.setInt(4, client.getSolde());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }





    /*
    public List<Commande> getClientOrderHistory(int clientId) {
        // Implémentation pour obtenir l'historique des commandes du client
    }

    public Commande getCurrentOrder(int clientId) {
        // Implémentation pour obtenir la commande en cours du client
    }

    public void createNewOrder(Commande newOrder) {
        // Implémentation pour créer une nouvelle commande
        // Cela devrait être implémenté dans le futur
    }*/

    // Vous pouvez ajouter d'autres méthodes de service nécessaires ici.
}