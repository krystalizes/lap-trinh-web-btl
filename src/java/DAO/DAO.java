
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Donhang;
import model.Donhanginfo;
import model.Giohang;
import model.Sanpham;
import model.Taikhoan;
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public List<Sanpham> getAllProduct() {
        List<Sanpham> list = new ArrayList<>();
        String query = "select * from product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Sanpham> getTopProduct() {
        List<Sanpham> list = new ArrayList<>();
        String query = "select * from product where category='top'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Sanpham> getOutwearProduct() {
        List<Sanpham> list = new ArrayList<>();
        String query = "select * from product where category='outwear'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Sanpham> getBottomProduct() {
        List<Sanpham> list = new ArrayList<>();
        String query = "select * from product where category='bottom'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public List<Sanpham> getAccessoriesProduct() {
        List<Sanpham> list = new ArrayList<>();
        String query = "select * from product where category='accessories'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Sanpham getProductbyID(String id) {
        String query = "select * from product where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }
    public List<Sanpham> searchProductbyName(String txtSearch) {
        List<Sanpham> list = new ArrayList<>();
        String query = "select * from product where [name] like ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,"%"+txtSearch+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public Taikhoan login(String user, String pass){
        String query = "select * from Account where [user] = ? and pass = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Taikhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                       
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
        
    }public Taikhoan checkTaikhoan(String user){
        String query = "select * from Account where [user] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Taikhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                       
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
        
    }
    public void signup(String user, String pass){
        String query = "insert into Account values(?,?,0, NULL, NULL, NULL)";   
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,user);
            ps.setString(2,pass);
            ps.executeUpdate();          
        } catch (Exception e) {
        }    
    }
    public void xoaProduct(String pid){
        String query = "delete from product where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,pid);         
            ps.executeUpdate();          
        } catch (Exception e) {
        }    
    }
    public void themProduct(String ten, String anh, String gia, String soluong, String chitiet, String danhmuc){
        String query = "insert into [dbo].[product] ([name], [image], [price], [amount], [description], [category]) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1,ten); 
            ps.setString(2,anh);       
            ps.setString(3,gia);  
            ps.setString(4,soluong);
            ps.setString(5,chitiet);       
            ps.setString(6,danhmuc);       
            ps.executeUpdate();          
        } catch (Exception e) {
        }    
    }
    public void suaProduct(String ten, String anh, String gia, String soluong, String chitiet, String danhmuc, String id) {
         String query = "UPDATE product SET [name]=?, [image]=?, [price]=?, [amount]=?, [description]=?, [category]=? WHERE [id]=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, ten);
            ps.setString(2, anh);
            ps.setString(3, gia);
            ps.setString(4, soluong);
            ps.setString(5, chitiet);
            ps.setString(6, danhmuc);
            ps.setString(7, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
    public List<Giohang> getCartbyID(int id) {
        List<Giohang> list = new ArrayList<>();
        String query = "select dbo.Cart.ProductID,dbo.product.[name],dbo.product.[image],dbo.product.price, dbo.Cart.Amount from dbo.Cart,dbo.product,dbo.Account where dbo.Cart.AccountID=dbo.Account.[uID] and dbo.Cart.ProductID=dbo.product.id and dbo.Cart.AccountID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Giohang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                      
                        rs.getDouble(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    public void themgiohang(int id, int pid, int soluong){
        String query = "insert into Cart([AccountID],[ProductID],[Amount]) values(?,?,?)";   
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setInt(2,pid);
            ps.setInt(3,soluong);
            ps.executeUpdate();          
        } catch (Exception e) {
        }    
    }
    public Giohang checkGiohang(int id, int pid){
        String query = "select dbo.Cart.ProductID,dbo.product.[name],dbo.product.[image],dbo.product.price, dbo.Cart.Amount from dbo.Cart,dbo.product,dbo.Account where dbo.Cart.AccountID=dbo.Account.[uID] and dbo.Cart.ProductID=dbo.product.id  and dbo.Cart.AccountID=? and dbo.Cart.ProductID=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setInt(2, pid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Giohang(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getDouble(4),
                        rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;     
    }
    public void xoaspgiohang(int id, int pid){
        String query = "delete from Cart where AccountID = ? and ProductID = ?";   
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.setInt(2,pid);
            ps.executeUpdate();          
        } catch (Exception e) {
        }    
    }
    public void xoagiohang(int id){
        String query = "delete from Cart where AccountID = ? ";   
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            ps.executeUpdate();          
        } catch (Exception e) {
        }    
    }
    public void suaGiohang(int soluong, int pid, int id) {
         String query = "UPDATE Cart SET [Amount]=? WHERE [ProductID]=? and [AccountID]=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, soluong);
            ps.setInt(2, pid);
            ps.setInt(3, id);
            ps.executeUpdate();               
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateAmountProduct(int amount, int id) {
         String query = "UPDATE product SET [amount]=? WHERE [id]=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public int getProductAmountByID(int id) {
        String query = "SELECT amount FROM product WHERE id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }    
        return -1;
    }
    public int getProductPriceByID(int id) {
        String query = "SELECT price FROM product WHERE id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("price");
            }
        } catch (Exception e) {
            e.printStackTrace(); 
        }    
        return -1;
    }
    public int themDonhang(String transactionid, int id, String name, String sdt, String dchi, String date, int price){
        String query = "insert into [dbo].[order] ([transactionid],[AccountID],[name],[sdt],[dchi],[date],[price]) OUTPUT INSERTED.id VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,transactionid);
            ps.setInt(2,id); 
            ps.setString(3,name);
            ps.setString(4,sdt);
            ps.setString(5,dchi);
            ps.setString(6,date);
            ps.setInt(7,price);         
            ps.execute(); 
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int generatedID = generatedKeys.getInt(1);
                    return generatedID;
                } else {
                    throw new SQLException("Creating record failed, no ID obtained.");
                }
            }
        } catch (Exception e) {
             e.printStackTrace();
        }    
        return -1;
    }
    public void themDonhangchitiet(int oid, int pid, int soluong, int price){
        String query = "insert into [dbo].[orderinfo]([orderid],[ProductID],[amount],[price]) values(?,?,?,?)";   
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,oid);
            ps.setInt(2,pid);
            ps.setInt(3,soluong);
            ps.setInt(4,price);
            ps.executeUpdate();          
        } catch (Exception e) {
            e.printStackTrace();
        }    
    }
    public List<Donhang> getDonhangbyID(int id) {
        List<Donhang> list = new ArrayList<>();
        String query = "select * from [dbo].[order] where [AccountID]=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Donhang(rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),   
                        rs.getString(5),   
                        rs.getString(6),   
                        rs.getString(7),                                   
                        rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Donhanginfo> getDonhanginfobyID(int oid) {
        List<Donhanginfo> list = new ArrayList<>();
        String query = "select dbo.orderinfo.orderid,dbo.orderinfo.ProductID,dbo.product.image,dbo.orderinfo.amount,dbo.orderinfo.price from [dbo].[orderinfo],dbo.product where [orderid]=? and dbo.product.id=dbo.orderinfo.ProductID";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, oid);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Donhanginfo(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),                                   
                        rs.getInt(4),
                        rs.getInt(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public List<Sanpham> getTop3Product() {
        List<Sanpham> list = new ArrayList<>();
        String query = "select top 3 * from product";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return list;
    }
    public List<Sanpham> getNext3Product(int amount) {
        List<Sanpham> list = new ArrayList<>();
        String query = "select * from product order by id offset ? rows fetch next 3 rows only";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, amount);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Sanpham(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
            System.out.println(list);
        } catch (Exception e) {
             e.printStackTrace();
        }
        return list;
    }
    public Taikhoan getTaikhoanbyID(int id){
        String query = "select * from Account where [uID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1,id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Taikhoan(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),                       
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
        
    }
     public void updateTaikhoan(String name, String sdt, String dchi, int id) {
         String query = "UPDATE [Account] SET [name] = ?, [sdt] = ?, [dchi] = ? WHERE [uID] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setString(2, sdt);
            ps.setString(3, dchi);
            ps.setInt(4, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}