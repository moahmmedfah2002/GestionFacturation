package ma.ensa.project.repo;

import ma.ensa.project.entity.Client;

import java.util.ArrayList;

public interface ClientRepo {
    public Client getClient(int id);
    public ArrayList<Client> getClients();
    public void addClient(Client client);
    public void updateClient(Client client);
    public void deleteClient(int id);
    public Client getClientByEmailAnd(String email);
}
