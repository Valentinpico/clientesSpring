package ec.valentin.clienteservice.cliente.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.valentin.clienteservice.cliente.models.Cliente;
import ec.valentin.clienteservice.cliente.ClienteRepository;

@Service
public class ClienteServiceImp implements ClienteServicio {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente postClient(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Cliente getClient(Long clienteId) {
        Cliente optionalCliente = clienteRepository.findById(clienteId).get();
        return optionalCliente;
    }

    public Cliente putClient(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public void deleteClient(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

    public List<Cliente> getClients() {
        System.out.println("Getting all clients");
        List<Cliente> clientes = new ArrayList<>();
        clienteRepository.findAll().forEach(clientes::add);
        return clientes;
    }

}
