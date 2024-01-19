/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.utils;

import java.util.List;
import ttnhat.data.model.Cart;
import ttnhat.data.model.Course;

/**
 *
 * @author nhatt
 */
public class API {
    public static double sumCart(List<Cart> cart,List<Course> course) {
        double sumCart = 0;
        for (Cart i: cart) {
           for (Course j: course) {
               if(i.getId_course() == j.getId()){
                   sumCart+=j.getPrice();
               }
           }
        }               
        return sumCart;
    }
}
