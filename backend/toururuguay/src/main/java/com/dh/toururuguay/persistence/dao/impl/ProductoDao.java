package com.dh.toururuguay.persistence.dao.impl;

import com.dh.toururuguay.model.Producto;
import com.dh.toururuguay.persistence.dao.IDao;
import com.dh.toururuguay.persistence.dao.configuration.ConfigurationJDBC;
//import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Repository
public class ProductoDao implements IDao<Producto> {

    private ConfigurationJDBC coneccionBD;

  //  final static Logger log = Logger.getLogger(ProductoDao.class);

    @Override
    public Producto guardar(Producto producto) {


        //llamo a buscarTodos y pregunto si el nombre ya no existe
        List<Producto> productos = new ArrayList<>();
        productos = buscarTodos();
        Producto productoEncontrado = buscarProductoPorNombre(productos, producto.getNombre());
        if (productoEncontrado != null) {
            System.out.println("El producto ya existe");
            return producto;
        } else {

    //    log.debug("Registrando nuevo producto : "+ producto.toString());
        Connection connection = coneccionBD.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = String.format("INSERT INTO producto(nombre,descripcion,urlImagen) VALUES('%s','%s','%s')", producto.getNombre(), producto.getDescripcion(),
                producto.getUrlImagen());
        try {
            stmt = connection.createStatement();

            //tengo dudas sobre esta linea, tengo que traerme el ID de la base, no lo genero yo
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stmt.getGeneratedKeys();
            if (keys.next())
                producto.setId(keys.getInt(1));
            stmt.close();
          //  connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return producto;
        }
    }

    @Override
    public Optional<Producto> buscar(Integer id) {
        return Optional.empty();
    }

    private static Producto buscarProductoPorNombre(List<Producto> lista, String nombre) {
        for (Producto producto : lista) {
            if (producto.getNombre().equals(nombre)) {
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
  //      log.debug("Buscando todos los productos");
        Connection connection = coneccionBD.conectarConBaseDeDatos();
        Statement stmt = null;
        String query = "SELECT *  FROM producto";
        List<Producto> productos = new ArrayList<>();
        try {
           stmt = connection.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {

                productos.add(crearObjetoProducto(result));

            }

            stmt.close();
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return productos;
    }

    @Override
    public List<Producto> buscarProductosAleatorios(Integer cantidad) {
        return buscarProductosAleatorios(cantidad.intValue());
    }


    //devolver los datos necesarios, no todo el objeto
       public List<Producto> buscarProductosAleatorios(int cantidad) {
           List<Producto> productos = new ArrayList<>();
           List<Producto> productosTemporales = new ArrayList<>();
           productos = buscarTodos();
           return seleccionarProductosAleatorios(productos, cantidad, productosTemporales);
       }
    private List<Producto> seleccionarProductosAleatorios(List<Producto> todosLosProductos, int cantidad, List<Producto> productosTemporales) {
        List<Producto> productosNuevos = new ArrayList<>();

        while (productosNuevos.size() < cantidad && !todosLosProductos.isEmpty()) {
            int indiceAleatorio = new Random().nextInt(todosLosProductos.size());
            Producto productoAleatorio = todosLosProductos.remove(indiceAleatorio);

            if (!productosTemporales.contains(productoAleatorio)) {
                productosNuevos.add(productoAleatorio);
                productosTemporales.add(productoAleatorio);
            }
       }

        return productosNuevos;
    }

    @Override
    public Producto actualizar(Producto producto) {
        return null;
    }

    private Producto crearObjetoProducto(ResultSet resultSet) throws SQLException {

        return new Producto(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("descripcion"), resultSet.getString("urlImagen"));
    }
}
