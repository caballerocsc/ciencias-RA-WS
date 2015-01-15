/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udistrital.ciencias.bd;

import co.edu.udistrital.ciencias.JsonWrapper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;
import org.json.simple.JSONObject;

/**
 *
 * @author Administrador
 */
public class OperacionesBD {

    @Resource(name = "dsCienciasRA")
    private DataSource dsCienciasRA;
   
    public OperacionesBD() {
        
    }
    
    public JsonWrapper getContent(String idUser,String idContent){
        JSONObject obj = new JSONObject();     
      JsonWrapper wrapper=null;
           try {
            Connection cn = dsCienciasRA.getConnection();
            PreparedStatement ps = cn.prepareStatement("select * from content where idContent = ?");
            ps.setInt(1, Integer.parseInt(idContent));
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int i=1;
                obj.put("id",rs.getInt(i++));
                obj.put("name",rs.getString(i++));
                obj.put("description",rs.getString(i++));
                obj.put("type",rs.getInt(i++)); 
                obj.put("url-content",rs.getString(i++)); 
                obj.put("url-local-content",rs.getString(i++)); 
                System.out.print(obj);
                rs.close();
                cn.close(); 
            }else
                obj.put("parameterInvalid", idContent);
        } catch (SQLException sQLException) {
               System.out.println(sQLException.toString());
               obj.put("Error",sQLException);
            return null;
        }
        wrapper= new JsonWrapper(obj);
        return wrapper;
    }    
    
     public String login(String idUsuario, String password){
        Connection cn=null;
         ResultSet rs=null;
         String res="";
         try {
            cn = dsCienciasRA.getConnection();
            PreparedStatement ps = cn.prepareStatement("select * from usuario where idUsuario = ? and clave=?");
            ps.setString(1, idUsuario);
            ps.setString(2, password);
            rs=ps.executeQuery();
            if(rs.next()){
                res="OK";
            }else
                res="parameterInvalid";
            rs.close();
            cn.close();
        } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
            res="Error";
        }
        return res;
     
     }
}
