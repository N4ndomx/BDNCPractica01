/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdncpractica01;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class DAODepartamento implements IDAO<PojoDepartamento> {

    private final ConexionDB cnx;
    private static final String INSERT_DEP_SQL = "INSERT INTO DEPARTAMENTOS "
            + "  ( nombre) VALUES " + " ( ?);";
    private static final String SELECT_DEP_SQL = "SELECT * FROM DEPARTAMENTOS ";
    private static final String UPDATE_DEP_SQL = "UPDATE DEPARTAMENTOS  nombre = ? WHERE id = ?";
    private static final String DELETE_DEP_SQL = "DELETE FROM DEPARTAMENTOS WHERE id = ?;";

    public DAODepartamento(ConexionDB cnx) {
        this.cnx = cnx;
    }

    @Override
    public boolean guardar(PojoDepartamento p) {
        boolean flag = false;

        try {
            PreparedStatement insertSt = cnx.getPreparedStatement(INSERT_DEP_SQL);
            insertSt.setString(1, p.getNombre());
            flag = insertSt.executeUpdate() > 0;
            cnx.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, "Error Insert", ex);
            cnx.rollback();
        }
        return flag;
    }

    @Override
    public boolean modificar(PojoDepartamento p) {
        boolean flag = false;

        try {
            PreparedStatement updateSt = cnx.getPreparedStatement(UPDATE_DEP_SQL);
            updateSt.setString(1, p.getNombre());
            updateSt.setInt(2, p.getId());
            flag = updateSt.executeUpdate() > 0;
            cnx.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, "Error Modificar", ex);
            cnx.rollback();
        }
        return flag;
    }

    @Override
    public List<PojoDepartamento> buscarAll() {
        List<PojoDepartamento> departamentos = new ArrayList<>();
        try {
            PreparedStatement insertSt = cnx.getPreparedStatement(SELECT_DEP_SQL);
            ResultSet resultSet = insertSt.executeQuery();
            while (resultSet.next()) {
                int clave = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                PojoDepartamento pojo = new PojoDepartamento();
                pojo.setId(clave);
                pojo.setNombre(nombre);
                departamentos.add(pojo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, "Error buscarAll", ex);
            cnx.rollback();

        }
        return departamentos;
    }

    @Override
    public PojoDepartamento buscarById(long id) {
         PojoDepartamento pojo = null;
        try {
            PreparedStatement selectByIdSt = cnx.getPreparedStatement(SELECT_DEP_SQL + "WHERE id = ?");
            selectByIdSt.setInt(1, (int) id);
            ResultSet resultSet = selectByIdSt.executeQuery();
            if (resultSet.next()) {
                int clave = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                pojo = new PojoDepartamento();
                pojo.setId(clave);
                pojo.setNombre(nombre);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, "Error buscarById", ex);
            cnx.rollback();
        }
        return pojo;
    }

    @Override
    public boolean eliminar(PojoDepartamento p) {
         boolean flag = false;

        try {
            PreparedStatement deleteSt = cnx.getPreparedStatement(DELETE_DEP_SQL);
            deleteSt.setInt(1, p.getId());
            flag = deleteSt.executeUpdate() > 0;
            cnx.commit();
        } catch (SQLException ex) {
            Logger.getLogger(DAOEmpleados.class.getName()).log(Level.SEVERE, "Error Eliminar", ex);
            cnx.rollback();
        }
        return flag;
    }

}
