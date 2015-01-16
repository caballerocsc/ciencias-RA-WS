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
     
     public String createCourse(String name, String description, int idTeacher, String token){
         Connection cn=null;
         String res="";
         try {
            cn = dsCienciasRA.getConnection();
            PreparedStatement ps = cn.prepareStatement("insert into (name_course,idTeacher,token) course values (?,?,?)");
            ps.setString(1, name);
            ps.setInt(2, idTeacher);
            ps.setString(3, token);
            if(ps.execute()){
                res="OK";
            }else
                res="parameterInvalid";
            cn.close();
         } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
            res="Error";
        }
        return res;
     }
     
     public String createTeacher(String name, String birthday, String email, String password){
         Connection cn=null;
         String res="";
         try {
             int i=0;
            cn = dsCienciasRA.getConnection();
            PreparedStatement ps = cn.prepareStatement("insert into teacher (name_teacher,birthday,email,passw) values (?,?,?,?)");
            ps.setString(i++, name);
            ps.setString(i++, birthday);
            ps.setString(i++, email);
            ps.setString(i++, password);
            if(ps.execute()){
                res="OK";
            }else
                res="parameterInvalid";
            cn.close();
         } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
            res="Error";
        }
        return res;
     }
     
     public String createStudent(String name, String birthday, String email, String password, String tokenCourse){
         Connection cn=null;
         String res="";
         try {
            int i=0;
            cn = dsCienciasRA.getConnection();
            PreparedStatement ps = cn.prepareStatement("insert into student (name_student,name_student,birthday,email,passw,token_course) values (?,?,?,?,?,?)");
            ps.setString(i++, name);
            ps.setString(i++, birthday);
            ps.setString(i++, email);
            ps.setString(i++, password);
            ps.setString(i++, tokenCourse);
            if(ps.execute()){
                res="OK";
            }else
                res="parameterInvalid";
            cn.close();
         } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
            res="Error";
        }
        return res;
     }
     
     public String createContent(String name, String description, String type, String urlContent){
         Connection cn=null;
         String res="";
         try {
            int i=0;
            cn = dsCienciasRA.getConnection();
            PreparedStatement ps = cn.prepareStatement("insert into content (namecontent,description,typecontent, urlcontent) values(?,?,?,?)");
            ps.setString(i++, name);
            ps.setString(i++, description);
            ps.setString(i++, type);
            ps.setString(i++, urlContent);
            if(ps.execute()){
                res="OK";
            }else
                res="parameterInvalid";
            cn.close();
         } catch (SQLException ex) {
            Logger.getLogger(OperacionesBD.class.getName()).log(Level.SEVERE, null, ex);
            res="Error";
        }
        return res;
     }
}
