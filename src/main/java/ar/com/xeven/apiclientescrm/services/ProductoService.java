package ar.com.xeven.apiclientescrm.services;

import ar.com.xeven.apiclientescrm.entities.Producto;
import ar.com.xeven.apiclientescrm.repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> getProductos(){ return productoRepository.findAll(); }

    public Producto buscarProducto(Integer id_producto){
        return productoRepository.findById(id_producto).orElse(null);
    }

    public void guardarProducto(Producto producto){
        productoRepository.save(producto);
    }

    public List<Producto> findProductosByNombreContaining(String nombre) {
        return productoRepository.findProductosByNombreContaining(nombre);
    }

    public List<Producto> findProductosByCategoriaContaining(String categoria) {
        return productoRepository.findProductosByCategoriaContaining(categoria);
    }
}
