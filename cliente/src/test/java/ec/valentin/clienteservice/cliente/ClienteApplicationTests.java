package ec.valentin.clienteservice.cliente;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import ec.valentin.clienteservice.cliente.models.Cliente;
import ec.valentin.clienteservice.cliente.services.ClienteServiceImp;

@SpringBootTest
class ClienteApplicationTests {

	@Test
	void contextLoads() {
	}

	@InjectMocks
	private ClienteServiceImp clienteService;

	@Mock
	private ClienteRepository clienteRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testPostClient() {
		Cliente cliente = new Cliente(1L, "Jose Lema", "Masculino", 24, "123456789",
				"Otavalo sn y principal", "098254785",
				"1234", true);
		when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

		Cliente result = clienteService.postClient(cliente);

		assertEquals(cliente.getClienteId(), result.getClienteId());
		assertEquals(cliente.getNombre(), result.getNombre());
	}

	@Test
	public void testGetClient() {
		Cliente cliente = new Cliente(1L, "Valentin", "Masculino", 24, "123456789",
				"Calle Ejemplo 123", "555-1234",
				"contrasenaSegura", true);
		when(clienteRepository.findById(1L)).thenReturn(Optional.of(cliente));

		Cliente result = clienteService.getClient(1L);

		assertEquals(cliente.getClienteId(), result.getClienteId());
		assertEquals(cliente.getNombre(), result.getNombre());
	}

	@Test
	public void testPutClient() {
		Cliente cliente = new Cliente(1L, "Valentin", "Masculino", 24, "123456789",
				"Calle Ejemplo 123", "555-1234",
				"contrasenaSegura", true);
		when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

		Cliente result = clienteService.putClient(cliente);

		assertEquals(cliente.getClienteId(), result.getClienteId());
		assertEquals(cliente.getNombre(), result.getNombre());
	}

	@Test
	public void testDeleteClient() {
		clienteService.deleteClient(1L);
		verify(clienteRepository, times(1)).deleteById(1L);
	}

	@Test
	public void testGetClients() {
		Cliente cliente1 = new Cliente(1L, "Valentin", "Masculino", 24, "123456789",
				"Calle Ejemplo 123", "555-1234",
				"contrasenaSegura", true);
		Cliente cliente2 = new Cliente(2L, "Ana", "Femenino", 30, "987654321",
				"Avenida Principal 456", "555-5678",
				"otraContrasena", false);
		when(clienteRepository.findAll()).thenReturn(Arrays.asList(cliente1, cliente2));

		List<Cliente> result = clienteService.getClients();

		assertEquals(2, result.size());
		assertEquals(cliente1.getNombre(), result.get(0).getNombre());
		assertEquals(cliente2.getNombre(), result.get(1).getNombre());
	}

}
