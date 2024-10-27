package ec.valentin.clienteservice.cliente.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ec.valentin.clienteservice.cliente.models.Cliente;
import ec.valentin.clienteservice.cliente.services.ClienteServiceImp;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class ClienteController {

    @Autowired
    private ClienteServiceImp clienteServiceImp;

    @GetMapping("/cliente")
    public List<Cliente> getClients() {
        return clienteServiceImp.getClients();
    }

    @GetMapping("/cliente/{clienteId}")
    public Cliente getClient(@PathVariable Long clienteId) {
        return clienteServiceImp.getClient(clienteId);
    }

    @PostMapping("/cliente")
    public Cliente postClient(@RequestBody Cliente cliente) {
        return clienteServiceImp.postClient(cliente);
    }

    @PutMapping("/cliente")
    public Cliente putClient(@RequestBody Cliente cliente) {
        return clienteServiceImp.putClient(cliente);
    }

    @DeleteMapping("/cliente/{clienteId}")
    public void deleteClient(@PathVariable Long clienteId) {
        clienteServiceImp.deleteClient(clienteId);
    }

}
