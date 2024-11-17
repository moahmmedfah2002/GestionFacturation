package ma.ensa.project.service;

import ma.ensa.project.entity.Client;
import ma.ensa.project.repo.ClientRepo;

import java.util.ArrayList;

public class ClientService  implements ClientRepo {
    @Override
    public Client getClient(int id) {
        return null;
    }

    @Override
    public ArrayList<Client> getClients() {
        return null;
    }

    @Override
    public void addClient(Client client) {

    }

    @Override
    public void updateClient(Client client) {

    }

    @Override
    public void deleteClient(int id) {

    }

    @Override
    public Client getClientByEmailAnd(String email) {
        return null;
    }
}
