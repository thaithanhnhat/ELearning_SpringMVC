/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ttnhat.data.dao;

import ttnhat.data.impl.VideoImpl;
import ttnhat.data.impl.UserImpl;
import ttnhat.data.impl.PaymentImpl;
import ttnhat.data.impl.OrderedImpl;
import ttnhat.data.impl.NotificationImpl;
import ttnhat.data.impl.CourseImpl;
import ttnhat.data.impl.CommentImpl;
import ttnhat.data.dao.BillDao;
import ttnhat.data.dao.CartDao;
import ttnhat.data.impl.CartImpl;
import ttnhat.data.dao.CategoryDao;
import ttnhat.data.impl.BillImpl;
import ttnhat.data.impl.BillImpl;
import ttnhat.data.impl.CategoryImpl;
import ttnhat.data.impl.CategoryImpl;

/**
 *
 * @author nhatt
 */
public class Database {
    public static CategoryDao getCategoryDao(){
        return new CategoryImpl();
    }
    public static BillDao getBillDao(){
        return new BillImpl();
    }
    public static CartDao getCartDao(){
        return new CartImpl();
    }
    public static CommentDao getCommentDao(){
        return new CommentImpl();
    }
    public static CourseDao getCourseDao(){
        return new CourseImpl();
    }
    public static NotificationDao getNotificationDao(){
        return new NotificationImpl();
    }
    public static OrderedDao getOrderedDao(){
        return new OrderedImpl();
    }
    public static PaymentDao getPaymentDao(){
        return new PaymentImpl();
    }
    public static UserDao getUserDao(){
        return new UserImpl();
    }
     public static VideoDao getVideoDao(){
        return new VideoImpl();
    }
}
