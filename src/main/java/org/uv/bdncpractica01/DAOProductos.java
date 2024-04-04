package org.uv.bdncpractica01;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DAOProductos implements IDAO<Producto> {

    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public boolean guardar(Producto p) {
        Transaction tr = null;
        boolean ban = true;

        Session session = sf.getCurrentSession();

        try {
            tr = session.beginTransaction();

            session.save(p);
            tr.commit();

        } catch (Exception e) {
            ban = false;
        }

        return ban;

    }

    @Override
    public boolean modificar(Producto p) {
        Transaction tr = null;
        boolean ban = true;

        Session session = sf.getCurrentSession();
        try {
            tr = session.beginTransaction();

            Producto pu = session.get(Producto.class, p.getId());
            pu.setDescripcion(p.getDescripcion());
            pu.setPrecioCompra(p.getPrecioCompra());
            pu.setPrecioVenta(p.getPrecioVenta());

            session.update(pu);
            tr.commit();
        } catch (Exception e) {
            ban = false;
        }

        return true;

    }

    @Override
    public List<Producto> buscarAll() {

        Session session = sf.getCurrentSession();
        Transaction tran = session.beginTransaction();
        List<Producto> ventas = session.createQuery("from Producto").list();
        tran.commit();
        return ventas;

    }

    @Override
    public Producto buscarById(long id) {
        Session session = sf.getCurrentSession();
        Transaction tran = session.beginTransaction();
        Producto p = session.get(Producto.class, id);
        tran.commit();

        return p;

    }

    @Override
    public boolean eliminar(Producto p) {
        boolean ban = true;
        Transaction tr = null;
        Session session = sf.getCurrentSession();
        try {

            tr = session.beginTransaction();
            session.delete(p);
            tr.commit();

        } catch (Exception e) {
            ban = false;
        }

        return ban;

    }
}
