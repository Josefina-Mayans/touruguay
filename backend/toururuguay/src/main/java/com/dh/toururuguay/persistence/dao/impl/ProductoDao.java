package com.dh.toururuguay.persistence.dao.impl;

import com.dh.toururuguay.model.Producto;
import com.dh.toururuguay.persistence.dao.IDao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;



import java.util.*;

@Repository
@Transactional
public class ProductoDao implements IDao<Producto> {

    @PersistenceContext
    private EntityManager entityManager;



    @Override
    public Producto guardar(Producto producto) {

        return null;
    }

    @Override
    public Optional<Producto> buscar(Integer id) {
        return Optional.empty();
    }

    private static Producto buscarProductoPorNombre(List<Producto> lista, String nombre) {
        for (Producto producto : lista) {
            if (producto.getProduct_name().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public List<Producto> buscarTodos() {

        return entityManager.createQuery("SELECT p FROM Producto p", Producto.class).getResultList();
    }


    @Override
    public List<Producto> buscarProductosAleatorios(Integer cantidad) {
        return buscarProductosAleatorios(cantidad.intValue());
    }

    private List<Producto> productosTemporales = new ArrayList<>();
    private static final Random RANDOM_GENERATOR = new Random();

    //devolver los datos necesarios, no todo el objeto
    public List<Producto> buscarProductosAleatorios(int cantidad) {
        List<Producto> productos = buscarTodos();
        return seleccionarProductosAleatorios(productos, cantidad);
    }
    private List<Producto> seleccionarProductosAleatorios(List<Producto> todosLosProductos, int cantidad) {
        List<Producto> productosNuevos = new ArrayList<>();

        while (productosNuevos.size() < cantidad && !todosLosProductos.isEmpty()) {
            int indiceAleatorio = RANDOM_GENERATOR.nextInt(todosLosProductos.size());
            Producto productoAleatorio = todosLosProductos.remove(indiceAleatorio);

            if (!productosTemporales.contains(productoAleatorio)) {
                productosNuevos.add(productoAleatorio);
                productosTemporales.add(productoAleatorio);
            }
       }
        //si ya mostre todos los productos de mi base, reinicio la comparativa
        if (todosLosProductos.size() < cantidad) {
            // Reinicia la lista temporal si no puedo devolver la cantidad de productos nuevos
            reiniciarProductosTemporales();
        }

        return productosNuevos;
    }

    private void reiniciarProductosTemporales() {
        productosTemporales.clear();
    }

    @Override
    public Producto actualizar(Producto producto) {
        return null;
    }

}
