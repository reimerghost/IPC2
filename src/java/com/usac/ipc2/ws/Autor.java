/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ipc2.ws;

import com.usac.ipc2.BDD.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ReimerGhost <rchamale10@gmail.com>
 */
public class Autor {
    public int id;
    public String nombre, apellido;
    public Autor(int i,String n, String a) {
        id = i;
        nombre = n;
        apellido = a;
    }
    
    public Autor(){
        
    }

    public boolean agregarAutor(String n, String a) throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO AUTOR"
                + "(nombre, apellido) VALUES"
                + "(?,?)";

        try {
            dbConnection = new Conexion().getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setString(1, n);
            preparedStatement.setString(2, a);

            // execute insert SQL stetement
            preparedStatement.executeUpdate();
            dbConnection.close();

            return true;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return false;

        }
    }

    public Autor getAutorPorID(int id) {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String selectSQL = "SELECT * FROM AUTOR WHERE id_autor=?";
        try {
            dbConnection = new Conexion().getDBConnection();

            preparedStatement = dbConnection.prepareStatement(selectSQL);
            preparedStatement.setInt(1, id);

            ResultSet rs;
            rs = preparedStatement.executeQuery();
            Autor a = null;
            while (rs.next()) {
                nombre = rs.getString("nombre");
                apellido = rs.getString("apellido");
                a = new Autor(id,nombre,apellido);
            }
            rs.close();
            return a;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Autor> getAutores() {
        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        ArrayList autores = new ArrayList<Autor>();

        String selectSQL = "SELECT * FROM AUTOR";
        try {
            dbConnection = new Conexion().getDBConnection();

            preparedStatement = dbConnection.prepareStatement(selectSQL);

            ResultSet rs;
            rs = preparedStatement.executeQuery();
            int i;
            String n,a;
            while (rs.next()) {
                i = rs.getInt("id_autor");
                n = rs.getString("nombre");
                a = rs.getString("apellido");                
                autores.add(new Autor(i,n,a));
            }
            rs.close();
            return autores;
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
