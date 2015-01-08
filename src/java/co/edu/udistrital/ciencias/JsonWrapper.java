/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package co.edu.udistrital.ciencias;

import org.json.simple.JSONObject;

/**
 *
 * @author Usuario
 */
public class JsonWrapper {

    private JSONObject jSon;

    public JsonWrapper(JSONObject jSon) {
        this.setjSon(jSon);
    }

    public JSONObject getjSon() {
        return jSon;
    }

    public void setjSon(JSONObject jSon) {
        this.jSon = jSon;
    }
    
    
}
