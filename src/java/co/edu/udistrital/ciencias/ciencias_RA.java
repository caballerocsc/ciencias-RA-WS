/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udistrital.ciencias;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.simple.JSONObject;

/**
 *
 * @author Usuario
 */
@WebService(serviceName = "ciencias_RA")
public class ciencias_RA {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getContent")
    public JsonWrapper getContent(@WebParam(name = "idUser") String idUser, @WebParam(name = "idContent") String idContent) {
      JSONObject obj = new JSONObject();
      obj.put("id",45);
      obj.put("name","cartilla UD");
      obj.put("description","Cartilla de prueba");
      obj.put("type","pdf"); 
      obj.put("url-content","url de contenido"); 
      obj.put("url-local-content","url local"); 
      //System.out.println("hola");
      System.out.print(obj);
      JsonWrapper wrapper= new JsonWrapper(obj);
        return wrapper;
    }
}
