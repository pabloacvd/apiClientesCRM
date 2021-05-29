package ar.com.xeven.apiclientescrm.controllers;

import ar.com.xeven.apiclientescrm.entities.Cliente;
import ar.com.xeven.apiclientescrm.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("clientes")
    public List<Cliente> getClientes(){
        return clienteService.getClientes();
    }

    @GetMapping("clientes/empresa/{empresa}")
    public List<Cliente> buscarClientesPorEmpresa(@PathVariable String empresa){
        return clienteService.buscarClientesPorEmpresa(empresa);
    }

    @GetMapping("clientes/nombre/{nombre}")
    public List<Cliente> findClientesByNombreContaining(@PathVariable String nombre){
        return clienteService.findClientesByNombreContaining(nombre);
    }

    @GetMapping("clientes/id/{id}")
    public Cliente buscarPorID(@PathVariable String id){
        Integer unID = 0;
        try{
            if(id!=null)
                unID = Integer.valueOf(id);
        }catch(NumberFormatException e){
            e.printStackTrace();
        }
        return clienteService.buscarPorID(unID);
    }
}
