/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package org.uv.bdncpractica01;

import java.util.List;

/**
 *
 * @author ASUS
 */
public interface IDAO<T> {

    public boolean guardar(T p);

    public boolean modificar(T p);

    public List<T> buscarAll();

    public T buscarById(long id);

    public boolean eliminar(T p);

}
