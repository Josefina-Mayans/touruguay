package com.dh.toururuguay.service;

import com.dh.toururuguay.model.Producto;
import com.dh.toururuguay.persistence.dao.IDao;
import com.dh.toururuguay.persistence.dao.impl.ProductoDao;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductoService {

    private IDao<Producto> productoDao;

    //Logger logger = Logger.getLogger(ProductoService.class);

    public ProductoService() {
        productoDao = new ProductoDao();
        //logger.info("Se ha creado una instancia");
    }

    public ProductoService(IDao<Producto> productoDao) {
        this.productoDao = productoDao;
     //   logger.info("Se ha creado una instancia");
    }

    public Producto registrarProducto(Producto producto) {
        return productoDao.guardar(producto);
    }

    public List<Producto> buscarTodos() {
        return productoDao.buscarTodos();
    }

    //creo la lista para controlar que no devuelva repetidos
    private List<Producto> productosTemporales = new ArrayList<>();

    public List<Producto> buscarProductosAleatorios(Integer cantidad) {
            return productoDao.buscarProductosAleatorios(cantidad);
        }
}
