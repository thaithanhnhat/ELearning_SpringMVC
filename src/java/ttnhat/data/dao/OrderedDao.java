/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ttnhat.data.dao;

import java.util.List;
import ttnhat.data.model.Ordered;

/**
 *
 * @author nhatt
 */
public interface OrderedDao {
    public  void removeCart(int User);
        public List<Ordered> findAll(int id_user);
}
