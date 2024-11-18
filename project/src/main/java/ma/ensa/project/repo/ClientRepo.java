package ma.ensa.project.repo;

import ma.ensa.project.entity.Client;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ClientRepo {
    public Client getClient(int id) throws SQLException;
    public ArrayList<Client> getClients() throws SQLException;
    public void addClient(Client client) throws SQLException;
    public void updateClient(Client client) throws SQLException;
    public void deleteClient(int id) throws SQLException;
    public Client getClientByEmailAnd(String email) throws SQLException;
}
