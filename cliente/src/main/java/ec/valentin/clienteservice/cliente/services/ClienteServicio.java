package ec.valentin.clienteservice.cliente.services;

import java.util.List;

import ec.valentin.clienteservice.cliente.models.Cliente;

public interface ClienteServicio {

    public Cliente postClient(Cliente cliente);

    public Cliente getClient(Long clienteId);

    public Cliente putClient(Cliente cliente);

    public void deleteClient(Long clienteId);

    public List<Cliente> getClients();

}
