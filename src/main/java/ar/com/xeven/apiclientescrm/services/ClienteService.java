package ar.com.xeven.apiclientescrm.services;

import ar.com.xeven.apiclientescrm.entities.Cliente;
import ar.com.xeven.apiclientescrm.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> getClientes(){
        return clienteRepository.findAll();
    }

    public List<Cliente> buscarClientesPorEmpresa(String empresa){
        return clienteRepository.findClientesByEmpresa(empresa);
    }

    public List<Cliente> findClientesByNombreContaining(String nombre){
        return clienteRepository.findClientesByNombreContaining(nombre);
    }

    public Cliente buscarPorID(Integer id){
        return clienteRepository.findById(id).orElse(null);
    }

}
