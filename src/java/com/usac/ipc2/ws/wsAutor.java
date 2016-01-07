/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.usac.ipc2.ws;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author ReimerGhost <rchamale10@gmail.com>
 */
@WebService(serviceName = "wsAutor")
public class wsAutor {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    
    @WebMethod(operationName = "ipc2AgregarAutor")
    public boolean agregarAutor(@WebParam(name = "nombre") String n, @WebParam(name = "apellido") String a) {
        try {
            return new Autor().agregarAutor(n, a);
        } catch (SQLException ex) {
            Logger.getLogger(wsAutor.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    @WebMethod(operationName = "getAutores")
    public List<Autor> getAutores(){
        return new Autor().getAutores();
    }
    
    @WebMethod(operationName = "getAutorPorID")
    public Autor getAutorPorID(@WebParam(name = "id") int id){
        return new Autor().getAutorPorID(id);
    }
}
