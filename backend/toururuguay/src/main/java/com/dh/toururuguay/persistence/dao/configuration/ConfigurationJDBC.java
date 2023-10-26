package com.dh.toururuguay.persistence.dao.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Component
@PropertySource("classpath:application.properties")
public class ConfigurationJDBC {

    @Value("spring.datasource.url")
    private String dbUrl;

    @Value("spring.datasource.username")
    private String nombreUsuario;
    @Value("spring.datasource.password")
    private String contrasenaUsuario;

    public Connection conectarConBaseDeDatos() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, nombreUsuario, contrasenaUsuario);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return connection;
    }

}
