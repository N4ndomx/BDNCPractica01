/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package org.uv.bdncpractica01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS
 */
public class BDNCPractica01 {

    public static void main(String[] args) {

        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.getCurrentSession();
        Transaction tr = session.beginTransaction();
        
        Producto p = new Producto();
        p.setDescripcion("cepillo");
        p.setPrecioCompra(12);
        p.setPrecioVenta(55);
        session.save(p);

        tr.commit();

//        Connection con = null;
//
//        try {
//            String url = "jdbc:postgresql://localhost:5432/testDB";
//            String pwd = "root";
//            String usr = "postgres";
//
//            con = DriverManager.getConnection(url, usr, pwd);
//
//            Logger.getLogger(BDNCPractica01.class.getName()).log(Level.INFO, "Se Conecto!");
//
//            con.setAutoCommit(false);
//            Statement st = con.createStatement();
//            String sql = "INSERT INTO empleadotemporal (nombre, direccion,telefono) VALUES('n4ndo','av 1', '3445')";
//            st.execute(sql);
//            con.commit();
//            Logger.getLogger(BDNCPractica01.class.getName()).log(Level.INFO, "Guardado...");
//
//
//        } catch (SQLException ex) {
//            Logger.getLogger(BDNCPractica01.class.getName()).log(Level.SEVERE, null, ex);
//            try {
//                con.rollback();
//            } catch (SQLException ex1) {
//                Logger.getLogger(BDNCPractica01.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//            
//        }
    }
}
