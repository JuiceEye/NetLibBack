package com.JavaEE.netlib.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        String url = "postgres://ukj43bnp9ucmh:pf3a8bd716bf277b9326eb1b0d11231a428cdeb7028cd6eb0fc8f01efc01e0827@cdgn4ufq38ipd0.cluster-czz5s0kz4scl.eu-west-1.rds.amazonaws.com:5432/ddf0qlavhp2vuq";
        String username = "ukj43bnp9ucmh";
        String password = "pf3a8bd716bf277b9326eb1b0d11231a428cdeb7028cd6eb0fc8f01efc01e0827";
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Не удалось установить соединение с базой данных.", e);
        }
    }
}