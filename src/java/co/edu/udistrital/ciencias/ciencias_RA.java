/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udistrital.ciencias;

import co.edu.udistrital.ciencias.bd.OperacionesBD;
import javax.annotation.Resource;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.sql.DataSource;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "ciencias_RA")
public class ciencias_RA {
    //@Resource(name = "dsCienciasRA")
    //private DataSource dsCienciasRA;

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getContent")
    public JsonWrapper getContent(@WebParam(name = "idUser") String idUser, @WebParam(name = "idContent") String idContent) {
        OperacionesBD op=new OperacionesBD();
        return op.getContent(idUser, idContent);
        /*
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
        */
    }
    
    @WebMethod(operationName = "login")
    public String login(String idUsuario, String password){
        OperacionesBD op=new OperacionesBD();
        return op.login(idUsuario, password);
    }
}
