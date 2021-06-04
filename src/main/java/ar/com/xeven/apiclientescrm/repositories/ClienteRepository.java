package ar.com.xeven.apiclientescrm.repositories;


import ar.com.xeven.apiclientescrm.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    List<Cliente> findClientesByEmpresa(String empresa);

    List<Cliente> findClientesByNombreContaining(String nombre);

    List<Cliente> findClientesByEmpresaOrderByNombreAsc(String empresa);

}
