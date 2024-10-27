package ec.valentin.clienteservice.cliente;

import ec.valentin.clienteservice.cliente.models.Cliente;

import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}