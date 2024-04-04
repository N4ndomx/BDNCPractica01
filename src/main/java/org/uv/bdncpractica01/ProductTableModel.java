/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.uv.bdncpractica01;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ASUS
 */
public class ProductTableModel extends AbstractTableModel {

    String[] columnNames = {"Clave", "Descripcion", "Precio Compra", "Precio Venta"};
    List<Producto> lsproductos;

    public ProductTableModel(List<Producto> productos) {
        this.lsproductos = productos;
    }

    @Override
    public int getRowCount() {
        return lsproductos.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto p = lsproductos.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getId();
            case 1:
                return p.getDescripcion();
            case 2:
                return p.getPrecioCompra();
            case 3:
                return p.getPrecioVenta();
            default:
                return null;
        }

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column]; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
