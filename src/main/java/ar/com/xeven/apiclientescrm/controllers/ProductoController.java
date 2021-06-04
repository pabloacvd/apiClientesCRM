package ar.com.xeven.apiclientescrm.controllers;

import ar.com.xeven.apiclientescrm.entities.Cliente;
import ar.com.xeven.apiclientescrm.entities.Producto;
import ar.com.xeven.apiclientescrm.services.ProductoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductoController {

    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("nuevo-producto")
    public String nuevoProductoForm(Model modelo){
        modelo.addAttribute("producto", new Producto());
        return "guardar-producto";
    }

    @GetMapping("unaPrueba/{nombre}")
    public String unaPrueba(Model modelo, @PathVariable String nombre){
        modelo.addAttribute("nombreMascota", nombre);
        modelo.addAttribute("otraCosa", "este es el nombre del botón");
        return "una-prueba";
    }

    @PostMapping("nuevo-producto")
    public String nuevoProductoSubmit(@ModelAttribute Producto producto, Model modelo){
        modelo.addAttribute("producto",producto);
        productoService.guardarProducto(producto);
        return "ver-producto";
    }
}
